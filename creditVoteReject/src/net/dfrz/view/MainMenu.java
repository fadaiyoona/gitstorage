package net.dfrz.view;

import java.util.Scanner;

import net.dfrz.control.UserExit;
import net.dfrz.domain.User;
import net.dfrz.tools.Tools;
import net.dfrz.view.print.Case1_print;

public class MainMenu {
	public static User onlineUser = new User();// 当前在线的用户

	public static void main(String[] args) {
		// 用户登录
		LoginView.login();

		Scanner sc = new Scanner(System.in);
		String select = null;

		while (true) {
			// 打印系统主菜单
			Case1_print.printMainMenu();
			System.out.print("你的选择:");
			select = sc.nextLine();

			switch (select) {
			case "1":// 后台管理
				if (!onlineUser.getType().equals("0")) {
					System.out.println("对不起,该功能属于系统管理员 ,请按任意键退回");
					sc.nextLine();
				} else {
					Case1_print.printCase1_Menu();// 打印后台管理菜单
					System.out.print("你的选择:");
					select = sc.nextLine();

					if (select.equals("1")) {// 用户管理
						Menu1.case1();// 用户管理界面
					} else if (select.equals("2")) {// 多人审批开关
						Menu1.case2();// 多人审批开关界面
						break;
					} else if (select.equals("Q") || select.equals("q")) {// 返回主菜单
						break;
					} else {
						Tools.invalidCode();// 输入无效字段
						break;
					}
				}
				break;
			case "2":// 信贷审批会次管理
				if (!onlineUser.getType().equals("3")) {
					System.out.println("对不起,该功能属于专职信贷审批人员 ,请按任意键退回");
					sc.nextLine();
				} else {
					Menu2.case1();// 信贷审批会次管理界面
					break;
				}
				break;
			case "3":// 行长审签
				if (!onlineUser.getType().equals("1")) {
					System.out.println("对不起,该功能属于分管信贷的副行长,请按任意键退回");
					sc.nextLine();
				} else {
					Menu3.case1();// 行长审签界面
					break;
				}
				break;
			case "4":// 退回重审
				if (!onlineUser.getType().equals("3")) {
					System.out.println("对不起,该功能属于专职信贷审批人员,请按任意键退回");
					sc.nextLine();
				} else {
					Menu4.case1();// 退回重审界面
				}
				break;
			case "5":// 在审会议查询
				Menu5.case1();// 在审会议查询界面
				break;
			case "6":// 历史记录卸取
				if (!onlineUser.getType().equals("1")
						&& !onlineUser.getType().equals("0")) {
					System.out.println("对不起,该功能属于管理员和副行长,请按任意键退回");
					sc.nextLine();
				} else {
					Menu6.case1();// 历史记录卸取界面
				}
				break;
			case "7":// 评审信息移植
				if (!onlineUser.getType().equals("0")) {
					System.out.println("对不起,该功能属于管理员,请按任意键退回");
					sc.nextLine();
				} else {
					Menu7.case1();// 评审信息移植界面
				}
				break;
			case "8":// 多人审签
				if (!onlineUser.getType().equals("1")) {
					System.out.println("对不起,该功能属于行长,请按任意键退回。");
					sc.nextLine();
				} else {
					Menu8.case1();// 多人审签界面
				}
				break;
			case "9":// 传阅
				if (!onlineUser.getType().equals("4")) {
					System.out.println("对不起,该功能属于有权传阅者,请按任意键退回。");
					sc.nextLine();
				} else {
					Menu9.case1();// 传阅界面
				}
				break;
			case "q":
			case "Q":// 退出程序
				UserExit.exit();
				System.exit(0);
				break;
			case "":
				System.out
						.println("No selection entered. Press Enter to continue...");
				sc.nextLine();
				break;
			}
		}

	}
}
