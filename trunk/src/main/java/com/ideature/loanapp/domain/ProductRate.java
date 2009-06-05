package com.ideature.loanapp.domain;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import com.ideature.loanapp.repository.ProductRateRepository;
import com.ideature.loanapp.repository.RepositoryException;

@Entity
@Configurable("productRate")
public class ProductRate {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long productRateId;
	private String productGroup;
	private String productName;
	private double interestRate;
	private BigDecimal minLoanAmount;
	private BigDecimal maxLoanAmount;
	private int minCreditScore;

	@Autowired
	@Transient
	private ProductRateRepository productRateRepository;

	/**
	 * @param productRateRepository the productRateRepository to set
	 */
	public void setProductRateRepository(ProductRateRepository productRateRepository) {
		this.productRateRepository = productRateRepository;
	}

	/**
	 * @return the productRateId
	 */
	public long getProductRateId() {
		return productRateId;
	}
	/**
	 * @param productRateId the productRateId to set
	 */
	public void setProductRateId(long productRateId) {
		this.productRateId = productRateId;
	}
	/**
	 * @return the productGroup
	 */
	public String getProductGroup() {
		return productGroup;
	}
	/**
	 * @param productGroup the productGroup to set
	 */
	public void setProductGroup(String productGroup) {
		this.productGroup = productGroup;
	}
	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}
	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	/**
	 * @return the interestRate
	 */
	public double getInterestRate() {
		return interestRate;
	}
	/**
	 * @param interestRate the interestRate to set
	 */
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	/**
	 * @return the minLoanAmount
	 */
	public BigDecimal getMinLoanAmount() {
		return minLoanAmount;
	}
	/**
	 * @param minLoanAmount the minLoanAmount to set
	 */
	public void setMinLoanAmount(BigDecimal minLoanAmount) {
		this.minLoanAmount = minLoanAmount;
	}
	/**
	 * @return the maxLoanAmount
	 */
	public BigDecimal getMaxLoanAmount() {
		return maxLoanAmount;
	}
	/**
	 * @param maxLoanAmount the maxLoanAmount to set
	 */
	public void setMaxLoanAmount(BigDecimal maxLoanAmount) {
		this.maxLoanAmount = maxLoanAmount;
	}
	/**
	 * @return the minCreditScore
	 */
	public int getMinCreditScore() {
		return minCreditScore;
	}
	/**
	 * @param minCreditScore the minCreditScore to set
	 */
	public void setMinCreditScore(int minCreditScore) {
		this.minCreditScore = minCreditScore;
	}

	// CRUD Methods
	public void add(ProductRate entity) {
		try {
			productRateRepository.add(entity);
		} catch (RepositoryException re) {
			re.printStackTrace();
		}
	}

	public void delete(long id) {
		try {
			productRateRepository.delete(id);
		} catch (RepositoryException re) {
			re.printStackTrace();
		}
	}

	public void update(ProductRate entity) {
		try {
			productRateRepository.update(entity);
		} catch (RepositoryException re) {
			re.printStackTrace();
		}
	}

	public ProductRate load(long id) {
		ProductRate newProductRate = null;
		try {
			newProductRate = productRateRepository.load(id);
		} catch (RepositoryException re) {
			re.printStackTrace();
		}
		return newProductRate;
	}

	public List<ProductRate> findProductRates() {
		List<ProductRate> productRates = null;
		try {
			productRates = (List<ProductRate>)productRateRepository.findAll();
		} catch (RepositoryException re) {
			re.printStackTrace();
		}
		return productRates;
	}
}
