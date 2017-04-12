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

		Case9_print.printCase9_Menu();// 打印传阅功能的主菜单

		meetDetails = MeetAction.queryMeetDetailByRounder(MainMenu.onlineUser);// 获取可传阅的会议信息
		Case9_print.printMeetDetailsByRounder(meetDetails);// 打印出会议的信息
		System.out.println("请按任意键返回主菜单");
		sc.nextLine();
	}
}
