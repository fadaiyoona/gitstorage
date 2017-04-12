package net.dfrz.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import net.dfrz.control.MeetAction;
import net.dfrz.domain.Meet;
import net.dfrz.domain.MeetDetail;
import net.dfrz.view.input.Case6_input;
import net.dfrz.view.print.Case6_print;

public class Menu6 {

	public static void case1() {
		String begin = null;
		String end = null;
		String address = null;

		Map<MeetDetail, Meet> meets = new HashMap<MeetDetail, Meet>();
		Scanner sc = new Scanner(System.in);

		while (true) {
			Case6_print.printCase6_Menu();// 打印历史记录卸取的主菜单

			begin = Case6_input.inputBeginDate();// 输入开始时间
			end = Case6_input.inputEndDate();// 输入结束时间
			address = Case6_input.inputAddress();// 输入保存的地址

			Case6_print.printAddress(address);// 打印保存的地址
			meets = MeetAction.queryHistoryLogging(begin, end);// 获取历史记录卸取的会议
			MeetAction.write(meets, address);// 将会议写入文本
			System.out.println("按任意键继续...");
			sc.nextLine();

			System.out.println("是否重新查询(y)es or (n)o, y?");
			if (sc.nextLine().equals("n"))
				break;

		}
	}

}
