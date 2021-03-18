package ObjectRep;

import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

//import Base.ReadExcel;

public class Login {
	
	
	WebDriver driver;
	//ReadExcel readDataObj = new ReadExcel();
	
	@FindBy(id="BodyContent_MainContent_MainContentPlaceHolder_UserName")
	WebElement username;
	
	@FindBy(id="BodyContent_MainContent_MainContentPlaceHolder_Password")
	WebElement password;
	
	@FindBy(id="BodyContent_MainContent_MainContentPlaceHolder_LoginButton")
	WebElement signin;
	
	public Login(WebDriver driver){
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}
	public Boolean login(String username,String password,String url) throws IOException, InterruptedException{
		
		setUserName(username);
		setPassword(password);
		submit();
		Thread.sleep(3000);
		if(driver.getCurrentUrl().contains(url+"core/")){
			//logger.log(PASS, "Login done");
			System.out.println("Home page dipslayed after login");
			return true;
		}
		else
			return false;
	
	}
	public void setUrl(String url){
		driver.get(url);
	}
	public void setUserName(String uname){
		username.sendKeys(uname);
		
	}
	public void setPassword(String pwd){
		password.sendKeys(pwd);
	}
	
	public void submit(){
		signin.click();
	}
	
	

}

