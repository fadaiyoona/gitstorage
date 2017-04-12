package net.dfrz.control;

import java.util.Map;

import net.dfrz.domain.MeetDetail;
import net.dfrz.domain.State;
import net.dfrz.domain.User;
import net.dfrz.log.Log;
import net.dfrz.model.MultipleSignDao;
import net.dfrz.model.impl.MultipleSignImpl;

public class MultipleSignAction {

	// �򿪶�����������
	public static void open(State state) {
		MultipleSignDao multipleSignDao = new MultipleSignImpl();

		multipleSignDao.open(state);
		Log.addLog("���˶�����������");
	}

	// �رն�����������
	public static void close(State state) {
		MultipleSignDao multipleSignDao = new MultipleSignImpl();

		multipleSignDao.close(state);
		Log.addLog("�ر��˶�����������");
	}

	// �ж��Ƿ�򿪶�����������
	public static boolean isOpen() {
		MultipleSignDao multipleSignDao = new MultipleSignImpl();

		return multipleSignDao.queryState();
	}

	// ��ȡ���������г�����
	public static String getSignGovernorsLogNames() {
		MultipleSignDao multipleSignDao = new MultipleSignImpl();

		return multipleSignDao.getSignByTheGovernor();
	}

	// ��ȡ���������������ϸ
	public static Map<Integer, MeetDetail> queryMultipleSignMeetDetails(
			User onlineUser) {
		MultipleSignDao multipleSignDao = new MultipleSignImpl();

		return multipleSignDao.queryMultipleSignMeetDetails(onlineUser);
	}

	// ������ǩ
	public static void updateMultipleSignMeetDetail(String id, String judge,
			User onlineUser) {
		MultipleSignDao multipleSignDao = new MultipleSignImpl();

		multipleSignDao.updateMultipleSign(id, judge, onlineUser);
		Log.addLog("�����˶�����ǩ");
	}

}
