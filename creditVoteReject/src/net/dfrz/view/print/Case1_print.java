package net.dfrz.view.print;

import net.dfrz.domain.User;

public class Case1_print {

	// 打印主菜单
	public static void printMainMenu() {
		System.out.println("商业银行信贷审批一票否决(系统主菜单)");
		System.out.println("=======================================");
		System.out.println("1) 后台管理");
		System.out.println("2) 信贷审批会次管理");
		System.out.println("3) 行长审签");
		System.out.println("4) 退回重审");
		System.out.println("5) 在审会议查询");
		System.out.println("6) 历史记录卸取");
		System.out.println("7) 评审信息移植");
		System.out.println("8) 多人会签");
		System.out.println("9) 传阅");
		System.out.println("Q) 退出");
	}

	// 打印后台管理
	public static void printCase1_Menu() {
		System.out.println("商业银行信贷审批一票否决(后台管理)");
		System.out.println("==================================");
		System.out.println("1) 用户管理");
		System.out.println("2) 多人审批开关");
		System.out.println("Q/q) 退回主菜单");
	}

	// 打印出多人审批开关的菜单
	public static void printCase1_MultipleSign() {
		System.out.println("商业银行信贷审批一票否决(后台管理) --多行长共同审批开关");
		System.out
				.println("=====================================================");
	}

	// 打印参与多人审批的行长的登录名
	public static void printGovernors(String governors) {
		String[] governorss = governors.split(",");
		System.out.println("您本次启动参与集体审批的行长登录名分别为:");
		for (String str : governorss) {
			System.out.println(str);
		}
	}

	// 打印员工信息
	public static void printUserInfo(User user) {
		System.out.println("您本次新增的员工详细信息为");
		System.out.println("员工名:" + user.getEmpName());
		System.out.println("系统登录名:" + user.getLogName());
		System.out.println("手机号码:" + user.getPhone());
		System.out.println("密码:" + user.getPassword());
		initType(user.getType());
		System.out.println("员工类型:" + initType(user.getType()));
	}

	// 初始化员工类型
	private static String initType(String type) {
		if (type.equals("0")) {
			return "系统管理员";
		} else if (type.equals("1")) {
			return "分管信贷的副行长";
		} else if (type.equals("2")) {
			return "其他条线的副行长";
		} else if (type.equals("3")) {
			return "专职信贷审批人员";
		} else if (type.equals("4")) {
			return "有权传阅者";
		} else {
			return null;
		}
	}

	public static void printCase1_Houtai() {
		System.out.println("商业银行信贷审批一票否决(后台管理)--用户管理");
		System.out.println("===================================");
	}
}
