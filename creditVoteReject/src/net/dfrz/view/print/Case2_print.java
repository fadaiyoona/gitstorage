package net.dfrz.view.print;

import net.dfrz.domain.Meet;
import net.dfrz.domain.MeetDetail;

public class Case2_print {

	// 打印信贷审批会次管理的主菜单
	public static void printCase2_Menu() {
		System.out.println("商业银行信贷审批一票否决(信贷审批会次管理)");
		System.out.println("==================================");
	}

	// 打印会议明细信息
	public static void printMeetDetail(MeetDetail meetDetail, Meet meet) {
		System.out.println("您本次提交给行长审签的信贷批次详细信息为");
		System.out.println("公司名:" + meetDetail.getCompany());
		System.out.println("行别:" + meetDetail.getAddress());
		System.out.println("贷款金额:" + meetDetail.getMoney());
		System.out.println("企业类型:" + meetDetail.getComTypeName());
		System.out.println("审批理由:" + meetDetail.getReason());
		System.out.println("传阅者:" + meet.getRounder());
	}
}
