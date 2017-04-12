package net.dfrz.control.lawful;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.dfrz.domain.User;
import net.dfrz.model.UserDao;
import net.dfrz.model.impl.UserImpl;

public class Case1_lowful {

	// �ж϶��˻�ǩ�г���¼���Ƿ�Ϸ�
	public static List<String> isGovernors(String[] logNames) {
		List<String> result = new ArrayList<String>();

		for (String logName : logNames) {
			if (isGovernorExist(logName)) {
				continue;
			} else {
				result.add(logName);
			}
		}

		return result;
	}

	// �ж�Ա�����ĺϷ���
	public static int empName(String empName) {
		if (empName.isEmpty()) {
			// System.out.println("�����Ա���ǲ���Ϊ�գ�");
			return 1;
		} else if (empName.indexOf(" ") >= 0) {
			// System.out.println("��������ֲ����пո�����������");
			return 2;
		} else if (!isEmpNameAble(empName)) {
			// System.out.println("��������ֱ����Ǻ��ֺ͡�����ϣ�����ĸΪ����, ���� 2-20
			// ��������������");
			return 3;
		} else {
			return 0;
		}
	}

	// �ж�ϵͳ��¼���ĺϷ���
	public static int logName(String logName) throws SQLException {
		if (logName.isEmpty()) {
			// System.out.println("����ĵ�¼������Ϊ�գ�");
			return 1;
		} else if (!isLogNameAble(logName)) {
			// System.out.println("���������Ϊ��ĸ�Ͱ�����������ϣ�ͳһ��.fj ��β������������");
			return 2;
		} else if (isUserExist(logName)) {
			// System.out.println("�����ϵͳ���Ѵ��ڣ�����������");
			return 3;
		} else {
			// user.setLogName(logname);
			return 0;
		}

	}

	// �ж��Ƿ���ڸ��û���
	private static boolean isUserExist(String logName) {
		UserDao userDao = new UserImpl();

		List<User> list = new ArrayList<User>();
		list = userDao.quaryUser(logName);
		if (list.size() > 0) {
			return true;
		}
		return false;
	}

	// �жϵ绰����ĺϷ���
	public static int phone(String phone) {
		if (phone.isEmpty()) {
			// System.out.println("������ֻ�����Ϊ�գ�����������");
			return 1;
		} else if (!isPhoneAble(phone)) {
			// System.out.println("������ֻ����벻�Ϸ�������������");
			return 2;
		} else {
			// user.setPhone(s);
			return 0;

		}
	}

	// �ж�����ĺϷ���
	public static int password(String password) {
		if (password.isEmpty()) {
			// System.out.println("���������Ϊ�գ�����������");
			return 1;
		} else if (!isPasswordAble(password)) {
			// System.out.println("�������Ϊ��λ�����ַ������ٰ�����Сд�����������������ַ��е�����");
			return 2;
		} else {
			// user.setPassword(s);
			return 0;
		}
	}

	// �ж�Ա�����͵ĺϷ���
	public static int type(String type) {
		if (type.isEmpty()) {
			// System.out.println("�����Ա������Ϊ�գ�����������");
			return 1;
		} else if (!isTypeAble(type)) {
			// System.out.println("�����Ա�����ͱ���Ϊ0-4");
			return 2;
		} else {
			// user.setType(s);
			return 0;
		}
	}

	// �ж������Ա�����ĺϷ���
	private static boolean isEmpNameAble(String s) {
		if (!s.matches("[\u4e00-\u9fa5][��\u4e00-\u9fa5]{1,19}"))
			return false;
		return true;
	}

	// �ж������¼���Ƿ�Ϸ�
	private static boolean isLogNameAble(String s) {
		if (!s.matches("[a-zA-Z0-9]+[.][f][j]"))
			return false;
		return true;
	}

	// �ж��Ƿ���ڸ��г��ĵ�¼��
	private static boolean isGovernorExist(String logName) {
		UserDao userDao = new UserImpl();

		List<User> list = new ArrayList<User>();
		list = userDao.quaryGovernors(logName);
		if (list.size() > 0) {
			return true;
		}
		return false;
	}

	// �ж������ֻ������Ƿ�Ϸ�
	private static boolean isPhoneAble(String s) {
		if (!s.matches("[1][0-9]{10}"))
			return false;
		return true;
	}

	// �ж����������Ƿ�Ϸ�
	private static boolean isPasswordAble(String s) {
		if (!s.matches("^(?![0-9]+$)(?![a-z]+$)(?![A-Z]+$)[0-9A-Za-z]{6,}$"))
			return false;
		return true;
	}

	// �ж�����Ա�������Ƿ�Ϸ�
	private static boolean isTypeAble(String s) {
		if (!s.matches("[0-4]"))
			return false;
		return true;
	}

}
