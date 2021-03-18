package ObjectRep;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Common_methods.CommonMethods;

public class GamificationRep {
	
	WebDriver driver;
	CommonMethods objCom =  new CommonMethods();
	
	@FindBy(id = "admin_header")
	WebElement adminHeader;
	
	@FindBy(xpath="//*[@id='social_gamification']/span")
	WebElement SocialGame;
	
	@FindBy(xpath="//*[@id='gamification_configuration']/span")
	WebElement gamConfig;	
	
	@FindBy(xpath="//*[text() = 'General']")
	WebElement General;
	
	@FindBy(xpath="//*[text() = 'Learn Points']")
	WebElement LearnPoints;
	
	@FindBy(xpath="//*[text() = 'Badges']")
	WebElement Badges;
	
	@FindBy(xpath="//*[text() = 'Levels']")
	WebElement Levels;
	
	@FindBy(xpath="//*[text() = 'Leaderboards']")
	WebElement Leaderboards;
	
	@FindBy(xpath="//*[@id='addLeaderBoard']")
	WebElement AddLeaderBoard;
	
	@FindBy(xpath="//*[@id='levelName']")
	WebElement LeaderBoardName;
	
	@FindBy(xpath="//*[@id='leaderBoardDescription']")
	WebElement LeaderBoardDescription;
	
	@FindBy(xpath="//*[@id='addAudienceBtn']")
	WebElement AddAudience;
	
//	@FindBy(xpath="//*[@id='addaudience--0']")
//	WebElement Audience;
	
	@FindBy(xpath="//*[@targetid='addAudienceBtn']/div/table/tbody/tr[1]/td[1]")
	WebElement Audience;
	
	@FindBy(xpath="//*[text()='ADD']")
	WebElement AddAudience2;
	
	@FindBy(xpath="//*[@name = 'leaderBoardEditForm']/div[4]/table/tbody/tr[1]/td[1]")
	WebElement selectAudience;
	
	@FindBy(xpath="//*[text()='Save']")
	WebElement Save;
	
	@FindBy(xpath="//*[@id='gamificationAdminAlert']/div/div/span")
	WebElement GamificationAlert;	
	
	@FindBy(xpath="//*[text() = 'Levels']")
	WebElement levelButn;
	
	@FindBy(xpath="//*[@id='addLevel']")
	WebElement addLevel;
	
	@FindBy(xpath="//*[@id='levelName']")
	WebElement levelNameT;
	
	@FindBy(xpath="//*[@id='levelCriteria']")
	WebElement levelCri;
	
	@FindBy(xpath="//*[@id='levelNotificationMsg']")
	WebElement notifLevel;
	
	@FindBy(xpath="//*[@id='idLevelStatus']")
	WebElement levelStatus;
	
	@FindBy(xpath="//*[text() = 'Save']")
	WebElement saveLevel;;
	
	@FindBy(xpath="//*[@id='gamificationAdminAlert']/div/div/span")
	WebElement alertLevelMsg;
	
	@FindBy(xpath="//*[@class='checkbox']//preceding-sibling::input[1]")
	WebElement gamCheckbox;
	
	@FindBy(xpath="//*[@id='rootViewContainer']/div[2]/div/div[3]/div[4]/div/button")
	WebElement saveGamification;
	
	@FindBy(xpath="//*[@id='rootViewContainer']/div[2]/div/div[3]/div[4]/div/button")
	WebElement saveDisableGame;
	
	@FindBy(xpath="//*[@id='self_header']")
	WebElement self;
	
	@FindBy(xpath="/html/body/div[3]/div/div/div/div[1]/div/div/div[3]")
	WebElement badges;
	
	
	
	public GamificationRep(WebDriver driver){
		this.driver= driver;
		PageFactory.initElements(driver, this);		
	}
	
