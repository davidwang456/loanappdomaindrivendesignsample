package com.ideature.loanapp.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;

import com.ideature.loanapp.repository.FundingRequestRepository;
import com.ideature.loanapp.repository.RepositoryException;

/**
 * Domain object for Funding details.
 *
 * @author Srini Penchikala
 */

@Entity
public class FundingRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long fundingTxnId;

	private long loanId;

	private String fundType;

	private BigDecimal fundingAmount;

	@Temporal(TemporalType.DATE)
	private Date firstPaymentDate;

	private int termInMonths;

	private double monthlyPayment;

	@Autowired
	@Transient
	private FundingRequestRepository fundingRequestRepository;

	public void setFundingRequestRepository(
			FundingRequestRepository fundingRequestRepository) {
		this.fundingRequestRepository = fundingRequestRepository;
	}

	/**
	 * @return the firstPaymentDate
	 */
	public Date getFirstPaymentDate() {
		return firstPaymentDate;
	}
	/**
	 * @param firstPaymentDate the firstPaymentDate to set
	 */
	public void setFirstPaymentDate(Date firstPaymentDate) {
		this.firstPaymentDate = firstPaymentDate;
	}
	/**
	 * @return the fundingTxnId
	 */
	public long getFundingTxnId() {
		return fundingTxnId;
	}
	/**
	 * @param fundingTxnId the fundingTxnId to set
	 */
	public void setFundingTxnId(long fundingTxnId) {
		this.fundingTxnId = fundingTxnId;
	}
	/**
	 * @return the fundType
	 */
	public String getFundType() {
		return fundType;
	}
	/**
	 * @param fundType the fundType to set
	 */
	public void setFundType(String fundType) {
		this.fundType = fundType;
	}
	/**
	 * @return the fundingAmount
	 */
	public BigDecimal getLoanAmount() {
		return fundingAmount;
	}
	/**
	 * @param fundingAmount the fundingAmount to set
	 */
	public void setLoanAmount(BigDecimal loanAmount) {
		this.fundingAmount = loanAmount;
	}
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
	 * @return the monthlyPayment
	 */
	public double getMonthlyPayment() {
		return this.monthlyPayment;
	}
	/**
	 * @param monthlyPayment the monthlyPayment to set
	 */
	public void setMonthlyPayment(double monthlyPayment) {
		this.monthlyPayment = monthlyPayment;
	}
	/**
	 * @return the termInMonths
	 */
	public int getTermInMonths() {
		return termInMonths;
	}
	/**
	 * @param termInMonths the termInMonths to set
	 */
	public void setTermInMonths(int termInMonths) {
		this.termInMonths = termInMonths;
	}

	// CRUD Methods
	public void add(FundingRequest fundingRequest) {
		try {
			fundingRequestRepository.add(fundingRequest);
		} catch (RepositoryException re) {
			re.printStackTrace();
		}
	}

	public void delete(long fundingRequestId) {
		try {
			fundingRequestRepository.delete(fundingRequestId);
		} catch (RepositoryException re) {
			re.printStackTrace();
		}
	}

	public void update(FundingRequest fundingRequest) {
		try {
			fundingRequestRepository.update(fundingRequest);
		} catch (RepositoryException re) {
			re.printStackTrace();
		}
	}

	public FundingRequest load(long fundingRequestId) {
		FundingRequest fundingRequest = null;
		try {
			fundingRequest = fundingRequestRepository.load(fundingRequestId);
		} catch (RepositoryException re) {
			re.printStackTrace();
		}
		return fundingRequest;
	}

}
