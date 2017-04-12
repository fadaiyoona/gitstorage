package net.dfrz.control.lawful;

import java.util.ArrayList;
import java.util.List;

import net.dfrz.domain.User;
import net.dfrz.model.UserDao;
import net.dfrz.model.impl.UserImpl;

public class Case2_lowful {

	// �жϹ�˾���ֵĺϷ���
	public static int comName(String comName) {
		if (comName.isEmpty()) {
			// System.out.println("û�����빫˾-����������");
			return 1;
		} else if (comName.matches("[\u4E00-\u9FA5]+") && comName.length() >= 2
				&& comName.length() <= 10) {
			// meetDetail.setCompany(comName);
			return 0;
		} else {
			// System.out.println("����Ĺ�˾������Ϊ���֣�����2-10λ������������");
			return 2;
		}
	}

	// �жϹ�˾��ַ�ĺϷ���
	public static int comAddress(String comAddress) {
		if (comAddress.isEmpty()) {
			// System.out.println("û�����빫˾-����������");
			return 1;
		} else if (comAddress.matches("[1-9]")) {
			// meetDetail.setAddress(meetDetail.getAddressName(comAddress));
			return 0;
		} else {
			// System.out.println("����Ĺ�˾������Ϊ1-9֮��İ��������֣�����������");
			return 2;
		}
	}

	// �жϴ�����ĺϷ���
	public static int money(String money) {
		if (money.isEmpty()) {
			// System.out.println("û�����������-����������");
			return 1;
		} else if (money.matches("[1-9][0-9]+") || money.matches("[1-9]")) {
			// meetDetail.setMoney(money);
			return 0;
		} else {
			// System.out.println("����Ĵ��������Ϊ����������������");
			return 2;
		}
	}

	// �жϹ�˾���͵ĺϷ���
	public static int comType(String comType) {
		if (comType.isEmpty()) {
			// System.out.println("û��������ҵ����-����������");
			return 1;
		} else if (comType.matches("[1-3]")) {
			return 0;
		} else {
			// System.out.println("�������ҵ���ͱ���Ϊ1��2��3������������");
			return 2;
		}
	}

	// �ж�ԭ��ĺϷ���
	public static int reason(String reason) {
		if (reason.isEmpty()) {
			// System.out.println("û��������������-����������");
			return 1;
		} else if (reason.length() >= 6) {
			// meetDetail.setReason(reason);
			return 0;
		} else {
			// System.out.println("������������ɱ���Ϊ6�������ַ�������������");
			return 2;
		}
	}

	// �ж϶��˻�ǩ�г���¼���Ƿ�Ϸ�
	public static List<String> rounders(String[] logNames) {
		List<String> result = new ArrayList<String>();

		for (String logName : logNames) {
			if (isRounderExist(logName)) {
				continue;
			} else {
				result.add(logName);
			}
		}

		return result;
	}

	// �ж��Ƿ���ڸ��г��ĵ�¼��
	private static boolean isRounderExist(String logName) {
		UserDao userDao = new UserImpl();

		List<User> list = new ArrayList<User>();
		list = userDao.quaryRounders(logName);
		if (list.size() > 0) {
			return true;
		}
		return false;
	}

}
