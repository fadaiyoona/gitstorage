package net.dfrz.view.print;

import java.util.Map;
import java.util.Set;

import net.dfrz.domain.MeetDetail;

public class Case9_print {

	public static void printCase9_Menu() {
		System.out.println("��ҵ�����Ŵ�����һƱ���(����)");
		System.out.println("===============================");
	}

	public static void printMeetDetailsByRounder(
			Map<Integer, MeetDetail> meetDetails) {
		Set<Map.Entry<Integer, MeetDetail>> set = meetDetails.entrySet();

		for (Map.Entry<Integer, MeetDetail> meet : set) {
			Integer key = meet.getKey();
			String value = meet.getValue().toString();
			System.out.println(key + " " + value);

		}
	}

}
