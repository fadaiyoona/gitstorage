package net.dfrz.view.print;

import java.util.Map;
import java.util.Set;

import net.dfrz.domain.MeetDetail;

public class Case3_print {

	// ��ӡ�г���ǩ�����˵�
	public static void printCase3_Menu() {
		System.out.println("��ҵ�����Ŵ�����һƱ���(�г�����)");
		System.out.println("==================================");
	}

	// ��ӡ������ǩ�Ļ�����ϸ
	public static void printMeetDetails(Map<Integer, MeetDetail> meetDetails) {
		Set<Map.Entry<Integer, MeetDetail>> set = meetDetails.entrySet();
		for (Map.Entry<Integer, MeetDetail> meet : set) {
			Integer key = meet.getKey();
			String value = meet.getValue().toString();
			System.out.println(key + " " + value);
		}
	}
}
