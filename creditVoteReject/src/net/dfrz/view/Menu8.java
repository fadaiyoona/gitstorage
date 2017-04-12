package net.dfrz.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import net.dfrz.control.MultipleSignAction;
import net.dfrz.domain.MeetDetail;
import net.dfrz.view.input.Case8_input;
import net.dfrz.view.print.Case8_print;

public class Menu8 {

	public static void case1() {
		Scanner sc = new Scanner(System.in);

		if (MultipleSignAction.isOpen()) {
			// �жϸ��г��Ƿ�μӱ��ζ�����ǩ
			if (MultipleSignAction.getSignGovernorsLogNames().contains(
					MainMenu.onlineUser.getLogName())) {
				int line;
				String judge = null;
				Map<Integer, MeetDetail> meetDetails = new HashMap<Integer, MeetDetail>();

				while (true) {
					Case8_print.printCase8_Menu();// ��ӡ�������������˵�
					meetDetails = MultipleSignAction
							.queryMultipleSignMeetDetails(MainMenu.onlineUser);// ��ȡ��Ҫ���������Ļ���
					Case8_print.printMultipleSignMeetDetails(meetDetails);// ��ӡ����Ҫ�����Ļ������Ϣ
					line = Case8_input.inputLine(meetDetails.size());// ������ǩ�Ļ���
					judge = Case8_input.inputJudgeManyPeopleSign();// ������ǩ�Ľ��
					System.out.println("��ȷ���Ƿ��ύ����(y)es or (n)o, y?");
					if (sc.nextLine().equals("y")) {
						MultipleSignAction.updateMultipleSignMeetDetail(
								meetDetails.get(line).getId(), judge,
								MainMenu.onlineUser);// ������ǩ���
						System.out.println("��ϲ,��ǩ�ɹ�");
						System.out.println("Ҫ��Ҫ��ǩ��һ���µ��Ŵ��������(y)es or (n)o, y?");
						if (sc.nextLine().equals("n")
								|| sc.nextLine().equals("no")) {
							break;
						}
					} else {
						System.out.println("�밴���������...");
						sc.nextLine();
						break;
					}
				}
			} else {
				System.out.println("��δ���������ǩģʽ");
				System.out.println("�밴���������");
				sc.nextLine();
			}
		} else {
			System.out.println("�Բ���,Ŀǰϵͳδ�������˻�ǩģʽ");
			System.out.println("�밴���������");
			sc.nextLine();
		}
	}
}
