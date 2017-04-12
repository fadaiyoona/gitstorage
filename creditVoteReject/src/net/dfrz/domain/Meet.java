package net.dfrz.domain;

/**
 * 
 * @author 发呆
 * @version 会议概要信息的类
 */
public class Meet {
	private String id;
	private int meetYear;
	private String name;
	private String phone;
	private String setDate;
	private String state;
	private String rounder;

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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone
	 *            the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the setDate
	 */
	public String getSetDate() {
		return setDate;
	}

	/**
	 * @param setDate
	 *            the setDate to set
	 */
	public void setSetDate(String setDate) {
		this.setDate = setDate;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param stete
	 *            the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the rounder
	 */
	public String getRounder() {
		return rounder;
	}

	/**
	 * @param rounder
	 *            the rounder to set
	 */
	public void setRounder(String rounder) {
		this.rounder = rounder;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
