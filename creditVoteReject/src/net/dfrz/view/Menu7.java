package net.dfrz.view;

import java.io.File;
import java.util.Map;
import java.util.Scanner;

import net.dfrz.control.MeetAction;
import net.dfrz.domain.MeetDetail;
import net.dfrz.resource.Resource;
import net.dfrz.view.print.Case7_print;

public class Menu7 {

	public static void case1() {
		Scanner sc = new Scanner(System.in);

		Case7_print.printCase7_Menu();// 打印评审信息移植的主菜单
		System.out.print("将信贷审批会明细数据从txt文本移到excel存储?(y)es or (n)o, y?");
		String str = sc.nextLine();

		if (str.equals("y")) {

			Map<Integer, MeetDetail> meetDetails = MeetAction.queryMeetDetail();// 获取评审信息移植的会议信息
			File file = new File(Resource.MeetDetailsInfoExcelPath);
			MeetAction.write(meetDetails, file);// 将会议信息写入Excel文本
			System.out.println("移植成功!请到" + Resource.MeetDetailsInfoExcelPath
					+ "查看");// 打印Excel文本存储的位置
			System.out.println("按任意键返回...");
			sc.nextLine();
		} else {
			System.out.println("按任意键返回...");
			sc.nextLine();
		}
	}

}
