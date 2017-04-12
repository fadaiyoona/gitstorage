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
			// 判断该行长是否参加本次多人审签
			if (MultipleSignAction.getSignGovernorsLogNames().contains(
					MainMenu.onlineUser.getLogName())) {
				int line;
				String judge = null;
				Map<Integer, MeetDetail> meetDetails = new HashMap<Integer, MeetDetail>();

				while (true) {
					Case8_print.printCase8_Menu();// 打印多人审批的主菜单
					meetDetails = MultipleSignAction
							.queryMultipleSignMeetDetails(MainMenu.onlineUser);// 获取需要多人审批的会议
					Case8_print.printMultipleSignMeetDetails(meetDetails);// 打印出需要审批的会议的信息
					line = Case8_input.inputLine(meetDetails.size());// 输入审签的会议
					judge = Case8_input.inputJudgeManyPeopleSign();// 输入审签的结果
					System.out.println("请确定是否提交审批(y)es or (n)o, y?");
					if (sc.nextLine().equals("y")) {
						MultipleSignAction.updateMultipleSignMeetDetail(
								meetDetails.get(line).getId(), judge,
								MainMenu.onlineUser);// 更新审签结果
						System.out.println("恭喜,审签成功");
						System.out.println("要不要审签另一个新的信贷审批会次(y)es or (n)o, y?");
						if (sc.nextLine().equals("n")
								|| sc.nextLine().equals("no")) {
							break;
						}
					} else {
						System.out.println("请按任意键返回...");
						sc.nextLine();
						break;
					}
				}
			} else {
				System.out.println("您未参与多人审签模式");
				System.out.println("请按任意键返回");
				sc.nextLine();
			}
		} else {
			System.out.println("对不起,目前系统未开启多人会签模式");
			System.out.println("请按任意键返回");
			sc.nextLine();
		}
	}
}
