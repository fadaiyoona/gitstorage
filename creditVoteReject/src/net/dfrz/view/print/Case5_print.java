package net.dfrz.view.print;

import java.util.Map;
import java.util.Set;

import net.dfrz.domain.Meet;
import net.dfrz.domain.MeetDetail;

public class Case5_print {

	public static void printMeetDetailsInfo(Map<MeetDetail, Meet> meets) {
		Set<Map.Entry<MeetDetail, Meet>> set = meets.entrySet();
		Meet meet = null;
		MeetDetail meetDetail = null;

		for (Map.Entry<MeetDetail, Meet> me : set) {
			meet = new Meet();
			meetDetail = new MeetDetail();

			meet = me.getValue();
			meetDetail = me.getKey();
			System.out.println(meet.getName() + ":" + meet.getPhone() + ":"
					+ meet.getSetDate() + ":" + meetDetail.getMeetYear() + "���"
					+ meetDetail.getFrequency() + "���Ŵ���������:"
					+ meetDetail.getAddress() + ":" + meetDetail.getCompany()
					+ ":" + meetDetail.getMoney() + ":"
					+ meetDetail.getComTypeName() + ":"
					+ meetDetail.getReason() + ":" + meet.getState());
		}
	}

	// ��ӡ�������
	public static void printCase5_Menu() {
		System.out.println("��ҵ�����Ŵ�����һƱ���(��������ѯ)");
		System.out.println("====================================");
	}

}
