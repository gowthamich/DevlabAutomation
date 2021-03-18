package ObjectRep;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Driver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Common_methods.CommonMethods;

public class Home {
	
	WebDriver driver;
	CommonMethods objCom =  new CommonMethods();
	//CommonMethods objCom;
	
	@FindBy(id = "admin_header")
	WebElement adminHeader;
	
	@FindBy(xpath = "//*[@id='learning_management']/span")
	WebElement learningManagement;
	
	@FindBy(xpath = "//*[@id='namecount-2256']")
	WebElement activityManagement;
	
	@FindBy(xpath = "//*[@id='Administrator_MenuLearningActivies']/span")
	WebElement learninActivities;
	
	@FindBy(xpath = "//*[@id='fileUpload_Button']")
	WebElement fileUploadButton;
	
//	@FindBy(xpath = "//*[@id='fileUpload']")
//	WebElement browse;
	
	@FindBy(xpath = "//*[@id='fileUpload']" )
	WebElement fileUpload;
	
	@FindBy(xpath = "//*[@id='FileSelction']/div/button")
	WebElement uploadFile;
	
	@FindBy(xpath = "//*[@id='NextButton']/button")
	WebElement nextButton;
	
//	@FindBy(xpath = "//button[@title = 'Next' and (text() = 'Next' or . = 'Next')]")
//  WebElement clickOnFileUploadNext;

	@FindBy(id="txt-activityName")
	WebElement activityName;
	
	@FindBy(id="txt-activityCode")
	WebElement activityCode;	
	
	//*[@id="txt-activityCode"]
	
	@FindBy(xpath = "//*[@id='UploadButton']/button")
	WebElement finalUpload;
	
	@FindBy(xpath = "//*[@id='upload-steps']/div/div/div[1]/label")
	WebElement alertMsg;
	
	@FindBy(xpath = "//*[@id='listuploadedfilesTab']/a")
	WebElement previouslyUpload;
	
	@FindBy(xpath = "//div[(text() = 'Browse...' or . = 'Browse...')]")
	WebElement browse;
	
	@FindBy(xpath="//*[@id='search_header']")
	WebElement enterpriseSearch;
	
//	@FindBy(xpath="//*[@id='txtSearch-main']")
//	WebElement searchInput;
	
	@FindBy(id="txtSearch-main")
    WebElement searchInput;
	
	@FindBy(xpath="//*[@id='mainContent']/div/div/table/tbody/tr[1]")
	WebElement firstFileRow;
	
	@FindBy(xpath="//*[@id='mainContent']/div/div/table/tbody/tr[1]/td[1]/input")
	WebElement firstFileCheck;
	
	@FindBy(xpath="//*[@id='toolBox']/button[3]")
	WebElement delete;
	
	@FindBy(xpath="//*[@id='mainContent']/div/div/table/tbody/tr[1]/td[8]/div/span")
	WebElement status;
	
	@FindBy(xpath="//*[@id='user_management']/span")
	WebElement users;
	
	@FindBy(xpath="//*[@id='common_list_users']/span")
	WebElement allUsers;
	
	@FindBy(xpath="//*[@id='CreateUserButtonId']")
	WebElement createUser;
	
	@FindBy(xpath="//*[contains(@class, 'form-group marginOverWrite') ]//*[text()='Login Name']/parent::div")
	WebElement loginName;
	
//	@FindBy(xpath="//*[contains(@class, 'form-group marginOverWrite') ]//*[text()='Login Name']/parent::div")
//	WebElement loginName;
	
	@FindBy(xpath="//*[contains(@class,'form-group marginOverWrite') ]//*[text()='Password']/parent::div")
	WebElement password;
	
	@FindBy(xpath="//*[contains(@class,'form-group marginOverWrite') ]//*[text()='User Type']/parent::div")
	WebElement userType;
	
	@FindBy(xpath="//*[contains(@class, 'form-group marginOverWrite') ]//*[text()='User Security Role']/parent::div")
	WebElement userSecurityRole;
	
	
	@FindBy(xpath="//*[contains(@class,'form-group marginOverWrite') ]//*[text()='First Name']/parent::div")
	WebElement Firstname;
	
	@FindBy(xpath="//*[contains(@class,'form-group marginOverWrite') ]//*[text()='Last Name']/parent::div")
	WebElement Lastname;
	
//	@FindBy(xpath="//*[@class='form-group marginOverWrite' ]//*[text()='Time Zone']/parent::div")
//	WebElement timezone;
	
	@FindBy(xpath="//*[contains(@class, 'form-group marginOverWrite')]//*[text()='Time Zone']/parent::div")
	WebElement timezone;
	
//	@FindBy(xpath="//*[@class='form-group marginOverWrite' ]//*[text()='User Language']/parent::div")
//	WebElement userLanguage;
	
	@FindBy(xpath="//*[contains(@class, 'form-group marginOverWrite')]//*[text()='User Language']/parent::div")
	WebElement userLanguage;	
	
	@FindBy(xpath="//*[contains(@class,'form-group marginOverWrite') ]//*[text()='Email 1']/parent::div")
	WebElement Email;
	
	@FindBy(xpath="//*[@id='footerSave']/input")
	WebElement saveButton;	
	
	@FindBy(xpath="/html/body/div[4]/div/div/div[2]/div[2]/span")
	WebElement SuccessMsg;
	
	@FindBy(xpath="/html/body/div[4]/div/div/div[3]/div[3]/button/span")
	WebElement ReturnToUserList;
	
	@FindBy(name="searchUser")
	WebElement searchUser;
	
	
	@FindBy(xpath="//*[@id='rootViewContainer']/div[2]/section/div[5]/div[7]")
	WebElement searchContainer;
	
	@FindBy(xpath="//*[@id='divViewActivities']/div/div/div/ul/li[1]")
	WebElement searchcourselist;
	
	@FindBy(xpath="//*[@id='Learning_0']")
	WebElement courseName;
	
	@FindBy(xpath="//*[@id='exportable']/tbody/tr[1]")
	WebElement srow;	
	
	@FindBy(xpath="//*[@id='exportable']/tbody/tr[1]/td[2]")
	WebElement sname;
	
	@FindBy(xpath="//*[@id='alert-container-create-user']/div")
	WebElement errMsg;	
	//error alert msg;
	
	@FindBy(xpath="//*[@id='errMsg']/li")
	WebElement ErrorMsg;
	
