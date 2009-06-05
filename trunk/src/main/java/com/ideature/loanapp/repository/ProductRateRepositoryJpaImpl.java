package com.ideature.loanapp.repository;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.ideature.loanapp.domain.ProductRate;

@Transactional
public class ProductRateRepositoryJpaImpl implements ProductRateRepository {

	private EntityManager em;

	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

	public void add(ProductRate productRate) throws RepositoryException {
		em.persist(productRate);
	}

	public void delete(long id) throws RepositoryException {
		ProductRate entity = em.find(ProductRate.class, id);
		em.merge(entity);

		em.remove(entity);
	}

	public Collection<ProductRate> findAll() throws RepositoryException {
		String query = "SELECT productRate from ProductRate productRate";
		List<ProductRate> entityList = (List<ProductRate>)em.createQuery(query).getResultList();
		return entityList;
	}

	public ProductRate load(long productRateId) throws RepositoryException {
		return em.find(ProductRate.class, productRateId);
	}

	public void update(ProductRate productRate) throws RepositoryException {
		ProductRate entity = em.find(ProductRate.class, productRate.getProductRateId());
		em.merge(entity);

//		// Set all the attributes in borrower into borrDetails
//		entity.setLoanAmount(productRate.getLoanAmount());
//		entity.setLoanId(productRate.getLoanId());
//		entity.setLoanStatus(productRate.getLoanStatus());
//		entity.setProductGroup(productRate.getProductGroup());
//		entity.setPurchasePrice(productRate.getPurchasePrice());

		em.persist(entity);
	}

}
