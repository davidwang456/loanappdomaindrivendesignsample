package com.ideature.loanapp.service;

import net.sf.dozer.util.mapping.MapperIF;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ideature.loanapp.domain.Borrower;
import com.ideature.loanapp.domain.FundingRequest;
import com.ideature.loanapp.domain.Loan;
import com.ideature.loanapp.dto.FundingRequestDTO;

public class FundingRequestDataMapper {
	
	private static final Log log = LogFactory.getLog(FundingRequestDataMapper.class);
	
	@Autowired
	private MapperIF mapper;

	public Loan getLoanFromDto(FundingRequestDTO dto) {
		log.debug("dto:" + dto.toString());

		Loan loan = (Loan) mapper.map(dto, Loan.class);
		log.debug("\nloan:" + ToStringBuilder.reflectionToString(loan, ToStringStyle.MULTI_LINE_STYLE));
		
		return loan;
	}

	public Borrower getBorrowerFromDto(FundingRequestDTO dto) {
		log.debug("dto:" + dto.toString());

		Borrower borrower = (Borrower) mapper.map(dto, Borrower.class);
		log.debug("\borrower:" + ToStringBuilder.reflectionToString(borrower, ToStringStyle.MULTI_LINE_STYLE));
		
		return borrower;
	}

	public FundingRequest getFundingRequestFromDto(FundingRequestDTO dto) {
		log.debug("dto:" + dto.toString());

		FundingRequest fundingRequest = (FundingRequest) mapper.map(dto, FundingRequest.class);
		log.debug("\fundingRequest:" + ToStringBuilder.reflectionToString(fundingRequest, ToStringStyle.MULTI_LINE_STYLE));
		
		return fundingRequest;
	}

}
