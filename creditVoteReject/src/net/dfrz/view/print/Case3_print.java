package net.dfrz.view.print;

import java.util.Map;
import java.util.Set;

import net.dfrz.domain.MeetDetail;

public class Case3_print {

	// 打印行长审签的主菜单
	public static void printCase3_Menu() {
		System.out.println("商业银行信贷审批一票否决(行长审批)");
		System.out.println("==================================");
	}

	// 打印多人审签的会议明细
	public static void printMeetDetails(Map<Integer, MeetDetail> meetDetails) {
		Set<Map.Entry<Integer, MeetDetail>> set = meetDetails.entrySet();
		for (Map.Entry<Integer, MeetDetail> meet : set) {
			Integer key = meet.getKey();
			String value = meet.getValue().toString();
			System.out.println(key + " " + value);
		}
	}
}
