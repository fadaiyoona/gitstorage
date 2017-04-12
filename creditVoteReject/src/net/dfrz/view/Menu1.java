package net.dfrz.view;

import java.sql.SQLException;
import java.util.Scanner;

import net.dfrz.control.BackStageManagement;
import net.dfrz.control.MultipleSignAction;
import net.dfrz.domain.State;
import net.dfrz.domain.User;
import net.dfrz.tools.Tools;
import net.dfrz.view.input.Case1_input;
import net.dfrz.view.print.Case1_print;

public class Menu1 {

	public static void case1() {
		String empName;
		String logName;
		String phone;
		String password;
		String type;
		User user = new User();
		Scanner sc = new Scanner(System.in);
		String select = null;

		try {
			while (true) {
				user = new User();

				// 打印菜单
				Case1_print.printCase1_Houtai();

				// 输入员工名
				empName = Case1_input.inputEmpName();
				user.setEmpName(empName);
				// 输入用户的系统登录名
				logName = Case1_input.inputLogName();
				user.setLogName(logName);
				// 输入手机号码
				phone = Case1_input.inputPhone();
				user.setPhone(phone);
				// 输入密码
				password = Case1_input.inputPassword();
				user.setPassword(password);
				// 输入用户的类型
				type = Case1_input.inputType();
				user.setType(type);

				Case1_print.printUserInfo(user);// 打印新增员工的信息
				System.out.println("请确定是否新增(y)es or (n)o, y?");
				select = sc.nextLine();
				if (select.equals("y") || select.equals("yes")) {
					BackStageManagement.addUser(user);// 添加员工
					System.out.println("恭喜, 添加用户成功!");
					System.out.println("按任意键继续...");
					sc.nextLine();
				} else {
					System.out.println("添加用户失败!");
					System.out.println("按任意键继续...");
					sc.nextLine();
				}
				System.out.println("要不要添加一个新用户?(y)es or (n)o, y?");
				if (!Tools.isContinue()) {
					break;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void case2() {
		Scanner sc = new Scanner(System.in);
		String select = null;
		String governors = null;
		State state = null;

		Case1_print.printCase1_MultipleSign();// 打印多人审签开关的主菜单
		while (true) {
			System.out.println("启动多行长审签(y)es or (n)o, y?");
			select = sc.nextLine();
			if (select.equals("y") || select.equals("yes")) {
				governors = Case1_input.inputMultipleSignNames();
				state = new State();
				state.setSignedByTheGovernor(governors);
				Case1_print.printGovernors(governors);// 打印行长的名单

				System.out.print("请确定是否启动(y)es or (n)o, y?");
				select = sc.nextLine();
				if (select.equals("y") || select.equals("yes")) {
					state.setState(1);
					MultipleSignAction.open(state);// 打开多人审签开关
					System.out.println("启动成功!");
					System.out.println("按任意键继续...");
					sc.nextLine();
				} else {
					System.out.println("未启动!");
					System.out.println("按任意键继续...");
					sc.nextLine();
				}
			} else if (select.equals("n") || select.equals("no")) {
				System.out.println("请确定是否关闭(y/n)?");
				state = new State();
				select = sc.nextLine();
				if (select.equals("y") || select.equals("yes")) {
					state.setState(0);
					state.setSignedByTheGovernor(null);
					MultipleSignAction.close(state);// 关闭多人审签开关
					System.out.println("按任意键继续...");
					sc.nextLine();
					break;
				} else if (select.equals("n") || select.equals("no")) {
					System.out.println("按任意键继续...");
					sc.nextLine();
					break;
				}
			} else {
				System.out.println("按任意键继续...");
				sc.nextLine();
			}
		}

	}
}