	@FindBy(xpath="//*[@id='namecount-2253']")
	WebElement accountManagement;
	
	@FindBy(id= "common_deactivate_account")
	WebElement deactivateAccount;
	//[contains(@class, 'form-group marginOverWrite')]//*[text()='Time Zone']
	
	@FindBy(xpath="//*[contains(@id , 'txtPersonSearchTextField')]")
	//*[text()='Search for a Person']")
	WebElement deactivateAccountSearch;
	
	//*[@id="txtPersonSearchTextField4437"]
	
	@FindBy(xpath="//*[@id='rowEmp0']")
	WebElement deactivateRow;
	
	@FindBy(xpath="//*[@id='deactivateFooter']/div[1]/button[1]")
	WebElement deactivateNext;
	
	@FindBy(xpath="//*[@id='deactivateFooter']/div[1]/button[3]")
	WebElement deactivateFinish;
	
	@FindBy(xpath="//*[@id='alert-container']/div/span")
	WebElement deactivateMsg;
	
	@FindBy(xpath="//*[@id='common_remove_account']/span")
	WebElement removeAccount;
	
	@FindBy(xpath="//*[contains(@id , 'txtPersonSearchTextField')]")
	//*[text()='Search for a Person']")
	WebElement removeAccountSearch;
	
	@FindBy(xpath="//*[@id='rowEmp0']")
	WebElement removeRow;
	
	@FindBy(xpath="//*[@id='btnNext']")
	WebElement removeNext;
	
	@FindBy(xpath="//*[@id='btnFinish']")
	WebElement removeFinish;
	
	@FindBy(xpath="//*[@id='alert-container']/div/span")
	WebElement removeMsg;
	// //*[@id="deactivateFooter"]/div[2]/button
	@FindBy(xpath="//*[@id='deactivateFooter']/div[2]/button")
	WebElement okButton;
	
	@FindBy(xpath="//*[@id='self_header']")
	WebElement self;
	
	@FindBy(xpath="//*[@id='menu_signout']")
	WebElement Logoff;
	//*[@id="menu_signout"]/span
	
	//*[@id="ng-app"]/body/div[3]/div/div[2]/button/i
	
	@FindBy(xpath="//*[@id='ng-app']/body/div[3]/div/div[2]/button/i")
	WebElement closeButton;
	
	@FindBy(xpath="//*[@id='self_reporting']/span")
	WebElement Reporting;
	
	@FindBy(xpath="//*[@id='Advanced_Reporting']/span")
	WebElement AdvanceReporting;
	
	@FindBy(xpath="//*[@id=\'SysAnalytics\']/span")
	WebElement Analytics;	
	
	@FindBy(xpath="//*[@id=\'headerBackA11y\']/table/tbody/tr")
	WebElement IBMDiv;
	
	@FindBy(xpath="//*[@id='product_administration']/span")
	WebElement productAdmin;
	
	@FindBy(xpath="//*[@id=\'administration_learning\']")
	WebElement Learning;
	
	@FindBy(xpath="//*[@id='administration_usermanager']")
	WebElement userManager;
	
	@FindBy(xpath="//*[@id='Roles']")
	WebElement Roles;
	
	@FindBy(xpath="//*[@id='handler2']")
	WebElement reportFolder;
	
	@FindBy(xpath="//*[@id='handler3']")
	WebElement AdhocComp;
	
	@FindBy(xpath="//*[contains(@id, 'node')]//*[text()='Custom']//*[contains(@id, 'handler')]")
	WebElement Custom;
	
	@FindBy(xpath="//*[contains(@id, 'node')]//*[text()='Reports']")
	WebElement Reports;
	
	@FindBy(xpath="//*[text() = 'Add Folder']")
	WebElement AddFolder;
	
	@FindBy(xpath="//*[@id='resultsList']//*[text()='Monitoring Report']")
	WebElement reportList;
	
	@FindBy(xpath="//*[@id='reportViewFrame']/div/div[2]")
	WebElement reportView;
	
	//*[@id="reportViewFrame"]/div/div[2]
	
	@FindBy(xpath="//*[@id='system_management']/span")
	WebElement system;
	
	@FindBy(xpath="//*[@id='namecount594']")
	WebElement Data;
	
	@FindBy(xpath="//*[@id='Administrator_MenuDataImports']/span")
	WebElement dataImport;
	
	@FindBy(xpath="//*[@id='content']//*[@ng-repeat='result in Results']//*[text()='Default Data Import Job ']/parent::td/parent::tr/td[7]/div/div/button[2]")
	WebElement dsudrop;
	
	@FindBy(xpath="//*[@id='content']//*[@ng-repeat='result in Results']//*[text()='Training Migration Job ']/parent::td/parent::tr/td[7]/div/div/button[2]")
	WebElement tmudrop;
	
	@FindBy(xpath="//*[@id='-1']/li[2]/a")
	WebElement dsudownload;
	
	@FindBy(xpath="//*[@id='-6']/li[2]/a")
	WebElement tmudownload;
	
	@FindBy(xpath="//*[@id='social_gamification']/span")
	WebElement SocialGame;
	
	@FindBy(xpath="//*[@id='gamification_configuration']/span")
	WebElement gamConfig;
	
	@FindBy(xpath="//*[@id='rootViewContainer']/div[2]/div/div[3]/div[3]")
	WebElement gamConfigPage;
	
	@FindBy(xpath="//*[@id='namecount-2283']")
	WebElement social;
	
	@FindBy(xpath="//*[@id='SOCIAL_SETTINGS']/span")
	WebElement socialSettings;
	
	@FindBy(xpath="//*[@id='rootViewContainer']/div[2]/div/div")
	WebElement socialPage;
	
	@FindBy(xpath="//*[@id='namecount-2284']")
	WebElement configLink;
	
	@FindBy(xpath="//*[@id='Mobile_Configuration']/span")
	WebElement mobileConfig;
	
	@FindBy(xpath="//*[@id='rootViewContainer']/div[2]/div")
	WebElement mobilePage;
	
	@FindBy(xpath="//*[@id='newActWizard_Button']")
	WebElement actWiz;
	
	@FindBy(xpath="//*[text()='Online Course or Document']")
	WebElement onlineCourse;
	
	//*[@id="createActivityWizard"]/div/div[4]/div/button[4]
	
	@FindBy(xpath="//*[@id='sf_Code']")
	WebElement XActcode;
	
