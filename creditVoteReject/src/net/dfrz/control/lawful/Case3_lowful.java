package net.dfrz.control.lawful;

import java.util.Map;

import net.dfrz.domain.MeetDetail;

public class Case3_lowful {

	// 判断多人审签输入的行数的合法性
	public static int line(String line, Map<Integer, MeetDetail> meetDetails) {
		if (line.isEmpty()) {
			// System.out.println("没有输入内容-请重新输入");
			return 1;
		} else if (line.equals("0")) {
			// System.out.println("输入拟审批的行必须为正整数");
			return 2;
		} else if (Integer.parseInt(line) > meetDetails.size()) {
			// System.out.println("输入拟审批的行只能是1-" + meetDetails.size() +
			// ",请重新输入");
			return 3;
		} else
			return 0;
	}

	// 判断行长审签的结果合法性
	public static int judge(String select) {
		if (select.isEmpty()) {
			// System.out.println("没有输入内容-请重新输入");
			return 1;
		} else if (!select.matches("[1-3]")) {
			// System.out.println("输入拟审批的行只能是1或2或3,请重新输入");
			return 2;
		} else {
			return 0;
		}
	}

}
