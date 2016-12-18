package com.gmailsignUp.Gmailtest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SignUpProcessTest {
	
	@Test	
	public static void OpenBrowser(){
		String exepath="C:\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exepath);
		WebDriver driver =new ChromeDriver();
		driver.get ("https://accounts.google.com/");
	}

}