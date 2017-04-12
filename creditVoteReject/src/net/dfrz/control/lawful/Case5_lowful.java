package net.dfrz.control.lawful;

import java.util.List;

import net.dfrz.control.MeetAction;

public class Case5_lowful {

	// 判断在审会议查询中日期的合法性
	public static int date(String beginDate) {
		List<String> list = MeetAction.quarySetDate();

		if (beginDate.isEmpty()) {
			// System.out.println("没有输入内容-请重新输入");
			return 1;
		} else if (!list.contains(beginDate)) {
			// System.out.println("对不起，输入的日期不存在，请重新输入");
			return 2;
		} else {
			return 0;
		}
	}
}
