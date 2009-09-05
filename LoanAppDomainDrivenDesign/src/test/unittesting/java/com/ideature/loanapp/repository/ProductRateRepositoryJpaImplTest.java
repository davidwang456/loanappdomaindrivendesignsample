package com.ideature.loanapp.repository;

import java.math.BigDecimal;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ideature.loanapp.domain.ProductRate;

/**
 * 
 * @author Srini
 * 
 * Run this test with a VM argument to specify the weaver for SpringAOP.
 * -javaagent:${PROJECT_HOME}/target/war/WEB-INF/lib/spring-agent.jar
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/loanapp-dao.xml"})
public class ProductRateRepositoryJpaImplTest {

	@Autowired
	private ProductRateRepository productRateRepository;

	@Test
	public void testAddUpdateDeleteEntity() throws Exception {
		long id = 100;

		Collection<ProductRate> entityList = productRateRepository.findAll();
		Assert.assertEquals(entityList.size(), 0);
		
		// Test data
		String productGroup = "FIXED";
		String productName = "30 YEAR FIXED CONFORMED";
		double interestRate = 6.5;
		BigDecimal minLoanAmount = new BigDecimal("300000");
		BigDecimal maxLoanAmount = new BigDecimal("700000");
		int minCreditScore = 600;
		
		// Add a new entity
		ProductRate newEntity = new ProductRate();
		newEntity.setProductGroup(productGroup);
		newEntity.setProductName(productName);
		newEntity.setInterestRate(interestRate);
		newEntity.setMinLoanAmount(minLoanAmount);
		newEntity.setMaxLoanAmount(maxLoanAmount);
		newEntity.setMinCreditScore(minCreditScore);

		productRateRepository.add(newEntity);
		
		entityList = productRateRepository.findAll();
		Assert.assertEquals("New loan was added so loan count should now be 1.", entityList.size(), 1);
		
		
	}

}
