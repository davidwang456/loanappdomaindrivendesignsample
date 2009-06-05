package com.ideature.loanapp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;

import com.ideature.loanapp.repository.BorrowerRepository;
import com.ideature.loanapp.repository.RepositoryException;

/**
 * Domain object for Borrower.
 *
 * @author Srini Penchikala
 */
@Entity
public class Borrower {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long borrowerId;

	private String borrowerType;

	private String firstName;

	private String lastName;

	private String phoneNumber;

	private String emailAddress;

	private long loanId;

	@Autowired
	@Transient
	private BorrowerRepository borrowerRepository;

	public void setBorrowerRepository(BorrowerRepository borrowerRepository) {
		this.borrowerRepository = borrowerRepository;
	}

	/**
	 * @return the borrowerId
	 */
	public long getBorrowerId() {
		return borrowerId;
	}

	/**
	 * @param borrowerId the borrowerId to set
	 */
	public void setBorrowerId(long borrowerId) {
		this.borrowerId = borrowerId;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBorrowerType() {
		return this.borrowerType;
	}

	public void setBorrowerType(String borrowerType) {
		this.borrowerType = borrowerType;
	}

	/**
	 * @return the emailAddress
	 */
	public String getEmailAddress() {
		return this.emailAddress;
	}

	/**
	 * @param emailAddress the emailAddress to set
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the loanId
	 */
	public long getLoanId() {
		return this.loanId;
	}

	/**
	 * @param loanId the loanId to set
	 */
	public void setLoanId(long loanId) {
		this.loanId = loanId;
	}

	// CRUD Methods
	public void add(Borrower borrower) {
		try {
			borrowerRepository.add(borrower);
		} catch (RepositoryException re) {
			re.printStackTrace();
		}
	}

	public void delete(long borrowerId) {
		try {
			borrowerRepository.delete(borrowerId);
		} catch (RepositoryException re) {
			re.printStackTrace();
		}
	}

	public void update(Borrower borrower) {
		try {
			borrowerRepository.update(borrower);
		} catch (RepositoryException re) {
			re.printStackTrace();
		}
	}

	public Borrower load(long borrowerId) {
		Borrower newBorrower = null;
		try {
			newBorrower = borrowerRepository.load(borrowerId);
		} catch (RepositoryException re) {
			re.printStackTrace();
		}
		return newBorrower;
	}
}