	@FindBy(xpath="//*[@id='frmUpload']//tr[5]//td[1]")
	WebElement NoOption; 
	
	@FindBy(xpath="//*[@id='sf_Url']")
	WebElement utlInput;
	
	@FindBy(xpath="//*[@id='sf_EnablexApiTracking']")
	WebElement xapichkbox;
	 
	@FindBy(xpath="//*[@id='idbtnUrlTest']")
	WebElement Test;
	
	@FindBy(xpath="//*[@id='idbtnNext']")
	WebElement xNext;
	
	@FindBy(xpath="//*[@id='main_create']")
	//*[@id="main_create"]/p[text()="Create"])[first()]
	WebElement createDrop;
	
	@FindBy(xpath="//*[text()='Ad Hoc View']")
	WebElement adhocView;
	
	@FindBy(xpath="//*[@id='dataChooserSource']/div[9]")
	WebElement adHocViewDiv;
	
	@FindBy(xpath="//*[@id='idbtnNext']")
	WebElement Next;
	
	@FindBy(xpath="//*[@id='idNextButton']")
	WebElement Next3;
	
	@FindBy(xpath="//*[@id='idCreateButton']")
	WebElement createx;
	
	@FindBy(xpath="//*[@id='idbtnAssign']")
	WebElement Assign;
	
	@FindBy(xpath="//*[@id='idSkipButton']")
	WebElement Skip;
	
	//*[@id="idbtnCancel"]
	//*[@id='idbtnCreate']
	
	@FindBy(xpath="//*[@id='idFinishButton']")
	WebElement Finish;
	
	@FindBy(xpath="//*[@id='idBtnDelete']")
	WebElement Del;
	
	@FindBy(xpath="//*[@id='idtask_Next']")
	WebElement Delete;
	
	@FindBy(xpath="//*[@id='MainFormId']")
	WebElement DelDiv; 
	
	@FindBy(xpath="//*[@id='mainContent']/div/div/table/tbody/tr[1]/td[1]/input")
	WebElement ch;
	//*[@id="mainContent"]/div/div/table/tbody/tr[1]/td[1]/input
	
	@FindBy(xpath="//*[@id='handler28']")
	WebElement LearnFolder;
	
	@FindBy(xpath="//*[@id='handler38']")
	WebElement AdhocCompView;
	
	@FindBy(xpath="//*[@id='addFolderInputName']")
	WebElement FolderName;
	
	
	@FindBy(xpath="//*[text()='Add Resource']")
	WebElement AddResource;
	
	@FindBy(xpath="//*[text()='JasperReport']")
	WebElement JasperRep;
	
	@FindBy(xpath="//*[@id='ng-app']/body/div[3]/div/div[2]/button")
	WebElement close;
	
//	@FindBy(xpath="//*[@id='resultsList']//*[text()='"+repName+"']"))
//	WebElement replist;
	@FindBy(xpath="//*[@id='self_wfm_timeattendance']/span")
	WebElement timeAttendance;
	
	@FindBy(xpath="//*[@id='self_wfm_scheduling']/span")
	WebElement scheduling;
	
	@FindBy(xpath="//*[@id='self_wfm_absence']/span")
	WebElement adsence;
	
	@FindBy(xpath="//*[@id='self_wfm_payrollallocation']/span")
	WebElement payroll;
	
	@FindBy(xpath="//*[@id='self_wfm_reporting']/span")
	WebElement wfmReporting;
	
	@FindBy(xpath="//*[@id='integrations']")
	WebElement Integrations;
	
	@FindBy(xpath="//*[@id='collaboration']")
	WebElement Collaboration;
	
	@FindBy(xpath="//*[@id='Administrator_Communities']")
	WebElement Communities;
	
	public Home(WebDriver driver){
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}
	public void closeButtonClick(){
		driver.switchTo().frame("productPillarFrame");
		close.click();	
		System.out.println("Close button clicked");		
	}
	public Boolean socialInte() {
		System.out.println("In social integration method");
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("admin_header")));
		adminHeader.click();
		System.out.println("Admin clicked");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='learning_management']/span")));
		learningManagement.click();
		System.out.println("Learning Management clicked");
		Integrations.click();
		System.out.println("Integrations clicked");
		Collaboration.click();
		System.out.println("Collaboration clicked");
		if(Communities.isDisplayed()) {
			Communities.click();
			System.out.println("Communities clciked");
			if(driver.getCurrentUrl().contains("Social%2FCommunitiesList")) {
				System.out.println(" Redirected to Social communities");
				return true;				
			}
			else {
				System.out.println("Not redirected to social communities");
				return false;
			}
			
		}
		else {
			System.out.println("Communities not displayed");
			return false;
		}
	}
	
	public Boolean maestroInte() {
		System.out.println("In maestro integration method");
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("admin_header")));
		adminHeader.click();
		System.out.println("Admin clicked");
		productAdmin.click();
		System.out.println("Product Administartion clicked");
		Learning.click();
		System.out.println("Learning clicked");
		userManager.click();
		System.out.println("User Manager clicked");
		if(Roles.isDisplayed()) {
			Roles.click();
			System.out.println("Roles clicked");
			if(driver.getCurrentUrl().contains("pillarRedirect?relyingParty=MaestroLM")) {
				System.out.println("Redirected to Maestro URL");
				return true;				
			}
			else {
				System.out.println("Not redirected to Maestro URL");
				return false;
			}				
		}
		else {
			System.out.println("Roles not displayed");
			return false;
		}	
		
	}
	
	public Boolean analyticsInte() throws InterruptedException {
		System.out.println("In analytics integration method");
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("self_header")));
		self.click();
		System.out.println("Self clicked");
		Reporting.click();
		System.out.println("Reporting clicked");
		if(Analytics.isDisplayed()) {
			Analytics.click();
			System.out.println("Analytics clicked");
			Thread.sleep(3000);
			if(IBMDiv.isDisplayed()) {
				System.out.println("IBM Cognos Connection displayed");
				return true;				
			}
			else {
				System.out.println("IBM Cognos Connection not displayed");
				return false;				
			}					
		}
		else {
			System.out.println("Analytics option not displayed");
			return false;
		}
	}
	
	public Boolean wfmInte() {
		System.out.println("In wfm integration method");
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("self_header")));
		self.click();
		System.out.println("Self clicked");
		
		if(timeAttendance.isDisplayed() && scheduling.isDisplayed() && adsence.isDisplayed() && payroll.isDisplayed() && wfmReporting.isDisplayed() ) {
			System.out.println(" WFM options are available");
			return true;
		}			
		else {
			System.out.println(" WFM options not available");
			return false;
		}
			
	}
	
	public Boolean deleteXApi(String xapiName){
		System.out.println("In xapi delete method");
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("admin_header")));
		adminHeader.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='learning_management']/span")));
		learningManagement.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='namecount-2256']")));
		activityManagement.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='Administrator_MenuLearningActivies']/span")));
		learninActivities.click();
		driver.switchTo().frame("productPillarFrame");
		WebElement sear = driver.findElement(By.xpath("//*[@id='ListActivitiesSearchTextBox']"));
		sear.sendKeys(xapiName);
		System.out.println("Name entered in search box");
