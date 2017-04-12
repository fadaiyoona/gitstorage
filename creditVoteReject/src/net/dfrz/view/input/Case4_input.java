package net.dfrz.view.input;

import java.util.Scanner;

import net.dfrz.control.lawful.Case4_lowful;

public class Case4_input {

	// 输入退回重审的行数
	public static int inputBackJudgeLine(int size) {
		String line = null;
		int result;
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("输入拟重审会议所对应的行数:");
			line = sc.nextLine();
			result = Case4_lowful.backJudgeLine(line, size);

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

	// 输入退回重审的金额
	public static String changeMoney() {
		String money = null;
		int result;
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("本行所对应的审批会信贷发放额度调整为(万元):");
			money = sc.nextLine();
			result = Case4_lowful.changemoney(money);

			if (result == 1) {
				System.out.println("没有输入贷款金额-请重新输入");
			} else if (result == 2) {
				System.out.println("输入拟审批行的贷款金额只能是正数");
			} else if (result == 0) {
				return money;
			} else {
				System.out.println("输入错误");
			}
		}
	}

}
