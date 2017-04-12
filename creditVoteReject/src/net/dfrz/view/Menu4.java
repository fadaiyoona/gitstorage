package net.dfrz.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import net.dfrz.control.MeetAction;
import net.dfrz.domain.MeetDetail;
import net.dfrz.tools.Tools;
import net.dfrz.view.input.Case4_input;
import net.dfrz.view.print.Case4_print;

public class Menu4 {

	public static void case1() {
		int line;
		String money = null;
		Scanner sc = new Scanner(System.in);
		Map<Integer, MeetDetail> meetDetails = new HashMap<Integer, MeetDetail>();

		while (true) {
			Case4_print.printCase4_Menu();// ��ӡ�˻���������˵�
			meetDetails = MeetAction.queryBackJudgeMeetDetail();// ��ȡ�˻�����Ļ������Ϣ
			// ��ӡ�˻�����Ļ������Ϣ
			Case4_print.printBackJudgeMeetDetails(meetDetails);
			line = Case4_input.inputBackJudgeLine(meetDetails.size());// ������Ҫ�޸ĵĻ���
			money = Case4_input.changeMoney();// ������ĵĽ��
			System.out.println("��ȷ���Ƿ��ύ(y)es or (n)o, y?");
			if (sc.nextLine().equals("y") || sc.nextLine().equals("yes")) {
				// �����Ŵ��������Ҫ��
				MeetAction.updateMeet(meetDetails.get(line).getId(), "�ύ");
				// �����Ŵ���������ϸ��
				MeetAction.updateMeetDetailMoney(meetDetails.get(line).getId(),
						money);
				System.out.println("����ɹ�!");
				System.out.println("�����������...");
				sc.nextLine();
			} else {
				System.out.println("����ʧ��!");
				System.out.println("�����������...");
				sc.nextLine();
			}

			System.out.println("Ҫ��Ҫ������һ���µ��Ŵ��������(y)es or (n)o, y?");
			if (!Tools.isContinue()) {
				break;
			}
		}
	}

}