//		WebElement di = driver.findElement(By.xpath("//*[@ng-model = 'ActivityStatusSelect']"));
//		di.click();
		WebElement all = driver.findElement(By.xpath("//*[@ng-model = 'ActivityStatusSelect']//*[@label ='All']"));
		all.click();
		WebElement ra = driver.findElement(By.xpath("//*[@class='table tree-grid']//tr[1]/td[1]/div/input"));
		//ra.click();
		
        if(ra.isEnabled()){
        	ra.click();
        	System.out.println("Delete clicked in select");
        	//*[@id='idtask_Next']
        	if(Del.isEnabled()){
        		Del.click();
        		System.out.println("Delete activities clicked");
        		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS) ;
        		WebElement fde = driver.findElement(By.xpath("//*[@title='Delete']"));
        		fde.click();
        		WebElement te =  driver.findElement(By.xpath("//*[@id='idDeleteMsg']/span"));
        		if(te.getText().equals("The activity you selected has been deleted.")){
        			System.out.println("Delete success");
        			return true;        			
        		}
        		else{
        			System.out.println("Delete not success");
        			return false;
        		}       			
        		
        	}
        	else{
        		return false;
        	}
        }        	
        else{ 
        	System.out.println("Delete button not enabled");
        	return false;
        }
	}
	
	public Boolean viewInReport() throws InterruptedException{
		System.out.println("In report check method");
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("self_header")));
		self.click();
		System.out.println("Self clicked");
		Reporting.click();
		System.out.println("Reporting clicked");
		AdvanceReporting.click();
		System.out.println("Advanced Reporting clicked");
		Thread.sleep(3000);    
		driver.switchTo().frame("productPillarFrame");
		System.out.println("Switched to product pillar iframe");
		if(createDrop.isDisplayed()){
			Actions builder = new Actions(driver); 
			Actions hoverOverRegistrar = builder.moveToElement(createDrop);
			hoverOverRegistrar.perform();
			adhocView.click();
			System.out.println("Ad Hoc View Clicked");
			Thread.sleep(3000);
			if(adHocViewDiv.isDisplayed()){
				System.out.println("Ad hoc view division displayed");
				return true;
			}
			else{
				System.out.println("Ad hoc view division not displayed");
				return false;
			}			
		}
		else{
			System.out.println("Ad Hoc not visible");
			return false;
		}
	}
	public Boolean xapi(String url) throws InterruptedException{
		System.out.println("In xapi method");
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("admin_header")));
		adminHeader.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='learning_management']/span")));
		learningManagement.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='namecount-2256']")));
		activityManagement.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='Administrator_MenuLearningActivies']/span")));
		learninActivities.click();
		driver.switchTo().frame("productPillarFrame");
		actWiz.click();
		System.out.println("Act wiz clicked");
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		System.out.println("Switch to default content frame");
		onlineCourse.click();
		System.out.println("online course clicked");
		driver.switchTo().frame("productPillarFrame");
		System.out.println("switched to Product pillar frame");
		driver.switchTo().frame("UploadFrame");
		System.out.println("switched to Upload frame");		
		NoOption.click();
		System.out.println("No option clicked");
		utlInput.sendKeys(url);
		Test.click();
		String parentWinHandle = driver.getWindowHandle();
		Set<?> popupHandles = driver.getWindowHandles();
		Boolean p = false;
		Iterator<?> iterator = popupHandles.iterator();
		while(iterator.hasNext()){
		    String popupHandle = iterator.next().toString();
		    if(!popupHandle.contains(parentWinHandle)) {
		        driver.switchTo().window(popupHandle);
		        Thread.sleep(3000);
		        //Perform the operation you want to do
		        //driver.switchTo().window(parentWinHandle);
		        if(driver.getCurrentUrl().contains("youtube")){
		        	p = true;
		        	System.out.println("youtube opened");
		        	//System.out.println(driver.getCurrentUrl());
		        	break;
		        }		        	
		        else
		        	System.out.println("youtube not opened");
		    }		    
		}
		System.out.println(driver.getCurrentUrl());
		driver.close();
		driver.switchTo().window(parentWinHandle);
		System.out.println(driver.getCurrentUrl());
		if(p){
			
			driver.switchTo().frame("productPillarFrame");
			System.out.println("Switched to product pillar frame");
			
			xNext.click();
			System.out.println("Clicked on next button");
			Thread.sleep(3000);
			System.out.println("Present act code  "+XActcode.getAttribute("Value"));
			if(XActcode.getAttribute("Value").length()== 0) {
				String actcode ="act"+objCom.GetTimeStamp();
				XActcode.sendKeys(actcode);
				System.out.println("Entered act code step 2 "+ actcode);
			}
			Next.click();
			System.out.println("Next clicked on step2");	
			if(xapichkbox.isSelected()) {
				System.out.println("xapi check box enabled");
			}
			else{
				System.out.println("xapi check box not enabled");
				xapichkbox.click();
				System.out.println("xapi check box clicked to enable");			
			}
			
			Next3.click();
			System.out.println("Next clicked on step3");
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
			//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='idCreateButton']")));
			//wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf("//*[@id='idCreateButton']")));
			for(int i=0; i<=2;i++){
				  try{
					 // driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS) ;
					  Thread.sleep(5000);
				      driver.findElement(By.xpath("//*[@id='idCreateButton']")).click();
				      System.out.println(i+"-------Create clciked at step 4");
				      break;
				  }
				  catch(Exception e){
				     //Sysout(e.getMessage());
					  System.out.println(e);
				  }
				}	
			Thread.sleep(5000);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='idSkipButton']")));
			Skip.click();
			System.out.println("Skip clicked");
			Finish.click();
			System.out.println("Finish clicked");
			
			return true;
		}
		else
			return false;
	}
	public Boolean mobile(){
		System.out.println("In Mobile");
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("admin_header")));
		adminHeader.click();
		System.out.println("Admin clicked");
		system.click();
		System.out.println("System clicked");
		configLink.click();
		System.out.println("Configuration link clicked");
		mobileConfig.click();
		System.out.println("Mobile configuration clicked");		 
		if(mobilePage.isDisplayed()){
			System.out.println("Mobile configuration page displayed");
			return true;
		}
		else{
			System.out.println("Mobile configuration page not displayed");
			return false;
		} 
		
	}
	public Boolean social(){
		System.out.println("In Social");
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("admin_header")));
		adminHeader.click();
		System.out.println("Admin clicked");
		SocialGame.click();
		System.out.println("Social and Gamification clicked");
		social.click();
		System.out.println("Social link clicked");
		socialSettings.click();
		System.out.println("Social settings clicked");
		if(socialPage.isDisplayed()){
			System.out.println("Social page is displayed");
			return true;
		}
		else{
			System.out.println("Social page not displayed");
			return false;
		}
	}
	
	public Boolean gamificationFun(){
		System.out.println("In Gamefication");
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("admin_header")));
		adminHeader.click();
		System.out.println("Admin clicked");
		SocialGame.click();
		System.out.println("Social and Gamification clicked");
		gamConfig.click();
		System.out.println("Gamification configuration clicked");
		if(gamConfigPage.isDisplayed()){
			System.out.println("Gamfication config page displayed");
			return true;
		}	
		else{
			System.out.println("Gamification config page not displayed");
			return false;
		}
	}
	

	public Boolean importTMU(){
		System.out.println("In TMU import");
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("admin_header")));
		adminHeader.click();
		system.click();
		System.out.println("System clicked");
		Data.click();
		System.out.println("Data clicked");
		dataImport.click();
		System.out.println("Data import clicked");
		driver.switchTo().frame("productPillarFrame");
		System.out.println("Switched frame");
		if(tmudrop.isDisplayed()){
			tmudrop.click();
			System.out.println("Dropdown clicked");
			if(tmudownload.isDisplayed()){
				tmudownload.click();
				System.out.println("Download TMU clicked"); 
				return true;
			}
			else
				return false;
		}
		else
			return false;
		
		
	}
	
	public Boolean importDSU(){
		System.out.println("In DSU import");
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("admin_header")));
		adminHeader.click();
		system.click();
		System.out.println("System clicked");
		Data.click();
		System.out.println("Data clicked");
		dataImport.click();
		System.out.println("Data import clicked");
		driver.switchTo().frame("productPillarFrame");
		System.out.println("Switched frame");
		if(dsudrop.isDisplayed()){
			dsudrop.click();
			System.out.println("Dropdown clicked");
			if(dsudownload.isDisplayed()){
				dsudownload.click();
				System.out.println("Download DSU clicked");
				return true;
			}
			else
				return false;
		}
		else
			return false;
		
		
	}
	
	public Boolean goToJasper(String url) throws MalformedURLException, IOException {
//		String rurl = url+"jasperserver-pro";		
//		System.out.println("href url is "+rurl);
		HttpURLConnection huc = null;
		huc = (HttpURLConnection)(new URL(url).openConnection());
		huc.setRequestMethod("HEAD");
		huc.connect();
		int respCode =200;
		respCode = huc.getResponseCode();
		System.out.println("Response code is"+ respCode);
		if(respCode<200) {
			System.out.println("Reporting working");
			return true;			
		}
		else {
			System.out.println("Reporting not working");
			return false;
		}
		
		
	}
	public Boolean goToAR() throws MalformedURLException, IOException {
		System.out.println("Go to AR");
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("self_header")));
		self.click();
		System.out.println("Self clicked");
		Reporting.click();
		System.out.println("Reporting clicked");
		AdvanceReporting.click();
		System.out.println("Advanced Reporting clicked");
