package Base;

import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Common_methods.CreateTestNgXML;

public class Initiator {
	public static void main(String[] args) throws Exception{
		CreateTestNgXML.createXml();
		CreateTestNgXML.autoRunXml();		
		
	} 
}


   