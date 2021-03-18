package TestScripts;

import java.io.IOException;

import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Base.Initiator;
import Common_methods.ReadExcel;
import Common_methods.CommonMethods;
import ObjectRep.Home;
import ObjectRep.Login;

public class TCNG extends BaseTest{
	
	String actName ="";

	@Test
	public void bvtExe() throws IOException{
		String MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try{			
			//read data specific to TC like upload file path			
			logger = report.startTest(MethodName, "To verify BVT cases");
			System.out.println("Test script"+MethodName+"- BVT Execution TC");
			objLogin = new Login(driver);
			logger.log(LogStatus.PASS, "Username:  "+username);
			logger.log(LogStatus.PASS, "Password:  "+password);
			// ****************Login Tc ********************//
			System.out.println("TC1");
			Boolean l = objLogin.login(username, password, appUrl);
//			Assert.assertTrue(driver.getCurrentUrl().contains("core") );
//			System.out.println("Afyer assert");
			if(l){
				logger.log(LogStatus.PASS,  "Login Successfull");
			}				
			else{
				logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Test failed");
			}
			
			// ****************Enterprise Search TC ********************//
			System.out.println("TC2");
			objHome = new Home(driver);
			Boolean s = objHome.search();
			logger.log(LogStatus.PASS,  "Enterprise search TC execution started");
			if(s){
				logger.log(LogStatus.PASS,  "Enterprise search is working ");				
				logger.log(LogStatus.PASS,  "Enterprise search test case execution completed");				
			}
			else{
				logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Test failed");
			}
			// ****************File upload TC ********************//
			System.out.println("TC3");
			String filePath = objDataTable.ReadExcelData("UploadFilePath");
			actName = actName+ objDataTable.ReadExcelData("ActivityName")+ objCom.GetTimeStamp();
			
			logger.log(LogStatus.PASS,  "Upload filePath"+filePath);	
			Boolean b = objHome.uploadFile(filePath,actName);			
			if(b){
				logger.log(LogStatus.PASS,  "Uploaded file successfully ");
				logger.log(LogStatus.PASS, "Upload file Test case execution completed");
			}
			else 
				logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Test failed");
			// ****************Deleting file TC ********************//
			System.out.println("TC4");
			//String delFile = objDataTable.ReadExcelData("DeleteFile");
			logger.log(LogStatus.PASS,  "Deleting upload file TC  Execution started");
			//logger.log(LogStatus.PASS,  "Deleting file "+delFile);
			Boolean d = objHome.fileDelete();	
			if(d){
				Alert alert = driver.switchTo().alert();
				String alertMessage= driver.switchTo().alert().getText();
				System.out.println(alertMessage);	
		        Thread.sleep(5000);
		        alert.accept();	
		        System.out.println(" file deleted successfully");
		        //logger.log(LogStatus.PASS, " Deleted Uploaded file --- "+delFile);
		        logger.log(LogStatus.PASS,  "Delete file Test case execution completed");
			}
			else{
				logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Test failed");
			}
//			objHome.closeButtonClick();
//			System.out.println("Closed");
			System.out.println("Switched to default contenet");
			//****************Create User  TC ********************//
			System.out.println("TC5");
			//String MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
			//read data specific to TC like upload file path
			String newUserName = objDataTable.ReadExcelData("NewUserName");	
			String newUserPassword = objDataTable.ReadExcelData("NewUserPassword");
			String firstName = objDataTable.ReadExcelData("FirstName");
			String lastName = objDataTable.ReadExcelData("LastName");
			String searchUserName = objDataTable.ReadExcelData("SearchUserName");
			String userLangSelect = objDataTable.ReadExcelData("UserLanguage");
			String userTypeSelect = objDataTable.ReadExcelData("UserTypeSelect");
			String userRoleSelect = objDataTable.ReadExcelData("SecurityRole");
			String timeZoneSelect = objDataTable.ReadExcelData("TimeZoneSelect");
			String email = objDataTable.ReadExcelData("Email");
			//logger = report.startTest(MethodName, "To verify creating new user");
			//System.out.println("Test script"+MethodName+"- Create New User TC");	
			logger.log(LogStatus.PASS,  "Create New user TC execution started");
			//objHome = new Home(driver);
			Boolean c = objHome.createUser(newUserName, newUserPassword, userTypeSelect,userRoleSelect, firstName, lastName,timeZoneSelect, email, userLangSelect);
			//System.out.println(b.booleanValue());
			if(c){
				logger.log(LogStatus.PASS,  "Created "+newUserName+" successfully in users list");
				logger.log(LogStatus.PASS,  "Creating new user Test case execution completed");
			}else 
				logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Test failed");
			
			//****************Deactivate User  TC ********************//
			System.out.println("TC6");			
			System.out.println("Test script"+MethodName+"- Deactivate user account");
			logger.log(LogStatus.PASS,  "Deactivate account Test case execution Started");
			objHome = new Home(driver);
			String name = "";
			name = name+newUserName;
			System.out.println(name);
			Boolean de =  objHome.deactivateAccount(name);
			if(de){
				logger.log(LogStatus.PASS, "Deactivated "+name+" successfully ");
				
				logger.log(LogStatus.PASS,  "Deactivate account Test case execution completed");
			}				
			else 
				logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Test failed");
			
			
			//****************Remove User  TC ********************//
			System.out.println("TC7");
			System.out.println("Test script"+MethodName+"- Remove user account");
			logger.log(LogStatus.PASS, "Remove user account TC execution Started");	
			//objHome = new Home(driver); 
			Boolean r = objHome.removeAccount(name);
			if(r){
				logger.log(LogStatus.PASS, "Removed "+name+" successfully ");
				logger.log(LogStatus.PASS, "Remove user account TC execution Completed");
				
			}
			else 
				logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Test failed");
			//*****************Report check *************************//
			System.out.println("TC8");
			System.out.println("Test script"+MethodName+"- Report check");
			logger.log(LogStatus.PASS, "Reporting TC execution Started");
			String folName = objDataTable.ReadExcelData("FolderName");
			String repName = objDataTable.ReadExcelData("ReportName");
			String resId = objDataTable.ReadExcelData("ReportResourceId");
			String repPath = objDataTable.ReadExcelData("ReportPath");			
			Boolean re = objHome.reportCheck(folName,repName,resId, repPath);
			if(re){
				logger.log(LogStatus.PASS,  "Report able to view ");
				logger.log(LogStatus.PASS,  "Reporting Tc execution completed ");
					
			}
			else 
				logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Test failed");
 
			objHome.logoff();
			logger.log(LogStatus.PASS, "Logoff");
		}
		catch(Exception e){
			System.out.println(e);
			logger.log(LogStatus.FAIL, e);
			logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Test failed");
		}
	}

