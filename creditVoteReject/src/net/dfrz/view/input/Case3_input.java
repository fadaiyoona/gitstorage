package net.dfrz.view.input;

import java.util.Map;
import java.util.Scanner;

import net.dfrz.control.lawful.Case3_lowful;
import net.dfrz.domain.MeetDetail;

public class Case3_input {

	// ����Ҫ����������
	public static int inputLine(Map<Integer, MeetDetail> meetDetails) {
		Scanner sc = new Scanner(System.in);
		String line = null;
		int result;

		while (true) {
			System.out.println("���������������Ӧ������:");
			line = sc.nextLine();
			result = Case3_lowful.line(line, meetDetails);

			if (result == 1) {
				System.out.println("û����������-����������");
			} else if (result == 2) {
				System.out.println("�������������б���Ϊ������");
			} else if (result == 3) {
				System.out.println("��������������ֻ����1-" + meetDetails.size() + ",����������");
			} else
				return Integer.parseInt(line);
		}
	}

	// ���������Ľ��
	public static String inputJudge() {
		String select = null;
		Scanner sc = new Scanner(System.in);
		int result;

		while (true) {
			System.out.println("���ѡ����������Ӧ�Ļ���������������(1��ͨ�� 2����� 3����ǩ):");
			select = sc.nextLine();
			result = Case3_lowful.judge(select);

			if (result == 1) {
				System.out.println("û����������-����������");
			} else if (result == 2) {
				System.out.println("��������������ֻ����1��2��3,����������");
			} else {
				return initJudge(select);
			}
		}
	}

	// ��ʼ���г���ǩ�Ľ��
	private static String initJudge(String select) {
		if (select.equals("1")) {
			return "ͨ��";
		} else if (select.equals("2")) {
			return "���";
		} else if (select.equals("3")) {
			return "��ǩ";
		} else {
			return null;
		}
	}
}
