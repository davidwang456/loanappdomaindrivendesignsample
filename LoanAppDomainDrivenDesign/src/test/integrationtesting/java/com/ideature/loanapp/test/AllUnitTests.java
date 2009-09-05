package com.ideature.loanapp.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.ideature.loanapp.caching.JBossCacheAspectTest;
import com.ideature.loanapp.repository.BorrowerRepositoryJpaImplTest;
import com.ideature.loanapp.repository.FundingRepositoryJpaImplTest;
import com.ideature.loanapp.repository.LoanRepositoryJpaImplTest;
import com.ideature.loanapp.repository.ProductRateRepositoryJpaImplTest;
import com.ideature.loanapp.service.FundingRequestDataMapperTest;
import com.ideature.loanapp.service.FundingServiceImplSecurityTest;
import com.ideature.loanapp.service.LoanAppDozerDataMapperTest;

@RunWith(Suite.class)
@SuiteClasses(value = {
		LoanRepositoryJpaImplTest.class,
		BorrowerRepositoryJpaImplTest.class,
		ProductRateRepositoryJpaImplTest.class,
		FundingRepositoryJpaImplTest.class,
		JBossCacheAspectTest.class,
		FundingRequestDataMapperTest.class,
		LoanAppDozerDataMapperTest.class,
		FundingServiceImplSecurityTest.class
})
public class AllUnitTests {

}
