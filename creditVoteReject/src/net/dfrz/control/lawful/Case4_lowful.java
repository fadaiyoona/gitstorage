package net.dfrz.control.lawful;

public class Case4_lowful {

	// 判断退回重审的输入行数的合法性
	public static int backJudgeLine(String line, int size) {
		if (line.isEmpty()) {
			// System.out.println("没有输入内容-请重新输入");
			return 1;
		} else if (line.equals("0")) {
			// System.out.println("输入拟审批的行必须为正整数");
			return 2;
		} else if (Integer.parseInt(line) > size) {
			// System.out.println("输入拟审批的行只能是1-" + meetDetails.size() +
			// ",请重新输入");
			return 3;
		} else
			return 0;
	}

	// 判断退回重审的金额的合法性
	public static int changemoney(String money) {
		if (money.isEmpty()) {
			// System.out.println("没有输入贷款金额-请重新输入");
			return 1;
		} else if (Integer.parseInt(money) <= 0) {
			// System.out.println("输入拟审批行的贷款金额只能是正数");
			return 2;
		} else if (Integer.parseInt(money) > 0) {
			return 0;
		} else {
			// System.out.println("输入错误");
			return 3;
		}
	}

}
