package net.dfrz.view.input;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import net.dfrz.control.lawful.Case2_lowful;

public class Case2_input {

	// 输入公司名称
	public static String inputComName() {
		String comName = null;
		Scanner sc = new Scanner(System.in);
		int result;

		while (true) {
			System.out.printf("请输入公司名:");
			comName = sc.nextLine();
			result = Case2_lowful.comName(comName);

			if (result == 1) {
				System.out.println("没有输入公司-请重新输入");
			} else if (result == 0) {
				return comName;
			} else {
				System.out.println("输入的公司名必须为汉字，字数2-10位，请重新输入");
			}
		}
	}

	// 输入公司地址
	public static String inputComAddress() {
		String comAddress = null;
		int result;
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out
					.println("输入行别(1.福州 2.莆田 3.泉州 4.厦门 5.漳州 6.龙岩 7.三明 8.南平 9.宁德):");
			comAddress = sc.nextLine();
			result = Case2_lowful.comAddress(comAddress);

			if (result == 1) {
				System.out.println("没有输入公司-请重新输入");
			} else if (result == 0) {
				return comAddress;
			} else {
				System.out.println("输入的公司名必须为1-9之间的阿拉伯数字，请重新输入");
			}
		}
	}

	// 输入贷款金额
	public static String inputMoney() {
		String money = null;
		int result;
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("输入贷款金额(万元):");
			money = sc.nextLine();
			result = Case2_lowful.money(money);

			if (result == 1) {
				System.out.println("没有输入贷款金额-请重新输入");
			} else if (result == 0) {
				return money;
			} else {
				System.out.println("输入的贷款金额必须为正数，请重新输入");
			}
		}
	}

	// 输入公司类型
	public static String inputComType() {
		String comType = null;
		int result;
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("输入企业类型(1.大型 2.中型 3.小型):");
			comType = sc.nextLine();
			result = Case2_lowful.comType(comType);

			if (result == 1) {
				System.out.println("没有输入企业类型-请重新输入");
			} else if (result == 0) {
				comType = initComType(comType);
				return comType;
			} else {
				System.out.println("输入的企业类型必须为1或2或3，请重新输入");
			}
		}
	}

	// 输入原因
	public static String inputReason() {
		String reason = null;
		int result;
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("输入审批理由:");
			reason = sc.nextLine();
			result = Case2_lowful.reason(reason);

			if (result == 1) {
				System.out.println("没有输入审批理由-请重新输入");
			} else if (result == 0) {
				return reason;
			} else {
				System.out.println("输入的审批理由必须为6个以上字符，请重新输入");
			}
		}
	}

	// 输入可传阅者
	public static String inputRounders() {
		Scanner sc = new Scanner(System.in);
		String transmiter = null;
		String[] logNames;
		List<String> results = new ArrayList<String>();

		while (true) {
			System.out.print("输入传阅者的姓名(用,隔开):");
			transmiter = sc.nextLine();
			logNames = transmiter.split(",");
			results = Case2_lowful.rounders(logNames);
			if (results.size() > 0) {
				printTheErrorLogNames(results);
			} else {
				break;
			}
		}
		return transmiter;
	}

	// 初始化公司类型
	private static String initComType(String comType) {
		if (comType.equals("1")) {
			return "大型";
		} else if (comType.equals("2")) {
			return "中型";
		} else if (comType.equals("3")) {
			return "小型";
		} else {
			return null;
		}
	}

	// 打印有误的登录名
	private static void printTheErrorLogNames(List<String> results) {
		for (String result : results) {
			System.out.println(result + ",该登录名有误!");
		}
	}

}
