package ObjectRep;

import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Talent {
	WebDriver driver;
	
	@FindBy(id="admin_header")
	WebElement adminHeader;
	
	@FindBy(xpath="//*[@id='talent_management']/span")
	WebElement talentManagement;
	
	@FindBy(xpath="//*[@id='admin.modules_360feedback']/span")
	WebElement assesment360;
	
	@FindBy(xpath="//*[@id='ext-gen27']/div/li[4]/div/a[2]/span")
	WebElement batchJobs;
	
	@FindBy(xpath="//*[@id='ext-gen29']/li[1]/div/a[2]/span")
	WebElement batchProcess;
	
	@FindBy(xpath="//*[@id='tabFilter1']/a")
	WebElement systemJobs;
	
	@FindBy(xpath="//*[@id='suidlgpagedlist_filterbar_S']")
	WebElement alphaS;
	
	@FindBy(xpath="//*[@id='lyui_18']/div/button[2]/span")
	WebElement SystemUpgradeJobDrop;
	
	@FindBy(xpath="//*[@id='lyui_18']/div/ul/li[2]/a/span")
	WebElement Run;
	
	
	
	public Talent(WebDriver driver){
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public Boolean talentBatch() {
		System.out.println("In TalentBatch method");
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("admin_header")));
		adminHeader.click();
		System.out.println("Admin clicked");
		talentManagement.click();
		System.out.println("Talent management Clicked");
		assesment360.click();
		System.out.println("360 Assesment clicked");
		driver.switchTo().frame("PillarIFrame_TM");
		System.out.println("Switched to iframe PillarIFrame_TM");		
		driver.switchTo().frame("content");
		System.out.println("Switched to iframe content");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ext-gen27']/div/li[4]/div/a[2]/span")));
		
		batchJobs.click();
		System.out.println("Batch Jobs clicked");	
		batchProcess.click();		
		System.out.println("Batch process clicked");		
		driver.switchTo().frame("profilecontent");
		System.out.println("Sitched to profilecontenet");
		
//		systemJobs.click();		
//		System.out.println("System Jobs clicked");
		
		alphaS.click();
		System.out.println("Alpha S clicked");
		SystemUpgradeJobDrop.click();
		System.out.println("System Upgrade Job dropdown clicked");
		Run.click();
		System.out.println("Run clicked");
		Alert alert = driver.switchTo().alert();
		String alertMessage= driver.switchTo().alert().getText();	
		System.out.println("Alert message displayed as"+ alertMessage);
		alert.accept();	
		System.out.println("Accept to Run");
		
		
		return true;
		
		
	}

}
