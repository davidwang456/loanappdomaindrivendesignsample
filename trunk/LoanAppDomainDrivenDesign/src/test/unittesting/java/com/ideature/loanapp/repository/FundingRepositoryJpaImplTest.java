package com.ideature.loanapp.repository;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ideature.loanapp.LoanAppConstants;
import com.ideature.loanapp.domain.FundingRequest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/loanapp-dao.xml"})
public class FundingRepositoryJpaImplTest {

	@Autowired
	private FundingRequestRepository repository;

	@Test
	public void testGetFundingDetails() throws RepositoryException {

		long fundingTxnId = 300;
		long loanId = 100;

		Collection<FundingRequest> fundingDetails = repository.findAll();
		Assert.assertEquals(fundingDetails.size(), 0);
		
		// Add a new record
		FundingRequest newFundingDetails = new FundingRequest();
		newFundingDetails.setFundingTxnId(fundingTxnId);
		newFundingDetails.setLoanId(loanId);
		newFundingDetails.setFirstPaymentDate(new Date());
		newFundingDetails.setFundType(LoanAppConstants.FUND_TYPE_WIRE);
		newFundingDetails.setLoanAmount(new BigDecimal("450000"));
		newFundingDetails.setMonthlyPayment(2500);
		newFundingDetails.setTermInMonths(360);

		repository.add(newFundingDetails);

		fundingDetails = repository.findAll();
		Assert.assertEquals("New record was added so the count should now be 1.", fundingDetails.size(), 1);

	}

}
