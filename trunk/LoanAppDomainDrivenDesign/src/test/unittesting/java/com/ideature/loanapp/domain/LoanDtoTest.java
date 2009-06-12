package com.ideature.loanapp.domain;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ideature.loanapp.service.LoanService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/loanapp-jaxb.xml"})
public class LoanDtoTest {
	
	@Autowired
	private LoanService loanService;
	
	@Test
	public void testXmlToJava()
	{
		try {
			loanService.xmlToJava();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
	}

	

}
