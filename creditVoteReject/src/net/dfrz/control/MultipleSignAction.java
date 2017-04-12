package net.dfrz.control;

import java.util.Map;

import net.dfrz.domain.MeetDetail;
import net.dfrz.domain.State;
import net.dfrz.domain.User;
import net.dfrz.log.Log;
import net.dfrz.model.MultipleSignDao;
import net.dfrz.model.impl.MultipleSignImpl;

public class MultipleSignAction {

	// 打开多人审批开关
	public static void open(State state) {
		MultipleSignDao multipleSignDao = new MultipleSignImpl();

		multipleSignDao.open(state);
		Log.addLog("打开了多人审批开关");
	}

	// 关闭多人审批开关
	public static void close(State state) {
		MultipleSignDao multipleSignDao = new MultipleSignImpl();

		multipleSignDao.close(state);
		Log.addLog("关闭了多人审批开关");
	}

	// 判断是否打开多人审批开关
	public static boolean isOpen() {
		MultipleSignDao multipleSignDao = new MultipleSignImpl();

		return multipleSignDao.queryState();
	}

	// 获取多人审批行长名单
	public static String getSignGovernorsLogNames() {
		MultipleSignDao multipleSignDao = new MultipleSignImpl();

		return multipleSignDao.getSignByTheGovernor();
	}

	// 获取多人审批会议的明细
	public static Map<Integer, MeetDetail> queryMultipleSignMeetDetails(
			User onlineUser) {
		MultipleSignDao multipleSignDao = new MultipleSignImpl();

		return multipleSignDao.queryMultipleSignMeetDetails(onlineUser);
	}

	// 多人审签
	public static void updateMultipleSignMeetDetail(String id, String judge,
			User onlineUser) {
		MultipleSignDao multipleSignDao = new MultipleSignImpl();

		multipleSignDao.updateMultipleSign(id, judge, onlineUser);
		Log.addLog("进行了多人审签");
	}

}
