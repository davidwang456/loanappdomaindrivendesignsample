package com.ideature.loanapp.repository;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ideature.loanapp.domain.Loan;

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
public class LoanRepositoryJpaImplTest {

	@Autowired
	private LoanRepository loanRepository;

	@Test
	public void testAddUpdateDeleteLoan() throws Exception {
		long loanId = 100;

		Collection<Loan> loans = loanRepository.findAll();
		Assert.assertEquals(loans.size(), 0);

		// Add a new loan
		Loan newLoan = new Loan();
		newLoan.setLoanId(loanId);
		newLoan.setLoanAmount(new BigDecimal("450000"));
		newLoan.setLoanStatus("REQUESTED");
		newLoan.setProductGroup("FIXED");
		newLoan.setProductId(1234);
		newLoan.setPurchasePrice(new BigDecimal("500000"));

		loanRepository.add(newLoan);
		
		loans = loanRepository.findAll();
		Assert.assertEquals("New loan was added so loan count should now be 1.", loans.size(), 1);
		
		// Modify some attributes
		String newStatus = "APPROVED";
		Loan updLoan = loanRepository.load(loanId);
		updLoan.setLoanStatus(newStatus);
		
		// Do an update on the record
		loanRepository.update(updLoan);
		
		// Get the record again
		Loan newUpdLoan = loanRepository.load(loanId);
		
		assertEquals("New LoanStatus didn't match with what's in the DB.",
				newUpdLoan.getLoanStatus(),newStatus);

		// Finally, delete the newly added record
		loanRepository.delete(loanId);
	}
}
