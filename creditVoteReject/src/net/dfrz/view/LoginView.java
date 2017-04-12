package net.dfrz.view;

import java.util.Scanner;

import net.dfrz.control.UserLogin;
import net.dfrz.log.Log;

public class LoginView {
	static void login() {
		Scanner sc = new Scanner(System.in);

		System.out.println("��ҵ�����Ŵ�����һƱ���ϵͳ����¼ҳ�棩\n"
				+ "====================================================");
		while (true) {
			String userName = inputLoginName();
			String password = inputPassWord();

			if (UserLogin.isLogin(userName, password)) {
				MainMenu.onlineUser = UserLogin.login(userName, password);
				Log.addLog("��¼");
				System.out.println("��ӭ��" + MainMenu.onlineUser.getLogName()
						+ "");
				System.out.println("��������������˵�...");
				sc.nextLine();
				break;
			} else {
				System.out.println("�û��������벻��ȷ");
			}
		}

	}

	// ��������
	private static String inputPassWord() {
		Scanner scanner = new Scanner(System.in);
		String s = null;
		while (true) {
			System.out.print("����:");
			s = scanner.nextLine();
			if (s.isEmpty()) {
				System.out.println("�Բ���������Ϊ�գ����������롣");
			} else {
				return s;
			}
		}
	}

	// �����¼��
	private static String inputLoginName() {
		Scanner scanner = new Scanner(System.in);
		String s = null;
		while (true) {
			System.out.print("ϵͳ��¼��:");
			s = scanner.nextLine();
			if (s.isEmpty()) {
				System.out.println("�Բ���������Ϊ�գ����������롣");
			} else if (!isUserName(s)) {
				System.out.println("�Բ���������ĸ�ʽ����ȷ�����������롣");
			} else {
				return s;
			}
		}
	}

	// �жϵ�¼���Ƿ�Ϸ�
	private static boolean isUserName(String s) {
		if (!(s.matches("[a-zA-Z0-9]+[.][f][j]") || s.matches("admin")))
			return false;
		return true;
	}
}
