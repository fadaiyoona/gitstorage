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
			Case3_print.printCase3_Menu();// 打印行长审签的主菜单
			meetDetails = MeetAction.queryMeetDetailShenQian();// 获取需要行长审签的会议明细
			Case3_print.printMeetDetails(meetDetails);// 打印需要行长审签的会议明细
			// 输入要审批的行数
			line = Case3_input.inputLine(meetDetails);
			// 输入审批的结果
			judge = Case3_input.inputJudge();
			System.out.println("请确定是否提交审批(y)es or (n)o,y?");
			select = sc.nextLine();
			if (select.equals("y") || select.equals("yes")) {
				MeetAction.updateMeet(meetDetails.get(line).getId(), judge);// 更新会议审签结果
				System.out.println("恭喜,审签成功");
				System.out.println("按任意键继续...");
				sc.nextLine();
			} else {
				System.out.println("审签失败");
				System.out.println("按任意键继续...");
				sc.nextLine();
			}

			System.out.println("要不要审签另一个新的信贷审批会次(y)es or (n)o, y?");
			if (!Tools.isContinue()) {
				break;
			}
		}
	}

}
