package com.gmailsignUp.Gmailtest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.gmailsignUp.Gmailtest.FunctionLibrary;


public class SignUpProcessTest {
	 
	//static WebDriverWait wait=new WebDriverWait(driver, 10);
	static FunctionLibrary fl=new FunctionLibrary();
	@Test	
	public static void TestSignup_wrongNumber() throws IOException {
//		String exepath="C:\\chromedriver.exe";
//		System.setProperty("webdriver.chrome.driver", exepath);
//		WebDriver driver =new ChromeDriver();
		fl.initData();
		WebDriver driver=fl.initBrowser();
		
		System.out.println("Open Google page.");
		
		driver.get (fl.getProperty("URL"));
		driver.manage().window().maximize();
		WebElement signup=driver.findElement(fl.getbjectLocator("signup"));
		signup.click();
		WebElement CreatepageMessage=driver.findElement(fl.getbjectLocator("CreatepageMessage"));
		Assert.assertEquals("Create your Google Account", CreatepageMessage.getText());
				
		System.out.println("Start filling SignUp form............");
		WebElement FirstName=driver.findElement(fl.getbjectLocator("FirstName"));
		FirstName.sendKeys("QATester01_FirstName");
		WebElement LastName=driver.findElement(fl.getbjectLocator("LastName"));
		LastName.sendKeys("QATester01_LastName");
		
		System.out.println("Createing new UserID.");
		WebElement GmailAddress=driver.findElement(fl.getbjectLocator("GmailAddress"));
		GmailAddress.sendKeys("JitendrakumarshuklaSelenium");
		
		System.out.println("Createing new Password.");
		WebElement Passwd=driver.findElement(fl.getbjectLocator("Passwd"));
		Passwd.sendKeys("QATesterPasswd");
		WebElement PasswdAgain=driver.findElement(fl.getbjectLocator("PasswdAgain"));
		PasswdAgain.sendKeys("QATesterPasswd");

		System.out.println("Provide DOB.");
		WebElement BirthMonth=driver.findElement(fl.getbjectLocator("BirthMonth"));
		BirthMonth.click();
//		driver.findElement(By.xpath("//*[@id=':7']/div")).click();
		driver.findElement(fl.getbjectLocator("July")).click();
				
		
		WebElement birthday=driver.findElement(fl.getbjectLocator("BirthDay"));
		birthday.sendKeys("19");
		WebElement BirthYear=driver.findElement(fl.getbjectLocator("BirthYear"));
		BirthYear.sendKeys("1991");
		
		System.out.println("Select Gender.");
		WebElement Gender=driver.findElement(fl.getbjectLocator("Gender"));
		Gender.click();	
		driver.findElement(fl.getbjectLocator("Male")).click();

		WebElement RecoveryPhoneNumber=driver.findElement(fl.getbjectLocator("RecoveryPhoneNumber"));
		RecoveryPhoneNumber.sendKeys("1991");
		WebElement RecoveryEmailAddress=driver.findElement(fl.getbjectLocator("RecoveryEmailAddress"));
		RecoveryEmailAddress.sendKeys("abc@gmail.com");
		WebElement submitbutton=driver.findElement(fl.getbjectLocator("submitbutton"));
		submitbutton.click();

		//fl.closeBrowser();
	}

}