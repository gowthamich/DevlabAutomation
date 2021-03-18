package TestScripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import ObjectRep.GamificationRep;
import ObjectRep.Login;

public class Gamification extends BaseTest {
	
	@Test
	public void disableGamificationConfig() throws IOException {
		String MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try{			
			//read data specific to TC like upload file path			
			logger = report.startTest(MethodName, "To Disable Gamefication Configuration");
			System.out.println("Test script"+MethodName+"-  Gamefication Configuration TC");	
				
			objLogin = new Login(driver);
			logger.log(LogStatus.PASS, "Username:  "+username);
			logger.log(LogStatus.PASS, "Password:  "+password);
			objLogin = new Login(driver);
			driver.get(appUrl);
			// ****************Login Tc ********************//			
			Boolean l = objLogin.login(username, password, appUrl);
			if(l){
				logger.log(LogStatus.PASS,  "Login Successfull");
			}				
			else{
				logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Test failed");
			}				
			ObjGamification = new GamificationRep(driver);
			Boolean lc = ObjGamification.disableGamification(appUrl);
			if(lc) {
				logger.log(LogStatus.PASS,  "Gamefication Configured disabled successfully ");				
			}
			else {				
				logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Gamefication Configuration disablingfailed");
			}
			
		}catch(Exception e){
			System.out.println(e);				
			logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Test failed");
			logger.log(LogStatus.FAIL, e);
		
			
		}
	}
	
	@Test
	public void enableGamificationConfig() throws IOException {
		String MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try{			
			//read data specific to TC like upload file path			
			logger = report.startTest(MethodName, "To Enable Gamefication Configuration");
			System.out.println("Test script"+MethodName+"-  Gamefication Configuration TC");	
				
			objLogin = new Login(driver);
			logger.log(LogStatus.PASS, "Username:  "+username);
			logger.log(LogStatus.PASS, "Password:  "+password);
			objLogin = new Login(driver);
			driver.get(appUrl);
			// ****************Login Tc ********************//			
			Boolean l = objLogin.login(username, password, appUrl);
			if(l){
				logger.log(LogStatus.PASS,  "Login Successfull");
			}				
			else{
				logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Test failed");
			}				
			ObjGamification = new GamificationRep(driver);
			Boolean lc = ObjGamification.enableGamification(appUrl);
			if(lc) {
				logger.log(LogStatus.PASS,  "Gamefication Configured enabled successfully ");				
			}
			else {				
				logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Gamefication Configuration failed");
			}
			
		}catch(Exception e){
			System.out.println(e);				
			logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Test failed");
			logger.log(LogStatus.FAIL, e);
		
			
		}
	}
	
	@Test
	public void levelConfiguration() throws IOException {
		String MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try{			
			//read data specific to TC like upload file path			
			logger = report.startTest(MethodName, "To LeaderBoard Configuration");
			System.out.println("Test script"+MethodName+"-  LeaderBoard Configuration TC");
			String LevelName = objDataTable.ReadExcelData("LeaderBoardName");	
			String LevelCriteria = objDataTable.ReadExcelData("LevelCriteria");		
			String LevelNotifMsg = objDataTable.ReadExcelData("LevelNotifMsg");	
			objLogin = new Login(driver);
			logger.log(LogStatus.PASS, "Username:  "+username);
			logger.log(LogStatus.PASS, "Password:  "+password);
			objLogin = new Login(driver);
			driver.get(appUrl);
			// ****************Login Tc ********************//			
			Boolean l = objLogin.login(username, password, appUrl);
			if(l){
				logger.log(LogStatus.PASS,  "Login Successfull");
			}				
			else{
				logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Test failed");
			}
			ObjGamification = new GamificationRep(driver);
			Boolean gp = ObjGamification.gamificationPage(appUrl);
			if(gp) {
				logger.log(LogStatus.PASS,  "Gamification Page displayed Successfull");				
			}
			else{
				logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Test failed");
			}	
			LevelName = LevelName+objCom.GetTimeStamp();
			logger.log(LogStatus.PASS,  "Level name to be entered is "+LevelName);	
			Boolean lc = ObjGamification.levelConfig(LevelName, LevelCriteria, LevelNotifMsg);
			if(lc) {
				logger.log(LogStatus.PASS,  "Level Configured successfully ");				
			}
			else {				
				logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Level Configuration failed");
			}
			
		}catch(Exception e){
			System.out.println(e);				
			logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Test failed");
			logger.log(LogStatus.FAIL, e);
		
			
		}
	}
	
	@Test
	public void leaderBoardConfiguration() throws IOException {
		String MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try{			
			//read data specific to TC like upload file path			
			logger = report.startTest(MethodName, "To LeaderBoard Configuration");
			System.out.println("Test script"+MethodName+"-  LeaderBoard Configuration TC");
			String LeaderBoardName = objDataTable.ReadExcelData("LeaderBoardName");	
			String Description = objDataTable.ReadExcelData("Description");			
			objLogin = new Login(driver);
			logger.log(LogStatus.PASS, "Username:  "+username);
			logger.log(LogStatus.PASS, "Password:  "+password);
			objLogin = new Login(driver);
			driver.get(appUrl);
			// ****************Login Tc ********************//			
			Boolean l = objLogin.login(username, password, appUrl);
			if(l){
				logger.log(LogStatus.PASS,  "Login Successfull");
			}				
			else{
				logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Test failed");
			}
			ObjGamification = new GamificationRep(driver);
			Boolean gp = ObjGamification.gamificationPage(appUrl);
			if(gp) {
				logger.log(LogStatus.PASS,  "Gamification Page displayed Successfull");				
			}
			else{
				logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Test failed");
			}	
			LeaderBoardName = LeaderBoardName+objCom.GetTimeStamp();
			logger.log(LogStatus.PASS,  "LeaderBoard name to be entered is "+LeaderBoardName);	
			Boolean lc = ObjGamification.leaderBoardConfig(LeaderBoardName,Description);
			if(lc) {
				logger.log(LogStatus.PASS,  "LeaderBoard Configured successfully ");				
			}
			else {				
				logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "LeaderBoard Configured failed");
			}
			
		}catch(Exception e){
			System.out.println(e);				
			logger.log(LogStatus.FAIL, logger.addScreenCapture(objCommonMethods.capture(driver, MethodName))+ "Test failed");
			logger.log(LogStatus.FAIL, e);
		
			
		}
		
		
	}
	
	

}
