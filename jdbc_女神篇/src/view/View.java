package view;

import java.util.List;
import java.util.Scanner;

import model.Goddess;
import Action.GoddessAction;

public class View {

	private static final String MENU = "��ӭ����Ů�����:\n" + "������Ů������Ĺ����б�:\n"
			+ "��MAIN/M��:���˵�\n" + "��QUERY/Q��:�鿴ȫ��Ů�����Ϣ\n"
			+ "��GET/G��:�鿴ĳλŮ�����ϸ��Ϣ\n" + "��ADD/A��:���Ů����Ϣ\n"
			+ "��UPDATE/U��:����Ů����Ϣ\n" + "��DELETE/D��:ɾ��Ů����Ϣ\n"
			+ "��SEARCH/S��:��ѯŮ����Ϣ(�����������ֻ�������ѯ)\n" + "��EXIT/E��:�˳�Ů�����\n"
			+ "��BREAK/B��:�˳���ǰ����,�������˵�";
	private static final String OPERATION_MAIN = "MAIN";
	private static final String OPERATION_QUERY = "QUERY";
	private static final String OPERATION_GET = "GET";
	private static final String OPERATION_ADD = "ADD";
	private static final String OPERATION_UPDATE = "UPDATE";
	private static final String OPERATION_DELETE = "DELETE";
	private static final String OPERATION_SEARCH = "SEARCH";
	private static final String OPERATION_EXIT = "EXIT";
	private static final String OPERATION_BREAK = "BREAK";

	public static void main(String[] args) {

		System.out.println(MENU);

		Scanner sc = new Scanner(System.in);
		Goddess goddess = new Goddess();
		GoddessAction action = new GoddessAction();
		String prenious = null;
		Integer step = 1;

		while (sc.hasNext()) {
			String in = sc.next().toString();
			if (OPERATION_EXIT.equals(in.toUpperCase())
					|| OPERATION_EXIT.substring(0, 1).equals(in.toUpperCase())
					|| OPERATION_EXIT.equals(prenious)) {
				System.out.println("���ѳɹ��˳�Ů�����!");
				break;
			} else if (OPERATION_QUERY.equals(in.toUpperCase())
					|| OPERATION_QUERY.substring(0, 1).equals(in.toUpperCase())
					|| OPERATION_QUERY.equals(prenious)) {
				try {
					List<Goddess> gs = action.query();

					for (Goddess g : gs) {
						System.out
								.println(g.getId() + "����:" + g.getUser_name());
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (OPERATION_ADD.equals(in.toUpperCase())
					|| OPERATION_ADD.substring(0, 1).equals(in.toUpperCase())
					|| OPERATION_ADD.equals(prenious)) {
				prenious = OPERATION_ADD;
				// ����Ů��
				if (1 == step) {
					System.out.println("������Ů��ġ�ID��:");
				} else if (2 == step) {
					goddess.setId(Integer.valueOf(in));
					System.out.println("������Ů��ġ�������:");
				} else if (3 == step) {
					goddess.setUser_name(in);
					System.out.println("������Ů��ġ����䡿:");
				} else if (4 == step) {
					goddess.setAge(Integer.valueOf(in));
					System.out.println("������Ů��ġ��Ա�:");
				} else if (5 == step) {
					goddess.setSex(Integer.valueOf(in));
					System.out.println("������Ů��ġ����ա�,��ʽ��:yyyy-MM-dd:");
				} else if (6 == step) {
					goddess.setBirthday(null);
					System.out.println("������Ů��ġ����䡿:");
				} else if (7 == step) {
					goddess.setEmail(in);
					System.out.println("������Ů��ġ��ֻ��š�:");
				} else if (8 == step) {
					goddess.setMobile(in);
					System.out.println("������Ů��ġ������ˡ�:");
				} else if (9 == step) {
					goddess.setCreate_user(in);
					System.out.println("������Ů��ġ������ˡ�:");
				} else if (9 == step) {
					goddess.setUpdate_user(in);
					System.out.println("������Ů��ġ�ɾ����:");
				} else if (10 == step) {
					goddess.setIsdel(Integer.parseInt(in));

					try {
						System.out.println("------------------------");
						action.add(goddess);
						System.out.println("����Ů��ɹ�!");
					} catch (Exception e) {
						e.printStackTrace();
						System.out.println("����Ů��ʧ��!");
					}
				}
				if (OPERATION_ADD.equals(prenious)) {
					step++;
				}

			} else {
				System.out.println("�������ֵΪ:" + in);
			}
		}
	}
}
