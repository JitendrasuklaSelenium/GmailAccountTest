package com.gmailsignUp.Gmailtest;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
 
@CucumberOptions(features = "src/test/resources/features/GmailSignUp.feature",
        glue = "uk.co.automatictester.jwebfwk.glue",
        format = {"html:format"})
public class testRunner extends AbstractTestNGCucumberTests {
}

