Domain Driven Design and Development In Practice:
===================================================

The sample application is an Eclipse project, you can extract the zip file to a local directory and should be pretty much be ready to build the project. See the classpath instructions below.


Test Classes:
=============

FundingServiceImplTest: Caching Aspect for loading product rates. Validation testing. Process loan funding business service method testing.

FundingServiceImplSecurityTest: Domain level security (authentication and authorization) testing of FundingService service class.

FundingRequestDataMapperTest: Domain Object (DO) to DTO mapping.

LoanRepositoryJpaImplTest: Repository test for Loan.


Sample Application Directory Structure:
========================================

Project:

src
	java
		main
			com.ideature.loanapp
				domain
				dto
				service
				repository
		test
			unit testing
			integration testing
	resources
		conf
target
	web
		WEB-INF
			classes
			lib
			web.xml
etc
	spring
	log4j
	META-INF\persistence.xml


Classpath:
==========

Add the following JAR files to the classpath to compile and test the application. Copy these JAR files into target\web\WEB-INF\lib directory.


acegi-security-1.0.6.jar
antlr-2.7.6.jar
aspectjrt.jar
aspectjweaver.jar
cglib-nodep-2.1_3.jar
commons-beanutils.jar
commons-collections.jar
commons-lang.jar
commons-logging.jar
dom4j-1.6.1.jar
dozer-4.2.jar
ehcache-1.2.4.jar
hibernate-annotations.jar
hibernate-commons-annotations.jar
hibernate-entitymanager.jar
hibernate3.jar
hsqldb.jar
javassist.jar
jaxb-api.jar
jaxb-impl.jar
jboss-common-core.jar
jboss-javaee.jar
jbosscache-core.jar
jgroups.jar
junit-4.4.jar
log4j-1.2.14.jar
persistence.jar
spring-agent.jar
spring-oxm-1.0.3.jar
spring-oxm-tiger-1.0.3.jar
spring-test.jar
spring-xml-1.0.3.jar
spring.jar
toplink-essentials.jar


JUnit Tests:
=============

Run the junit tests with a VM argument specifying the javaagent as follows:

-javaagent:${PROJECT_HOME}/target/war/WEB-INF/lib/spring-agent.jar

where PROJECT_HOME is the directory where LoanAppDomainDrivenDesign project is located.

