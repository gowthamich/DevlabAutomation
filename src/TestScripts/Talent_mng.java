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

public class Talent_mng extends BaseTest{
	
	@Test
	public void talentBatchProcess() throws IOException {
		System.out.println("In talent test");
		String MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			//read data specific to TC like upload file path
			String talentUrl = objDataTable.ReadExcelData("Talent URL");
			String talentusername = objDataTable.ReadExcelData("Talent Username");
			String talentpassword = objDataTable.ReadExcelData("Talent Password");
			logger = report.startTest(MethodName, "Talent Management batch process ");
			System.out.println("Test script"+MethodName+"- Talent Management batch process");
			driver.get(talentUrl);
			objLogin = new Login(driver);
			logger.log(LogStatus.PASS, "Customer Site:   "+talentUrl);
			logger.log(LogStatus.PASS, "Username:  "+talentusername);
			//logger.log(LogStatus.PASS, "Password:  "+wfmpassword);
			// ****************Login Tc ********************//
			System.out.println("TC1");
			Boolean l = objLogin.login(talentusername, talentpassword, talentUrl);
			if(l){
				logger.log(LogStatus.PASS,  "Login Successfull");
			}				
			else{
				logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Test failed");
			}
			objTalent = new Talent(driver);
			Boolean b = objTalent.talentBatch();
			
			
			
		}catch(Exception e) {
			System.out.println(e);			
			logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Test failed");
			logger.log(LogStatus.FAIL, e);
		}
	}

}
