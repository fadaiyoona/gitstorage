package net.dfrz.view.print;

import java.util.Map;
import java.util.Set;

import net.dfrz.domain.MeetDetail;

public class Case4_print {

	// 打印退回重审的主菜单
	public static void printCase4_Menu() {
		System.out.println("商业银行信贷审批一票否决(退回重审)");
		System.out.println("================================");
	}

	// 打印退回重审的会议明细
	public static void printBackJudgeMeetDetails(
			Map<Integer, MeetDetail> meetDetails) {
		Set<Map.Entry<Integer, MeetDetail>> set = meetDetails.entrySet();
		for (Map.Entry<Integer, MeetDetail> meetDetail : set) {
			Integer key = meetDetail.getKey();
			String value = meetDetail.getValue().toString();
			System.out.println(key + " " + value);
		}
	}

}
