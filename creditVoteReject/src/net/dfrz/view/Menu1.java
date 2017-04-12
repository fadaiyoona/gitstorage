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

				// ��ӡ�˵�
				Case1_print.printCase1_Houtai();

				// ����Ա����
				empName = Case1_input.inputEmpName();
				user.setEmpName(empName);
				// �����û���ϵͳ��¼��
				logName = Case1_input.inputLogName();
				user.setLogName(logName);
				// �����ֻ�����
				phone = Case1_input.inputPhone();
				user.setPhone(phone);
				// ��������
				password = Case1_input.inputPassword();
				user.setPassword(password);
				// �����û�������
				type = Case1_input.inputType();
				user.setType(type);

				Case1_print.printUserInfo(user);// ��ӡ����Ա������Ϣ
				System.out.println("��ȷ���Ƿ�����(y)es or (n)o, y?");
				select = sc.nextLine();
				if (select.equals("y") || select.equals("yes")) {
					BackStageManagement.addUser(user);// ���Ա��
					System.out.println("��ϲ, ����û��ɹ�!");
					System.out.println("�����������...");
					sc.nextLine();
				} else {
					System.out.println("����û�ʧ��!");
					System.out.println("�����������...");
					sc.nextLine();
				}
				System.out.println("Ҫ��Ҫ���һ�����û�?(y)es or (n)o, y?");
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

		Case1_print.printCase1_MultipleSign();// ��ӡ������ǩ���ص����˵�
		while (true) {
			System.out.println("�������г���ǩ(y)es or (n)o, y?");
			select = sc.nextLine();
			if (select.equals("y") || select.equals("yes")) {
				governors = Case1_input.inputMultipleSignNames();
				state = new State();
				state.setSignedByTheGovernor(governors);
				Case1_print.printGovernors(governors);// ��ӡ�г�������

				System.out.print("��ȷ���Ƿ�����(y)es or (n)o, y?");
				select = sc.nextLine();
				if (select.equals("y") || select.equals("yes")) {
					state.setState(1);
					MultipleSignAction.open(state);// �򿪶�����ǩ����
					System.out.println("�����ɹ�!");
					System.out.println("�����������...");
					sc.nextLine();
				} else {
					System.out.println("δ����!");
					System.out.println("�����������...");
					sc.nextLine();
				}
			} else if (select.equals("n") || select.equals("no")) {
				System.out.println("��ȷ���Ƿ�ر�(y/n)?");
				state = new State();
				select = sc.nextLine();
				if (select.equals("y") || select.equals("yes")) {
					state.setState(0);
					state.setSignedByTheGovernor(null);
					MultipleSignAction.close(state);// �رն�����ǩ����
					System.out.println("�����������...");
					sc.nextLine();
					break;
				} else if (select.equals("n") || select.equals("no")) {
					System.out.println("�����������...");
					sc.nextLine();
					break;
				}
			} else {
				System.out.println("�����������...");
				sc.nextLine();
			}
		}

	}
}
