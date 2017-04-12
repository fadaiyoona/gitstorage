package net.dfrz.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import net.dfrz.control.MeetAction;
import net.dfrz.domain.Meet;
import net.dfrz.domain.MeetDetail;
import net.dfrz.tools.Tools;
import net.dfrz.view.input.Case5_input;
import net.dfrz.view.print.Case5_print;

public class Menu5 {

	public static void case1() {
		String begin = null;
		String end = null;
		Map<MeetDetail, Meet> meets = new HashMap<MeetDetail, Meet>();
		Scanner sc = new Scanner(System.in);

		while (true) {
			Case5_print.printCase5_Menu();// ��ӡ��������ѯ�����˵�
			begin = Case5_input.inputBeginDate();// ���뿪ʼ��ʱ��
			end = Case5_input.inputEndDate();// ���������ʱ��
			if (Integer.parseInt(begin) > Integer.parseInt(end)) {
				System.out.println("��ʼ���ڲ��ܴ��ڽ�������");
				System.out.println("�����������...");
				sc.nextLine();
				continue;
			}
			meets = MeetAction.quaryMeetDetail(begin, end);// ���ݿ�ʼʱ��ͽ���ʱ���ȡ���������

			Case5_print.printMeetDetailsInfo(meets);// ��ӡ�������

			System.out.println("�Ƿ����²�ѯ(y)es or (n)o, y?");
			if (!Tools.isContinue()) {
				break;
			}
		}
	}

}
