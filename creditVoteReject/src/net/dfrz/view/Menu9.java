package net.dfrz.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import net.dfrz.control.MeetAction;
import net.dfrz.domain.MeetDetail;
import net.dfrz.view.print.Case9_print;

public class Menu9 {

	public static void case1() {
		Scanner sc = new Scanner(System.in);
		Map<Integer, MeetDetail> meetDetails = new HashMap<Integer, MeetDetail>();

		Case9_print.printCase9_Menu();// ��ӡ���Ĺ��ܵ����˵�

		meetDetails = MeetAction.queryMeetDetailByRounder(MainMenu.onlineUser);// ��ȡ�ɴ��ĵĻ�����Ϣ
		Case9_print.printMeetDetailsByRounder(meetDetails);// ��ӡ���������Ϣ
		System.out.println("�밴������������˵�");
		sc.nextLine();
	}
}
