package net.dfrz.view.input;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import net.dfrz.control.lawful.Case1_lowful;

public class Case1_input {

	// ��������������г��ĵ�¼��
	public static String inputMultipleSignNames() {
		Scanner sc = new Scanner(System.in);
		String governors = null;
		String[] logNames;
		List<String> results = new ArrayList<String>();

		while (true) {
			System.out.print("��������뼯���������г��ĵ�¼��,��,����:");
			governors = sc.nextLine();
			logNames = governors.split(",");
			results = Case1_lowful.isGovernors(logNames);
			if (results.size() == 0) {
				break;
			} else {
				printTheErrorLogNames(results);
			}
		}
		return governors;
	}

	// ����Ա����
	public static String inputEmpName() {
		Scanner scanner = new Scanner(System.in);
		String empName = null;
		int result;
		while (true) {
			System.out.print("����Ա����:");
			empName = scanner.nextLine();
			result = Case1_lowful.empName(empName);
			if (result == 1) {
				System.out.println("�����Ա���ǲ���Ϊ�գ�");
			} else if (result == 2) {
				System.out.println("��������ֲ����пո�����������");
			} else if (result == 3) {
				System.out.println("��������ֱ����Ǻ��ֺ͡�����ϣ�����ĸΪ����, ���� 2-20 ��������������");
			} else {
				return empName;
			}
		}
	}

	// ����ϵͳ��¼��
	public static String inputLogName() throws SQLException {
		Scanner scanner = new Scanner(System.in);
		String logName = null;
		int result;

		while (true) {
			System.out.print("�����û���ϵͳ��¼��:");
			logName = scanner.nextLine();
			result = Case1_lowful.logName(logName);

			if (result == 1) {
				System.out.println("����ĵ�¼������Ϊ�գ�");
			} else if (result == 2) {
				System.out.println("���������Ϊ��ĸ�Ͱ�����������ϣ�ͳһ��.fj ��β������������");
			} else if (result == 3) {
				System.out.println("�����ϵͳ���Ѵ��ڣ�����������");
			} else {
				return logName;
			}
		}
	}

	// ����绰����
	public static String inputPhone() {
		Scanner scanner = new Scanner(System.in);
		String phone = null;
		int result;

		while (true) {
			System.out.print("�����ֻ�����:");
			phone = scanner.next();
			result = Case1_lowful.phone(phone);
			if (result == 1) {
				System.out.println("������ֻ�����Ϊ�գ�����������");
			} else if (result == 2) {
				System.out.println("������ֻ����벻�Ϸ�������������");
			} else {
				return phone;
			}
		}
	}

	// ��������
	public static String inputPassword() {
		Scanner scanner = new Scanner(System.in);
		String password = null;
		int result;

		while (true) {
			System.out.print("��������:");
			password = scanner.next();
			result = Case1_lowful.password(password);
			if (result == 1) {
				System.out.println("���������Ϊ�գ�����������");
			} else if (result == 2) {
				System.out.println("�������Ϊ��λ�����ַ������ٰ�����Сд�����������������ַ��е�����");
			} else {
				return password;
			}
		}
	}

	// ����Ա������
	public static String inputType() {
		Scanner scanner = new Scanner(System.in);
		String type = null;
		int result;

		while (true) {
			System.out
					.print("����Ա������(0�������Ա��1����ֹ��Ŵ��ĸ��г���2�����ѡ�����ˣ�3����ר���Ŵ�������Ա��4������Ȩ������):");
			type = scanner.next();
			result = Case1_lowful.type(type);
			if (result == 1) {
				System.out.println("�����Ա������Ϊ�գ�����������");
			} else if (result == 2) {
				System.out.println("�����Ա�����ͱ���Ϊ0-4");
			} else {
				return type;
			}
		}
	}

	// ��ӡ����ĵ�¼��
	private static void printTheErrorLogNames(List<String> results) {
		for (String result : results) {
			System.out.println(result + ",�õ�¼������!");
		}
	}
}
