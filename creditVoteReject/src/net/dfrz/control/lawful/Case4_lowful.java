package net.dfrz.control.lawful;

public class Case4_lowful {

	// �ж��˻���������������ĺϷ���
	public static int backJudgeLine(String line, int size) {
		if (line.isEmpty()) {
			// System.out.println("û����������-����������");
			return 1;
		} else if (line.equals("0")) {
			// System.out.println("�������������б���Ϊ������");
			return 2;
		} else if (Integer.parseInt(line) > size) {
			// System.out.println("��������������ֻ����1-" + meetDetails.size() +
			// ",����������");
			return 3;
		} else
			return 0;
	}

	// �ж��˻�����Ľ��ĺϷ���
	public static int changemoney(String money) {
		if (money.isEmpty()) {
			// System.out.println("û�����������-����������");
			return 1;
		} else if (Integer.parseInt(money) <= 0) {
			// System.out.println("�����������еĴ�����ֻ��������");
			return 2;
		} else if (Integer.parseInt(money) > 0) {
			return 0;
		} else {
			// System.out.println("�������");
			return 3;
		}
	}

}
