package com.ideature.loanapp.repository;

import java.util.Collection;

import com.ideature.loanapp.domain.Loan;

public interface LoanRepository {

	Loan load(long loanId) throws RepositoryException;

	Collection<Loan> findAll() throws RepositoryException;

	void add(Loan loan) throws RepositoryException;
	
	void update(Loan loan) throws RepositoryException;

	void delete(long loanId) throws RepositoryException;

}
