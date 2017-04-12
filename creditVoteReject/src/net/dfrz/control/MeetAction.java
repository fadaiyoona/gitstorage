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

	// ��ӻ�����ϸ
	public static void add(MeetDetail meetDetail) {
		MeetDetailDao meetDetailDao = new MeetDetailImpl();

		meetDetailDao.add(meetDetail);
	}

	// ��ӻ����Ҫ
	public static void add(Meet meet) {
		MeetDao meetDao = new MeetImpl();

		meetDao.add(meet);
		Log.addLog("�����һ������");
	}

	// ��ѯ��ǩ������ϸ
	public static Map<Integer, MeetDetail> queryMeetDetailShenQian() {
		MeetDetailDao meetDetailDao = new MeetDetailImpl();

		return meetDetailDao.queryMeetDetailShenQian();
	}

	// �г���ǩ�������
	public static void updateMeet(String id, String judge) {
		MeetDao meetDao = new MeetImpl();

		meetDao.updateMeet(id, judge);
		Log.addLog("�������г���ǩ");
	}

	// ��ѯ�˻�����Ļ����Ҫ
	public static Map<Integer, MeetDetail> queryBackJudgeMeetDetail() {
		MeetDetailDao meetDetailDao = new MeetDetailImpl();

		return meetDetailDao.queryBackJudgeMeetDetail();
	}

	// �����˻�����Ľ��
	public static void updateMeetDetailMoney(String id, String money) {
		MeetDetailDao meetDetailDao = new MeetDetailImpl();

		meetDetailDao.updateMeetDetailMoney(id, money);
		Log.addLog("�������˻�����");
	}

	// ��ѯ���л��������
	public static List<String> quarySetDate() {
		MeetDao meetDao = new MeetImpl();

		return meetDao.quarySetDate();
	}

	// ��ѯ�������
	public static Map<MeetDetail, Meet> quaryMeetDetail(String begin, String end) {
		MeetDao meetDao = new MeetImpl();

		Log.addLog("��ѯ���������");
		return meetDao.quaryMeetDetail(begin, end);
	}

	// ��ʼ�������Ҫ
	public static Meet initMeet(User onlineUser, Meet meet) {
		Calendar now = Calendar.getInstance();
		meet.setMeetYear(now.get(Calendar.YEAR));
		meet.setName(onlineUser.getEmpName());
		meet.setPhone(onlineUser.getPhone());
		meet.setSetDate(String.valueOf(new SimpleDateFormat("yyyyMMdd")
				.format(new Date())));
		meet.setState("�ύ");

		return meet;
	}

	// ��ʷ��¼жȡ
	public static Map<MeetDetail, Meet> queryHistoryLogging(String begin,
			String end) {
		MeetDao meetDao = new MeetImpl();

		return meetDao.quaryMeetDetailHistory(begin, end);
	}

	public static void write(Map<MeetDetail, Meet> meets, String address) {
		MeetDao meetDao = new MeetImpl();

		Log.addLog("жȡ��ʷ��¼");
		meetDao.write(meets, address);
	}

	public static Map<Integer, MeetDetail> queryMeetDetail() {
		MeetDetailDao meetDetailDao = new MeetDetailImpl();

		return meetDetailDao.queryMeetDetail();
	}

	public static void write(Map<Integer, MeetDetail> meetDetails, File file) {
		MeetDetailDao meetDetailDao = new MeetDetailImpl();

		meetDetailDao.write(meetDetails, file);
		Log.addLog("����������Ϣ��ֲ");
	}

	public static Map<Integer, MeetDetail> queryMeetDetailByRounder(
			User onlineUser) {
		MeetDetailDao meetDetailDao = new MeetDetailImpl();

		Log.addLog("�����˻���");
		return meetDetailDao.queryMeetDetailByRounder(onlineUser);
	}
}
