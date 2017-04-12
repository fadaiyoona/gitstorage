package model;

import java.sql.Date;

public class TransInfo {

	private Integer id;
	private Integer sourceId;
	private String sourceAccount;
	private Integer destinationId;
	private String destinationAccount;
	private Double amount;
	private Date createAt;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the sourceId
	 */
	public Integer getSourceId() {
		return sourceId;
	}

	/**
	 * @param sourceId
	 *            the sourceId to set
	 */
	public void setSourceId(Integer sourceId) {
		this.sourceId = sourceId;
	}

	/**
	 * @return the sourceAccount
	 */
	public String getSourceAccount() {
		return sourceAccount;
	}

	/**
	 * @param sourceAccount
	 *            the sourceAccount to set
	 */
	public void setSourceAccount(String sourceAccount) {
		this.sourceAccount = sourceAccount;
	}

	/**
	 * @return the destinationId
	 */
	public Integer getDestinationId() {
		return destinationId;
	}

	/**
	 * @param destinationId
	 *            the destinationId to set
	 */
	public void setDestinationId(Integer destinationId) {
		this.destinationId = destinationId;
	}

	/**
	 * @return the destinationAccount
	 */
	public String getDestinationAccount() {
		return destinationAccount;
	}

	/**
	 * @param destinationAccount
	 *            the destinationAccount to set
	 */
	public void setDestinationAccount(String destinationAccount) {
		this.destinationAccount = destinationAccount;
	}

	/**
	 * @return the amount
	 */
	public Double getAmount() {
		return amount;
	}

	/**
	 * @param amount
	 *            the amount to set
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	}

	/**
	 * @return the createAt
	 */
	public Date getCreateAt() {
		return createAt;
	}

	/**
	 * @param createAt
	 *            the createAt to set
	 */
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

}
