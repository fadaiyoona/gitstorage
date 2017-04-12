package net.dfrz.control.lawful;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.dfrz.domain.User;
import net.dfrz.model.UserDao;
import net.dfrz.model.impl.UserImpl;

public class Case1_lowful {

	// 判断多人会签行长登录名是否合法
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

	// 判断员工名的合法性
	public static int empName(String empName) {
		if (empName.isEmpty()) {
			// System.out.println("输入的员工们不能为空！");
			return 1;
		} else if (empName.indexOf(" ") >= 0) {
			// System.out.println("输入的名字不能有空格，请重新输入");
			return 2;
		} else if (!isEmpNameAble(empName)) {
			// System.out.println("输入的名字必须是汉字和·的组合，首字母为汉字, 字数 2-20
			// 个，请重新输入");
			return 3;
		} else {
			return 0;
		}
	}

	// 判断系统登录名的合法性
	public static int logName(String logName) throws SQLException {
		if (logName.isEmpty()) {
			// System.out.println("输入的登录名不能为空！");
			return 1;
		} else if (!isLogNameAble(logName)) {
			// System.out.println("输入的名字为字母和阿拉伯数字组合，统一以.fj 结尾，请重新输入");
			return 2;
		} else if (isUserExist(logName)) {
			// System.out.println("输入的系统名已存在，请重新输入");
			return 3;
		} else {
			// user.setLogName(logname);
			return 0;
		}

	}

	// 判断是否存在该用户名
	private static boolean isUserExist(String logName) {
		UserDao userDao = new UserImpl();

		List<User> list = new ArrayList<User>();
		list = userDao.quaryUser(logName);
		if (list.size() > 0) {
			return true;
		}
		return false;
	}

	// 判断电话号码的合法性
	public static int phone(String phone) {
		if (phone.isEmpty()) {
			// System.out.println("输入的手机号码为空，请重新输入");
			return 1;
		} else if (!isPhoneAble(phone)) {
			// System.out.println("输入的手机号码不合法，请重新输入");
			return 2;
		} else {
			// user.setPhone(s);
			return 0;

		}
	}

	// 判断密码的合法性
	public static int password(String password) {
		if (password.isEmpty()) {
			// System.out.println("输入的密码为空，请重新输入");
			return 1;
		} else if (!isPasswordAble(password)) {
			// System.out.println("密码必须为六位以上字符，至少包含大小写、阿拉伯数字三种字符中的两种");
			return 2;
		} else {
			// user.setPassword(s);
			return 0;
		}
	}

	// 判断员工类型的合法性
	public static int type(String type) {
		if (type.isEmpty()) {
			// System.out.println("输入的员工类型为空，请重新输入");
			return 1;
		} else if (!isTypeAble(type)) {
			// System.out.println("输入的员工类型必须为0-4");
			return 2;
		} else {
			// user.setType(s);
			return 0;
		}
	}

	// 判断输入的员工名的合法性
	private static boolean isEmpNameAble(String s) {
		if (!s.matches("[\u4e00-\u9fa5][·\u4e00-\u9fa5]{1,19}"))
			return false;
		return true;
	}

	// 判断输入登录名是否合法
	private static boolean isLogNameAble(String s) {
		if (!s.matches("[a-zA-Z0-9]+[.][f][j]"))
			return false;
		return true;
	}

	// 判断是否存在该行长的登录名
	private static boolean isGovernorExist(String logName) {
		UserDao userDao = new UserImpl();

		List<User> list = new ArrayList<User>();
		list = userDao.quaryGovernors(logName);
		if (list.size() > 0) {
			return true;
		}
		return false;
	}

	// 判断输入手机号码是否合法
	private static boolean isPhoneAble(String s) {
		if (!s.matches("[1][0-9]{10}"))
			return false;
		return true;
	}

	// 判断输入密码是否合法
	private static boolean isPasswordAble(String s) {
		if (!s.matches("^(?![0-9]+$)(?![a-z]+$)(?![A-Z]+$)[0-9A-Za-z]{6,}$"))
			return false;
		return true;
	}

	// 判断输入员工类型是否合法
	private static boolean isTypeAble(String s) {
		if (!s.matches("[0-4]"))
			return false;
		return true;
	}

}
