package com.ideature.loanapp.service;

import com.ideature.loanapp.LoanAppException;
import com.ideature.loanapp.dto.FundingRequestDTO;

public interface FundingService {

	public FundingRequestDTO getLoanFundingDetails(long loanId) throws LoanAppException;

	public void approveLoanFunding(FundingRequestDTO dto) throws LoanAppException;

	public void processLoanFunding(FundingRequestDTO fundingRequestDto) throws LoanAppException;

}
