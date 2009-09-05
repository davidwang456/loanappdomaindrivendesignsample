package com.ideature.loanapp.repository;

import static org.junit.Assert.assertEquals;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ideature.loanapp.domain.Borrower;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/loanapp-dao.xml"})
public class BorrowerRepositoryJpaImplTest {

	@Autowired
	private BorrowerRepository repository;

	@Test
	public void testAddUpdateDeleteBorrower() throws Exception {

		long borrowerId = 131;
		long loanId = 100;

		//Collection<Borrower> borrowers = repository.getBorrowers();
		//Assert.assertEquals(borrowers.size(), 0);

		// Add a new user
		Borrower newBorr = new Borrower();
		newBorr.setBorrowerId(borrowerId);
		newBorr.setFirstName("BOB");
		newBorr.setLastName("SMITH");
		newBorr.setPhoneNumber("123-456-7890");
		newBorr.setEmailAddress("test.borr@abc.com");
		newBorr.setLoanId(loanId);

		repository.add(newBorr);

	
	}
}