//		WebElement e  = driver.findElement(By.id("Advanced_Reporting"));
//		String tag = e.getTagName();
//		System.out.println("tag name is  "+tag);
//		String url = e.getAttribute("href");
//		System.out.println("href url is "+url);
//		HttpURLConnection huc = null;
//		huc = (HttpURLConnection)(new URL(url).openConnection());
//		huc.setRequestMethod("HEAD");
//		huc.connect();
//		int respCode =200;
//		respCode = huc.getResponseCode();
//		System.out.println("Response code is"+ respCode);
		driver.switchTo().frame("productPillarFrame");
		if(reportFolder.isEnabled()) {
			System.out.println("Report folder avaialble");
			return true;
		}
		else{
			System.out.println("Report not available");
			return false;
		}
	}
//	public int getResponseCode() {
//		return 
//		
//	}
	
	public Boolean reportCheck(String folname,String repName, String resId, String repPath) throws InterruptedException{
		System.out.println("In report check method");
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("self_header")));
		self.click();
		System.out.println("Self clicked");
		Reporting.click();
		System.out.println("Reporting clicked");
		AdvanceReporting.click();
		System.out.println("Advanced Reporting clicked");
		Thread.sleep(3000);
		driver.switchTo().frame("productPillarFrame");
		
		reportFolder.click();
		System.out.println("Parent Reporting clicked");
		AdhocComp.click();
		System.out.println("Ahhoc component clicked");
		Custom.click();
		System.out.println("Custom folder clicked");
		Thread.sleep(1000);
		Actions actions = new Actions(driver);
		//WebElement elementLocator = driver.findElement(By.xpath("//*[contains(@id, 'node')]//*[text()='Reports']"));
		Thread.sleep(3000);
		actions.contextClick(Reports).build().perform();
		System.out.println("Report right clicked");
		AddFolder.click();
		System.out.println("Add folder clicked");
		Thread.sleep(3000);
		FolderName.sendKeys(folname);
		System.out.println("Folder name entered");
		WebElement add= driver.findElement(By.xpath("//*[@id='addFolderBtnAdd']"));
		add.click();
		System.out.println("Add clicked");
		WebElement FolName = driver.findElement(By.xpath("//*[contains(@id, 'node')]//*[text()='"+folname+"']"));
		actions.contextClick(FolName).perform();
		System.out.println("FolName right clicked");
		AddResource.click();
		System.out.println("Add resource clicked");
		JasperRep.click();
		System.out.println("Jasper report clicked");
		WebElement na =  driver.findElement(By.xpath("//*[@id='label']"));
		na.sendKeys(repName);
		System.out.println("Report name enterd");
		WebElement ri = driver.findElement(By.xpath("//*[@id='resourceID']"));
		ri.sendKeys(resId);
