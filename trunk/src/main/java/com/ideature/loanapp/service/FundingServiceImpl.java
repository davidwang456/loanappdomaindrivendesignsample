package com.ideature.loanapp.service;

import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ideature.loanapp.LoanAppException;
import com.ideature.loanapp.domain.Borrower;
import com.ideature.loanapp.domain.FundingRequest;
import com.ideature.loanapp.domain.Loan;
import com.ideature.loanapp.domain.ProductRate;
import com.ideature.loanapp.dto.FundingRequestDTO;

public class FundingServiceImpl implements FundingService {
	
	private static final Log log = LogFactory.getLog(FundingService.class);

	@Autowired
	private Loan loan;
	@Autowired
	private Borrower borrower;
	@Autowired
	private FundingRequest fundingRequest;
	@Autowired
	private ProductRate productRate;
	
	@Autowired
	private FundingRequestDataMapper dataMapper;

	/**
	 * @param loan the loan to set
	 */
	public void setLoan(Loan loan) {
		this.loan = loan;
	}

	/**
	 * @param borrower the borrower to set
	 */
	public void setBorrower(Borrower borrower) {
		this.borrower = borrower;
	}

	/**
	 * @param fundingRequest the fundingRequest to set
	 */
	public void setFundingRequest(FundingRequest fundingRequest) {
		this.fundingRequest = fundingRequest;
	}

	public FundingRequestDTO getLoanFundingDetails(long loanId) throws LoanAppException {
		log.debug("getLoanFundingDetails() called.");
		
		FundingRequestDTO dto = new FundingRequestDTO();
		
		// Get funding details from the domain objects and populate the DTO.

		return dto;
	}

	public void approveLoanFunding(FundingRequestDTO dto) throws LoanAppException {
		log.debug("approveLoanFunding() called.");
		return;
	}

	public void processLoanFunding(FundingRequestDTO dto) throws LoanAppException {
		log.debug("dto:" + dto.toString());

		Loan newLoan = (Loan) dataMapper.getLoanFromDto(dto);
		log.debug("\nloan:" + ToStringBuilder.reflectionToString(newLoan, ToStringStyle.MULTI_LINE_STYLE));
		
		// Check loan status is valid
		String loanStatus = loan.getLoanStatus();
		
		// Check the loan amount and credit score are w/in the limits with product rate specifications
		// TODO: Get product rates.
		List<ProductRate> productRateList = productRate.findProductRates();

		Borrower newBorrower = (Borrower) dataMapper.getBorrowerFromDto(dto);
		log.debug("\nloan:" + ToStringBuilder.reflectionToString(newBorrower, ToStringStyle.MULTI_LINE_STYLE));

		FundingRequest newFundingRequest = (FundingRequest) dataMapper.getFundingRequestFromDto(dto);
		log.debug("\nloan:" + ToStringBuilder.reflectionToString(newFundingRequest, ToStringStyle.MULTI_LINE_STYLE));
		
		// -------------------------------------------
		// Insert LOAN details
		// -------------------------------------------
		loan.add(newLoan);

		// -------------------------------------------
		// Insert BORROWER details
		// -------------------------------------------
		borrower.add(newBorrower);

		// -------------------------------------------
		// Insert FUNDING details
		// -------------------------------------------
		fundingRequest.add(newFundingRequest);

	}

}
