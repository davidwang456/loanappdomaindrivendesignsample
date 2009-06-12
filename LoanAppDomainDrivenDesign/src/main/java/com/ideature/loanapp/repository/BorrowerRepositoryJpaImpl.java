package com.ideature.loanapp.repository;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.ideature.loanapp.domain.Borrower;

@Transactional
public class BorrowerRepositoryJpaImpl implements BorrowerRepository {

	private EntityManager em;

	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

	public Collection<Borrower> getBorrowers() throws RepositoryException {
		List<Borrower> borrowerList = (List<Borrower>)em.createQuery("SELECT borrower from Borrower borrower").getResultList();
		return borrowerList;
	}

	public Borrower load(long borrowerId) throws RepositoryException
	{
		return em.find(Borrower.class, borrowerId);
	}

	public void add(Borrower borrower) {
		em.persist(borrower);
	}

	public void update(Borrower borrower) throws RepositoryException {
		Borrower borrDetails = em.find(Borrower.class, borrower.getBorrowerId());
		em.merge(borrDetails);

		// Set all the attributes in borrower into borrDetails
		borrDetails.setEmailAddress(borrower.getEmailAddress());
		borrDetails.setLoanId(borrower.getLoanId());
		borrDetails.setFirstName(borrower.getFirstName());
		borrDetails.setLastName(borrower.getLastName());
		borrDetails.setPhoneNumber(borrower.getPhoneNumber());

		em.persist(borrDetails);
	}

	public void delete(long borrowerId) throws RepositoryException {
		Borrower borrDetails = em.find(Borrower.class, borrowerId);
		em.merge(borrDetails);

		em.remove(borrDetails);
	}


}