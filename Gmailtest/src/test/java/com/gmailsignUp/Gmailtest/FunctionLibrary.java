package com.gmailsignUp.Gmailtest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FunctionLibrary {
	
	
 public static WebDriver driver=null;  	
 public boolean browserAlreadyOpen=false;
 public static Properties SYSPARAM =null;
 
 //To Initialize .properties file.
 public void initData() throws IOException{
  SYSPARAM = new Properties();
  FileInputStream Ist = new FileInputStream(System.getProperty("user.dir")+"//src//com//gmailsignUp//Gmailtest//SYSPARAM.properties");
  SYSPARAM.load(Ist);
  System.out.println(SYSPARAM.getProperty("BrowserToTestIn"));
 }
 
 public WebDriver initBrowser(){
  //Check If browser Is already opened during previous test execution.
  if(!browserAlreadyOpen){
   //Read value of 'BrowserToTestIn' key from SYSPARAM.properties file.
   //If key value Is MFF then execute If statement
   //If key value Is CHRM then execute else statement.
	  System.out.println(SYSPARAM.getProperty("BrowserToTestIn"));
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
	   System.setProperty("webdriver.IE.driver", exepath);
	    driver = new ChromeDriver();
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



}
