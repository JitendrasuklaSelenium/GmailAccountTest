package com.gmailsignUp.Gmailtest;

import cucumber.api.PendingException;
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

import TestApp.FunctionLibrary;

public class GmailSignUp {
	

	@Given("^I have a \"([^\"]*)\" page$")
	public void i_have_a_page(String arg1) throws Throwable {
	    System.out.println(" in Given :"+arg1);
		System.out.println("Cucmber:--Google page Opened. "+arg1);			
	}

	@When("^I click on \"([^\"]*)\" link\\.$")
	public void i_click_on_link(String arg1) throws Throwable {
		System.out.println(" in When :"+arg1);
//	    throw new PendingException();
	}

	@Then("^It redirect to \"([^\"]*)\" Page\\.$")
	public void it_redirect_to_Page(String arg1) throws Throwable {
		System.out.println(" in Then :"+arg1);
//	    throw new PendingException();
	}

	@And("^\"([^\"]*)\" page tile is there\\.$")
	public void page_tile_is_there(String arg1) throws Throwable {
		System.out.println(" in And :"+arg1);
//	    throw new PendingException();
	}

	@But("^We still need to fill the \"([^\"]*)\" form\\.$")
	public void we_still_need_to_fill_the_form(String arg1) throws Throwable {
		System.out.println(" in But :"+arg1);
//	    throw new PendingException();
	}

}
