package net.dfrz.model;

import java.util.List;
import java.util.Map;

import net.dfrz.domain.Meet;
import net.dfrz.domain.MeetDetail;

/**
 * 
 * @author 发呆
 * @version 对会议概要操作的接口类
 */
public interface MeetDao {

	/**
	 * 添加会议概要
	 * 
	 * @param meet
	 *            需要添加的会议概要
	 */
	public void add(Meet meet);

	/**
	 * 更新多人行长审签的结果
	 * 
	 * @param id
	 *            审签会议的id
	 * @param judge
	 *            审签的结果
	 */
	public void updateMeet(String id, String judge);

	/**
	 * 查询所有的日期
	 * 
	 * @return 返回数据库中所有的日期
	 */
	public List<String> quarySetDate();

	/**
	 * 查询在审会议
	 * 
	 * @param beginDate
	 *            在审会议的开始日期
	 * @param endDate
	 *            在审会议的结束日期
	 * @return 在审会议的集合 <会议明细,会议概要>
	 */
	public Map<MeetDetail, Meet> quaryMeetDetail(String beginDate,
			String endDate);

	/**
	 * 查询历史记录卸取
	 * 
	 * @param beginDate
	 *            历史记录的开始日期
	 * @param endDate
	 *            历史记录的结束时间
	 * @return 历史记录的集合 <会议明细,会议概要>
	 */
	public Map<MeetDetail, Meet> quaryMeetDetailHistory(String beginDate,
			String endDate);

	/**
	 * 历史记录写入文本
	 * 
	 * @param meets
	 *            历史记录
	 * @param address
	 *            存储的文本地址
	 */
	public void write(Map<MeetDetail, Meet> meets, String address);
}
