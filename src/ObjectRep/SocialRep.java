package ObjectRep;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.TimeUnit;

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

import Common_methods.CommonMethods;

public class SocialRep {
	
	WebDriver driver;
	CommonMethods cmObj = new CommonMethods();
	
//	@FindBy(id = "admin_header")
//	WebElement adminHeader;
	
	@FindBy(xpath="//*[@id='self_header']")
	WebElement self;
	
	@FindBy(xpath="//*[@id='self_collaboration']")
	WebElement collabration;
	
	@FindBy(xpath="//*[@id='SOCIAL_COMMUNITIES']")
	WebElement socialcommunities;
	
	@FindBy(xpath="//*[@id='addCommunity_memberCommunities']/span")
	WebElement newButton;
	
	@FindBy(xpath="//*[@id='communityName']")
	WebElement communityName;
	
	@FindBy(xpath="//table[@ng-table='viewModel.selectedUsertableParams']/tbody/tr[1]//input[@type='checkbox']")
	WebElement userCheckbox;
	
	@FindBy(xpath="//*[text()='Save']")
	WebElement Save;
	
	@FindBy(xpath="//*[text()='Test_CreateCommunity community created successfully.']")
	WebElement successmsg;
	
	@FindBy(xpath="//*[@id='memberCommunities']/div/community-cards-directive/div/ul/li")
	WebElement communityDiv;
	
	@FindBy(xpath="//*[@id='memberCommunities']/div/community-cards-directive/div/ul/li/div/div[2]/a")
	WebElement commuNameDiv;
	
	@FindBy(xpath="//*[@id='rootViewContainer']/div[2]/div/div[2]/div[4]/div/ul/li[1]/a")
	WebElement communityPage;
	
	@FindBy(xpath="//*[@id='editCommunityDrpdwn']")
	WebElement editCommDrop;
	
	@FindBy(xpath="//*[text()='Delete']")
	WebElement deleteComm;
	
	@FindBy(xpath="//*[@id='community-remove-modal']/div/div")
	WebElement popup;
	
	@FindBy(xpath="//*[@id='removeSocialObjectModalId']/div/div/div[2]/p")
	WebElement popupDiscussion;
	
	@FindBy(xpath="//*[@id='community-remove-modal']/div/div/div[2]/div/p")
	WebElement popupMsg;
	
	@FindBy(xpath="//*[@class='btn-container']/button[2]")
	WebElement deletePopup;
	
	
	@FindBy(xpath="//*[@id='socialCommunitiesAlertContainer']/div/div/span")
	WebElement alertConf;
	
	@FindBy(xpath="//*[@id='addDiscussionAll']")
	WebElement addDiscussion;
	
	@FindBy(xpath="//*[@id='discussionName']")
	WebElement discussionName;
	
	@FindBy(xpath="/html/body/p")
	WebElement discussionText;
	
	
	@FindBy(xpath="//*[@id='discussion_slideout_bottom']/div/button[2]")
	WebElement saveDiscussion;
	
	@FindBy(xpath="//*[text()='Discussion created successfully']")
	WebElement discussionMsg;
	
	@FindBy(xpath="//*[text()='Discussion deleted successfully']")
	WebElement deleteDiscussionMsg;
	
	@FindBy(xpath="//iframe[@class ='cke_wysiwyg_frame cke_reset']")
	WebElement iframe;
	
	@FindBy(xpath="//table[@class='table ng-table']/tbody/tr[1]/td[2]/div/a")
	WebElement discussionNameDiv;
	
	@FindBy(xpath="//*[@role='menuitem']")
	WebElement deletediscusiion;
	
	@FindBy(xpath="//*[@id='removeSocialObjectModalId']/div/div/div[3]/button[2]")
	WebElement deletepopdiscussion;
	
	@FindBy(xpath="//*[@id='addBlogsAll']")
	WebElement addBlog;
	
	@FindBy(xpath="//*[@id='blogTitle']")
	WebElement blogTitle;
	
	@FindBy(xpath="//*[@id='blogDesc']")
	WebElement blogDesc;
	
	@FindBy(xpath="//*[@id='blog_slideout_bottom']/div/button[2]")
	WebElement blogSave;
	
	@FindBy(xpath="//*[@id='socialCommunitiesAlertContainer']")
	WebElement newBlogMsgDiv;
	
	@FindBy(xpath="//*[@id=\'socialCommunitiesAlertContainer\']/div/div/span")
	WebElement BlogMsg;
	
