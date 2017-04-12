package net.dfrz.domain;

public class State {
	private int state;
	private String signedByTheGovernor;

	/**
	 * @return the state
	 */
	public int getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(int state) {
		this.state = state;
	}

	/**
	 * @return the rounder
	 */
	public String getSignedByTheGovernor() {
		return signedByTheGovernor;
	}

	/**
	 * @param rounder
	 *            the rounder to set
	 */
	public void setSignedByTheGovernor(String signedByTheGovernor) {
		this.signedByTheGovernor = signedByTheGovernor;
	}

}