	@Test
	public void reportView() throws IOException{
		String MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try{
		    System.out.println("TC8");
			//String MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
			//read data specific to TC like upload file path			
			logger = report.startTest(MethodName, "To verify reporting functionality");
			System.out.println("Test script"+MethodName+"- Reporting  TC");
			objLogin = new Login(driver);
			driver.get(appUrl);
			logger.log(LogStatus.PASS, "Customer Site URL:  "+appUrl);
			logger.log(LogStatus.PASS, "Username:  "+username);			
			Boolean l = objLogin.login(username, password, appUrl);
			if(l){
				logger.log(LogStatus.PASS,  "Login Successfull");
			}				
			else{
				logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Test failed");
			}		
			 objHome = new Home(driver);
			 Boolean b = objHome.viewInReport();
			 if(b){
					logger.log(LogStatus.PASS,  "Able to create view in report ");
					objHome.logoff();
					logger.log(LogStatus.PASS, "Logoff");
				}
				else 
					logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Test failed");

		}
		catch(Exception e){
			System.out.println(e);
			logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Test failed");
		}
		
	}
	
	@Test
	public void xApiDelete() throws IOException{
		String MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try{
		    System.out.println("TC12");			
			//read data specific to TC like upload file path			
			logger = report.startTest("XAPI Delete");
			String xapiName = objDataTable.ReadExcelData("xapiSearchName");
			objLogin = new Login(driver);
			driver.get(appUrl);
			logger.log(LogStatus.PASS, "Customer Site URL:  "+appUrl);
			logger.log(LogStatus.PASS, "Username:  "+username);
			//logger.log(LogStatus.PASS, "Password:  "+password);
			Boolean l = objLogin.login(username, password, appUrl);
			if(l){
//				Assert.assertEquals(driver.getCurrentUrl(), "https://test1.dev.sumtotal.host/core/");
				logger.log(LogStatus.PASS, "Login Successful");	
			}
			else{
				logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Test failed");
			}
			objHome = new Home(driver);
			Boolean b = objHome.deleteXApi(xapiName);
			if(b){
				logger.log(LogStatus.PASS,  "XApi deleted as expected");
				objHome.logoff();
				logger.log(LogStatus.PASS, "Logoff");
				logger.log(LogStatus.PASS, "XApi deletion test case execution completed");
			}				
			else{
				logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Test failed");
				
			}
		}
		catch(Exception e){
 			System.out.println(e);
 			logger.log(LogStatus.FAIL, e);
 			logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Test failed");
		}
	}
	@Test
	public void xAPI() throws IOException{
		String MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try{
		    System.out.println("TC12");			
			//read data specific to TC like upload file path			
			logger = report.startTest("XAPI");
			String url = objDataTable.ReadExcelData("xAPIURL");
			objLogin = new Login(driver);
			driver.get(appUrl);
			logger.log(LogStatus.PASS, "Customer Site URL:  "+appUrl);
			logger.log(LogStatus.PASS, "Username:  "+username);
			//logger.log(LogStatus.PASS, "Password:  "+password);
			Boolean l = objLogin.login(username, password, appUrl);
			if(l){
//				Assert.assertEquals(driver.getCurrentUrl(), "https://test1.dev.sumtotal.host/core/");
				logger.log(LogStatus.PASS, "Login Successful");	
			}
			else{
				logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Test failed");
			}
			objHome = new Home(driver);
			Boolean b = objHome.xapi(url);
			if(b){
				logger.log(LogStatus.PASS,  "XApi working as expected");
				objHome.logoff();
				logger.log(LogStatus.PASS, "Logoff");
				logger.log(LogStatus.PASS, "XApi creation test case execution completed");
			}				
			else{
				logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Test failed");
				
			}
		}
		catch(Exception e){
  			System.out.println(e);
  			logger.log(LogStatus.FAIL, e);
  			logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Test failed");
		}
			
	}
	
