package net.dfrz.view.input;

import java.util.Scanner;

import net.dfrz.control.lawful.Case5_lowful;

public class Case6_input {

	// ���뿪ʼ����
	public static String inputBeginDate() {
		String beginDate = null;
		int result;
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("�����ѯ�Ŀ�ʼ����:");
			beginDate = sc.nextLine();
			result = Case5_lowful.date(beginDate);

			if (result == 1) {
				System.out.println("û����������-����������");
			} else if (result == 2) {
				System.out.println("�Բ�����������ڲ����ڣ�����������");
			} else {
				return beginDate;
			}
		}
	}

	// �����������
	public static String inputEndDate() {
		String endDate = null;
		int result;
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("�����ѯ�Ľ�������:");
			endDate = sc.nextLine();
			result = Case5_lowful.date(endDate);

			if (result == 1) {
				System.out.println("û����������-����������");
			} else if (result == 2) {
				System.out.println("�Բ�����������ڲ����ڣ�����������");
			} else {
				return endDate;
			}
		}
	}

	// ���뱣��·��
	public static String inputAddress() {
		String address = null;
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("�����뱣��·��:");
			address = sc.nextLine();

			if (address.isEmpty()) {
				System.out.println("û����������-����������");
			} else {
				break;
			}
		}
		return address;
	}

}
