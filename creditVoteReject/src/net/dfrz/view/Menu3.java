package net.dfrz.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import net.dfrz.control.MeetAction;
import net.dfrz.domain.MeetDetail;
import net.dfrz.tools.Tools;
import net.dfrz.view.input.Case3_input;
import net.dfrz.view.print.Case3_print;

public class Menu3 {

	public static void case1() {
		int line;
		String judge = null;
		Scanner sc = new Scanner(System.in);
		Map<Integer, MeetDetail> meetDetails = new HashMap<Integer, MeetDetail>();
		String select = null;

		while (true) {
			Case3_print.printCase3_Menu();// ��ӡ�г���ǩ�����˵�
			meetDetails = MeetAction.queryMeetDetailShenQian();// ��ȡ��Ҫ�г���ǩ�Ļ�����ϸ
			Case3_print.printMeetDetails(meetDetails);// ��ӡ��Ҫ�г���ǩ�Ļ�����ϸ
			// ����Ҫ����������
			line = Case3_input.inputLine(meetDetails);
			// ���������Ľ��
			judge = Case3_input.inputJudge();
			System.out.println("��ȷ���Ƿ��ύ����(y)es or (n)o,y?");
			select = sc.nextLine();
			if (select.equals("y") || select.equals("yes")) {
				MeetAction.updateMeet(meetDetails.get(line).getId(), judge);// ���»�����ǩ���
				System.out.println("��ϲ,��ǩ�ɹ�");
				System.out.println("�����������...");
				sc.nextLine();
			} else {
				System.out.println("��ǩʧ��");
				System.out.println("�����������...");
				sc.nextLine();
			}

			System.out.println("Ҫ��Ҫ��ǩ��һ���µ��Ŵ��������(y)es or (n)o, y?");
			if (!Tools.isContinue()) {
				break;
			}
		}
	}

}
