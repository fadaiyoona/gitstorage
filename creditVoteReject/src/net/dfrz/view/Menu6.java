package net.dfrz.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import net.dfrz.control.MeetAction;
import net.dfrz.domain.Meet;
import net.dfrz.domain.MeetDetail;
import net.dfrz.view.input.Case6_input;
import net.dfrz.view.print.Case6_print;

public class Menu6 {

	public static void case1() {
		String begin = null;
		String end = null;
		String address = null;

		Map<MeetDetail, Meet> meets = new HashMap<MeetDetail, Meet>();
		Scanner sc = new Scanner(System.in);

		while (true) {
			Case6_print.printCase6_Menu();// ��ӡ��ʷ��¼жȡ�����˵�

			begin = Case6_input.inputBeginDate();// ���뿪ʼʱ��
			end = Case6_input.inputEndDate();// �������ʱ��
			address = Case6_input.inputAddress();// ���뱣��ĵ�ַ

			Case6_print.printAddress(address);// ��ӡ����ĵ�ַ
			meets = MeetAction.queryHistoryLogging(begin, end);// ��ȡ��ʷ��¼жȡ�Ļ���
			MeetAction.write(meets, address);// ������д���ı�
			System.out.println("�����������...");
			sc.nextLine();

			System.out.println("�Ƿ����²�ѯ(y)es or (n)o, y?");
			if (sc.nextLine().equals("n"))
				break;

		}
	}

}
