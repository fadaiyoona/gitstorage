package net.dfrz.view.print;

import java.util.Map;
import java.util.Set;

import net.dfrz.domain.MeetDetail;

public class Case4_print {

	// ��ӡ�˻���������˵�
	public static void printCase4_Menu() {
		System.out.println("��ҵ�����Ŵ�����һƱ���(�˻�����)");
		System.out.println("================================");
	}

	// ��ӡ�˻�����Ļ�����ϸ
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