	public boolean badgesLevels() {
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("self_header")));
		self.click();
		System.out.println("Self clicked");		
		if(badges.isDisplayed()) {
			System.out.println("Badges and Levels link displayed");
			badges.click();
			System.out.println("Badges and Levels link clicked");
			
			return true;
		}else {
			return false;
		}
		
	}
	
	public boolean disableGamification(String appUrl) throws InterruptedException {		
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("admin_header")));
		adminHeader.click();
		System.out.println("Admin clicked");
		SocialGame.click();
		System.out.println("Social and Gamification clicked");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='gamification_configuration']/span")));
		gamConfig.click();
		System.out.println("Gamification configuration clicked");
		System.out.println(driver.getCurrentUrl());
		Thread.sleep(3000);
		if(driver.getCurrentUrl().equals(appUrl+"core/administration/applications/gamification/gamificationAdministration")) {
			System.out.println("Gamification page displayed");
			if(gamCheckbox.isSelected()) {
				System.out.println("Gamification is in enabled state");
				gamCheckbox.click();
				System.out.println("Gamefication checkbox clicked to disable");	
				saveDisableGame.click();
				System.out.println("Save clicked for disabling Gamefication");
				if(gamCheckbox.isSelected()) {
					System.out.println("Gamefication is not disabled");
					return true;
				}else {
					System.out.println("Gamefication is disabled");
					return false;
				}			
				
			}else{
				System.out.println("Gamification configuration is already in disable state");
				return true;
			}
			
		}else {
			System.out.println("Gamification page not displayed");
			return false;			
		}
		
	}
	
	public boolean enableGamification(String appUrl) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("admin_header")));
		adminHeader.click();
		System.out.println("Admin clicked");
		SocialGame.click();
		System.out.println("Social and Gamification clicked");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='gamification_configuration']/span")));
		gamConfig.click();
		System.out.println("Gamification configuration clicked");
		System.out.println(driver.getCurrentUrl());
		Thread.sleep(3000);
		if(driver.getCurrentUrl().equals(appUrl+"core/administration/applications/gamification/gamificationAdministration")) {
			System.out.println("Gamification page displayed");
			if(gamCheckbox.isSelected()) {
				System.out.println("Gamification is already enabled");
				return true;
			}else {
				System.out.println("Gamefication is not enabled");
				gamCheckbox.click();
				System.out.println("Gamefication is clicked now");
				saveGamification.click();
				System.out.println("Gamefication Save Button clicked");
				if(gamCheckbox.isSelected()) {
					System.out.println("Gamefication is enabled now");
					return true;
				}else {
					System.out.println("Gamefication is not enabled");
					return false;
				}
			}			
		}
		else{
			System.out.println("Gamification page not displayed");
			return false;
		}		
	}
	
	public boolean levelConfig(String levelName, String levelCriteria, String levelNitofMsg) {
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text() = 'Levels']")));
		levelButn.click();
		System.out.println("Level clicked");
		addLevel.click();
		System.out.println("Add Level clicked");
		levelNameT.sendKeys(levelName);
		System.out.println("Level Name entered");
		levelCri.sendKeys(levelCriteria);
		System.out.println("Level Criteria entered");
		notifLevel.sendKeys(levelNitofMsg);
		System.out.println("Level Notification Message entered");
		if(levelStatus.isSelected()) {
			System.out.println("Status is active");
		}
		else{
			System.out.println("Status is in-active");
			levelStatus.click();
			System.out.println("Status is set to active");
		}
		saveLevel.click();
		System.out.println("Save Level clicked");
		if(alertLevelMsg.getText().equals("Successfully saved level details")) {
			System.out.println("Alert message displayed as "+alertLevelMsg.getText());
			return true;
		}
		else {
			System.out.println("Alert message not displayed");
			return false;
		}
	}
	
	public Boolean gamificationPage(String appUrl) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("admin_header")));
		adminHeader.click();
		System.out.println("Admin clicked");
		SocialGame.click();
		System.out.println("Social and Gamification clicked");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='gamification_configuration']/span")));
		gamConfig.click();
		System.out.println("Gamification configuration clicked");
		System.out.println(driver.getCurrentUrl());
		Thread.sleep(3000);
		if(driver.getCurrentUrl().equals(appUrl+"core/administration/applications/gamification/gamificationAdministration")) {
			System.out.println("Gamification page displayed");
			return true;
		}
		else{
			System.out.println("Gamification page not displayed");
			return false;
		}
	}
	
	public Boolean leaderBoardConfig(String leaderBoardName, String description) {
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text() = 'Leaderboards']")));
		Leaderboards.click();
		System.out.println("Leaderboard configuration clicked");
		AddLeaderBoard.click();
		System.out.println("Add clicked");
		LeaderBoardName.sendKeys(leaderBoardName);		
		System.out.println("LeaderBoard name entered as  "+leaderBoardName);
		LeaderBoardDescription.sendKeys(description);
		System.out.println("Description Entered");
		AddAudience.click();
		System.out.println("Add audience button clicked");
		String audienceName = driver.findElement(By.xpath("//*[@targetid='addAudienceBtn']/div/table/tbody/tr[1]/td[2]")).getText();
		String primaryAudience = driver.findElement(By.xpath("//*[@targetid='addAudienceBtn']/div/table/tbody/tr[1]/td[3]")).getText();
		System.out.println("Audience Name == "+audienceName);
		System.out.println("Primary Audience == "+primaryAudience);		
		Audience.click();
		System.out.println("Audience selected from the list");
		AddAudience2.click();		
		System.out.println("Add clicked after audience selected");
		String audienceNameSel = driver.findElement(By.xpath("//*[@name = 'leaderBoardEditForm']/div[4]/table/tbody/tr[1]/td[2]")).getText();
		String primaryAudienceSel = driver.findElement(By.xpath("//*[@name = 'leaderBoardEditForm']/div[4]/table/tbody/tr[1]/td[3]")).getText();
		if(audienceName.equals(audienceNameSel) && primaryAudience.equals(primaryAudienceSel)) {
			System.out.println("Selected audience exists in config list");
			selectAudience.click();
			System.out.println("Selected audience appears and clicked");
			Save.click();
			System.out.println("Save Button clciked");
			if(GamificationAlert.getText().equals("Successfully saved leaderboard details")) {
				System.out.println("Leader board configuration successfull");
				return true;
			}
			else {
				System.out.println("Alert is  "+GamificationAlert.getText());
				System.out.println("Failed Leader board configuration");
				return false;
			}
		}
		else {
			System.out.println("Selected audience didnt add to config list");
			return false;
		}
		
	}
}
