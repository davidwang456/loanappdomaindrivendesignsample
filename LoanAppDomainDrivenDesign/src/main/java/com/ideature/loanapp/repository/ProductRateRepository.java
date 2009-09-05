package com.ideature.loanapp.repository;

import java.util.Collection;

import com.ideature.loanapp.domain.ProductRate;

public interface ProductRateRepository {

	ProductRate load(long productRateId) throws RepositoryException;

	Collection<ProductRate> findAll() throws RepositoryException;

	void add(ProductRate productRate) throws RepositoryException;
	
	void update(ProductRate productRate) throws RepositoryException;

	void delete(long productRateId) throws RepositoryException;

}
