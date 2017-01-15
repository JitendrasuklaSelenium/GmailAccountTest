package com.gmailsignUp.Gmailtest;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.But;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.gmailsignUp.Gmailtest.FunctionLibrary;

public class CucumberTest {
	
	public static FunctionLibrary fl=new FunctionLibrary();
	 
		@Before
		public void before(){
			System.out.println("Before Cucumber test case start.");
		}
		@Given(value = "")
		public void given() throws IOException{
			fl.initData();
			WebDriver driver=fl.initBrowser();
			
			System.out.println("Open Google page.");
			
			driver.get (fl.getProperty("URL"));
			WebElement signup=driver.findElement(fl.getbjectLocator("signup"));
			signup.click();			
		}
		
		@Test
		public void skiptestmethod(){
			System.out.println("SKIP testcase executed");
			throw new SkipException("Skip this test case");		
		}
		
		@When(value = "")
		public void when(){
			
		}
		@Then(value = "")
		public void then(){
			
		}
		@And(value = "")
		public void and(){
			
		}
		@But(value = "")
		public void but(){
			
		}
		
		@After
		public void after(){
			fl.closeBrowser();
			System.out.println("After Cucumber test case start.");
		}

}
