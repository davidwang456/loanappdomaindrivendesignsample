package com.ideature.loanapp.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import com.ideature.loanapp.repository.LoanRepository;
import com.ideature.loanapp.repository.RepositoryException;

/**
 * Domain object for Loan details.
 *
 * @author Srini Penchikala
 */
@Entity
@Configurable("loan")
public class Loan {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long loanId;

	private String productGroup;

	private long productId;

	private BigDecimal loanAmount;

	private BigDecimal purchasePrice;

	private String loanStatus;

	private String propertyAddress;
	
	@Autowired
	@Transient
	private LoanRepository loanRepository;
	
	public void setLoanRepository(LoanRepository loanRepository) {
		this.loanRepository = loanRepository;
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
	 * @return the loanAmount
	 */
	public BigDecimal getLoanAmount() {
		return this.loanAmount;
	}
	/**
	 * @param loanAmount the loanAmount to set
	 */
	public void setLoanAmount(BigDecimal loanAmount) {
		this.loanAmount = loanAmount;
	}
	/**
	 * @return the loanStatus
	 */
	public String getLoanStatus() {
		return this.loanStatus;
	}
	/**
	 * @param loanStatus the loanStatus to set
	 */
	public void setLoanStatus(String loanStatus) {
		this.loanStatus = loanStatus;
	}
	/**
	 * @return the productGroup
	 */
	public String getProductGroup() {
		return this.productGroup;
	}
	/**
	 * @param productGroup the productGroup to set
	 */
	public void setProductGroup(String productGroup) {
		this.productGroup = productGroup;
	}
	/**
	 * @return the purchasePrice
	 */
	public BigDecimal getPurchasePrice() {
		return this.purchasePrice;
	}
	/**
	 * @param purchasePrice the purchasePrice to set
	 */
	public void setPurchasePrice(BigDecimal purchasePrice) {
		this.purchasePrice = purchasePrice;
	}
	/**
	 * @return the productId
	 */
	public long getProductId() {
		return productId;
	}
	/**
	 * @param productId the productId to set
	 */
	public void setProductId(long productId) {
		this.productId = productId;
	}

	/**
	 * @return the propertyAddress
	 */
	public String getPropertyAddress() {
		return propertyAddress;
	}
	/**
	 * @param propertyAddress the propertyAddress to set
	 */
	public void setPropertyAddress(String propertyAddress) {
		this.propertyAddress = propertyAddress;
	}
	
	// CRUD Methods
	public void add(Loan loanData) {
		try {
			loanRepository.add(loanData);
		} catch (RepositoryException re) {
			re.printStackTrace();
		}
	}

	public void delete(long loanId) {
		try {
			loanRepository.delete(loanId);
		} catch (RepositoryException re) {
			re.printStackTrace();
		}
	}
	
	public void update(Loan loanData) {
		try {
			loanRepository.update(loanData);
		} catch (RepositoryException re) {
			re.printStackTrace();
		}
	}

	public Loan load(long loanId) {
		Loan newLoan = null;
		try {
			newLoan = loanRepository.load(loanId);
		} catch (RepositoryException re) {
			re.printStackTrace();
		}
		return newLoan;
	}
}
