package com.gmailsignUp.Gmailtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;



public class SignUpProcessTest {
	 
	//static WebDriverWait wait=new WebDriverWait(driver, 10);
	
	@Test	
	public static void OpenBrowser(){
		String exepath="C:\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exepath);
		WebDriver driver =new ChromeDriver();
		System.out.println("Open Google page.");
		driver.get ("https://accounts.google.com/");
		driver.manage().window().maximize();
		WebElement signup=driver.findElement(By.xpath("//*[@id='link-signup']/a"));
		signup.click();
		WebElement CreatepageMessage=driver.findElement(By.xpath("//*[@id='wrapper']/div[2]/h1"));
		Assert.assertEquals("Create your Google Account", CreatepageMessage.getText());
		WebElement FirstName=driver.findElement(By.id("FirstName"));
		
		System.out.println("Start filling SignUp form............");
		FirstName.sendKeys("QATester01_FirstName");
		WebElement LastName=driver.findElement(By.id("LastName"));
		LastName.sendKeys("QATester01_LastName");
		
		System.out.println("Createing new UserID.");
		WebElement GmailAddress=driver.findElement(By.id("GmailAddress"));
		GmailAddress.sendKeys("JitendrakumarshuklaSelenium");
		
		System.out.println("Createing new Password.");
		WebElement Passwd=driver.findElement(By.id("Passwd"));
		Passwd.sendKeys("QATesterPasswd");
		WebElement PasswdAgain=driver.findElement(By.id("PasswdAgain"));
		PasswdAgain.sendKeys("QATesterPasswd");

		System.out.println("Provide DOB.");
		WebElement BirthMonth=driver.findElement(By.id("BirthMonth"));
//		Select selectBirthMonth = new Select(BirthMonth);
//		selectBirthMonth.deselectAll();
//		selectBirthMonth.selectByVisibleText("July");
		BirthMonth.click();// //*[@id=":6"]/div
		
		driver.findElement(By.xpath("//td[@id='BirthMonth']/span[text()='July']")).click();
		
		WebElement birthday=driver.findElement(By.id("birthday-placeholder"));
		birthday.sendKeys("19");
		WebElement BirthYear=driver.findElement(By.id("BirthYear"));
		BirthYear.sendKeys("1991");
		
		System.out.println("Select Gender.");
		WebElement Gender=driver.findElement(By.id("Gender"));
		Select selectGender = new Select(Gender);
		selectGender.selectByValue("Male");

		WebElement RecoveryPhoneNumber=driver.findElement(By.id("RecoveryPhoneNumber"));
		RecoveryPhoneNumber.sendKeys("1991");
		WebElement RecoveryEmailAddress=driver.findElement(By.id("RecoveryEmailAddress"));
		RecoveryEmailAddress.sendKeys("abc@gmail.com");
		WebElement submitbutton=driver.findElement(By.id("submitbutton"));
		submitbutton.click();

		
	}

}