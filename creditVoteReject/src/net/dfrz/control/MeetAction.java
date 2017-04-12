package net.dfrz.control;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import net.dfrz.domain.Meet;
import net.dfrz.domain.MeetDetail;
import net.dfrz.domain.User;
import net.dfrz.log.Log;
import net.dfrz.model.MeetDao;
import net.dfrz.model.MeetDetailDao;
import net.dfrz.model.impl.MeetDetailImpl;
import net.dfrz.model.impl.MeetImpl;

public class MeetAction {

	// 添加会议明细
	public static void add(MeetDetail meetDetail) {
		MeetDetailDao meetDetailDao = new MeetDetailImpl();

		meetDetailDao.add(meetDetail);
	}

	// 添加会议概要
	public static void add(Meet meet) {
		MeetDao meetDao = new MeetImpl();

		meetDao.add(meet);
		Log.addLog("添加了一个会议");
	}

	// 查询审签会议明细
	public static Map<Integer, MeetDetail> queryMeetDetailShenQian() {
		MeetDetailDao meetDetailDao = new MeetDetailImpl();

		return meetDetailDao.queryMeetDetailShenQian();
	}

	// 行长审签结果更新
	public static void updateMeet(String id, String judge) {
		MeetDao meetDao = new MeetImpl();

		meetDao.updateMeet(id, judge);
		Log.addLog("进行了行长审签");
	}

	// 查询退回重审的会议概要
	public static Map<Integer, MeetDetail> queryBackJudgeMeetDetail() {
		MeetDetailDao meetDetailDao = new MeetDetailImpl();

		return meetDetailDao.queryBackJudgeMeetDetail();
	}

	// 更新退回重审的金额
	public static void updateMeetDetailMoney(String id, String money) {
		MeetDetailDao meetDetailDao = new MeetDetailImpl();

		meetDetailDao.updateMeetDetailMoney(id, money);
		Log.addLog("进行了退回重审");
	}

	// 查询所有会议的日期
	public static List<String> quarySetDate() {
		MeetDao meetDao = new MeetImpl();

		return meetDao.quarySetDate();
	}

	// 查询在审会议
	public static Map<MeetDetail, Meet> quaryMeetDetail(String begin, String end) {
		MeetDao meetDao = new MeetImpl();

		Log.addLog("查询了在审会议");
		return meetDao.quaryMeetDetail(begin, end);
	}

	// 初始化会议概要
	public static Meet initMeet(User onlineUser, Meet meet) {
		Calendar now = Calendar.getInstance();
		meet.setMeetYear(now.get(Calendar.YEAR));
		meet.setName(onlineUser.getEmpName());
		meet.setPhone(onlineUser.getPhone());
		meet.setSetDate(String.valueOf(new SimpleDateFormat("yyyyMMdd")
				.format(new Date())));
		meet.setState("提交");

		return meet;
	}

	// 历史记录卸取
	public static Map<MeetDetail, Meet> queryHistoryLogging(String begin,
			String end) {
		MeetDao meetDao = new MeetImpl();

		return meetDao.quaryMeetDetailHistory(begin, end);
	}

	public static void write(Map<MeetDetail, Meet> meets, String address) {
		MeetDao meetDao = new MeetImpl();

		Log.addLog("卸取历史记录");
		meetDao.write(meets, address);
	}

	public static Map<Integer, MeetDetail> queryMeetDetail() {
		MeetDetailDao meetDetailDao = new MeetDetailImpl();

		return meetDetailDao.queryMeetDetail();
	}

	public static void write(Map<Integer, MeetDetail> meetDetails, File file) {
		MeetDetailDao meetDetailDao = new MeetDetailImpl();

		meetDetailDao.write(meetDetails, file);
		Log.addLog("进行评审信息移植");
	}

	public static Map<Integer, MeetDetail> queryMeetDetailByRounder(
			User onlineUser) {
		MeetDetailDao meetDetailDao = new MeetDetailImpl();

		Log.addLog("传阅了会议");
		return meetDetailDao.queryMeetDetailByRounder(onlineUser);
	}
}