//		WebElement se = driver.findElement(By.xpath("//*[@id='FILE_SYSTEM']"));
//		se.click();
		WebElement fi =  driver.findElement(By.xpath("//*[@id='filePath']"));
		fi.sendKeys(repPath);
		//driver.findElement(By.xpath("//*[@id='browser_button']")).click();
		WebElement da =  driver.findElement(By.xpath("//*[@name='_eventId_dataSource']"));
		da.click();
		Thread.sleep(3000);
		WebElement sel =  driver.findElement(By.xpath("//*[@id='CONTENT_REPOSITORY']"));
		sel.click();
		System.out.println("Selected data source");
		Thread.sleep(3000);
		WebElement br =  driver.findElement(By.xpath("//*[@id='browser_button']"));
		br.click();
		System.out.println("Browse clicked");
		Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		WebElement dat =  driver.findElement(By.xpath("//*[text()='Datasources']//*[contains(@id, 'handler')]"));
		dat.click();
		WebElement rw = driver.findElement(By.xpath("//*[text()='RMDWDataSource']"));
		rw.click();
		WebElement sel1 = driver.findElement(By.xpath("(//*[@class='footer ']//*[text()='Select'])[last()]"));
		sel1.click();
		WebElement sub = driver.findElement(By.xpath("//*[@id='done']//*[text()='Submit']"));
		sub.click();
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		WebElement replist = driver.findElement(By.xpath("//*[@id='resultsList']//*[text()='"+repName+"']"));
		
		if(replist.isDisplayed()){
			replist.click();
			Thread.sleep(15000);
			WebElement ba = driver.findElement(By.xpath("//*[@id='back']"));
			Actions action = new Actions(driver);
			Thread.sleep(5000);
			action.moveToElement(ba).click().perform();
			//ba.click();
			System.out.println("Back clicked");
			//ba.click();
			Thread.sleep(9000);
			///****************Deleting report*****************//
			Actions delactions = new Actions(driver);
			int i=0;
			while(i<3){
				try{
					Thread.sleep(3000);	
					WebElement replistd = driver.findElement(By.xpath("//*[@id='resultsList']//*[text()='"+repName+"']"));
					delactions.contextClick(replistd).perform();
					break;
				}catch(StaleElementReferenceException e){
					
				}
				i++;				
			}
//			WebDriverWait waitS = new WebDriverWait(driver,60);
//			waitS.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='resultsList']//*[text()='"+repName+"']")));
//			Actions delactions = new Actions(driver);
//			//Thread.sleep(3000);			
//			delactions.contextClick(replist).perform();
			WebElement del = driver.findElement(By.xpath("//*[text()='Delete']"));
			del.click();
			WebElement sc = driver.findElement(By.xpath("//*[@id='standardConfirm']"));
			if(sc.isDisplayed()){
				WebElement ok = driver.findElement(By.xpath("//*[@id='deleteResourceOK']"));
				ok.click();
				System.out.println("Report deleted");
				//return true;
			}
			else{
				System.out.println("confirmation alert not present");
				return false;
			}
			//// ********** Deleting report Folder ************/////////////
			Thread.sleep(10000);
			WebElement FoldName = driver.findElement(By.xpath("//*[contains(@id, 'node')]//*[text()='"+folname+"']"));
			//actions.contextClick(FolName).perform();
			Actions delractions = new Actions(driver);			
			delractions.contextClick(FoldName).perform();
			System.out.println("Folder right clicked to delete");
			Thread.sleep(5000);
			WebElement dre =  driver.findElement(By.xpath("(//*[text()='Delete'])[last()]"));
			//dre.click();
			Thread.sleep(5000);
			action.moveToElement(dre).click().perform();
			System.out.println("Folder delete clicked");
			WebElement drok = driver.findElement(By.xpath("//*[@id='deleteResourceOK']"));
			drok.click();
			System.out.println("Report folder deleted");
			return true;			
		}
		else{
			System.out.println("Report not added");
			return false;
		}
		
	}
	
	public Boolean logoff() throws InterruptedException{
		System.out.println("In logoff method");
		driver.switchTo().defaultContent();
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("self_header")));
		self.click();
		System.out.println("Self clicked");
		Thread.sleep(3000);
		if(Logoff.isEnabled()){
			Logoff.click();
			System.out.println("Log off link clicked");
			return true;
		}
		else{
			System.out.println("Logoff link not enabled");
			return false;
		}			
			
	}
	
	public Boolean removeAccount(String name){
		System.out.println(" In decativate account method");
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("admin_header")));
		adminHeader.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='user_management']/span")));
		users.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='namecount-2253']")));
		accountManagement.click();
		removeAccount.click();
		removeAccountSearch.sendKeys(name);
		if(removeRow.isEnabled()){
			System.out.println("Remove row displayed");
			removeRow.click();
			removeNext.click();
			removeFinish.click();
			if(removeMsg.getText().equals("Account successfully removed")){
				System.out.println("Removed Successfully");
				return true;
			}
			else{
				System.out.println("Not Removed ");
				return false;
			}
		
		}
		else{
			System.out.println("Not found user in Remove Search ");
			return false;
		}
			
	}
	
	public Boolean deactivateAccount(String name){
		System.out.println(" In decativate account method");
		System.out.println("Name to delete account---"+name);
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("admin_header")));
		adminHeader.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='user_management']/span")));
		users.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='namecount-2253']")));
		accountManagement.click();
		deactivateAccount.click();
		deactivateAccountSearch.sendKeys(name);
		if(deactivateRow.isEnabled()){
			System.out.println("Deactivate row displayed");
			deactivateRow.click();
			deactivateNext.click();
			deactivateFinish.click();
			if(deactivateMsg.getText().equals("Employee successfully deactivated.")){
				System.out.println("Deactivated successfully");
				okButton.click();
				return true;
			}
			else{
				System.out.println("Not decativated");
				return false;
			}
				
		}  
		else{
			System.out.println("Deactivate username not found ");
			return false;
		}
			
	}
	
	public Boolean createUser(String newUserName, String newUserPassword, String typeSelect,String roleSelect, String firstName,
			String lastName, String timeZone, String email, String userLang){
		System.out.println("in create user method");
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("admin_header")));
		adminHeader.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='user_management']/span")));
		users.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='common_list_users']/span")));
		allUsers.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CreateUserButtonId']")));
		createUser.click();
		System.out.println("Create user button clicked"); 
		if(loginName!=null){
			String lname  = loginName.getAttribute("ng-class").split("'")[3];
			WebElement logname = driver.findElement(By.id(lname));
			logname.sendKeys(newUserName);
			System.out.println("Login name entered");
		}
		if(password!=null){	
			String pswd  = password.getAttribute("ng-class").split("'")[3];
			WebElement pswdn = driver.findElement(By.id(pswd));
			pswdn.sendKeys(newUserPassword);
			System.out.println("Password entered");
		}