	@Test
	public void mobileConfig() throws IOException{
		String MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try{
		    System.out.println("TC12");			
			//read data specific to TC like upload file path			
			logger = report.startTest("Mobile Configuration");
			
			//System.out.println("Test script"+MethodName+"- Mobile configuration  TC");
			objLogin = new Login(driver);
			driver.get(appUrl);
			logger.log(LogStatus.PASS, "Customer Site URL:  "+appUrl);
			logger.log(LogStatus.PASS, "Username:  "+username);
			//logger.log(LogStatus.PASS, "Password:  "+password);
			Boolean l = objLogin.login(username, password, appUrl);
			if(l){
//				Assert.assertEquals(driver.getCurrentUrl(), "https://test1.dev.sumtotal.host/core/");
				logger.log(LogStatus.PASS, "Login Successful");	
			}
			else{
				logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Test failed");
			}
			//test.log(LogStatus.PASS, "Login Successful");
			objHome = new Home(driver);
			Boolean b = objHome.mobile();			
			if(b){
				logger.log(LogStatus.PASS,  "Mobile configuration page is displayed ");
				objHome.logoff();
				logger.log(LogStatus.PASS, "Logoff");
				logger.log(LogStatus.PASS, "Mobile configuration test case execution completed");
				
			}				
			else{
				logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Test failed");
				
			}				
		}
		catch(Exception e){
			System.out.println(e);
			logger.log(LogStatus.FAIL, e);
			logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Test failed");
		}
	}
	
	@Test
	public void mongoSocial() throws IOException{
		String MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try{
		    System.out.println("TC11");			
			//read data specific to TC like upload file path			
			logger = report.startTest("Mongo Social");
			System.out.println("Test script"+MethodName+"- Social  TC");
			objLogin = new Login(driver);
			driver.get(appUrl);
			logger.log(LogStatus.PASS, "Customer Site URL:  "+appUrl);
			logger.log(LogStatus.PASS, "Username:  "+username);
			//logger.log(LogStatus.PASS, "Password:  "+password);
			Boolean l = objLogin.login(username, password, appUrl);
			if(l){
				logger.log(LogStatus.PASS,  "Login Successfull");
			}				
			else{
				logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Test failed");
				
			}
			objHome = new Home(driver);
			Boolean b = objHome.social();
			if(b){
				logger.log(LogStatus.PASS, "Social configuration page is displayed ");
				objHome.logoff();
				logger.log(LogStatus.PASS, "Logoff");
				logger.log(LogStatus.PASS, "Mongo Social test case execution completed");
			}	
			else 
				logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Test failed");
			
		}
		catch(Exception e){
			System.out.println(e);
			logger.log(LogStatus.FAIL, e);
			logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Test failed");
		}
		
	}
	
