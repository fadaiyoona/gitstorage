package net.dfrz.view;

import java.util.Scanner;

import net.dfrz.control.UserLogin;
import net.dfrz.log.Log;

public class LoginView {
	static void login() {
		Scanner sc = new Scanner(System.in);

		System.out.println("商业银行信贷审批一票否决系统（登录页面）\n"
				+ "====================================================");
		while (true) {
			String userName = inputLoginName();
			String password = inputPassWord();

			if (UserLogin.isLogin(userName, password)) {
				MainMenu.onlineUser = UserLogin.login(userName, password);
				Log.addLog("登录");
				System.out.println("欢迎：" + MainMenu.onlineUser.getLogName()
						+ "");
				System.out.println("按任意键进入主菜单...");
				sc.nextLine();
				break;
			} else {
				System.out.println("用户名或密码不正确");
			}
		}

	}

	// 输入密码
	private static String inputPassWord() {
		Scanner scanner = new Scanner(System.in);
		String s = null;
		while (true) {
			System.out.print("密码:");
			s = scanner.nextLine();
			if (s.isEmpty()) {
				System.out.println("对不起，您输入为空，请重新输入。");
			} else {
				return s;
			}
		}
	}

	// 输入登录名
	private static String inputLoginName() {
		Scanner scanner = new Scanner(System.in);
		String s = null;
		while (true) {
			System.out.print("系统登录名:");
			s = scanner.nextLine();
			if (s.isEmpty()) {
				System.out.println("对不起，您输入为空，请重新输入。");
			} else if (!isUserName(s)) {
				System.out.println("对不起，您输入的格式不正确，请重新输入。");
			} else {
				return s;
			}
		}
	}

	// 判断登录名是否合法
	private static boolean isUserName(String s) {
		if (!(s.matches("[a-zA-Z0-9]+[.][f][j]") || s.matches("admin")))
			return false;
		return true;
	}
}
