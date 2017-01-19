package TestApp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.sun.media.jfxmedia.logging.Logger;

public class FunctionLibrary {
	
	
 public static WebDriver driver=null;  	
 public boolean browserAlreadyOpen=false;
 public static Properties SYSPARAM =null;
 public static Properties OBJECTREPOSITORY =new Properties();;
 
 public static String RepositoryFile=null;
 public static Properties propertyFile = new Properties();

 //To Initialize .properties file.
 public void initData() throws IOException{
  SYSPARAM = new Properties();  
  FileInputStream Ist = new FileInputStream(System.getProperty("user.dir")+"//src//test//java//com//gmailsignUp//Gmailtest//SYSPARAM.properties");
  SYSPARAM.load(Ist);  
  
 }
 
 public WebDriver initBrowser(){
  //Check If browser Is already opened during previous test execution.
  if(!browserAlreadyOpen){
   //Read value of 'BrowserToTestIn' key from SYSPARAM.properties file.
   //If key value Is MFF then execute If statement
   //If key value Is CHRM then execute else statement.	 
   if(SYSPARAM.getProperty("BrowserToTestIn").equals("MFF")){
    driver = new FirefoxDriver();   
   }else if(SYSPARAM.getProperty("BrowserToTestIn").equals("CHRM")){
    //Write lines to open chrome browser.
	   String exepath="C:\\chromedriver.exe";
	   System.setProperty("webdriver.chrome.driver", exepath);
    driver = new ChromeDriver();
   }else if(SYSPARAM.getProperty("BrowserToTestIn").equals("IE")){
	    //Write lines to open IE browser.
	   String exepath="C:\\IEDriverServer.exe";	   
	   System.setProperty("webdriver.ie.driver", exepath);
	    driver = new InternetExplorerDriver();
	   }
  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
  driver.manage().window().maximize();
  //At last browserAlreadyOpen flag will becomes true to not open new browser when start executing next test.
  browserAlreadyOpen=true;  
  }
return driver;
 } 
  //To Close Browser
 public void closeBrowser(){
  driver.quit();
  browserAlreadyOpen=false;
 } 

public void setProperty(String key,String value) throws IOException{
	OutputStream outputObjRepo= new FileOutputStream(System.getProperty("user.dir")+"//src//test//java//com//gmailsignUp//Gmailtest//SYSPARAM.properties");
	SYSPARAM.setProperty(((key.toUpperCase()).trim()),value);
	SYSPARAM.store(outputObjRepo, "Uploded Object "+key+" with value "+value+".");
	
}

public String getProperty(String key) throws IOException{
	FileInputStream inputObjRepo = new FileInputStream(System.getProperty("user.dir")+"//src//test//java//com//gmailsignUp//Gmailtest//SYSPARAM.properties");
	SYSPARAM.load(inputObjRepo);
	
	return SYSPARAM.getProperty((key.toUpperCase()).trim());
	
}
	
 
	public By getbjectLocator(String locatorName) throws IOException
	{
		FileInputStream stream=new FileInputStream(System.getProperty("user.dir")+"//src//test//java//com//gmailsignUp//Gmailtest//OBJECTREPOSITORY.properties");
		OBJECTREPOSITORY.load(stream);
		System.out.println("Searching webelement "+locatorName.toString());
		String locatorProperty = OBJECTREPOSITORY.getProperty((locatorName.toUpperCase()).trim());		
		String locatorType = locatorProperty.split("::")[0];		
		String locatorValue = locatorProperty.split("::")[1];
 
		By locator = null;
		switch((locatorType.toUpperCase()).trim())
		{
		case "ID":
			locator = By.id(locatorValue.trim());
			break;
		case "NAME":
			locator = By.name(locatorValue.trim());
			break;
		case "CSSSELECTOR":
			locator = By.cssSelector(locatorValue.trim());
			break;
		case "LINKTEXT":
			locator = By.linkText(locatorValue.trim());
			break;
		case "PARTIALLINKTEXT":
			locator = By.partialLinkText(locatorValue.trim());
			break;
		case "TAGNAME":
			locator = By.tagName(locatorValue.trim());
			break;
		case "XPATH":
			locator = By.xpath(locatorValue.trim());
			break;
		}
		System.out.println("Found webelement "+locatorName.toString());
		return locator;
	 }
	

	
}
