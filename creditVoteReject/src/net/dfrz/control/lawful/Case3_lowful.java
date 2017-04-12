package net.dfrz.control.lawful;

import java.util.Map;

import net.dfrz.domain.MeetDetail;

public class Case3_lowful {

	// �ж϶�����ǩ����������ĺϷ���
	public static int line(String line, Map<Integer, MeetDetail> meetDetails) {
		if (line.isEmpty()) {
			// System.out.println("û����������-����������");
			return 1;
		} else if (line.equals("0")) {
			// System.out.println("�������������б���Ϊ������");
			return 2;
		} else if (Integer.parseInt(line) > meetDetails.size()) {
			// System.out.println("��������������ֻ����1-" + meetDetails.size() +
			// ",����������");
			return 3;
		} else
			return 0;
	}

	// �ж��г���ǩ�Ľ���Ϸ���
	public static int judge(String select) {
		if (select.isEmpty()) {
			// System.out.println("û����������-����������");
			return 1;
		} else if (!select.matches("[1-3]")) {
			// System.out.println("��������������ֻ����1��2��3,����������");
			return 2;
		} else {
			return 0;
		}
	}

}
