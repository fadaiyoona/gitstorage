package net.dfrz.control.lawful;

public class Case8_lowful {

	// �ж����������ĺϷ���
	public static int line(String line, int size) {
		if (line.isEmpty()) {
			// System.out.println("û����������-����������");
			return 1;
		} else if (line.equals("0")) {
			// System.out.println("�������������б���Ϊ������");
			return 2;
		} else if (Integer.parseInt(line) > size) {
			// System.out.println("��������������ֻ����1-" + size + ",����������");
			return 3;
		} else
			return 0;
	}

	// �ж��������ǩ�����ĺϷ���
	public static int judgemanypeoplesign(String select) {
		if (select.isEmpty()) {
			// System.out.println("û����������-����������");
			return 1;
		} else if (!select.matches("[1-3]")) {
			// System.out.println("��������������ֻ����1��2,����������");
			return 2;
		} else {
			return 0;
		}
	}

}
