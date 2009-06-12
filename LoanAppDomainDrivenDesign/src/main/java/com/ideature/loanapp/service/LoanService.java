package com.ideature.loanapp.service;

import java.io.IOException;

import javax.xml.bind.JAXBException;
import javax.xml.transform.stream.StreamSource;

import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;
import org.springframework.oxm.XmlMappingException;

public class LoanService {

//	@Autowired
	private Marshaller marshaller;
	
//	@Autowired
	private Unmarshaller unmarshaller;
	
	public void setMarshaller(Marshaller marshaller) {
		this.marshaller = marshaller;
	}

	public void setUnmarshaller(Unmarshaller unmarshaller) {
		this.unmarshaller = unmarshaller;
	}

	public void xmlToJava() throws IOException, JAXBException
	{
		// Unmarshall the file into a content object
		// NOTE: Make sure the specified file location is in classpath
		try {
			Object objContent = unmarshaller.unmarshal(new StreamSource(LoanService.class.getResourceAsStream("/funding-request.xml")));
			System.out.println("objContent = " + objContent);
		} catch (XmlMappingException xme) {
			xme.printStackTrace();
		}

//		Content content = (Content)objContent;
		
	}
}
