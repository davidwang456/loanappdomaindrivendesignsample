package com.ideature.loanapp.domain;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/loanapp-dao.xml", 
		"/loanapp-domain.xml", "/loanapp-datamapper-config.xml"})
public class LoanDomainTest {
	
	@Autowired
	private Loan loan;
	
	@Test
	public void testAddUpdateDeleteLoan() {
		
		long loanId = 100;
		
		// Add a new loan
		Loan newLoan = new Loan();
		newLoan.setLoanId(loanId);
		newLoan.setLoanAmount(new BigDecimal("450000"));
		newLoan.setLoanStatus("REQUESTED");
		newLoan.setProductGroup("FIXED");
		newLoan.setProductId(1234);
		newLoan.setPurchasePrice(new BigDecimal("500000"));
		loan.add(newLoan);
	}

}
