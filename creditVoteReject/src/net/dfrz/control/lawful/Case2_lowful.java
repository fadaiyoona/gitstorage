package net.dfrz.control.lawful;

import java.util.ArrayList;
import java.util.List;

import net.dfrz.domain.User;
import net.dfrz.model.UserDao;
import net.dfrz.model.impl.UserImpl;

public class Case2_lowful {

	// 判断公司名字的合法性
	public static int comName(String comName) {
		if (comName.isEmpty()) {
			// System.out.println("没有输入公司-请重新输入");
			return 1;
		} else if (comName.matches("[\u4E00-\u9FA5]+") && comName.length() >= 2
				&& comName.length() <= 10) {
			// meetDetail.setCompany(comName);
			return 0;
		} else {
			// System.out.println("输入的公司名必须为汉字，字数2-10位，请重新输入");
			return 2;
		}
	}

	// 判断公司地址的合法性
	public static int comAddress(String comAddress) {
		if (comAddress.isEmpty()) {
			// System.out.println("没有输入公司-请重新输入");
			return 1;
		} else if (comAddress.matches("[1-9]")) {
			// meetDetail.setAddress(meetDetail.getAddressName(comAddress));
			return 0;
		} else {
			// System.out.println("输入的公司名必须为1-9之间的阿拉伯数字，请重新输入");
			return 2;
		}
	}

	// 判断贷款金额的合法性
	public static int money(String money) {
		if (money.isEmpty()) {
			// System.out.println("没有输入贷款金额-请重新输入");
			return 1;
		} else if (money.matches("[1-9][0-9]+") || money.matches("[1-9]")) {
			// meetDetail.setMoney(money);
			return 0;
		} else {
			// System.out.println("输入的贷款金额必须为正数，请重新输入");
			return 2;
		}
	}

	// 判断公司类型的合法性
	public static int comType(String comType) {
		if (comType.isEmpty()) {
			// System.out.println("没有输入企业类型-请重新输入");
			return 1;
		} else if (comType.matches("[1-3]")) {
			return 0;
		} else {
			// System.out.println("输入的企业类型必须为1或2或3，请重新输入");
			return 2;
		}
	}

	// 判断原因的合法性
	public static int reason(String reason) {
		if (reason.isEmpty()) {
			// System.out.println("没有输入审批理由-请重新输入");
			return 1;
		} else if (reason.length() >= 6) {
			// meetDetail.setReason(reason);
			return 0;
		} else {
			// System.out.println("输入的审批理由必须为6个以上字符，请重新输入");
			return 2;
		}
	}

	// 判断多人会签行长登录名是否合法
	public static List<String> rounders(String[] logNames) {
		List<String> result = new ArrayList<String>();

		for (String logName : logNames) {
			if (isRounderExist(logName)) {
				continue;
			} else {
				result.add(logName);
			}
		}

		return result;
	}

	// 判断是否存在该行长的登录名
	private static boolean isRounderExist(String logName) {
		UserDao userDao = new UserImpl();

		List<User> list = new ArrayList<User>();
		list = userDao.quaryRounders(logName);
		if (list.size() > 0) {
			return true;
		}
		return false;
	}

}
