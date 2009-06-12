package com.ideature.loanapp.service;

import org.acegisecurity.AccessDeniedException;
import org.acegisecurity.Authentication;
import org.acegisecurity.context.SecurityContext;
import org.acegisecurity.context.SecurityContextHolder;
import org.acegisecurity.context.SecurityContextImpl;
import org.acegisecurity.providers.UsernamePasswordAuthenticationToken;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ideature.loanapp.LoanAppException;
import com.ideature.loanapp.dto.FundingRequestDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/loanapp-domain-security.xml", "/loanapp-dao.xml",
		"/loanapp-domain.xml", "/loanapp-datamapper-config.xml"})
public class FundingServiceImplSecurityTest {
	
	private static Log log = LogFactory.getLog(FundingServiceImplSecurityTest.class);

	@Autowired
	private FundingService fundingService;
	
	// BORROWER

	@Test
	public void testGetFundingDetailsByBorrower() throws LoanAppException {
		// Borrower
		setUserContextBorrower();
		
		// Call get funding details method in the service class
		fundingService.getLoanFundingDetails(123);
	}

	@Test(expected=AccessDeniedException.class)
	public void testProcessFundingDetailsByBorrower() throws LoanAppException {
		// Borrower
		setUserContextBorrower();
		
		// Call process funding method in the service class
		FundingRequestDTO dto = new FundingRequestDTO();
		fundingService.processLoanFunding(dto);
	}

	@Test(expected=AccessDeniedException.class)
	public void testApproveFundingDetailsByBorrower() throws LoanAppException {
		// Borrower
		setUserContextBorrower();
		
		// Call approve funding method in the service class
		FundingRequestDTO dto = new FundingRequestDTO();
		fundingService.approveLoanFunding(dto);
	}
	
	// FUNDING PROCESSOR

	@Test
	public void testGetFundingDetailsByFundingProcessor() throws LoanAppException {
		// Funding Processor
		setUserContextFundingProcessor();
		
		// Call get funding details method in the service class
		fundingService.getLoanFundingDetails(123);
	}

	@Test
	public void testProcessFundingDetailsByFundingProcessor() throws LoanAppException {
		// Borrower
		setUserContextFundingProcessor();
		
		// Call process funding method in the service class
		FundingRequestDTO dto = new FundingRequestDTO();
		fundingService.processLoanFunding(dto);
	}

	@Test(expected=AccessDeniedException.class)
	public void testApproveFundingDetailsByFundingProcessor() throws LoanAppException {
		// Borrower
		setUserContextFundingProcessor();
		
		// Call approve funding method in the service class
		FundingRequestDTO dto = new FundingRequestDTO();
		fundingService.approveLoanFunding(dto);
	}
	
	
	// FUNDING PROCESSING MANAGER

	@Test
	public void testGetFundingDetailsByFundingProcessingManager() throws LoanAppException {
		// Funding Processor
		setUserContextFundingProcessingManager();
		
		// Call get funding details method in the service class
		fundingService.getLoanFundingDetails(123);
	}

	@Test
	public void testProcessFundingDetailsByFundingProcessingManager() throws LoanAppException {
		// Borrower
		setUserContextFundingProcessingManager();
		
		// Call process funding method in the service class
		FundingRequestDTO dto = new FundingRequestDTO();
		fundingService.processLoanFunding(dto);
	}

	@Test
	public void testApproveFundingDetailsByFundingProcessingManager() throws LoanAppException {
		// Borrower
		setUserContextFundingProcessingManager();
		
		// Call approve funding method in the service class
		FundingRequestDTO dto = new FundingRequestDTO();
		fundingService.approveLoanFunding(dto);
	}
	

	private void setUserContextBorrower() {
		// VISITOR
		String userName = "borrower";
		String password = "test";
		
		setUserSecurityContext(userName, password);
	}

	private void setUserContextFundingProcessor() {
		// USER
		String userName = "processor";
		String password = "test1";

		setUserSecurityContext(userName, password);
	}

	private void setUserContextFundingProcessingManager() {
		// SUPERVISOR
		String userName = "manager";
		String password = "test2";

		setUserSecurityContext(userName, password);
	}

	private void setUserSecurityContext(String userName, String password) {
		Authentication authentication = new UsernamePasswordAuthenticationToken(userName, password);
		
		SecurityContext securityContext = new SecurityContextImpl();
		securityContext.setAuthentication(authentication);
		
		SecurityContextHolder.setContext(securityContext);
	}

}