package com.ideature.loanapp.repository;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.ideature.loanapp.domain.FundingRequest;

@Transactional
public class FundingRequestRepositoryJpaImpl implements FundingRequestRepository {

	private EntityManager em;

	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

	public Collection<FundingRequest> findAll() throws RepositoryException {
		List<FundingRequest> fundingDetailsList = (List<FundingRequest>)em.createQuery("SELECT funding from FundingRequest funding").getResultList();
		return fundingDetailsList;
	}

	public FundingRequest load(long fundingTxnId) throws RepositoryException {
		return em.find(FundingRequest.class, fundingTxnId);
	}

	public List<FundingRequest> findByLoanId(long loanId) throws RepositoryException {
		List<FundingRequest> fundingDetailsList = (List<FundingRequest>)em.createQuery("SELECT funding from FundingRequest funding").getResultList();
		return fundingDetailsList;
	}

	public void add(FundingRequest fundingDetails) throws RepositoryException {
		em.persist(fundingDetails);
	}

	public void update(FundingRequest fundingDetails) throws RepositoryException {
		FundingRequest dbFundingDetails = em.find(FundingRequest.class, fundingDetails.getFundingTxnId());
		em.merge(dbFundingDetails);

		// Set all the attributes in borrower into borrDetails
		dbFundingDetails.setFirstPaymentDate(fundingDetails.getFirstPaymentDate());
		dbFundingDetails.setFundType(fundingDetails.getFundType());
		dbFundingDetails.setLoanAmount(fundingDetails.getLoanAmount());
		dbFundingDetails.setLoanId(fundingDetails.getLoanId());
		dbFundingDetails.setMonthlyPayment(fundingDetails.getMonthlyPayment());
		dbFundingDetails.setTermInMonths(fundingDetails.getTermInMonths());

		em.persist(dbFundingDetails);
	}

	public void delete(long fundingTxnId) throws RepositoryException {
		FundingRequest fundingDetails = em.find(FundingRequest.class, fundingTxnId);
		em.merge(fundingDetails);

		em.remove(fundingDetails);
	}
}

