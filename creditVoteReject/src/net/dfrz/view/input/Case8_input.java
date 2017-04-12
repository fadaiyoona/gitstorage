package net.dfrz.view.input;

import java.util.Scanner;

import net.dfrz.control.lawful.Case8_lowful;

public class Case8_input {

	// 输入要审批的行数
	public static int inputLine(int size) {
		String line = null;
		int result;
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("输入拟审批会议对应的行数:");
			line = sc.nextLine();
			result = Case8_lowful.line(line, size);

			if (result == 1) {
				System.out.println("没有输入内容-请重新输入");
			} else if (result == 2) {
				System.out.println("输入拟审批的行必须为正整数");
			} else if (result == 3) {
				System.out.println("输入拟审批的行只能是1-" + size + ",请重新输入");
			} else
				break;
		}
		return Integer.parseInt(line);
	}

	// 输入审批的结果
	public static String inputJudgeManyPeopleSign() {
		String select = null;
		int result;
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("请对选定的行数对应的会议输入审批决定(1、通过 2、否决 3、重审):");
			select = sc.nextLine();
			result = Case8_lowful.judgemanypeoplesign(select);

			if (result == 1) {
				System.out.println("没有输入内容-请重新输入");
			} else if (result == 2) {
				System.out.println("输入拟审批的行只能是1或2或3,请重新输入");
			} else {
				select = initJudgeManyPeopleSign(select);
				return select;
			}
		}
	}

	// 初始化审批决定
	private static String initJudgeManyPeopleSign(String select) {
		if (select.equals("1")) {
			return "通过";
		} else if (select.equals("2")) {
			return "否决";
		} else if (select.equals("3")) {
			return "重审";
		} else {
			return null;
		}
	}

}
