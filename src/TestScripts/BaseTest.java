package TestScripts;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import Common_methods.CommonMethods;
import Common_methods.ReadExcel;
import ObjectRep.Attestation;
import ObjectRep.GamificationRep;
import ObjectRep.Home;
import ObjectRep.Login;
import ObjectRep.SocialRep;
import ObjectRep.Talent;

public class BaseTest {
	
	public static ExtentTest logger;
	public static ExtentReports report;
	//public static ExtentTest test;
	public static ExtentReports reports;
	public static WebDriver driver;
	public static Login objLogin;
	public static Home objHome;
	public static Talent objTalent;
	public static SocialRep objSocial;
	public static GamificationRep ObjGamification;
	public static Attestation objAttestation;
	public static CommonMethods objCom;
	public static CommonMethods objCommonMethods;
	public static ReadExcel objDataTable;
	public static String username;
	public static String password;
	public static String appUrl;
	public static String TestResultPath;
	
	
	@BeforeSuite
	public void setUp() throws IOException {
		objCommonMethods = new CommonMethods(driver);
 		objCom = new CommonMethods();
		objDataTable = new ReadExcel("Common");
		//report = objCommonMethods.SetReport(this.getClass().getSimpleName());
		TestResultPath= objDataTable.ReadExcelData("TestResultPath");
		String Time_Stamp = objCommonMethods.GetTimeStamp();
		report = new ExtentReports(TestResultPath +"DEV_"+Time_Stamp+".html", true);		
		
	}
	@BeforeTest
	public void btest() throws Exception{
		//BasicConfigurator.configure();
		System.out.println("Before Test");
		
 		objCommonMethods = new CommonMethods(driver);
 		objCom = new CommonMethods();
		objDataTable = new ReadExcel("Common");
		//report = objCommonMethods.SetReport(this.getClass().getSimpleName());
//		TestResultPath= objDataTable.ReadExcelData("TestResultPath");
//		String Time_Stamp = objCommonMethods.GetTimeStamp();
//		report = new ExtentReports(TestResultPath +"DEV_"+Time_Stamp+".html", true);
		//Read common input from excel like username, pswd etc
		username= objDataTable.ReadExcelData("Username");
		password= objDataTable.ReadExcelData("Password");
		appUrl = objDataTable.ReadExcelData("App URL");
		
				
	}
	@BeforeMethod
	public void bmethod()throws IOException{
		System.out.println("Before Method");
		driver = objCommonMethods.Initiate();
	
	}
	@AfterMethod
	public void tearDown(ITestResult result)throws Exception{
 		System.out.println("AfterMethod");
//		if(result.getStatus()==ITestResult.FAILURE){
//			objCommonMethods = new CommonMethods(driver); 
//			String screenshot_path = objCommonMethods.Takescreenprint(result.getName());
//			String image = logger.addScreenCapture(screenshot_path);
//			logger.log(LogStatus.FAIL, image);
//			logger.log(LogStatus.FAIL,"Test case Failed is "+result.getThrowable() );
//			
//		}else if(result.getStatus()== ITestResult.SKIP){
//			logger.log(LogStatus.SKIP, "Test Case Skipped is "+result.getThrowable());
//			
//		}else if (result.getStatus()== ITestResult.SUCCESS){
//			logger.log(LogStatus.PASS, "Test Case Passed "+result.getThrowable());
//		}
		report.endTest(logger);
		System.out.println("browser quit");
		driver.quit();
	}
	
	@AfterSuite
    public void afSuite(){
		
        report.flush();
        report.close();
    }
	

}
