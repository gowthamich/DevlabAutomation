package TestScripts;

import java.io.IOException;

import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Common_methods.CommonMethods;
import Common_methods.ReadExcel;
import ObjectRep.Attestation;
import ObjectRep.Home;
import ObjectRep.Login;

public class IntegrationTC extends BaseTest {
	
	

	@Test
	public void wfmIntegration() throws IOException {
		String MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try{				
				//read data specific to TC like upload file path
				String wfmUrl = objDataTable.ReadExcelData("WFM URL");
				String wfmusername = objDataTable.ReadExcelData("WFM Username");
				String wfmpassword = objDataTable.ReadExcelData("WFM Password");
				logger = report.startTest(MethodName, "WFM Integration");
				System.out.println("Test script"+MethodName+"- WFM Integration TC");
				driver.get(wfmUrl);
				objLogin = new Login(driver);
				logger.log(LogStatus.PASS, "Customer Site:   "+wfmUrl);
				logger.log(LogStatus.PASS, "Username:  "+wfmusername);
				//logger.log(LogStatus.PASS, "Password:  "+wfmpassword);
				// ****************Login Tc ********************//
				System.out.println("TC1");
				Boolean l = objLogin.login(wfmusername, wfmpassword, wfmUrl);
	//			Assert.assertTrue(driver.getCurrentUrl().contains("core") );
	//			System.out.println("Afyer assert");
				if(l){
					logger.log(LogStatus.PASS,  "Login Successfull");
				}				
				else{
					logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Test failed");
				}
				objHome = new Home(driver);
				Boolean b = objHome.wfmInte();
				if(b) {
					logger.log(LogStatus.PASS,  "WFM integration displayed");				
					logger.log(LogStatus.PASS,  "WFM integration test case execution completed");	
				}
				else
					logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Test failed");
				
		}catch(Exception e) {
			System.out.println(e);
			logger.log(LogStatus.FAIL, e);
			logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Test failed");
		}
		
	}
	
	@Test
	public void analyticsIntegration() throws IOException {
		String MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try{				
				//read data specific to TC like upload file path
				String analyticsUrl = objDataTable.ReadExcelData("Analytics URL");
//				String analyticsusername = objDataTable.ReadExcelData("WFM Username");
//				String analyticspassword = objDataTable.ReadExcelData("WFM Password");
				logger = report.startTest(MethodName, "Analytics Integration");
				System.out.println("Test script"+MethodName+"- Analytics Integration TC");
				driver.get(analyticsUrl);
				objLogin = new Login(driver);
				logger.log(LogStatus.PASS, "Customer Site:   "+analyticsUrl);
				logger.log(LogStatus.PASS, "Username:  "+username);
				//logger.log(LogStatus.PASS, "Password:  "+wfmpassword);
				// ****************Login Tc ********************//
				System.out.println("TC1");
				Boolean l = objLogin.login(username, password, analyticsUrl);
				if(l){
					logger.log(LogStatus.PASS,  "Login Successfull");
				}				
				else{
					logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Test failed");
				}
				objHome = new Home(driver);
				Boolean b = objHome.analyticsInte();
				if(b) {
					logger.log(LogStatus.PASS,  "Analytics integration displayed");				
					logger.log(LogStatus.PASS,  "Analytics integration test case execution completed");	
				}
				else
					logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Test failed");
				
		}catch(Exception e) {
			System.out.println(e);
			logger.log(LogStatus.FAIL, e);
			logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Test failed");
		}
		
	}
	
	@Test
	public void maestroIntegration() throws IOException {
		String MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try{				
				//read data specific to TC like upload file path
				String maestroUrl = objDataTable.ReadExcelData("Maestro URL");
				String maestrousername = objDataTable.ReadExcelData("Maestro Username");
				String maestropassword = objDataTable.ReadExcelData("Maestro Password");
				logger = report.startTest(MethodName, "Maestro Integration");
				System.out.println("Test script"+MethodName+"- Maestro Integration TC");
				driver.get(maestroUrl);
				objLogin = new Login(driver);
				logger.log(LogStatus.PASS, "Customer Site:   "+maestroUrl);
				logger.log(LogStatus.PASS, "Username:  "+maestrousername);
				//logger.log(LogStatus.PASS, "Password:  "+wfmpassword);
				// ****************Login Tc ********************//
				System.out.println("TC1");
				Boolean l = objLogin.login(maestrousername, maestropassword, maestroUrl);
				if(l){
					logger.log(LogStatus.PASS,  "Login Successfull");
				}				
				else{
					logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Test failed");
				}
				objHome = new Home(driver);
				Boolean b = objHome.maestroInte();
				if(b) {
					logger.log(LogStatus.PASS,  "Maestro URL----"+driver.getCurrentUrl());
					logger.log(LogStatus.PASS,  "Maestro integration displayed");				
					logger.log(LogStatus.PASS,  "Maestro integration test case execution completed");	
				}
				else
					logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Test failed");
				
		}catch(Exception e) {
			System.out.println(e);
			logger.log(LogStatus.FAIL, e);
			logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Test failed");
		}
		
		
	}
	
