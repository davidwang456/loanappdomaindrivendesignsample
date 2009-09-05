package com.ideature.loanapp.caching;

import java.math.BigDecimal;

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
@ContextConfiguration(locations={"/loanapp-aspects.xml"})
public class JBossCacheAspectTest {

	@Autowired
	JBossCacheAspect cacheAspect;

	@Test
	public void testCacheAspect() throws Exception {
		
		// Init object cache
		cacheAspect.init();
		
		// Test data
		long id = 100;
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
		
		String cacheKey = "ProductRates";

		// put object in cache
		cacheAspect.put(cacheKey, newEntity);
		
		// get object from cache
		ProductRate cachedProductRate = (ProductRate)cacheAspect.get(cacheKey);
		
		// Destroy object cache
		cacheAspect.cleanup();
	}
	
}
