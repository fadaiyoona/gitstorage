package net.dfrz.view;

import java.util.Scanner;

import net.dfrz.control.MeetAction;
import net.dfrz.domain.Meet;
import net.dfrz.domain.MeetDetail;
import net.dfrz.tools.Tools;
import net.dfrz.view.input.Case2_input;
import net.dfrz.view.print.Case2_print;

public class Menu2 {

	public static void case1() {
		String comName;
		String comAddress;
		String money;
		String comType;
		String reason;
		String rounders;
		Scanner sc = new Scanner(System.in);
		MeetDetail meetDetail = null;
		Meet meet = null;
		String select = null;

		Case2_print.printCase2_Menu();
		while (true) {
			meetDetail = new MeetDetail();
			System.out.println("新增一个信贷审批会次详细信息。");

			// 输入公司名称
			comName = Case2_input.inputComName();
			meetDetail.setCompany(comName);
			// 输入公司地址
			comAddress = Case2_input.inputComAddress();
			meetDetail.setAddress(comAddress);
			// 输入贷款金额
			money = Case2_input.inputMoney();
			meetDetail.setMoney(money);
			// 输入公司类型
			comType = Case2_input.inputComType();
			meetDetail.setComTypeName(comType);
			// 输入原因
			reason = Case2_input.inputReason();
			meetDetail.setReason(reason);
			// 输入传阅者
			rounders = Case2_input.inputRounders();
			meet = new Meet();
			meet.setRounder(rounders);

			Case2_print.printMeetDetail(meetDetail, meet);// 打印新增的会议信息

			System.out.println("请确定是否添加该信贷审批会次(y)es or (n)o, y?");
			select = sc.nextLine();
			if (select.equals("y") || select.equals("yes")) {
				MeetAction.add(meetDetail);// 添加会议明细
				meet = MeetAction.initMeet(MainMenu.onlineUser, meet);// 初始化会议概要
				MeetAction.add(meet);// 添加会议概要
				System.out.println("恭喜,本条提交行长审签成功。");
				System.out.println("按任意键继续...");
				sc.nextLine();
			} else {
				System.out.println("添加失败!");
				System.out.println("按任意键继续...");
				sc.nextLine();
			}
			System.out.println("要不要添加一个新的信贷审批会次信息(y)es or (n)o, y?");
			if (!Tools.isContinue()) {
				break;
			}
		}
	}
}