//		if(userType!=null){	
//			String utype  = userType.getAttribute("ng-class").split("'")[3];
//			WebElement userty = driver.findElement(By.id(utype));
//			userty.sendKeys(typeSelect);
//			System.out.println("User type entered");
//		}
		if(userSecurityRole!=null){	
			String ustype  = userSecurityRole.getAttribute("ng-class").split("'")[3];
			WebElement userRol = driver.findElement(By.id(ustype));
			userRol.sendKeys(roleSelect);
			System.out.println("User security role entered");
		}
		
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].scrollIntoView();", userType);
//		System.out.println("Scrolled to view select user type");
//		Select user = new Select(driver.findElement(By.xpath("//*[@id='user_10']")));
//		user.selectByVisibleText(typeSelect);
//		System.out.println("User Type Selected");
		if(Firstname != null){
			String fname  = Firstname.getAttribute("ng-class").split("'")[3];
			WebElement finame = driver.findElement(By.id(fname));
			finame.sendKeys(firstName);
			System.out.println("First NAme entered");			
		}
		if(Lastname != null){
			String lname  = Lastname.getAttribute("ng-class").split("'")[3];
			WebElement laname = driver.findElement(By.id(lname));
			laname.sendKeys(lastName);
			System.out.println("Last NAme entered");			
		}
//		try{
//			if(userLanguage != null){
//				String  ulan = userLanguage.getAttribute("ng-class").split("'")[3];
//				WebElement ulang = driver.findElement(By.id(ulan));
//				ulang.sendKeys(userLang);
//				System.out.println("User Language entered");			
//			}
//		}catch(NoSuchElementException e){
//			System.out.println("User language not found");
//		}
		
		if(userLanguage.isEnabled()){
			String  ulan = userLanguage.getAttribute("ng-class").split("'")[3];
			WebElement ulang = driver.findElement(By.id(ulan));			
			ulang.sendKeys(userLang);
			System.out.println("User Language entered");			
		}
		if(timezone != null){
			String tz  = timezone.getAttribute("ng-class").split("'")[3];
			WebElement tzone = driver.findElement(By.id(tz));
			tzone.sendKeys(timeZone);
			System.out.println("Time Zone entered");			
		}
		if(Email != null){
			String ema  = Email.getAttribute("ng-class").split("'")[3];
			WebElement emailE = driver.findElement(By.id(ema));
			emailE.sendKeys(email);
			System.out.println("Email entered");			
		}
		saveButton.click();
		System.out.println("Save Clicked");
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS) ;

		if(SuccessMsg.getText().equals("User account successfully created")){
			System.out.println("User added");
			ReturnToUserList.click();
			System.out.println("Return to user list is clicked");				
	        searchUser.sendKeys(newUserName);
			System.out.println("New User entered into search box");
			if(srow.isEnabled()){
				System.out.println("User name found in search");
				return true;
			}			
			else{
				System.out.println("User name not found in search");
				return false;
			}
		}
		else if(ErrorMsg.getText().equals("Login Name already Exists")){
			System.out.println("User already exists and not added");
			return false;
		}
		else
			return false;
		
			
		
	}
	
	public boolean searchUser(String searchusername){
		System.out.println("In search user method");
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("admin_header")));
		adminHeader.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='user_management']/span")));
		users.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='common_list_users']/span")));
		allUsers.click();
		searchUser.sendKeys(searchusername);
		System.out.println("New User entered into search box");
		if(srow!= null){
				System.out.println("Found username in serach user");
				return true;
		}
		else {
			System.out.println("Usrname not found in search user");
			return false;
		}
		 
	}
	 
	public Boolean search() throws Exception{
		System.out.println("In enterprise search method");
		enterpriseSearch.click();
		System.out.println("Search button clicked");
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtSearch-main")));		
		searchInput.sendKeys("*");
		System.out.println("Entered * in Search input");
		if(searchContainer.isDisplayed()){ 
			if(searchcourselist.isDisplayed()){
				//System.out.println("Course name ---"+ courseName.getText());
				//getCourseNames();
	  			System.out.println("Search course is displayed");
	  			return true;
				
			}			
			else{
				System.out.println("Search is not working");
				return false;
			}
				
		}
		else{
			System.out.println("Search is not working");
			return false;
		}
			
	}
	
	public boolean advancedsearchConfig(String appurl) {
		System.out.println("In advanced search method");
		System.out.println("Current URL "+appurl+"core/advancedsearchConfiguration") ;
		driver.get(appurl+"core/advancedsearchConfiguration");
		
		WebElement TogetRows = driver.findElement(By.xpath("//table[@class='table ng-scope ng-table']/tbody"));
		List<WebElement>TotalRowsList = TogetRows.findElements(By.tagName("tr"));
		System.out.println("Total number of Rows in the table are : "+ TotalRowsList.size());
		int r = 0;
		for(int i = 1;i<=TotalRowsList.size();i++ ) {
			WebElement core = driver.findElement(By.xpath("//*[@class='table ng-scope ng-table']/tbody/tr["+i+"]/td[1]"));
			WebElement act = driver.findElement(By.xpath("//table[@class='table ng-scope ng-table']/tbody/tr["+i+"]/td[2]/span"));
			WebElement exp = driver.findElement(By.xpath("//table[@class='table ng-scope ng-table']/tbody/tr["+i+"]/td[3]/span"));
			String coreType= core.getText();
			String actual= act.getText(); 
			String expected=exp.getText();			
			System.out.println("Core type ="+coreType+"actual= "+actual+"expected = "+expected);
			if(actual.equals(expected)) {
				System.out.println("Actual count and expected count matches for Core Type =="+coreType+"=="+actual);
				r++;
			}
			else {
				System.out.println("Actual count and expected count doesnt matche for Core Type =="+coreType);
				System.out.println("Actual Count is "+actual);
				System.out.println("Expected count is"+expected);
				break;							
			}
		}
			if(r==TotalRowsList.size()) {
				System.out.println("Count matches and advanced search works fine");
				return true;
			}
			else {
				System.out.println("Count doesnt matche and advanced search fails");
				return false;				
			}
	}
	
	public void getCourseNames(){
		Dimension s = driver.findElement(By.xpath("//*[@id='divViewActivities']/div/div/div/ul")).getSize();
		System.out.println("sixe of courses"+ ((WebElement) s).getText());
		
	}		
	
	public Boolean uploadFile(String filePath, String actName)throws IOException, AWTException, InterruptedException{
		System.out.println("In upload file method");
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("admin_header")));
		adminHeader.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='learning_management']/span")));
		learningManagement.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='namecount-2256']")));
		activityManagement.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='Administrator_MenuLearningActivies']/span")));
		learninActivities.click();
		driver.switchTo().frame("productPillarFrame");		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='fileUpload_Button']")));
		fileUploadButton.click();
		
