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

public class BVT extends BaseTest {
	
	String actName ="";
	
	@Test
	 public void login() throws Exception{
		System.out.println("TC1");
		String MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			logger = report.startTest(MethodName, "To verify login");
			System.out.println("Test script"+MethodName+"- Login TC");
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
			Boolean b = objHome.logoff();
			if(b){
				System.out.println("Logoff successfull");
				logger.log(LogStatus.PASS, "Logoff successfull");
				logger.log(LogStatus.PASS, "Login Test case execution completed");
			}
			else{
				System.out.println("Logoff not success");
				logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Test failed");
			}
		}
			catch(Exception e) {
				System.out.println(e);
				logger.log(LogStatus.FAIL, e);
				logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Test failed");
				
			}
	}
	
	@Test
	public void upload()throws Exception{
		String MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try{
	    System.out.println("TC2");		
		//read data specific to TC like upload file path
		String filePath = objDataTable.ReadExcelData("UploadFilePath");
		actName = actName+objDataTable.ReadExcelData("ActivityName")+ objCom.GetTimeStamp();
		System.out.println("Actname generated as    "+ actName);
		logger = report.startTest(MethodName, "To verify upload file");
		System.out.println("Test script"+MethodName+"- Upload  TC");
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
		logger.log(LogStatus.PASS,  "Upload filePath"+filePath);
		logger.log(LogStatus.PASS,  "Activity Name----"+actName);		
		Boolean b = objHome.uploadFile(filePath,actName);
		if(b){
			logger.log(LogStatus.PASS,  "Uploaded file successfully ");
			objDataTable.SetCell(actName);
			objHome.logoff();
			logger.log(LogStatus.PASS, "Logoff");
			logger.log(LogStatus.PASS, "Upload file Test case execution completed");
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
	public void deleteUploadFile()throws Exception{
		String MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try{
		    System.out.println("TC3");			
			//read data specific to TC like upload file path
			//String delFile = objDataTable.ReadExcelData("DeleteFile");
		    String delFile = "";
		    delFile = delFile+actName;
		    //delFile = delFile+"testgact20200805194300579";
		    System.out.println("actname to be deleted    "+delFile);
			
			System.out.println("After setting value in delete method---"+delFile);
			logger = report.startTest(MethodName, "To verify deleting uploaded file");
			System.out.println("Test script"+MethodName+"- Delete Uploaded File  TC");
			objLogin = new Login(driver);
			driver.get(appUrl);
			
			logger.log(LogStatus.PASS, "Customer Site URL   :  "+appUrl);
			logger.log(LogStatus.PASS, "Username:  "+username);			
			Boolean l = objLogin.login(username, password, appUrl);
			if(l){
				logger.log(LogStatus.PASS,  "Login Successfull");
			}				
			else{
				logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Test failed");
			}					
			objHome = new Home(driver);
			logger.log(LogStatus.PASS,  " To Delete Uploaded file --- "+delFile);	
			Boolean b = objHome.deleteUpload(delFile);	
			if(b){
				Alert alert = driver.switchTo().alert();
				String alertMessage= driver.switchTo().alert().getText();
				System.out.println(alertMessage);	
		        Thread.sleep(5000);
		        alert.accept();	
		        System.out.println(" file deleted successfully");
		        logger.log(LogStatus.PASS, " Deleted Uploaded file --- "+delFile);
		        objHome.logoff();
				logger.log(LogStatus.PASS,  "Logoff");
				logger.log(LogStatus.PASS,  "Delete file Test case execution completed");
			}
			else{
				logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Test failed");
			}
		}
		catch(Exception e){
			System.out.println(e);			
			logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Test failed");
			logger.log(LogStatus.FAIL, e);
		}
		
	}
	
	@Test
	public void enterpriseSearch()throws Exception{
		String MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			System.out.println("TC4");	
			//String appUrl = objDataTable.ReadExcelData("App URL");
			logger = report.startTest(MethodName, "To verify Enterprise Search");
			System.out.println("Test script"+MethodName+"- Enterprise Search");
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
			Boolean b = objHome.search();
			if(b){
				logger.log(LogStatus.PASS,  "Enterprise search is working ");
				objHome.logoff();
				logger.log(LogStatus.PASS,  "Logoff");
				logger.log(LogStatus.PASS,  "Enterprise search test case execution completed");
				
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
	
	@Test
	public void createNewUser() throws IOException{
		String MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try{
		    System.out.println("TC5");			
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
			logger = report.startTest(MethodName, "To verify creating new user");
			System.out.println("Test script"+MethodName+"- Create New User TC");
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
			Boolean b = objHome.createUser(newUserName, newUserPassword, userTypeSelect,userRoleSelect, firstName, lastName,timeZoneSelect, email, userLangSelect);
			System.out.println(b.booleanValue());
			if(b){
				logger.log(LogStatus.PASS,  "Created "+newUserName+" successfully in users list");
				objHome.logoff();
				logger.log(LogStatus.PASS,  "Logoff");
				logger.log(LogStatus.PASS,  "Creating new user Test case execution completed");
			}else 
				logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Test failed");
		}
		catch(Exception e){
			System.out.println(e);
			logger.log(LogStatus.FAIL, e);
			logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Test failed");
			
		}
		
 	}
	
	@Test
	public void deactivateAccount() throws IOException{
		String MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try{
			System.out.println("TC6");			
			//read data specific to TC like upload file path
			String name = objDataTable.ReadExcelData("DeactivateName");	
			logger = report.startTest(MethodName, "To verify Deactivate user account");
			System.out.println("Test script"+MethodName+"- Deactivate user account");
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
			Boolean b =  objHome.deactivateAccount(name);
			if(b){
				logger.log(LogStatus.PASS, "Deactivated "+name+" successfully ");
				objHome.logoff();
				logger.log(LogStatus.PASS,  "Logoff");
				logger.log(LogStatus.PASS,  "Deactivate account Test case execution completed");
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
	public void removeAccount() throws IOException{
		String MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try{
			System.out.println("TC7");			
			//read data specific to TC like upload file path
			String name = objDataTable.ReadExcelData("RemoveName");	
			logger = report.startTest(MethodName, "To verify Removing user account");
			System.out.println("Test script"+MethodName+"- Remove user account");
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
			Boolean b = objHome.removeAccount(name);
			if(b){
				logger.log(LogStatus.PASS, "Removed "+name+" successfully ");
				objHome.logoff();
				logger.log(LogStatus.PASS, "Logoff");
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
	public void reporting() throws IOException{
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
			//logger.log(LogStatus.PASS, "Password:  "+password);
			String folName = objDataTable.ReadExcelData("FolderName");
			String repName = objDataTable.ReadExcelData("ReportName");
			String resId = objDataTable.ReadExcelData("ReportResourceId");
			String repPath = objDataTable.ReadExcelData("ReportPath");
			Boolean l = objLogin.login(username, password, appUrl);
			if(l){
				logger.log(LogStatus.PASS,  "Login Successfull");
			}				
			else{
				logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Test failed");
			}		  
			 objHome = new Home(driver);
			 String url = appUrl+"jasperserver-pro";
			 Boolean b = objHome.reportCheck(folName,repName,resId, repPath);
			 if(b){
					logger.log(LogStatus.PASS,  "Adle to create, delete and view Report ");
					objHome.logoff();
					logger.log(LogStatus.PASS, "Logoff");
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
	public void userSearch() throws IOException{
		String MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try{
		    System.out.println("TC12");			
			//read data specific to TC like upload file path			
			logger = report.startTest("Search User");
			String name = objDataTable.ReadExcelData("SearchUserName");			
			//System.out.println("Test script"+MethodName+"- Mobile configuration  TC");
			objLogin = new Login(driver);
			driver.get(appUrl);
			logger.log(LogStatus.PASS, "Customer Site URL:  "+appUrl);
			logger.log(LogStatus.PASS, "Username:  "+username);
			//logger.log(LogStatus.PASS, "Password:  "+password);
			Boolean l = objLogin.login(username, password, appUrl);
			if(l){
				logger.log(LogStatus.PASS, "Login Successful");	
			}
			else{
				logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Test failed");
			}
			objHome = new Home(driver);
			Boolean b = objHome.searchUser(name);
			if(b){
				logger.log(LogStatus.PASS,  "User name  "+name+ " found in search list");
				objHome.logoff();
				logger.log(LogStatus.PASS, "Logoff");
				logger.log(LogStatus.PASS, "User Serach test case execution completed");
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

}