	@FindBy(xpath="//*[@id='removeSocialObjectModalId']/div/div")
	WebElement deleteBlogpopDiv;
	
	@FindBy(xpath="//*[@id='removeSocialObjectModalId']/div/div/div[2]/p")
	WebElement BlogDeletePopMsg;
	
	@FindBy(xpath="//*[@id='removeSocialObjectModalId']/div/div/div[3]/button[2]")
	WebElement blogdeletebuttonpopup;
	
	@FindBy(xpath="//*[@id='socialCommunitiesAlertContainer']/div/div/span")
	WebElement blogdeleteMsg;
	
	@FindBy(xpath="//*[@id='addFileAll']")
	WebElement addFileButton;
	
	@FindBy(xpath="//*[@id='uploadFileModalId']/div/div")
	WebElement uploadFileDiv;
	
	@FindBy(xpath="//*[@id='fieldDataDisplayName']")
	WebElement fileName;
	
	@FindBy(xpath="//*[@id='fieldDataDescription']")
	WebElement fileDesc;
	
	@FindBy(xpath="//*[@id='fileDropOrUpload']/div/span")
	WebElement fileuploadLink;
	
	@FindBy(xpath="//*[@id='uploadFileModalId']/div/div/div[3]/button[4]")
	WebElement uploadBut;
	
	@FindBy(xpath="//*[@id='finishUploadButton']")
	WebElement doneButn;
	
	@FindBy(xpath="//*[@id='socialCommunitiesAlertContainer']/div/div/span")
	WebElement fileaddedMsg;
	
	@FindBy(xpath="//*[@id='all']/div/div[2]/table/tbody/tr/td[3]/div/ul")
	WebElement deletedpfile;
	
	@FindBy(xpath="//*[@id='removeSocialFileModalId']/div/div")
	WebElement filealertDiv;
	
	@FindBy(xpath="//*[@id='removeSocialFileModalId']/div/div/div[3]/button[2]")
	WebElement delBtnAlert;
	
	@FindBy(xpath="//*[@id='removeSocialFileModalId']/div/div/div[2]/p")
	WebElement filealerMsg;
	
	@FindBy(xpath="//*[@id='socialCommunitiesAlertContainer']/div/div/span")
	WebElement fileDelMsg;
	
