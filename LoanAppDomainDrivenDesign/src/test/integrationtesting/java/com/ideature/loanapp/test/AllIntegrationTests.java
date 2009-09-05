package com.ideature.loanapp.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.ideature.loanapp.service.FundingServiceImplTest;

@RunWith(Suite.class)
@SuiteClasses(value = {
		FundingServiceImplTest.class
})
public class AllIntegrationTests {
}

