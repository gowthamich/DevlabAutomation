package ObjectRep;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Attestation {
	WebDriver driver;
	
	@FindBy(xpath = "//input[@value='I Disagree']")
	WebElement Disagree;
	
	@FindBy(xpath = "//input[@value='I Agree']")
	WebElement Agree;		
	
	public Attestation(WebDriver driver){
		this.driver= driver;
		PageFactory.initElements(driver, this);		
	}
	
	public Boolean checkAttestationUrl(String attUrl) {
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		System.out.println(driver.getCurrentUrl());
		if(driver.getCurrentUrl().contains(attUrl+"Broker/Core/Attestation")) {
			System.out.println("Attestation url loaded");
			return true;		
		}else {
			System.out.println("Attestation url not loaded");
			return false;
		}
	}
	
	public Boolean agreeAttestation(String attUrl) {
		System.out.println("In Agree Attestation method");
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='I Agree']")));
		if(Agree.isDisplayed()) {
			Agree.click();
			System.out.println(" Agree Clicked");
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			System.out.println("URL after agree attestaion   "+driver.getCurrentUrl());
			if(driver.getCurrentUrl().contains(attUrl+"core/dash/home")) {
				System.out.println("Redirected to Home page");
				return true;				
			}else {
				System.out.println("Not Redirected to Home page");
				return false;
			}
		}else {
			System.out.println("Agree button not displayed");
			return false;
		}
	}
	
	public Boolean disAgreeAttestation(String attUrl) {
		System.out.println("In DisAgree Attestation method");
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='I Disagree']")));
		if(Disagree.isDisplayed()) {
			Disagree.click();
			System.out.println("Dis Agree clicked");
			driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
			System.out.println("After disagree  "+ driver.getCurrentUrl());
			if(driver.getCurrentUrl().contains(attUrl+"Broker/Public/LogOff")) {
				System.out.println("Logoff page loaded");
				return true;
			}else {
				System.out.println("Logoff page not loaded");
				return false;
			}						
		}
		else {
			System.out.println("Dis agree not available");
			return false;
		}
		
	}
	

}
