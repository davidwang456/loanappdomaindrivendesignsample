package com.ideature.loanapp.domain;

public class UnderwritingDecision {

	private long loanId;
	
	private String underwritingDecision;
	
	private String reason;

	/**
	 * @return the loanId
	 */
	public long getLoanId() {
		return loanId;
	}

	/**
	 * @param loanId the loanId to set
	 */
	public void setLoanId(long loanId) {
		this.loanId = loanId;
	}

	/**
	 * @return the underwritingDecision
	 */
	public String getUnderwritingDecision() {
		return underwritingDecision;
	}

	/**
	 * @param underwritingDecision the underwritingDecision to set
	 */
	public void setUnderwritingDecision(String underwritingDecision) {
		this.underwritingDecision = underwritingDecision;
	}

	/**
	 * @return the reason
	 */
	public String getReason() {
		return reason;
	}

	/**
	 * @param reason the reason to set
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	
}
