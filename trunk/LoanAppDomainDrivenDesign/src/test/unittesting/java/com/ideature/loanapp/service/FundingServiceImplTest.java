package com.ideature.loanapp.service;

import java.math.BigDecimal;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ideature.loanapp.LoanAppException;
import com.ideature.loanapp.domain.ProductRate;
import com.ideature.loanapp.dto.FundingRequestDTO;
import com.ideature.loanapp.repository.RepositoryException;

/**
 * 
 * @author Srini
 * 
 * Run this test with a VM argument to specify the weaver for SpringAOP.
 * -javaagent:${PROJECT_HOME}/target/war/WEB-INF/lib/spring-agent.jar
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/loanapp-aspects.xml", "/loanapp-dao.xml"
		,"/loanapp-domain.xml", "/loanapp-datamapper-config.xml" })
public class FundingServiceImplTest {
	private static final Log log = LogFactory.getLog(FundingServiceImplTest.class);
	
	@Autowired
	private FundingService fundingService;
	
	@Autowired
	private ProductRate productRate;
	
	@Test
	public void loadProductRates() throws RepositoryException {
		// ProductRate 1
		String productGroup = "FIXED";
		String productName = "30 YEAR FIXED CONFORMED";
		double interestRate = 6.5;
		BigDecimal minLoanAmount = new BigDecimal("300000");
		BigDecimal maxLoanAmount = new BigDecimal("600000");
		int minCreditScore = 400;

		ProductRate entity = new ProductRate();
		entity.setProductGroup(productGroup);
		entity.setProductName(productName);
		entity.setInterestRate(interestRate);
		entity.setMinLoanAmount(minLoanAmount);
		entity.setMaxLoanAmount(maxLoanAmount);
		entity.setMinCreditScore(minCreditScore);
		
		productRate.add(entity);

		// ProductRate 2
		productGroup = "FIXED";
		productName = "30 YEAR FIXED NON-CONFORMED";
		interestRate = 6.5;
		minLoanAmount = new BigDecimal("300000");
		maxLoanAmount = new BigDecimal("400000");
		minCreditScore = 600;

		entity = new ProductRate();
		entity.setProductGroup(productGroup);
		entity.setProductName(productName);
		entity.setInterestRate(interestRate);
		entity.setMinLoanAmount(minLoanAmount);
		entity.setMaxLoanAmount(maxLoanAmount);
		entity.setMinCreditScore(minCreditScore);
		
		productRate.add(entity);

		// ProductRate 3
		productGroup = "ARM";
		productName = "5 YEAR ARM";
		interestRate = 5.0;
		minLoanAmount = new BigDecimal("200000");
		maxLoanAmount = new BigDecimal("800000");
		minCreditScore = 400;

		entity = new ProductRate();
		entity.setProductGroup(productGroup);
		entity.setProductName(productName);
		entity.setInterestRate(interestRate);
		entity.setMinLoanAmount(minLoanAmount);
		entity.setMaxLoanAmount(maxLoanAmount);
		entity.setMinCreditScore(minCreditScore);

		productRate.add(entity);
	}

	@Test
	public void testLoanFunding() throws RepositoryException {
		// Create DTO and populate data
		FundingRequestDTO dto = new FundingRequestDTO();
		
		// loan details
		long loanId = 12345;
		String productGroup = "FIXED";
		BigDecimal loanAmount = new BigDecimal("500000");
		BigDecimal purchasePrice = new BigDecimal("600000");
		String propertyAddress = "123 MAIN STREET";

		dto.setLoanId(loanId);
		dto.setProductGroup(productGroup);
//		dto.setProductName("15-YR NON AGENCY FIXED");
		dto.setLoanAmount(loanAmount);
		dto.setPurchasePrice(purchasePrice);
		dto.setPropertyAddress(propertyAddress);
		
		// borrower details
		String firstName = "TEST";
		String lastName = "BORROWER";
		String phoneNumber = "123-456-7890";
		String emailAddress = "test.borrower@tb.com";
		dto.setFirstName(firstName);
		dto.setLastName(lastName);
		dto.setPhoneNumber(phoneNumber);
		dto.setEmailAddress(emailAddress);
		
		// funding details
		String fundType = "FULL DISBURSE";
		BigDecimal fundingAmount = new BigDecimal("500000");
		int termInMonths = 360;
		
		dto.setFundType(fundType);
		dto.setFundingAmount(fundingAmount);
		dto.setTermInMonths(termInMonths);
		
		log.debug("dto:" + dto.toString());
		
		try {
			fundingService.processLoanFunding(dto);
		} catch (LoanAppException lae) {
			log.error(lae);
		}

	}

}
