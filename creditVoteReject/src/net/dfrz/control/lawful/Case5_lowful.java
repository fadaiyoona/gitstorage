package net.dfrz.control.lawful;

import java.util.List;

import net.dfrz.control.MeetAction;

public class Case5_lowful {

	// �ж���������ѯ�����ڵĺϷ���
	public static int date(String beginDate) {
		List<String> list = MeetAction.quarySetDate();

		if (beginDate.isEmpty()) {
			// System.out.println("û����������-����������");
			return 1;
		} else if (!list.contains(beginDate)) {
			// System.out.println("�Բ�����������ڲ����ڣ�����������");
			return 2;
		} else {
			return 0;
		}
	}
}
