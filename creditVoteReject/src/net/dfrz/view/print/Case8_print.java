package net.dfrz.view.print;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import net.dfrz.domain.MeetDetail;

public class Case8_print {

	public static void printCase8_Menu() {
		System.out.println("��ҵ�����Ŵ�����һƱ���(���˻�ǩ)");
		System.out.println("================================");
	}

	public static void printMultipleSignMeetDetails(Map<Integer, MeetDetail> meetDetails) {
		Set<Entry<Integer, MeetDetail>> set = meetDetails.entrySet();

		for (Map.Entry<Integer, MeetDetail> meet : set) {
			Integer key = meet.getKey();
			String value = meet.getValue().toString();
			System.out.println(key + " " + value);
		}
	}

}
