package net.dfrz.view.print;

import net.dfrz.domain.Meet;
import net.dfrz.domain.MeetDetail;

public class Case2_print {

	// ��ӡ�Ŵ�������ι�������˵�
	public static void printCase2_Menu() {
		System.out.println("��ҵ�����Ŵ�����һƱ���(�Ŵ�������ι���)");
		System.out.println("==================================");
	}

	// ��ӡ������ϸ��Ϣ
	public static void printMeetDetail(MeetDetail meetDetail, Meet meet) {
		System.out.println("�������ύ���г���ǩ���Ŵ�������ϸ��ϢΪ");
		System.out.println("��˾��:" + meetDetail.getCompany());
		System.out.println("�б�:" + meetDetail.getAddress());
		System.out.println("������:" + meetDetail.getMoney());
		System.out.println("��ҵ����:" + meetDetail.getComTypeName());
		System.out.println("��������:" + meetDetail.getReason());
		System.out.println("������:" + meet.getRounder());
	}
}
