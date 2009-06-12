package com.ideature.loanapp.repository;

import java.util.Collection;
import java.util.List;

import com.ideature.loanapp.domain.FundingRequest;

public interface FundingRequestRepository {

	FundingRequest load(long loanId) throws RepositoryException;

	Collection<FundingRequest> findAll() throws RepositoryException;

	List<FundingRequest> findByLoanId(long loanId) throws RepositoryException;

	void add(FundingRequest loanDetails) throws RepositoryException;

	void update(FundingRequest loanDetails) throws RepositoryException;

	void delete(long loanId) throws RepositoryException;

}
