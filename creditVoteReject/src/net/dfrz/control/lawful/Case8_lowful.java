package net.dfrz.control.lawful;

public class Case8_lowful {

	// 判断输入行数的合法性
	public static int line(String line, int size) {
		if (line.isEmpty()) {
			// System.out.println("没有输入内容-请重新输入");
			return 1;
		} else if (line.equals("0")) {
			// System.out.println("输入拟审批的行必须为正整数");
			return 2;
		} else if (Integer.parseInt(line) > size) {
			// System.out.println("输入拟审批的行只能是1-" + size + ",请重新输入");
			return 3;
		} else
			return 0;
	}

	// 判断输入的审签行数的合法性
	public static int judgemanypeoplesign(String select) {
		if (select.isEmpty()) {
			// System.out.println("没有输入内容-请重新输入");
			return 1;
		} else if (!select.matches("[1-3]")) {
			// System.out.println("输入拟审批的行只能是1或2,请重新输入");
			return 2;
		} else {
			return 0;
		}
	}

}
