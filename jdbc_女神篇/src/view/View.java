package view;

import java.util.List;
import java.util.Scanner;

import model.Goddess;
import Action.GoddessAction;

public class View {

	private static final String MENU = "欢迎来到女神禁区:\n" + "下面是女神禁区的功能列表:\n"
			+ "【MAIN/M】:主菜单\n" + "【QUERY/Q】:查看全部女神的信息\n"
			+ "【GET/G】:查看某位女神的详细信息\n" + "【ADD/A】:添加女神信息\n"
			+ "【UPDATE/U】:更新女神信息\n" + "【DELETE/D】:删除女神信息\n"
			+ "【SEARCH/S】:查询女神信息(根据姓名、手机号来查询)\n" + "【EXIT/E】:退出女神禁区\n"
			+ "【BREAK/B】:退出当前功能,返回主菜单";
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
				System.out.println("您已成功退出女神禁区!");
				break;
			} else if (OPERATION_QUERY.equals(in.toUpperCase())
					|| OPERATION_QUERY.substring(0, 1).equals(in.toUpperCase())
					|| OPERATION_QUERY.equals(prenious)) {
				try {
					List<Goddess> gs = action.query();

					for (Goddess g : gs) {
						System.out
								.println(g.getId() + "姓名:" + g.getUser_name());
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (OPERATION_ADD.equals(in.toUpperCase())
					|| OPERATION_ADD.substring(0, 1).equals(in.toUpperCase())
					|| OPERATION_ADD.equals(prenious)) {
				prenious = OPERATION_ADD;
				// 新增女神
				if (1 == step) {
					System.out.println("请输入女神的【ID】:");
				} else if (2 == step) {
					goddess.setId(Integer.valueOf(in));
					System.out.println("请输入女神的【姓名】:");
				} else if (3 == step) {
					goddess.setUser_name(in);
					System.out.println("请输入女神的【年龄】:");
				} else if (4 == step) {
					goddess.setAge(Integer.valueOf(in));
					System.out.println("请输入女神的【性别】:");
				} else if (5 == step) {
					goddess.setSex(Integer.valueOf(in));
					System.out.println("请输入女神的【生日】,格式如:yyyy-MM-dd:");
				} else if (6 == step) {
					goddess.setBirthday(null);
					System.out.println("请输入女神的【邮箱】:");
				} else if (7 == step) {
					goddess.setEmail(in);
					System.out.println("请输入女神的【手机号】:");
				} else if (8 == step) {
					goddess.setMobile(in);
					System.out.println("请输入女神的【创建人】:");
				} else if (9 == step) {
					goddess.setCreate_user(in);
					System.out.println("请输入女神的【更新人】:");
				} else if (9 == step) {
					goddess.setUpdate_user(in);
					System.out.println("请输入女神的【删除】:");
				} else if (10 == step) {
					goddess.setIsdel(Integer.parseInt(in));

					try {
						System.out.println("------------------------");
						action.add(goddess);
						System.out.println("新增女神成功!");
					} catch (Exception e) {
						e.printStackTrace();
						System.out.println("新增女神失败!");
					}
				}
				if (OPERATION_ADD.equals(prenious)) {
					step++;
				}

			} else {
				System.out.println("您输入的值为:" + in);
			}
		}
	}
}
