package net.dfrz.view.input;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import net.dfrz.control.lawful.Case2_lowful;

public class Case2_input {

	// ���빫˾����
	public static String inputComName() {
		String comName = null;
		Scanner sc = new Scanner(System.in);
		int result;

		while (true) {
			System.out.printf("�����빫˾��:");
			comName = sc.nextLine();
			result = Case2_lowful.comName(comName);

			if (result == 1) {
				System.out.println("û�����빫˾-����������");
			} else if (result == 0) {
				return comName;
			} else {
				System.out.println("����Ĺ�˾������Ϊ���֣�����2-10λ������������");
			}
		}
	}

	// ���빫˾��ַ
	public static String inputComAddress() {
		String comAddress = null;
		int result;
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out
					.println("�����б�(1.���� 2.���� 3.Ȫ�� 4.���� 5.���� 6.���� 7.���� 8.��ƽ 9.����):");
			comAddress = sc.nextLine();
			result = Case2_lowful.comAddress(comAddress);

			if (result == 1) {
				System.out.println("û�����빫˾-����������");
			} else if (result == 0) {
				return comAddress;
			} else {
				System.out.println("����Ĺ�˾������Ϊ1-9֮��İ��������֣�����������");
			}
		}
	}

	// ���������
	public static String inputMoney() {
		String money = null;
		int result;
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("���������(��Ԫ):");
			money = sc.nextLine();
			result = Case2_lowful.money(money);

			if (result == 1) {
				System.out.println("û�����������-����������");
			} else if (result == 0) {
				return money;
			} else {
				System.out.println("����Ĵ��������Ϊ����������������");
			}
		}
	}

	// ���빫˾����
	public static String inputComType() {
		String comType = null;
		int result;
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("������ҵ����(1.���� 2.���� 3.С��):");
			comType = sc.nextLine();
			result = Case2_lowful.comType(comType);

			if (result == 1) {
				System.out.println("û��������ҵ����-����������");
			} else if (result == 0) {
				comType = initComType(comType);
				return comType;
			} else {
				System.out.println("�������ҵ���ͱ���Ϊ1��2��3������������");
			}
		}
	}

	// ����ԭ��
	public static String inputReason() {
		String reason = null;
		int result;
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("������������:");
			reason = sc.nextLine();
			result = Case2_lowful.reason(reason);

			if (result == 1) {
				System.out.println("û��������������-����������");
			} else if (result == 0) {
				return reason;
			} else {
				System.out.println("������������ɱ���Ϊ6�������ַ�������������");
			}
		}
	}

	// ����ɴ�����
	public static String inputRounders() {
		Scanner sc = new Scanner(System.in);
		String transmiter = null;
		String[] logNames;
		List<String> results = new ArrayList<String>();

		while (true) {
			System.out.print("���봫���ߵ�����(��,����):");
			transmiter = sc.nextLine();
			logNames = transmiter.split(",");
			results = Case2_lowful.rounders(logNames);
			if (results.size() > 0) {
				printTheErrorLogNames(results);
			} else {
				break;
			}
		}
		return transmiter;
	}

	// ��ʼ����˾����
	private static String initComType(String comType) {
		if (comType.equals("1")) {
			return "����";
		} else if (comType.equals("2")) {
			return "����";
		} else if (comType.equals("3")) {
			return "С��";
		} else {
			return null;
		}
	}

	// ��ӡ����ĵ�¼��
	private static void printTheErrorLogNames(List<String> results) {
		for (String result : results) {
			System.out.println(result + ",�õ�¼������!");
		}
	}

}
