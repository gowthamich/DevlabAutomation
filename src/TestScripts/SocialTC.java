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
import ObjectRep.Talent;
import ObjectRep.SocialRep;

public class SocialTC extends BaseTest {
	
	
	@Test
	public void createBlog() throws IOException {
		System.out.println("In Create Blog TC");
		String MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			//read data specific to TC like upload file path
			String socialUrl = objDataTable.ReadExcelData("Social URL");
			String socialusername = objDataTable.ReadExcelData("Social Username");
			String socialpassword = objDataTable.ReadExcelData("Social Password");
			String socialcommunityname = objDataTable.ReadExcelData("Social Community Name");
			String socialblogname = objDataTable.ReadExcelData("Social Blog Name");
			String socialblogdesc = objDataTable.ReadExcelData("Social Blog Description");
			
			logger = report.startTest(MethodName, "New Blog Creation");
			System.out.println("Test script"+MethodName+"- New Blog Creation");
			driver.get(socialUrl);
			objLogin = new Login(driver);
			logger.log(LogStatus.PASS, "Customer Site:   "+socialUrl);
			logger.log(LogStatus.PASS, "Username:  "+socialusername);
			//logger.log(LogStatus.PASS, "Password:  "+wfmpassword);
			// ****************Login Tc ********************//
			System.out.println("TC1");
			Boolean l = objLogin.login(socialusername, socialpassword, socialUrl);
			if(l){
				logger.log(LogStatus.PASS,  "Login Successfull");
			}				
			else{
				logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Test failed");
			}
			objSocial = new SocialRep(driver);
			Boolean b = objSocial.newBlog(socialUrl, socialcommunityname, socialblogname, socialblogdesc );
			if(b) {
				logger.log(LogStatus.PASS,  "Blog Created successfully");				
				logger.log(LogStatus.PASS,  "Blog Creation test case execution completed");	
			}
			else
				logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Test failed");		
			
			
		}catch(Exception e) {
			System.out.println(e);			
			logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Test failed");
			logger.log(LogStatus.FAIL, e);
		}
	}
	
	@Test
	public void deleteBlog() throws IOException {
		System.out.println("In Delete Blog TC");
		String MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			//read data specific to TC like upload file path
			String socialUrl = objDataTable.ReadExcelData("Social URL");
			String socialusername = objDataTable.ReadExcelData("Social Username");
			String socialpassword = objDataTable.ReadExcelData("Social Password");
			String socialcommunityname = objDataTable.ReadExcelData("Social Community Name");
			String socialblogname = objDataTable.ReadExcelData("Social Blog Name");
			//String socialblogdesc = objDataTable.ReadExcelData("Social Blog Description");
			
			logger = report.startTest(MethodName, "Blog Deletion");
			System.out.println("Test script"+MethodName+"- Blog Deletion");
			driver.get(socialUrl);
			objLogin = new Login(driver);
			logger.log(LogStatus.PASS, "Customer Site:   "+socialUrl);
			logger.log(LogStatus.PASS, "Username:  "+socialusername);
			//logger.log(LogStatus.PASS, "Password:  "+wfmpassword);
			// ****************Login Tc ********************//
			System.out.println("TC1");
			Boolean l = objLogin.login(socialusername, socialpassword, socialUrl);
			if(l){
				logger.log(LogStatus.PASS,  "Login Successfull");
			}				
			else{
				logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Test failed");
			}
			objSocial = new SocialRep(driver);
			Boolean b = objSocial.deleteblog(socialUrl, socialcommunityname, socialblogname );
			if(b) {
				logger.log(LogStatus.PASS,  "Blog Deleted successfully");				
				logger.log(LogStatus.PASS,  "Blog deletion test case execution completed");	
			}
			else
				logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Test failed");		
			
			
		}catch(Exception e) {
			System.out.println(e);			
			logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Test failed");
			logger.log(LogStatus.FAIL, e);
		}
	}
	
	@Test
	public void createcomm() throws IOException {
		
		System.out.println("In Create Community TC");
		String MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			//read data specific to TC like upload file path
			String socialUrl = objDataTable.ReadExcelData("Social URL");
			String socialusername = objDataTable.ReadExcelData("Social Username");
			String socialpassword = objDataTable.ReadExcelData("Social Password");
			String socialcommunityname = objDataTable.ReadExcelData("Social Community Name");
			
			logger = report.startTest(MethodName, "Social Community Creation and Deletion ");
			System.out.println("Test script"+MethodName+"- Social Community Creation and Deletion");
			driver.get(socialUrl);
			objLogin = new Login(driver);
			logger.log(LogStatus.PASS, "Customer Site:   "+socialUrl);
			logger.log(LogStatus.PASS, "Username:  "+socialusername);
			//logger.log(LogStatus.PASS, "Password:  "+wfmpassword);
			// ****************Login Tc ********************//
			System.out.println("TC1");
			Boolean l = objLogin.login(socialusername, socialpassword, socialUrl);
			if(l){
				logger.log(LogStatus.PASS,  "Login Successfull");
			}				
			else{
				logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Test failed");
			}
			objSocial = new SocialRep(driver);
			Boolean b = objSocial.createComm(socialUrl, socialcommunityname);
			if(b) {
				logger.log(LogStatus.PASS,  "Community Created successfully");				
				logger.log(LogStatus.PASS,  "Community Creation test case execution completed");	
			}
			else
				logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Test failed");		
			
			
		}catch(Exception e) {
			System.out.println(e);			
			logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Test failed");
			logger.log(LogStatus.FAIL, e);
		}
	}
	
	@Test
	public void deletecomm() throws IOException {
		System.out.println("In Delete Community TC");
		String MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			//read data specific to TC like upload file path
			String socialUrl = objDataTable.ReadExcelData("Social URL");
			String socialusername = objDataTable.ReadExcelData("Social Username");
			String socialpassword = objDataTable.ReadExcelData("Social Password");
			String socialcommunityname = objDataTable.ReadExcelData("Social Community Name");
			
			logger = report.startTest(MethodName, "Social Community Deletion ");
			System.out.println("Test script"+MethodName+"- Social Community Deletion");
			driver.get(socialUrl);
			objLogin = new Login(driver);
			logger.log(LogStatus.PASS, "Customer Site:   "+socialUrl);
			logger.log(LogStatus.PASS, "Username:  "+socialusername);
			//logger.log(LogStatus.PASS, "Password:  "+wfmpassword);
			// ****************Login Tc ********************//
			System.out.println("TC1");
			Boolean l = objLogin.login(socialusername, socialpassword, socialUrl);
			if(l){
				logger.log(LogStatus.PASS,  "Login Successfull");
			}				
			else{
				logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Test failed");
			}
			objSocial = new SocialRep(driver);
			Boolean b = objSocial.deleteComm(socialUrl, socialcommunityname);
			if(b) {
				logger.log(LogStatus.PASS,  "Community Deleted successfully");				
				logger.log(LogStatus.PASS,  "Community Deletion test case execution completed");	
			}
			else
				logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Test failed");		
			
			
		}catch(Exception e) {
			System.out.println(e);			
			logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Test failed");
			logger.log(LogStatus.FAIL, e);
		}
		
	}
	
	@Test
	public void createDiscussion() throws IOException {
		System.out.println("In craete discussion in Community TC");
		String MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			//read data specific to TC like upload file path
			String socialUrl = objDataTable.ReadExcelData("Social URL");
			String socialusername = objDataTable.ReadExcelData("Social Username");
			String socialpassword = objDataTable.ReadExcelData("Social Password");
			String socialcommunityname = objDataTable.ReadExcelData("Social Community Name");
			String socialdiscussionname = objDataTable.ReadExcelData("Social Discussion Name");
			String socialdiscussiontext = objDataTable.ReadExcelData("Social Discussion Text");
			
			logger = report.startTest(MethodName, "New Discussion Creation in Community ");
			System.out.println("Test script"+MethodName+"- New Discussion Creation in Community");
			driver.get(socialUrl);
			objLogin = new Login(driver);
			logger.log(LogStatus.PASS, "Customer Site:   "+socialUrl);
			logger.log(LogStatus.PASS, "Username:  "+socialusername);
			//logger.log(LogStatus.PASS, "Password:  "+wfmpassword);
			// ****************Login Tc ********************//
			System.out.println("TC1");
			Boolean l = objLogin.login(socialusername, socialpassword, socialUrl);
			if(l){
				logger.log(LogStatus.PASS,  "Login Successfull");
			}				
			else{
				logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Test failed");
			}
			objSocial = new SocialRep(driver);
			Boolean b = objSocial.newDiscussion(socialUrl, socialcommunityname, socialdiscussionname,socialdiscussiontext );
			if(b) {
				logger.log(LogStatus.PASS,  "New discussion created in community");				
				logger.log(LogStatus.PASS,  "New Discussion Creation in Community test case execution completed");	
			}
			else
				logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Test failed");		
			
			
		}catch(Exception e) {
			System.out.println(e);			
			logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Test failed");
			logger.log(LogStatus.FAIL, e);
		}
		
	}
	
	@Test
	public void deleteDiscussion() throws IOException {
		System.out.println("In Delete discussion in Community TC");
		String MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			//read data specific to TC like upload file path
			String socialUrl = objDataTable.ReadExcelData("Social URL");
			String socialusername = objDataTable.ReadExcelData("Social Username");
			String socialpassword = objDataTable.ReadExcelData("Social Password");
			String socialcommunityname = objDataTable.ReadExcelData("Social Community Name");
			String socialdiscussionname = objDataTable.ReadExcelData("Social Discussion Name");
			//String socialdiscussiontext = objDataTable.ReadExcelData("Social Discussion Text");
			
			logger = report.startTest(MethodName, "New Discussion deletion in Community ");
			System.out.println("Test script"+MethodName+"-  Discussion Deletion in Community");
			driver.get(socialUrl);
			objLogin = new Login(driver);
			logger.log(LogStatus.PASS, "Customer Site:   "+socialUrl);
			logger.log(LogStatus.PASS, "Username:  "+socialusername);
			//logger.log(LogStatus.PASS, "Password:  "+wfmpassword);
			// ****************Login Tc ********************//
			System.out.println("TC1");
			Boolean l = objLogin.login(socialusername, socialpassword, socialUrl);
			if(l){
				logger.log(LogStatus.PASS,  "Login Successfull");
			}				
			else{
				logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Test failed");
			}
			objSocial = new SocialRep(driver);
			Boolean b = objSocial.deletediscussion(socialUrl, socialcommunityname, socialdiscussionname );
			if(b) {
				logger.log(LogStatus.PASS,  "Discussion deleted in community");				
				logger.log(LogStatus.PASS,  "Discussion deletion in Community test case execution completed");	
			}
			else
				logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Test failed");		
			
			
		}catch(Exception e) {
			System.out.println(e);			
			logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Test failed");
			logger.log(LogStatus.FAIL, e);
		}
		
	}
	
	@Test
	public void newFile() throws IOException {
		System.out.println("In uploading new file in Community TC");
		String MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			//read data specific to TC like upload file path
			String socialUrl = objDataTable.ReadExcelData("Social URL");
			String socialusername = objDataTable.ReadExcelData("Social Username");
			String socialpassword = objDataTable.ReadExcelData("Social Password");
			String socialcommunityname = objDataTable.ReadExcelData("Social Community Name");
			String socialfilename = objDataTable.ReadExcelData("Social File Name");
			String socialfiledesc = objDataTable.ReadExcelData("Social File Description");
			String socialUploadfilepath = objDataTable.ReadExcelData("UploadFilePath");
			
			logger = report.startTest(MethodName, "New file upload  in Community ");
			System.out.println("Test script"+MethodName+"-  New file upload  in Community");
			driver.get(socialUrl);
			objLogin = new Login(driver);
			logger.log(LogStatus.PASS, "Customer Site:   "+socialUrl);
			logger.log(LogStatus.PASS, "Username:  "+socialusername);
			//logger.log(LogStatus.PASS, "Password:  "+wfmpassword);
			// ****************Login Tc ********************//
			System.out.println("TC1");
			Boolean l = objLogin.login(socialusername, socialpassword, socialUrl);
			if(l){
				logger.log(LogStatus.PASS,  "Login Successfull");
			}				
			else{
				logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Test failed");
			}
			objSocial = new SocialRep(driver);
			Boolean b = objSocial.newFileSocial(socialUrl, socialcommunityname, socialfilename,socialfiledesc, socialUploadfilepath );
			if(b) {
				logger.log(LogStatus.PASS,  "New file uploaded in community");				
				logger.log(LogStatus.PASS,  "File Upload in community test case execution completed");	
			}
			else
				logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Test failed");		
			
			
		}catch(Exception e) {
			System.out.println(e);			
			logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Test failed");
			logger.log(LogStatus.FAIL, e);
		}
		
	}
	
	@Test
	public void deleteFile() throws IOException {
		
		System.out.println("In uploading new file in Community TC");
		String MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			//read data specific to TC like upload file path
			String socialUrl = objDataTable.ReadExcelData("Social URL");
			String socialusername = objDataTable.ReadExcelData("Social Username");
			String socialpassword = objDataTable.ReadExcelData("Social Password");
			String socialcommunityname = objDataTable.ReadExcelData("Social Community Name");
			String socialfilename = objDataTable.ReadExcelData("Social File Name");			
			
			logger = report.startTest(MethodName, "Delete file in Community ");
			System.out.println("Test script"+MethodName+"-  Delete file in Community");
			driver.get(socialUrl);
			objLogin = new Login(driver);
			logger.log(LogStatus.PASS, "Customer Site:   "+socialUrl);
			logger.log(LogStatus.PASS, "Username:  "+socialusername);
			//logger.log(LogStatus.PASS, "Password:  "+wfmpassword);
			// ****************Login Tc ********************//
			System.out.println("TC1");
			Boolean l = objLogin.login(socialusername, socialpassword, socialUrl);
			if(l){
				logger.log(LogStatus.PASS,  "Login Successfull");
			}				
			else{
				logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Test failed");
			}
			objSocial = new SocialRep(driver);
			Boolean b = objSocial.deleteFileSocial(socialUrl, socialcommunityname, socialfilename);
			if(b) {
				logger.log(LogStatus.PASS,  "Deleted file in community");				
				logger.log(LogStatus.PASS,  "Delete File in community test case execution completed");	
			}
			else
				logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Test failed");		
			
			
		}catch(Exception e) {
			System.out.println(e);			
			logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Test failed");
			logger.log(LogStatus.FAIL, e);
		}
		
	}

		
	
}
	


