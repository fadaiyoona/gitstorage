package net.dfrz.model;

import java.io.File;
import java.util.Map;

import net.dfrz.domain.MeetDetail;
import net.dfrz.domain.User;

/**
 * 
 * @author 发呆
 * @version 对会议明细操作的接口类
 */
public interface MeetDetailDao {

	/**
	 * 添加会议明细
	 * 
	 * @param meetDetail
	 *            会议明细
	 */
	public void add(MeetDetail meetDetail);

	/**
	 * 遍历审签会议明细
	 * 
	 * @return 审签会议的集合
	 */
	public Map<Integer, MeetDetail> queryMeetDetailShenQian();

	/**
	 * 遍历退回会议明细
	 * 
	 * @return 退回重审会议的集合
	 */
	public Map<Integer, MeetDetail> queryBackJudgeMeetDetail();

	/**
	 * 更新会议的金额
	 * 
	 * @param id
	 *            需要更新的会议的id
	 * @param money
	 *            修改的会议的额度
	 */
	public void updateMeetDetailMoney(String id, String money);

	/**
	 * 查询所有会议明细
	 * 
	 * @return 所有会议的集合
	 */
	public Map<Integer, MeetDetail> queryMeetDetail();

	/**
	 * 把数据写入Excel
	 * 
	 * @param meetDetails
	 *            需要写入Excel的会议
	 * @param file
	 *            写入的Excel文本
	 */
	public void write(Map<Integer, MeetDetail> meetDetails, File file);

	/**
	 * 传阅者查询会议明细
	 * 
	 * @param onlineUser
	 *            传阅者
	 * @return 传阅者能看到的会议的集合
	 */
	public Map<Integer, MeetDetail> queryMeetDetailByRounder(User onlineUser);
}
