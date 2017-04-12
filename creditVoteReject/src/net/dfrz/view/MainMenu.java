package net.dfrz.view;

import java.util.Scanner;

import net.dfrz.control.UserExit;
import net.dfrz.domain.User;
import net.dfrz.tools.Tools;
import net.dfrz.view.print.Case1_print;

public class MainMenu {
	public static User onlineUser = new User();// ��ǰ���ߵ��û�

	public static void main(String[] args) {
		// �û���¼
		LoginView.login();

		Scanner sc = new Scanner(System.in);
		String select = null;

		while (true) {
			// ��ӡϵͳ���˵�
			Case1_print.printMainMenu();
			System.out.print("���ѡ��:");
			select = sc.nextLine();

			switch (select) {
			case "1":// ��̨����
				if (!onlineUser.getType().equals("0")) {
					System.out.println("�Բ���,�ù�������ϵͳ����Ա ,�밴������˻�");
					sc.nextLine();
				} else {
					Case1_print.printCase1_Menu();// ��ӡ��̨����˵�
					System.out.print("���ѡ��:");
					select = sc.nextLine();

					if (select.equals("1")) {// �û�����
						Menu1.case1();// �û��������
					} else if (select.equals("2")) {// ������������
						Menu1.case2();// �����������ؽ���
						break;
					} else if (select.equals("Q") || select.equals("q")) {// �������˵�
						break;
					} else {
						Tools.invalidCode();// ������Ч�ֶ�
						break;
					}
				}
				break;
			case "2":// �Ŵ�������ι���
				if (!onlineUser.getType().equals("3")) {
					System.out.println("�Բ���,�ù�������רְ�Ŵ�������Ա ,�밴������˻�");
					sc.nextLine();
				} else {
					Menu2.case1();// �Ŵ�������ι������
					break;
				}
				break;
			case "3":// �г���ǩ
				if (!onlineUser.getType().equals("1")) {
					System.out.println("�Բ���,�ù������ڷֹ��Ŵ��ĸ��г�,�밴������˻�");
					sc.nextLine();
				} else {
					Menu3.case1();// �г���ǩ����
					break;
				}
				break;
			case "4":// �˻�����
				if (!onlineUser.getType().equals("3")) {
					System.out.println("�Բ���,�ù�������רְ�Ŵ�������Ա,�밴������˻�");
					sc.nextLine();
				} else {
					Menu4.case1();// �˻��������
				}
				break;
			case "5":// ��������ѯ
				Menu5.case1();// ��������ѯ����
				break;
			case "6":// ��ʷ��¼жȡ
				if (!onlineUser.getType().equals("1")
						&& !onlineUser.getType().equals("0")) {
					System.out.println("�Բ���,�ù������ڹ���Ա�͸��г�,�밴������˻�");
					sc.nextLine();
				} else {
					Menu6.case1();// ��ʷ��¼жȡ����
				}
				break;
			case "7":// ������Ϣ��ֲ
				if (!onlineUser.getType().equals("0")) {
					System.out.println("�Բ���,�ù������ڹ���Ա,�밴������˻�");
					sc.nextLine();
				} else {
					Menu7.case1();// ������Ϣ��ֲ����
				}
				break;
			case "8":// ������ǩ
				if (!onlineUser.getType().equals("1")) {
					System.out.println("�Բ���,�ù��������г�,�밴������˻ء�");
					sc.nextLine();
				} else {
					Menu8.case1();// ������ǩ����
				}
				break;
			case "9":// ����
				if (!onlineUser.getType().equals("4")) {
					System.out.println("�Բ���,�ù���������Ȩ������,�밴������˻ء�");
					sc.nextLine();
				} else {
					Menu9.case1();// ���Ľ���
				}
				break;
			case "q":
			case "Q":// �˳�����
				UserExit.exit();
				System.exit(0);
				break;
			case "":
				System.out
						.println("No selection entered. Press Enter to continue...");
				sc.nextLine();
				break;
			}
		}

	}
}
