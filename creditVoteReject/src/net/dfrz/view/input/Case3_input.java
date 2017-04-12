package net.dfrz.view.input;

import java.util.Map;
import java.util.Scanner;

import net.dfrz.control.lawful.Case3_lowful;
import net.dfrz.domain.MeetDetail;

public class Case3_input {

	// 输入要审批的行数
	public static int inputLine(Map<Integer, MeetDetail> meetDetails) {
		Scanner sc = new Scanner(System.in);
		String line = null;
		int result;

		while (true) {
			System.out.println("输入拟审批会议对应的行数:");
			line = sc.nextLine();
			result = Case3_lowful.line(line, meetDetails);

			if (result == 1) {
				System.out.println("没有输入内容-请重新输入");
			} else if (result == 2) {
				System.out.println("输入拟审批的行必须为正整数");
			} else if (result == 3) {
				System.out.println("输入拟审批的行只能是1-" + meetDetails.size() + ",请重新输入");
			} else
				return Integer.parseInt(line);
		}
	}

	// 输入审批的结果
	public static String inputJudge() {
		String select = null;
		Scanner sc = new Scanner(System.in);
		int result;

		while (true) {
			System.out.println("请对选定的行数对应的会议输入审批决定(1、通过 2、否决 3、重签):");
			select = sc.nextLine();
			result = Case3_lowful.judge(select);

			if (result == 1) {
				System.out.println("没有输入内容-请重新输入");
			} else if (result == 2) {
				System.out.println("输入拟审批的行只能是1或2或3,请重新输入");
			} else {
				return initJudge(select);
			}
		}
	}

	// 初始化行长审签的结果
	private static String initJudge(String select) {
		if (select.equals("1")) {
			return "通过";
		} else if (select.equals("2")) {
			return "否决";
		} else if (select.equals("3")) {
			return "重签";
		} else {
			return null;
		}
	}
}
