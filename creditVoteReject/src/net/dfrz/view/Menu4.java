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
			Case4_print.printCase4_Menu();// 打印退回重审的主菜单
			meetDetails = MeetAction.queryBackJudgeMeetDetail();// 获取退回重审的会议的信息
			// 打印退回重审的会议的信息
			Case4_print.printBackJudgeMeetDetails(meetDetails);
			line = Case4_input.inputBackJudgeLine(meetDetails.size());// 输入需要修改的会议
			money = Case4_input.changeMoney();// 输入更改的金额
			System.out.println("请确定是否提交(y)es or (n)o, y?");
			if (sc.nextLine().equals("y") || sc.nextLine().equals("yes")) {
				// 更新信贷审批会概要表
				MeetAction.updateMeet(meetDetails.get(line).getId(), "提交");
				// 更新信贷审批会明细表
				MeetAction.updateMeetDetailMoney(meetDetails.get(line).getId(),
						money);
				System.out.println("重审成功!");
				System.out.println("按任意键继续...");
				sc.nextLine();
			} else {
				System.out.println("重审失败!");
				System.out.println("按任意键继续...");
				sc.nextLine();
			}

			System.out.println("要不要重审另一个新的信贷审批会次(y)es or (n)o, y?");
			if (!Tools.isContinue()) {
				break;
			}
		}
	}

}
