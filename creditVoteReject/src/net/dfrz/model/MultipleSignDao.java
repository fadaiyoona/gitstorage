package net.dfrz.model;

import java.util.Map;

import net.dfrz.domain.MeetDetail;
import net.dfrz.domain.State;
import net.dfrz.domain.User;

/**
 * 
 * @author 发呆
 * @version 多人审批操作的接口类
 */
public interface MultipleSignDao {

	/**
	 * 判断多人会签模式是否开启
	 * 
	 * @return true:已开启多人会签模式 false:未开启多人会签模式
	 */
	public boolean queryState();

	/**
	 * 多人会签
	 * 
	 * @param id
	 *            多人会签的会议的ID
	 * @param judge
	 *            多人会签的结果
	 * @param onlineUser
	 *            本次多人会签的人
	 */
	public void updateMultipleSign(String id, String judge, User onlineUser);

	/**
	 * 打开多人会签开关
	 * 
	 * @param state
	 *            多人会签的对象
	 */
	public void open(State state);

	/**
	 * 关闭多人会签开关
	 * 
	 * @param state
	 *            多人会签的对象
	 */
	public void close(State state);

	/**
	 * 获取参与多人审批的行长的名单
	 * 
	 * @return 行长名单(governor1,governor2,...,governorn)
	 */
	public String getSignByTheGovernor();

	/**
	 * 获取多人审签的会议
	 * 
	 * @param user
	 *            参与多人审签的行长
	 * @return 该行长参与的多人审签会议
	 */
	public Map<Integer, MeetDetail> queryMultipleSignMeetDetails(User user);
}
