package net.dfrz.view.input;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import net.dfrz.control.lawful.Case1_lowful;

public class Case1_input {

	// 输入多人审批的行长的登录名
	public static String inputMultipleSignNames() {
		Scanner sc = new Scanner(System.in);
		String governors = null;
		String[] logNames;
		List<String> results = new ArrayList<String>();

		while (true) {
			System.out.print("请输入参与集体审批的行长的登录名,用,隔开:");
			governors = sc.nextLine();
			logNames = governors.split(",");
			results = Case1_lowful.isGovernors(logNames);
			if (results.size() == 0) {
				break;
			} else {
				printTheErrorLogNames(results);
			}
		}
		return governors;
	}

	// 输入员工名
	public static String inputEmpName() {
		Scanner scanner = new Scanner(System.in);
		String empName = null;
		int result;
		while (true) {
			System.out.print("输入员工名:");
			empName = scanner.nextLine();
			result = Case1_lowful.empName(empName);
			if (result == 1) {
				System.out.println("输入的员工们不能为空！");
			} else if (result == 2) {
				System.out.println("输入的名字不能有空格，请重新输入");
			} else if (result == 3) {
				System.out.println("输入的名字必须是汉字和·的组合，首字母为汉字, 字数 2-20 个，请重新输入");
			} else {
				return empName;
			}
		}
	}

	// 输入系统登录名
	public static String inputLogName() throws SQLException {
		Scanner scanner = new Scanner(System.in);
		String logName = null;
		int result;

		while (true) {
			System.out.print("输入用户的系统登录名:");
			logName = scanner.nextLine();
			result = Case1_lowful.logName(logName);

			if (result == 1) {
				System.out.println("输入的登录名不能为空！");
			} else if (result == 2) {
				System.out.println("输入的名字为字母和阿拉伯数字组合，统一以.fj 结尾，请重新输入");
			} else if (result == 3) {
				System.out.println("输入的系统名已存在，请重新输入");
			} else {
				return logName;
			}
		}
	}

	// 输入电话号码
	public static String inputPhone() {
		Scanner scanner = new Scanner(System.in);
		String phone = null;
		int result;

		while (true) {
			System.out.print("输入手机号码:");
			phone = scanner.next();
			result = Case1_lowful.phone(phone);
			if (result == 1) {
				System.out.println("输入的手机号码为空，请重新输入");
			} else if (result == 2) {
				System.out.println("输入的手机号码不合法，请重新输入");
			} else {
				return phone;
			}
		}
	}

	// 输入密码
	public static String inputPassword() {
		Scanner scanner = new Scanner(System.in);
		String password = null;
		int result;

		while (true) {
			System.out.print("输入密码:");
			password = scanner.next();
			result = Case1_lowful.password(password);
			if (result == 1) {
				System.out.println("输入的密码为空，请重新输入");
			} else if (result == 2) {
				System.out.println("密码必须为六位以上字符，至少包含大小写、阿拉伯数字三种字符中的两种");
			} else {
				return password;
			}
		}
	}

	// 输入员工类型
	public static String inputType() {
		Scanner scanner = new Scanner(System.in);
		String type = null;
		int result;

		while (true) {
			System.out
					.print("输入员工类型(0代表管理员，1代表分管信贷的副行长，2代表可选传阅人，3代表专制信贷审批人员，4代表有权传阅者):");
			type = scanner.next();
			result = Case1_lowful.type(type);
			if (result == 1) {
				System.out.println("输入的员工类型为空，请重新输入");
			} else if (result == 2) {
				System.out.println("输入的员工类型必须为0-4");
			} else {
				return type;
			}
		}
	}

	// 打印有误的登录名
	private static void printTheErrorLogNames(List<String> results) {
		for (String result : results) {
			System.out.println(result + ",该登录名有误!");
		}
	}
}
