package net.dfrz.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import net.dfrz.control.MeetAction;
import net.dfrz.domain.Meet;
import net.dfrz.domain.MeetDetail;
import net.dfrz.tools.Tools;
import net.dfrz.view.input.Case5_input;
import net.dfrz.view.print.Case5_print;

public class Menu5 {

	public static void case1() {
		String begin = null;
		String end = null;
		Map<MeetDetail, Meet> meets = new HashMap<MeetDetail, Meet>();
		Scanner sc = new Scanner(System.in);

		while (true) {
			Case5_print.printCase5_Menu();// 打印在审会议查询的主菜单
			begin = Case5_input.inputBeginDate();// 输入开始的时间
			end = Case5_input.inputEndDate();// 输入结束的时间
			if (Integer.parseInt(begin) > Integer.parseInt(end)) {
				System.out.println("开始日期不能大于结束日期");
				System.out.println("按任意键继续...");
				sc.nextLine();
				continue;
			}
			meets = MeetAction.quaryMeetDetail(begin, end);// 根据开始时间和结束时间获取到在审会议

			Case5_print.printMeetDetailsInfo(meets);// 打印在审会议

			System.out.println("是否重新查询(y)es or (n)o, y?");
			if (!Tools.isContinue()) {
				break;
			}
		}
	}

}
