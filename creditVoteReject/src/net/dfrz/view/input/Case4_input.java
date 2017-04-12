package net.dfrz.view.input;

import java.util.Scanner;

import net.dfrz.control.lawful.Case4_lowful;

public class Case4_input {

	// �����˻����������
	public static int inputBackJudgeLine(int size) {
		String line = null;
		int result;
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("�����������������Ӧ������:");
			line = sc.nextLine();
			result = Case4_lowful.backJudgeLine(line, size);

			if (result == 1) {
				System.out.println("û����������-����������");
			} else if (result == 2) {
				System.out.println("�������������б���Ϊ������");
			} else if (result == 3) {
				System.out.println("��������������ֻ����1-" + size + ",����������");
			} else
				break;
		}
		return Integer.parseInt(line);
	}

	// �����˻�����Ľ��
	public static String changeMoney() {
		String money = null;
		int result;
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("��������Ӧ���������Ŵ����Ŷ�ȵ���Ϊ(��Ԫ):");
			money = sc.nextLine();
			result = Case4_lowful.changemoney(money);

			if (result == 1) {
				System.out.println("û�����������-����������");
			} else if (result == 2) {
				System.out.println("�����������еĴ�����ֻ��������");
			} else if (result == 0) {
				return money;
			} else {
				System.out.println("�������");
			}
		}
	}

}
