package net.dfrz.view.input;

import java.util.Scanner;

import net.dfrz.control.lawful.Case8_lowful;

public class Case8_input {

	// ����Ҫ����������
	public static int inputLine(int size) {
		String line = null;
		int result;
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("���������������Ӧ������:");
			line = sc.nextLine();
			result = Case8_lowful.line(line, size);

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

	// ���������Ľ��
	public static String inputJudgeManyPeopleSign() {
		String select = null;
		int result;
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("���ѡ����������Ӧ�Ļ���������������(1��ͨ�� 2����� 3������):");
			select = sc.nextLine();
			result = Case8_lowful.judgemanypeoplesign(select);

			if (result == 1) {
				System.out.println("û����������-����������");
			} else if (result == 2) {
				System.out.println("��������������ֻ����1��2��3,����������");
			} else {
				select = initJudgeManyPeopleSign(select);
				return select;
			}
		}
	}

	// ��ʼ����������
	private static String initJudgeManyPeopleSign(String select) {
		if (select.equals("1")) {
			return "ͨ��";
		} else if (select.equals("2")) {
			return "���";
		} else if (select.equals("3")) {
			return "����";
		} else {
			return null;
		}
	}

}