	public SocialRep(WebDriver driver){
		this.driver= driver;
		PageFactory.initElements(driver, this);		
	}
	public boolean newFileSocial(String appurl, String socialcommunityName, String socialFileName, String  socialFileDesc, String UploadFilePath) throws AWTException, InterruptedException {		
		System.out.println("In create discussion method");
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("self_header")));
		self.click();
		System.out.println("Self clicked");
		collabration.click();
		System.out.println("Collabration link clicked");
		socialcommunities.click();
		System.out.println("Social Communities link clicked");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='addCommunity_memberCommunities']/span")));
		System.out.println("Page loaded successfull");
		if(driver.getCurrentUrl().equals(appurl+"core/socialCommunities")) {
			System.out.println("Social Communities page loaded successfully");
			if(communityDiv.isDisplayed()) {
				System.out.println("Created community division is displayed");
				if(commuNameDiv.getText().equals(socialcommunityName)) {
					System.out.println("Social community name displayed as "+socialcommunityName);
					commuNameDiv.click();
					System.out.println("Community name div clicked");
					if(addFileButton.isDisplayed()) {
						addFileButton.click();
						System.out.println("Add File Button clicked");
						if(uploadFileDiv.isDisplayed()) {
							System.out.println("Upload File Div displayed");
							fileName.sendKeys(socialFileName);
							System.out.println("Social file name entered");
							fileDesc.sendKeys(socialFileDesc);
							System.out.println("Social file description entered");
							fileuploadLink.click();
							System.out.println("File Upload Link clicked");
							System.out.println("upload file path is "+UploadFilePath);
							//String fileAbsolutePath = "C:\\SeleniumArtifacts\\TestCaseData.xlsx";
							StringSelection clipBoardPath = new StringSelection(UploadFilePath);
							Toolkit.getDefaultToolkit().getSystemClipboard().setContents(clipBoardPath, null);							
							Thread.sleep(5000);
							
							//Robot Class
							Robot robot = new Robot();
							
							//Keyboard Action : CTRL+V
							robot.keyPress(KeyEvent.VK_CONTROL);
							robot.keyPress(KeyEvent.VK_V);
							
							robot.keyRelease(KeyEvent.VK_CONTROL);
							robot.keyRelease(KeyEvent.VK_V);
							
							//Keyboard Action : Enter
							robot.keyPress(KeyEvent.VK_ENTER);
							robot.keyPress(KeyEvent.VK_ENTER);							
							
							System.out.println("File path entered");	
							uploadBut.click();
							System.out.println("Upload Button clicked");
							wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='finishUploadButton']")));
							doneButn.click();
							System.out.println("Done Button clciked");
							if(fileaddedMsg.getText().equals("File added successfully.")) {
								System.out.println("File added alert message displayed");
								return true;
																
							}
							else{
								System.out.println("File added alert message not displayed");
								return false;		
							}
							
						}
						else {
							System.out.println("Upload File Div not displayed");
							return false;
						}
											
					}
					else {
						System.out.println("Add File Button not displayed");
						return false;
					}
				}
				else {
					System.out.println("Social community name not displayed as "+socialcommunityName);
					return false;
				}
			}
			else {
				System.out.println("Created community division is not displayed");
				return false;
			}
		}
		else {
			System.out.println("Social page not loaded");
			return false;
		}	
		
	}
	
	public boolean deleteFileSocial(String appurl, String socialcommunityName, String socialFileName) {
		System.out.println("In create discussion method");
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("self_header")));
		self.click();
		System.out.println("Self clicked");
		collabration.click();
		System.out.println("Collabration link clicked");
		socialcommunities.click();
		System.out.println("Social Communities link clicked");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='addCommunity_memberCommunities']/span")));
		System.out.println("Page loaded successfull");
		if(communityDiv.isDisplayed()) {
			System.out.println("Created community division is displayed");
			if(commuNameDiv.getText().equals(socialcommunityName)) {
				System.out.println("Social community name displayed as "+socialcommunityName);
				commuNameDiv.click();
				System.out.println("Community name div clicked");
				List<WebElement> trsize = driver.findElements(By.xpath("//table[@class='table ng-table']/tbody/tr")); 
				System.out.println("Tr size "+trsize.size());
				if(trsize.size()==0) {
					System.out.println("No records found");
					return false;
				}
				else{
					for(int i=1;i<=trsize.size()+1;i++) {
						WebElement wd = driver.findElement(By.xpath("//table[@class='table ng-table']/tbody/tr["+i+"]/td[2]/div/a"));
						if(wd.getText().equals(socialFileName)) {
							System.out.println("File name identified");
							WebElement we = driver.findElement(By.xpath("//table[@class='table ng-table']/tbody/tr["+i+"]/td[3]/div/button[2]"));
							we.click();
							System.out.println("Dropdown clicked");
							deletedpfile.click();
							System.out.println("Delete from drop down clicked");
							if(filealertDiv.isDisplayed()) {
								System.out.println("Alert message for delete file Div is displayed");
								if(filealerMsg.getText().equals("Are you sure you want to delete the selected file? This action cannot be undone.")) {
									System.out.println("Alert message displayed");
									delBtnAlert.click();
									System.out.println("Delete button clicked");
									if(fileDelMsg.getText().equals("Successfully deleted the file.")) {
										System.out.println("confirm alert  message displayed ");
										return true;
									}
									else {
										System.out.println("confirm alert message not displayed ");
										return false;
									}
									
								}
								else {
									System.out.println("Alert message not displayed");
									return false;
								}							
								
							}
							else {
								System.out.println("Alert message for delete file Div is not displayed");
								return false;
							}						
							
						}
						else {
							System.out.println("File name not displayed");
							return false;
						}
						
					}
					return false;
				}
			}
			else {
				System.out.println("Social community name not displayed as "+socialcommunityName);
				return false;
			}
		}
		else {
			System.out.println("Social community Div not displayed");
			return false;			
		}		
		
	}
	public boolean newBlog(String appurl, String socialcommunityName, String socialblogname , String socialblogdesc ) {
		System.out.println("In create discussion method");
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("self_header")));
		self.click();
		System.out.println("Self clicked");
		collabration.click();
		System.out.println("Collabration link clicked");
		socialcommunities.click();
		System.out.println("Social Communities link clicked");
		//WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='addCommunity_memberCommunities']/span")));
		System.out.println("Page loaded successfull");
		if(driver.getCurrentUrl().equals(appurl+"core/socialCommunities")) {
			System.out.println("Social Communities page loaded successfully");
			if(communityDiv.isDisplayed()) {
				System.out.println("Created community division is displayed");
				if(commuNameDiv.getText().equals(socialcommunityName)) {
					System.out.println("Social community name displayed as "+socialcommunityName);
					commuNameDiv.click();
					System.out.println("Community name div clicked");
					if(addBlog.isDisplayed()) {
						System.out.println("Add Blog Button is enabled");
						addBlog.click();
						System.out.println("Add Blog button clicked");
						blogTitle.sendKeys(socialblogname);
						System.out.println("Blog name entered");
						blogDesc.sendKeys(socialblogdesc);
						System.out.println("Blog description entered");
						blogSave.click();
						System.out.println("Blog save Button clicked");							
						System.out.println("Blog creation Message Div displayed");
						System.out.println(BlogMsg.getText());
						if(BlogMsg.getText().equals(socialblogname+" blog created successfully.")) {
							System.out.println("Blog success message  displayed");
							return true;								
						}
						else{
							System.out.println("Blog success message not displayed");
							return false;
						}
					}
					else {
						System.out.println("Add Blog Button is not enabled");
						return false;
					}
				}
				else {
					System.out.println("Social community name is not displayed as "+socialcommunityName);
					return false;
				}
			}
			else {
				System.out.println("Social community Div is not displayed");
				return false;				
			}
		}
		else{
			System.out.println("Social communities page not loaded");
			return false;
		}	
		
	}
	
	public boolean deleteblog(String appurl, String socialcommunityName, String socialblogname) {
		System.out.println("In create discussion method");
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("self_header")));
		self.click();
		System.out.println("Self clicked");
		collabration.click();
		System.out.println("Collabration link clicked");
		socialcommunities.click();
		System.out.println("Social Communities link clicked");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='addCommunity_memberCommunities']/span")));
		System.out.println("Page loaded successfull");
		if(driver.getCurrentUrl().equals(appurl+"core/socialCommunities")) {
			System.out.println("Social Communities page loaded successfully");
			if(communityDiv.isDisplayed()) {
				System.out.println("Created community division is displayed");
				if(commuNameDiv.getText().equals(socialcommunityName)) {
					System.out.println("Social community name displayed as "+socialcommunityName);
					commuNameDiv.click();
					System.out.println("Community name div clicked");
					List<WebElement> trsize = driver.findElements(By.xpath("//table[@class='table ng-table']/tbody/tr")); 
					System.out.println("Tr size "+trsize.size());
					if(trsize.size()==0) {
						System.out.println("No records found");
						return false;
					}
					else{
						for(int i=1;i<=trsize.size()+1;i++) {
							WebElement wd = driver.findElement(By.xpath("//table[@class='table ng-table']/tbody/tr["+i+"]/td[2]/div/a"));
							if(wd.getText().equals(socialblogname)) {
								System.out.println("Blog name identified");
								WebElement we = driver.findElement(By.xpath("//table[@class='table ng-table']/tbody/tr["+i+"]/td[3]/div/button[2]"));
								we.click();
								System.out.println("Dropdown clicked");
								deletediscusiion.click();
								System.out.println("Delete from dropdown clicked");
								if(deleteBlogpopDiv.isDisplayed()) {
									System.out.println("Delete Blog Pop up Div Displayed");
									if(BlogDeletePopMsg.getText().equals("Are you sure you want to delete this blog? This action cannot be undone.")) {
										System.out.println("Delete Alert message displayed");
										blogdeletebuttonpopup.click();
										System.out.println("Delete from Alert for Blog deletion clicked");
										if(blogdeleteMsg.getText().equals(socialblogname+" blog deleted successfully.")) {
											System.out.println("Blog Deleted message displayed");
											return true;
										}
										else{
											System.out.println("Blog Deleted message not displayed");
											return false;
										}
									}
									else {
										System.out.println("Delete Blog Pop up Message is not displayed");
										return false;
									}
								}
								else{
									System.out.println("Delete Blog Pop up Div is not displayed");
									return false;
								}
								//return true;
							}
							else {
								System.out.println("Blog name not identified");
								return false;
							}
						}
						
					}
					return false;			
					
				}
				else {
					System.out.println("Social community name is not displayed");
					return false;
				}				
			}
			else {
				System.out.println("Community division not displayed");
				return false;
				}
			}
		else {
			System.out.println("Social Communities page not loaded");
			return false;
		
		}			
		
	}
	
	public boolean newDiscussion(String appurl, String socialcommunityName, String discussionname, String discussiontext) {
		System.out.println("In create discussion method");
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("self_header")));
		self.click();
		System.out.println("Self clicked");
		collabration.click();
		System.out.println("Collabration link clicked");
		socialcommunities.click();
		System.out.println("Social Communities link clicked");
		//WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='addCommunity_memberCommunities']/span")));
		System.out.println("Page loaded successfull");
		if(driver.getCurrentUrl().equals(appurl+"core/socialCommunities")) {
			System.out.println("Social Communities page loaded successfully");
			if(communityDiv.isDisplayed()) {
				System.out.println("Created community division is displayed");
				if(commuNameDiv.getText().equals(socialcommunityName)) {
					System.out.println("Social community name displayed as "+socialcommunityName);
					commuNameDiv.click();
					System.out.println("Community name div clicked");
					if(addDiscussion.isDisplayed()) {
						System.out.println("Add Discussion button enabled");
						addDiscussion.click();
						System.out.println("Add Discussion button clicked");
						discussionName.sendKeys(discussionname);
						System.out.println("Discussion name entered");
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@class ='cke_wysiwyg_frame cke_reset']")));
						driver.switchTo().frame(iframe);
						System.out.println("Switched to iframe");
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/p")));
						discussionText.sendKeys(discussiontext);					
						System.out.println("Discussion Text entered");
						driver.switchTo().defaultContent();
						driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
						saveDiscussion.click();
						System.out.println("Discussion Save button clicked");
						if(discussionMsg.isDisplayed()) {
							System.out.println("Discussion creation success message displayed");
							if(discussionNameDiv.getText().equals(discussionname)) {
								System.out.println("Discussion name created in div and  displayed");
								return true;
								
							}
							else{
								System.out.println("Discussion name not displyed in div");
								return false;
							}
							
						}
						else {
							System.out.println("Discussion creation success message not displayed");
							return false;
						}
					}
					else {
						System.out.println("Add Discussion button not enabled");
						return false;
					}
				}
				else{
					System.out.println("Social community is not name displayed as "+socialcommunityName);
					return false;					
				}
			}
			else {
				System.out.println("Created community division is not displayed");	
				return false;
			}
			
		}
		else{
			System.out.println("Social Communities page not loaded");
			return false;
		}
	}
	
	public boolean deletediscussion(String appurl, String socialcommunityName, String discussionname) {		
		System.out.println("In create discussion method");
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("self_header")));
		self.click();
		System.out.println("Self clicked");
		collabration.click();
		System.out.println("Collabration link clicked");
		socialcommunities.click();
		System.out.println("Social Communities link clicked");
		//WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='addCommunity_memberCommunities']/span")));
		System.out.println("Page loaded successfull");
		if(driver.getCurrentUrl().equals(appurl+"core/socialCommunities")) {
			System.out.println("Social URL loaded successfully");
			if(communityDiv.isDisplayed()) {
				System.out.println("Community Div displayed");
				if(commuNameDiv.getText().equals(socialcommunityName)) {
					System.out.println("Social community name displayed as "+socialcommunityName);
					commuNameDiv.click();
					System.out.println("Community name div clicked");
					List<WebElement> trsize = driver.findElements(By.xpath("//table[@class='table ng-table']/tbody/tr")); 
					System.out.println("Tr size "+trsize.size());
					for(int i=1;i<=trsize.size()+1;i++) {
						WebElement wd = driver.findElement(By.xpath("//table[@class='table ng-table']/tbody/tr["+i+"]/td[2]/div/a"));
						if(wd.getText().equals(discussionname)) {
							System.out.println("Discussion name identified");
							WebElement we = driver.findElement(By.xpath("//table[@class='table ng-table']/tbody/tr["+i+"]/td[3]/div/button[2]"));
							we.click();
							deletediscusiion.click();
							System.out.println("Delete Discussion clicked ");	
							if(popupDiscussion.getText().equals("Are you sure you want to delete this discussion? This action cannot be undone.")) {
								System.out.println("Pop up for delete discussion displayed");
								deletepopdiscussion.click();
								System.out.println("Delete clicked in pop up");
								if(deleteDiscussionMsg.isDisplayed()) {
									System.out.println("Delete discussion message displayed");
									return true;
								}
								else{
									System.out.println("Delete discussion message not displayed");
									return false;
								}								
							}
							else {
								System.out.println("Pop up for delete discussion is not displayed");
								return false;								
							}							
						}
						else{
							System.out.println("Discussion name is not displayed");
							return false;							
						}					
					}
					return true;					
				}
				else {
					System.out.println("Social community name not displayed as "+socialcommunityName);
					return false;
				}
			}
			else {
				System.out.println("Community Div not displayed");
				return false;
			}
		}
		else{
			System.out.println("Social URL not loaded");
			return false;			
		}
		
		
	}
		
	
	public boolean createComm(String appurl, String socialcommunityName) {
		System.out.println("In create community method");
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("self_header")));
		self.click();
		System.out.println("Self clicked");
		collabration.click();
		System.out.println("Collabration link clicked");
		socialcommunities.click();
		System.out.println("Social Communities link clicked");
		//WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='addCommunity_memberCommunities']/span")));
		System.out.println("Page loaded successfull");
		if(driver.getCurrentUrl().equals(appurl+"core/socialCommunities")) {
			System.out.println("Social Communities page loaded successfully");
			newButton.click();
			System.out.println("New Button clicked");
			communityName.sendKeys(socialcommunityName);
			System.out.println("Community name entered");
			userCheckbox.click();
			System.out.println("Username checkbox clicked");
			Save.click();
			System.out.println("Save Button clicked");
			if(successmsg.isDisplayed()) {
				System.out.println("Success message displayed");
				if(communityDiv.isDisplayed()) {
					System.out.println("Created community division is displayed");
					if(commuNameDiv.getText().equals(socialcommunityName)) {
						System.out.println("Social community name displayed as "+socialcommunityName);
						commuNameDiv.click();
						System.out.println("Community name div clicked");
						System.out.println("Community created successfully");
						return true;
					}
					else{
						System.out.println("Social community is not name displayed as "+socialcommunityName);
						return false;					
					}
					
				}
				else {
					System.out.println("Created community division is not displayed");	
					return false;
				}
			}
			else{
				System.out.println("Success message not displayed");
				return false;
			}
			
		}
		else {
			System.out.println("Social page not loaded");
			return false;
		}
	}
	
	public boolean deleteComm(String appurl, String socialcommunityName) {
		System.out.println("In create community method");
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("self_header")));
		self.click();
		System.out.println("Self clicked");
		collabration.click();
		System.out.println("Collabration link clicked");
		socialcommunities.click();
		System.out.println("Social Communities link clicked");
		//WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='addCommunity_memberCommunities']/span")));
		System.out.println("Page loaded successfull");
		if(driver.getCurrentUrl().equals(appurl+"core/socialCommunities")) {
			System.out.println("Social Communities page loaded successfully");
			if(communityDiv.isDisplayed()) {
				System.out.println("Created community division is displayed");
				if(commuNameDiv.getText().equals(socialcommunityName)) {
					System.out.println("Social community name displayed as "+socialcommunityName);
					commuNameDiv.click();
					System.out.println("Community name div clicked");
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='rootViewContainer']/div[2]/div/div[2]/div[4]/div/ul/li[1]/a")));
					editCommDrop.click();
					System.out.println("Edit dropdown in community is clicked");
					deleteComm.click();
					System.out.println("Delete in community clicked");
					if(popup.isDisplayed()) {
						System.out.println("Pop up displayed");
						String msg= popupMsg.getText();
						System.out.println("Pop Up Message displayed as "+msg);
						if(msg.equals("Are you sure you want to delete this community? This action cannot be undone.")) {
							System.out.println("PopUp message displaed correctly");
							deletePopup.click();
							System.out.println("Delete in popup is clicked");
							String conf =alertConf.getText();
							if(conf.equals("Test_CreateCommunity community deleted successfully.")) {
								System.out.println("Community deletion confirmation message displayed");
								return true;	
							}
							else {
								System.out.println("Community deletion confirmation message is not displayed");
								return false;
							}
													
						}
						else {
							System.out.println("PopUp message displaed incorrectly");
							return false;
						}
						
					}
					else {
						System.out.println("Pop up is not displayed");
						return false;
					}
					
				}
				else{
					System.out.println("Social community is not name displayed as "+socialcommunityName);
					return false;					
				}
				
			}
			else {
				System.out.println("Created community division is not displayed");	
				return false;
			}
		}
		else {
			System.out.println("Social page not loaded");
			return false;
		}		
		
	}	
		

}
		
	
