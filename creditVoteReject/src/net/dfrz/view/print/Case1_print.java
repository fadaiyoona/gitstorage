package net.dfrz.view.print;

import net.dfrz.domain.User;

public class Case1_print {

	// ��ӡ���˵�
	public static void printMainMenu() {
		System.out.println("��ҵ�����Ŵ�����һƱ���(ϵͳ���˵�)");
		System.out.println("=======================================");
		System.out.println("1) ��̨����");
		System.out.println("2) �Ŵ�������ι���");
		System.out.println("3) �г���ǩ");
		System.out.println("4) �˻�����");
		System.out.println("5) ��������ѯ");
		System.out.println("6) ��ʷ��¼жȡ");
		System.out.println("7) ������Ϣ��ֲ");
		System.out.println("8) ���˻�ǩ");
		System.out.println("9) ����");
		System.out.println("Q) �˳�");
	}

	// ��ӡ��̨����
	public static void printCase1_Menu() {
		System.out.println("��ҵ�����Ŵ�����һƱ���(��̨����)");
		System.out.println("==================================");
		System.out.println("1) �û�����");
		System.out.println("2) ������������");
		System.out.println("Q/q) �˻����˵�");
	}

	// ��ӡ�������������صĲ˵�
	public static void printCase1_MultipleSign() {
		System.out.println("��ҵ�����Ŵ�����һƱ���(��̨����) --���г���ͬ��������");
		System.out
				.println("=====================================================");
	}

	// ��ӡ��������������г��ĵ�¼��
	public static void printGovernors(String governors) {
		String[] governorss = governors.split(",");
		System.out.println("�������������뼯���������г���¼���ֱ�Ϊ:");
		for (String str : governorss) {
			System.out.println(str);
		}
	}

	// ��ӡԱ����Ϣ
	public static void printUserInfo(User user) {
		System.out.println("������������Ա����ϸ��ϢΪ");
		System.out.println("Ա����:" + user.getEmpName());
		System.out.println("ϵͳ��¼��:" + user.getLogName());
		System.out.println("�ֻ�����:" + user.getPhone());
		System.out.println("����:" + user.getPassword());
		initType(user.getType());
		System.out.println("Ա������:" + initType(user.getType()));
	}

	// ��ʼ��Ա������
	private static String initType(String type) {
		if (type.equals("0")) {
			return "ϵͳ����Ա";
		} else if (type.equals("1")) {
			return "�ֹ��Ŵ��ĸ��г�";
		} else if (type.equals("2")) {
			return "�������ߵĸ��г�";
		} else if (type.equals("3")) {
			return "רְ�Ŵ�������Ա";
		} else if (type.equals("4")) {
			return "��Ȩ������";
		} else {
			return null;
		}
	}

	public static void printCase1_Houtai() {
		System.out.println("��ҵ�����Ŵ�����һƱ���(��̨����)--�û�����");
		System.out.println("===================================");
	}
}
