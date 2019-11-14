package com.testautomation.StepDef;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.testautomation.Listeners.ExtentReportListener;
import com.testautomation.PageObjects.YouTubeChannelPage;
import com.testautomation.PageObjects.YouTubeResultsPage;
import com.testautomation.PageObjects.YoutubeSearchPage;
import com.testautomation.Utility.BrowserUtility;
import com.testautomation.Utility.PropertiesFileReader;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class YoutubeChannelValidation extends ExtentReportListener {
	PropertiesFileReader obj=new PropertiesFileReader();
	private WebDriver driver; 
	@Given("^Open Chrome browser with URL$")
	public void open_Chrome_browser_with_URL() throws IOException, InterruptedException
	
	{  
		ExtentTest logInfo=null;
		try {
			test=extent.createTest(Feature.class,"Youtube channel name validation");
			test=test.createNode(Scenario.class,"Youtube channel name validations");
			logInfo=test.createNode(new GherkinKeyword("Given"),"Open Chrome browser with URL");
			driver.quit();
			Properties properties=obj.getProperty();
			driver= BrowserUtility.OpenBrowser(driver, properties.getProperty("browser.name"), properties.getProperty("browser.baseURL"));
			logInfo.pass("Opened chrome browser and entered url");
			logInfo.addScreencastFromPath(captureSreenShot(driver));
		}
		catch(AssertionError| Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}	    
	}
	@When("^Search selenium tutorial$")
	public void search_selenium_tutorial() throws Throwable 
	{	
		ExtentTest logInfo=null;
		try {
									
			logInfo=test.createNode(new GherkinKeyword("When"), "search_selenium_tutorial");
			new YoutubeSearchPage(driver).NavigateToResultPage("selenium by bakkappa n");
			logInfo.pass("Searching selenium tutorial");
			logInfo.addScreencastFromPath(captureSreenShot(driver));
			
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);			
		}
		
		
	}

	@When("^Search selenium tutorial \"([^\"]*)\"$" )
	public void search_selenium_tutorial(String searchString) throws Throwable 
	{
		new YoutubeSearchPage(driver).NavigateToResultPage(searchString);
	}
	

	@When("^Click on channel name$")
	public void click_on_channel_name() throws InterruptedException {
	   ExtentTest logInfo=null;
	   try {
		   logInfo=test.createNode(new GherkinKeyword("When"),"Click on channel name");	
		   new YouTubeResultsPage(driver).NavigateToChannelName();
		   logInfo.addScreencastFromPath(captureSreenShot(driver));	 	
	       
	   } catch (AssertionError | Exception e) {
		testStepHandle("FAIL", driver, logInfo,e);		
	}   
	}

	@Then("^Validate channel name$")
	public void validate_channel_name() throws InterruptedException {
		ExtentTest logInfo=null; 
		try {
		
		logInfo=test.createNode(new GherkinKeyword("Then"),"Validate Channel name");
		String expectedChannelName="Selenium Java TestNG Tutorials - Bakkappa N - YouTube";
		String actualChannelName=new YouTubeChannelPage(driver).getTitle();
		Assert.assertEquals(actualChannelName, expectedChannelName,"Channel names are not matching");
		logInfo.pass("Validated channel title");
		logInfo.addScreencastFromPath(captureSreenShot(driver));
		driver.quit();
	}		catch(AssertionError| Exception e){
			testStepHandle("FAIL",driver,logInfo,e);
		}
		
	}

}
