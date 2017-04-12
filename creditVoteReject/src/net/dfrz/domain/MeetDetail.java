package net.dfrz.domain;

/**
 * 
 * @author 发呆
 * @version 会议明细的类
 */
public class MeetDetail {
	private String id;
	private int meetYear;
	private int frequency;
	private String address;
	private String company;
	private String money;
	private String reason;
	private String comTypeName;
	private String governor;

	/**
	 * @param comTypeName
	 *            the comTypeName to set
	 */
	public void setComTypeName(String comTypeName) {
		this.comTypeName = comTypeName;
	}

	public String getAddressName(String comAddress) {
		if (comAddress.equals("1")) {
			comAddress = "福州分行";
		} else if (comAddress.equals("2")) {
			comAddress = "莆田分行";
		} else if (comAddress.equals("3")) {
			comAddress = "泉州分行";
		} else if (comAddress.equals("4")) {
			comAddress = "厦门分行";
		} else if (comAddress.equals("5")) {
			comAddress = "漳州分行";
		} else if (comAddress.equals("6")) {
			comAddress = "龙岩分行";
		} else if (comAddress.equals("7")) {
			comAddress = "三明分行";
		} else if (comAddress.equals("8")) {
			comAddress = "南平分行";
		} else if (comAddress.equals("9")) {
			comAddress = "宁德分行";
		}

		return comAddress;
	}

	/**
	 * @return the comTypeName
	 */
	public String getComTypeName() {
		return comTypeName;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the meetYear
	 */
	public int getMeetYear() {
		return meetYear;
	}

	/**
	 * @param meetYear
	 *            the meetYear to set
	 */
	public void setMeetYear(int meetYear) {
		this.meetYear = meetYear;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the company
	 */
	public String getCompany() {
		return company;
	}

	/**
	 * @param company
	 *            the company to set
	 */
	public void setCompany(String company) {
		this.company = company;
	}

	/**
	 * @return the money
	 */
	public String getMoney() {
		return money;
	}

	/**
	 * @param money
	 *            the money to set
	 */
	public void setMoney(String money) {
		this.money = money;
	}

	/**
	 * @return the reason
	 */
	public String getReason() {
		return reason;
	}

	/**
	 * @param reason
	 *            the reason to set
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.meetYear + "年第" + this.frequency + "次信贷审批会议:"
				+ this.address + ":" + this.company + ":" + this.money + "万元:"
				+ this.comTypeName + ":" + this.reason;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	public String getGovernor() {
		return governor;
	}

	public void setGovernor(String governor) {
		this.governor = governor;
	}
}
