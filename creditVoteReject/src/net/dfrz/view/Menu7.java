package net.dfrz.view;

import java.io.File;
import java.util.Map;
import java.util.Scanner;

import net.dfrz.control.MeetAction;
import net.dfrz.domain.MeetDetail;
import net.dfrz.resource.Resource;
import net.dfrz.view.print.Case7_print;

public class Menu7 {

	public static void case1() {
		Scanner sc = new Scanner(System.in);

		Case7_print.printCase7_Menu();// ��ӡ������Ϣ��ֲ�����˵�
		System.out.print("���Ŵ���������ϸ���ݴ�txt�ı��Ƶ�excel�洢?(y)es or (n)o, y?");
		String str = sc.nextLine();

		if (str.equals("y")) {

			Map<Integer, MeetDetail> meetDetails = MeetAction.queryMeetDetail();// ��ȡ������Ϣ��ֲ�Ļ�����Ϣ
			File file = new File(Resource.MeetDetailsInfoExcelPath);
			MeetAction.write(meetDetails, file);// ��������Ϣд��Excel�ı�
			System.out.println("��ֲ�ɹ�!�뵽" + Resource.MeetDetailsInfoExcelPath
					+ "�鿴");// ��ӡExcel�ı��洢��λ��
			System.out.println("�����������...");
			sc.nextLine();
		} else {
			System.out.println("�����������...");
			sc.nextLine();
		}
	}

}