	@Test
	public void gamification() throws IOException{
		String MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try{
		    System.out.println("TC10");			
			//read data specific to TC like upload file path			
			logger = report.startTest(MethodName, "To Gamification Feature");
			System.out.println("Test script"+MethodName+"- Gamification  TC");
			objLogin = new Login(driver);
			driver.get(appUrl);
			logger.log(LogStatus.PASS, "Customer Site URL:  "+appUrl);
			logger.log(LogStatus.PASS, "Username:  "+username);
			//logger.log(LogStatus.PASS, "Password:  "+password);
			Boolean l = objLogin.login(username, password, appUrl);
			if(l){
				logger.log(LogStatus.PASS,  "Login Successfull");
			}				
			else{
				logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Test failed");
			}
			objHome = new Home(driver);
			Boolean b = objHome.gamificationFun();
			if(b){
				logger.log(LogStatus.PASS, "Gamification configuration page is displayed ");
				objHome.logoff();
				logger.log(LogStatus.PASS, "Logoff");
				logger.log(LogStatus.PASS, "Gamefication test case execution completed");
			}
			else 
				logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Test failed");
		}
		catch(Exception e){
			System.out.println(e);
			logger.log(LogStatus.FAIL, e);
			logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Test failed");
		}
		
	}
	
	@Test
	public void tmuImport() throws IOException{
		String MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try{
		    System.out.println("TC9");			
			//read data specific to TC like upload file path			
			logger = report.startTest(MethodName, "To verify TMU Import");
			System.out.println("Test script"+MethodName+"- Import TMU  TC");
			objLogin = new Login(driver);
			driver.get(appUrl);
			logger.log(LogStatus.PASS, "Customer Site URL:  "+appUrl);
			logger.log(LogStatus.PASS, "Username:  "+username);
			//logger.log(LogStatus.PASS, "Password:  "+password);
			Boolean l = objLogin.login(username, password, appUrl);
			if(l){
				logger.log(LogStatus.PASS,  "Login Successfull");
			}				
			else{
				logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Test failed");
			}					
			objHome = new Home(driver);
			Boolean b = objHome.importTMU();
			if(b){
				logger.log(LogStatus.PASS,  "Taining migration import success ");
				objHome.logoff();
				logger.log(LogStatus.PASS, "Logoff");
				logger.log(LogStatus.PASS, "TMU import test case execution completed");
			}
			else 
				logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Test failed");

		}
		catch(Exception e){
			System.out.println(e);
			logger.log(LogStatus.FAIL, e);
			logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Test failed");
		}
		
	}
	
	@Test
	public void dsuImport() throws IOException{
		String MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try{
		    System.out.println("TC8");			
			//read data specific to TC like upload file path			
			logger = report.startTest(MethodName, "To verify DSU import");
			System.out.println("Test script"+MethodName+"- Import DSU  TC");
			objLogin = new Login(driver);
			driver.get(appUrl);
			logger.log(LogStatus.PASS, "Customer Site URL:  "+appUrl);
			logger.log(LogStatus.PASS, "Username:  "+username);
			//logger.log(LogStatus.PASS, "Password:  "+password);
			Boolean l = objLogin.login(username, password, appUrl);
			if(l){
				logger.log(LogStatus.PASS,  "Login Successfull");
			}				
			else{
				logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Test failed");
			}
			objHome = new Home(driver);
			Boolean b = objHome.importDSU();
			if(b){
				logger.log(LogStatus.PASS,  "Data import success ");
				objHome.logoff();
				logger.log(LogStatus.PASS, "Logoff");
				logger.log(LogStatus.PASS, "Data import Test case execution completed");
			}
			else 
				logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Test failed");
			
			
		}
		catch(Exception e){
			System.out.println(e);
			logger.log(LogStatus.FAIL, e);
			logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Test failed");
		}
		
	}
	
	@Test
	public void advancedSearch() throws IOException {
		String MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			System.out.println("TC4");	
			//String appUrl = objDataTable.ReadExcelData("App URL");
			logger = report.startTest(MethodName, "To verify Advanced Search Configuration");
			System.out.println("Test script"+MethodName+"- Advanced Search Configuration");
			//driver.manage().deleteAllCookies();
			driver.get(appUrl);
			objLogin = new Login(driver);
			logger.log(LogStatus.PASS, "Customer Site URL:  "+appUrl);
			logger.log(LogStatus.PASS, "Username:  "+username);
			//logger.log(LogStatus.PASS, "Password:  "+password);
			Boolean l = objLogin.login(username, password, appUrl);
			if(l){
				logger.log(LogStatus.PASS,  "Login Successfull");
			}				
			else{
				logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Test failed");
			}		
			objHome = new Home(driver);
			Boolean b = objHome.advancedsearchConfig(appUrl);
			if(b){
				logger.log(LogStatus.PASS,  "Advanced search is working ");
				objHome.logoff();
				logger.log(LogStatus.PASS,  "Logoff");
				logger.log(LogStatus.PASS,  "Advanced search test case execution completed");
				
			}
			else{
				logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Test failed");
			}			
		}catch(Exception e) {
			System.out.println(e);
			logger.log(LogStatus.FAIL, e);
			logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Test failed");
			
		}
	}
	



  
}
