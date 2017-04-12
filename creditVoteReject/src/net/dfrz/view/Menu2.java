package net.dfrz.view;

import java.util.Scanner;

import net.dfrz.control.MeetAction;
import net.dfrz.domain.Meet;
import net.dfrz.domain.MeetDetail;
import net.dfrz.tools.Tools;
import net.dfrz.view.input.Case2_input;
import net.dfrz.view.print.Case2_print;

public class Menu2 {

	public static void case1() {
		String comName;
		String comAddress;
		String money;
		String comType;
		String reason;
		String rounders;
		Scanner sc = new Scanner(System.in);
		MeetDetail meetDetail = null;
		Meet meet = null;
		String select = null;

		Case2_print.printCase2_Menu();
		while (true) {
			meetDetail = new MeetDetail();
			System.out.println("����һ���Ŵ����������ϸ��Ϣ��");

			// ���빫˾����
			comName = Case2_input.inputComName();
			meetDetail.setCompany(comName);
			// ���빫˾��ַ
			comAddress = Case2_input.inputComAddress();
			meetDetail.setAddress(comAddress);
			// ���������
			money = Case2_input.inputMoney();
			meetDetail.setMoney(money);
			// ���빫˾����
			comType = Case2_input.inputComType();
			meetDetail.setComTypeName(comType);
			// ����ԭ��
			reason = Case2_input.inputReason();
			meetDetail.setReason(reason);
			// ���봫����
			rounders = Case2_input.inputRounders();
			meet = new Meet();
			meet.setRounder(rounders);

			Case2_print.printMeetDetail(meetDetail, meet);// ��ӡ�����Ļ�����Ϣ

			System.out.println("��ȷ���Ƿ���Ӹ��Ŵ��������(y)es or (n)o, y?");
			select = sc.nextLine();
			if (select.equals("y") || select.equals("yes")) {
				MeetAction.add(meetDetail);// ��ӻ�����ϸ
				meet = MeetAction.initMeet(MainMenu.onlineUser, meet);// ��ʼ�������Ҫ
				MeetAction.add(meet);// ��ӻ����Ҫ
				System.out.println("��ϲ,�����ύ�г���ǩ�ɹ���");
				System.out.println("�����������...");
				sc.nextLine();
			} else {
				System.out.println("���ʧ��!");
				System.out.println("�����������...");
				sc.nextLine();
			}
			System.out.println("Ҫ��Ҫ���һ���µ��Ŵ����������Ϣ(y)es or (n)o, y?");
			if (!Tools.isContinue()) {
				break;
			}
		}
	}
}
