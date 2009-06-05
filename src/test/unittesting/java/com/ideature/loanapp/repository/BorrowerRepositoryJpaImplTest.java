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

		Collection<Borrower> borrowers = repository.getBorrowers();
		Assert.assertEquals(borrowers.size(), 0);

		// Add a new user
		Borrower newBorr = new Borrower();
		newBorr.setBorrowerId(borrowerId);
		newBorr.setFirstName("BOB");
		newBorr.setLastName("SMITH");
		newBorr.setPhoneNumber("123-456-7890");
		newBorr.setEmailAddress("test.borr@abc.com");
		newBorr.setLoanId(loanId);

		repository.add(newBorr);

		borrowers = repository.getBorrowers();
		Assert.assertEquals("New record was added so the count should now be 1.", borrowers.size(), 1);

		// Modify some attributes
		String newPhoneNumber = "999-99-9999";
		String newFirstName = "JOHN";
		Borrower updBorrower = repository.load(borrowerId);
		updBorrower.setPhoneNumber(newPhoneNumber);
		updBorrower.setFirstName(newFirstName);

		// Do an update on the record
		repository.update(updBorrower);

		// Get the borrower again
		Borrower newUpdBorrower = repository.load(borrowerId);

		assertEquals("New PhoneNumber didn't match with what's in the DB.",newUpdBorrower.getPhoneNumber(),newPhoneNumber);

		assertEquals("New FirstName didn't match with what's in the DB.",newUpdBorrower.getFirstName(),newFirstName);

		// Finally, delete the newly added record
		repository.delete(borrowerId);
	}
}