	@Test
	public void socialIntegration() throws IOException {
		String MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try{				
				//read data specific to TC like upload file path
				String socialUrl = objDataTable.ReadExcelData("Social URL");
//				String socialusername = objDataTable.ReadExcelData("Social Username");
//				String socialpassword = objDataTable.ReadExcelData("Social Password");
				logger = report.startTest(MethodName, "Social Integration");
				System.out.println("Test script"+MethodName+"- Social Integration TC");
				driver.get(socialUrl);
				objLogin = new Login(driver);
				logger.log(LogStatus.PASS, "Customer Site:   "+socialUrl);
				logger.log(LogStatus.PASS, "Username:  "+username);
				//logger.log(LogStatus.PASS, "Password:  "+wfmpassword);
				// ****************Login Tc ********************//
				System.out.println("TC1");
				Boolean l = objLogin.login(username, password, socialUrl);
				if(l){
					logger.log(LogStatus.PASS,  "Login Successfull");
				}				
				else{
					logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Test failed");
				}
				objHome = new Home(driver);
				Boolean b = objHome.socialInte();
				if(b) {
					logger.log(LogStatus.PASS,  "Social URL----"+driver.getCurrentUrl());
					logger.log(LogStatus.PASS,  "Social integration displayed");				
					logger.log(LogStatus.PASS,  "Social integration test case execution completed");	
				}
				else
					logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Test failed");
				
		}catch(Exception e) {
			System.out.println(e);
			logger.log(LogStatus.FAIL, e);
			logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Test failed");
		}
		
	}
	
	@Test
	public void attestationDisAgree() throws IOException {
		String MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try{				
				//read data specific to TC like upload file path
				String attestationUrl = objDataTable.ReadExcelData("Attestation URL");
				String attestationusername = objDataTable.ReadExcelData("Attestation Username");
				String attestationpassword = objDataTable.ReadExcelData("Attestation Password");
				logger = report.startTest(MethodName, "Attestation Check");
				System.out.println("Test script"+MethodName+"- Attestation page check TC");
				driver.get(attestationUrl);
				objLogin = new Login(driver);
				logger.log(LogStatus.PASS, "Customer Site:   "+attestationUrl);
				logger.log(LogStatus.PASS, "Username:  "+attestationusername);
				System.out.println("TC1");
				Boolean l = objLogin.login(attestationusername, attestationpassword, attestationUrl);
				if(l){
					logger.log(LogStatus.PASS,  "Login Successfull");
				}				
				else{
					logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Test failed");
				}				
				objAttestation= new Attestation(driver);
				Boolean u = objAttestation.checkAttestationUrl(attestationUrl);
				if(u) {
					logger.log(LogStatus.PASS,  "Attestation URL loaded Successfilly");
					Boolean a = objAttestation.disAgreeAttestation(attestationUrl);
					if(a) {
						logger.log(LogStatus.PASS,  "Home page loaded not after Attestion Dis Agree");
						
					}else {
						logger.log(LogStatus.FAIL,"Home page loaded");
						logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Test failed");
					}
				}else {
					logger.log(LogStatus.FAIL,"Attestation URL not loaded properly");
					logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Test failed");
				}
		}catch(Exception e) {
			System.out.println(e);
			logger.log(LogStatus.FAIL, e);
			logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Test failed");
		}
		
	}
	
	@Test
	public void attestationAgree() throws IOException {
		String MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try{				
				//read data specific to TC like upload file path
				String attestationUrl = objDataTable.ReadExcelData("Attestation URL");
				String attestationusername = objDataTable.ReadExcelData("Attestation Username");
				String attestationpassword = objDataTable.ReadExcelData("Attestation Password");
				logger = report.startTest(MethodName, "Attestation Check");
				System.out.println("Test script"+MethodName+"- Attestation page check TC");
				driver.get(attestationUrl);
				objLogin = new Login(driver);
				logger.log(LogStatus.PASS, "Customer Site:   "+attestationUrl);
				logger.log(LogStatus.PASS, "Username:  "+attestationusername);
				System.out.println("TC1");
				Boolean l = objLogin.login(attestationusername, attestationpassword, attestationUrl);
				if(l){
					logger.log(LogStatus.PASS,  "Login Successfull");
				}				
				else{
					logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Test failed");
				}				
				objAttestation= new Attestation(driver);
				Boolean u = objAttestation.checkAttestationUrl(attestationUrl);
				if(u) {
					logger.log(LogStatus.PASS,  "Attestation URL loaded Successfilly");
					Boolean a = objAttestation.agreeAttestation(attestationUrl);
					if(a) {
						logger.log(LogStatus.PASS,  "Home page loaded after Attestion Agree");
						
					}else {
						logger.log(LogStatus.FAIL,"Home page not loaded");
						logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Test failed");
					}
				}else {
					logger.log(LogStatus.FAIL,"Attestation URL not loaded properly");
					logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Test failed");
				}
		}catch(Exception e) {
			System.out.println(e);
			logger.log(LogStatus.FAIL, e);
			logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Test failed");
		}
		
	}
	
	@Test
	public void ssoPage() {
		
		
	}


}
