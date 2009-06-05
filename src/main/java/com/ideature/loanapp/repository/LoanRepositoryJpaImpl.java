package com.ideature.loanapp.repository;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.ideature.loanapp.domain.Loan;

@Transactional
public class LoanRepositoryJpaImpl implements LoanRepository {

	private EntityManager em;

	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

	public Collection<Loan> findAll() throws RepositoryException {
		String query = "SELECT loan from Loan loan";
		List<Loan> loanList = (List<Loan>)em.createQuery(query).getResultList();
		return loanList;
	}

	public Loan load(long loanId) throws RepositoryException {
		return em.find(Loan.class, loanId);
	}

	public void add(Loan loanDetails) throws RepositoryException {
		em.persist(loanDetails);
	}

	public void update(Loan loanDetails) throws RepositoryException {
		Loan dbLoanDetails = em.find(Loan.class, loanDetails.getLoanId());
		em.merge(loanDetails);

		// Set all the attributes in borrower into borrDetails
		dbLoanDetails.setLoanAmount(loanDetails.getLoanAmount());
		dbLoanDetails.setLoanId(loanDetails.getLoanId());
		dbLoanDetails.setLoanStatus(loanDetails.getLoanStatus());
		dbLoanDetails.setProductGroup(loanDetails.getProductGroup());
		dbLoanDetails.setPurchasePrice(loanDetails.getPurchasePrice());

		em.persist(dbLoanDetails);
	}

	public void delete(long loanId) throws RepositoryException {
		Loan loan = em.find(Loan.class, loanId);
		em.merge(loan);

		em.remove(loan);
	}
}