//		WebDriver listActivitiesFrame = driver.switchTo().frame("listActivitiesFrame");
//      System.out.println("---"+listActivitiesFrame.getTitle());
		driver.switchTo().frame("listActivitiesFrame");
		
		fileUpload.sendKeys(filePath);
        uploadFile.click();
        System.out.println("Uploadfile clicked");
        nextButton.click();
        Thread.sleep(5000);
        nextButton.click();
        System.out.println("Next button clicked");
        //System.out.println("ActivityName"+actName+objCom.GetTimeStamp());
        activityName.sendKeys(actName);
        System.out.println(activityCode.getAttribute("Value"));
        System.out.println(activityCode.getText());
//        
//        if(activityCode.getAttribute("Value").length() == 0) {
//        	activityCode.sendKeys(actName);
//        } 
        System.out.println(activityCode.getText());
        if(activityCode.getText().length()==0) {
        	activityCode.sendKeys(actName);
        	
        }
        nextButton.click();
        System.out.println("Activity Next button clicked");
        Thread.sleep(3000);
        finalUpload.click();
        System.out.println("Upload final button clicked");
        String msg = alertMsg.getText();
        System.out.println("MSG "+ msg);
        previouslyUpload.click();
        System.out.println("Previously upload button clicked");
        //firstFileCheck.click();        
        System.out.println(status.getText()); 

        while(!(status.getText().equals("IN STAGING"))){
        	System.out.println(status.getText());
        	if(status.getText().equals("FAILED")) {
        		break;        		
        	}
        	Thread.sleep(3000);        	
        }
        System.out.println("After while loop"+status.getText()); 
        if((status.getText().equals("IN STAGING"))){
        	System.out.println(status.getText());
            System.out.println("Staged succesfully");
            driver.switchTo().defaultContent();
            //closeButton.click();
            //System.out.println("Close Button clicked");
            return true;
        }        	
        else
        	return false;
	}
	public boolean fileDelete(){	
		System.out.println("In file delete method");
		driver.switchTo().frame("productPillarFrame");
		driver.switchTo().frame("listActivitiesFrame");		
		previouslyUpload.click();
		System.out.println("Previously uploaded file clicked");
			ch.click();
			if(delete.isEnabled()){
	    		delete.click(); 
	        	System.out.println("Delete clicked");
	        	return true;
	    	}
			else
				return false;				
		
	}
	public Boolean deleteUpload(String deleteFile){
		System.out.println("In Delete upload file method");
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("admin_header")));
		adminHeader.click();
		System.out.println("Admin clicked");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='learning_management']/span")));
		learningManagement.click();
		System.out.println("Learning Management clicked");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='namecount-2256']")));
		activityManagement.click();
		System.out.println("Activity Management clicked");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='Administrator_MenuLearningActivies']/span")));
		learninActivities.click();
		System.out.println("Learning activities clicked");
		driver.switchTo().frame("productPillarFrame");		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='fileUpload_Button']")));
		fileUploadButton.click();
		System.out.println("File upload clicked");
		
//		WebDriver listActivitiesFrame = driver.switchTo().frame("listActivitiesFrame");
//      System.out.println("---"+listActivitiesFrame.getTitle());
		driver.switchTo().frame("listActivitiesFrame");
		
		previouslyUpload.click();
        System.out.println("Previously upload button clicked");
        //driver.manage().
        //WebElement ch=null;
        ArrayList<Integer> arr = new ArrayList<Integer>(); 
        int i =0;
        for(i=1;i<=6;i++){
        	String xpath = "//*[@id='mainContent']/div/div/table/tbody/tr["+i+"]/td[3]/div/a";
        	String xpathactcode = "//*[@id='mainContent']/div/div/table/tbody/tr["+i+"]/td[5]/div";
        	String chkbox = "//*[@id='mainContent']/div/div/table/tbody/tr["+i+"]/td[1]/input";
        	WebElement n = driver.findElement(By.xpath(xpath));
        	WebElement c = driver.findElement(By.xpath(xpathactcode));
        	String act = n.getText();
        	String code = c.getText();
        	if(act.equals(deleteFile)){
        		//arr.add(i);        		
        		WebElement ch = driver.findElement(By.xpath(chkbox));
        		ch.click();
        		break;
        	} 
        	else
        		System.out.println("Not found yet");
        }
//        for(int j=0;j<arr.size();j++){
//        	//int c = arr.get(0);
//        	//*[@id="mainContent"]/div/div/table/tbody/tr[1]/td[1]/input
//        	String chkbox = "//*[@id='mainContent']/div/div/table/tbody/tr["+arr.get(j)+"]/td[1]/input";
//        	WebElement ch = driver.findElement(By.xpath(chkbox));
//        	if(ch.isEnabled())
//        		ch.click();
//        }
        System.out.println("flename checkbox clicked");
    	if(delete.isEnabled()){
    		delete.click(); 
        	System.out.println("Delete clicked");
        	return true;
    	}
    	else 
    		return false;
	}
}
 
