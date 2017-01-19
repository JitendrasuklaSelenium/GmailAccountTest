package com.gmailsignUp.Gmailtest;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
 
@CucumberOptions(
		features = "D://Java//GitRepo//Gmailtest//src//test//java//com//gmailsignUp//Gmailtest//",
        glue = {"com.gmailsignUp.Gmailtest"}
        )
public class testRunner extends AbstractTestNGCucumberTests {
}