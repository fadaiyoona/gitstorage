package net.dfrz.view.input;

import java.util.Scanner;

import net.dfrz.control.lawful.Case5_lowful;

public class Case6_input {

	// 输入开始日期
	public static String inputBeginDate() {
		String beginDate = null;
		int result;
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("输入查询的开始日期:");
			beginDate = sc.nextLine();
			result = Case5_lowful.date(beginDate);

			if (result == 1) {
				System.out.println("没有输入内容-请重新输入");
			} else if (result == 2) {
				System.out.println("对不起，输入的日期不存在，请重新输入");
			} else {
				return beginDate;
			}
		}
	}

	// 输入结束日期
	public static String inputEndDate() {
		String endDate = null;
		int result;
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("输入查询的结束日期:");
			endDate = sc.nextLine();
			result = Case5_lowful.date(endDate);

			if (result == 1) {
				System.out.println("没有输入内容-请重新输入");
			} else if (result == 2) {
				System.out.println("对不起，输入的日期不存在，请重新输入");
			} else {
				return endDate;
			}
		}
	}

	// 输入保存路径
	public static String inputAddress() {
		String address = null;
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("请输入保存路径:");
			address = sc.nextLine();

			if (address.isEmpty()) {
				System.out.println("没有输入内容-请重新输入");
			} else {
				break;
			}
		}
		return address;
	}

}
