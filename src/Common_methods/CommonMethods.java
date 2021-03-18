package Common_methods;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;

public class CommonMethods {
	
	 ExtentReports report;
	 WebDriver driver;
	 ReadExcel objDriverSheet;
	 ReadExcel objDataTable;
	 String PageLoadingTimeInSeconds;
	 
	 public WebDriver Initiate()throws IOException{
		 //String appUrl = objDataTable.ReadExcelData("App URL");
		 String chromeWebDriver = objDataTable.ReadExcelData("ChromeWebDriver");
		 String chromeWebDriverPath = objDataTable.ReadExcelData("ChromeWebDriverPath");
		 String executionBrowser = objDataTable.ReadExcelData("ExecutionBrowser");		 
		 if(executionBrowser.contentEquals("Chrome")){
			 System.setProperty(chromeWebDriver, chromeWebDriverPath);
			 driver = new ChromeDriver();
		 }
		 //driver.manage().deleteAllCookies();
		 //driver.get(appUrl);
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		 return driver;
		 
	 }
	 
	 public CommonMethods(WebDriver driver)throws IOException{
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
		 objDataTable = new ReadExcel("Common");
		 objDriverSheet = new ReadExcel("Driver");
		 PageLoadingTimeInSeconds =  objDataTable.ReadExcelData("PageLoadingTimeInSeconds");	 
		 
	 }
	 public CommonMethods(){
		 
	 }
	 public String GetTimeStamp(){
			Date date = new Date();
			long time = date.getTime();
			Timestamp ts =  new Timestamp(time);
			String Time_Stamp = ts.toString();
			return (((Time_Stamp.replace(".", "")).replace(":", "")).replace("-","")).replace(" ", "");
	 }	
//	 public ExtentReports SetReport(String MethodName )throws IOException{
//			String AutomationPath = objDataTable.ReadExcelData("AutomationPath");
//			String TestResultPath = AutomationPath +"Results/";
//			String Time_Stamp = GetTimeStamp();
//			report = new ExtentReports(TestResultPath +MethodName+"_"+Time_Stamp+".html", true);		
//			return report;
//			
//	}
	 
	 public void fileUpload (String path) throws AWTException {
		 
		 StringSelection stringSelection = new StringSelection(path);
		   Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
//	        StringSelection strSelection = new StringSelection(path);
//	        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
//	        clipboard.setContents(strSelection, null);
		   //setClipboardData(path);
	        Robot robot = new Robot();
	  
	        //robot.delay(300);
	        robot.keyPress(KeyEvent.VK_ENTER);
	        robot.keyRelease(KeyEvent.VK_ENTER);
	        robot.keyPress(KeyEvent.VK_CONTROL);
	        robot.keyPress(KeyEvent.VK_V);
	        robot.keyRelease(KeyEvent.VK_V);
	        robot.keyRelease(KeyEvent.VK_CONTROL);
	        robot.keyPress(KeyEvent.VK_ENTER);
	        robot.delay(200);
	        robot.keyRelease(KeyEvent.VK_ENTER);
	    }
	 
	 public String capture(WebDriver driver, String MethodName) throws IOException {
		 File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		 File Dest = new File("src/../BStackImages/" + MethodName+ System.currentTimeMillis()+ ".png");
		 String errflpath = Dest.getAbsolutePath();
		 FileUtils.copyFile(scrFile, Dest);
		 return errflpath;
	}
	 public String Takescreenprint(String MethodName) throws Exception{
			String TestResultPath = objDataTable.ReadExcelData("AutomatioPath");			
			String TimeStamp = GetTimeStamp();
			String screenshot_path  = TestResultPath+"Results/"+MethodName+TimeStamp+".png";
			TakesScreenshot scrShot = ((TakesScreenshot)driver);
			File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
			File DestFile = new File(screenshot_path);
			
			FileUtils.copyFile(SrcFile,DestFile);
			return screenshot_path;
			
		}
	 
	 
	 
}

