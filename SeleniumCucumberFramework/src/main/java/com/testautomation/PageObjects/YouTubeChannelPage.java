package com.testautomation.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class YouTubeChannelPage {
	
	WebDriver driver;
	public YouTubeChannelPage(WebDriver driver)
	{
	this.driver=driver;
	PageFactory.initElements(driver, this);		
	}
	
	@FindBy(how=How.LINK_TEXT,using="Selenium Java TestNG Tutorials - Bakkappa N")
     public WebElement SearchTextbox;
	
	public String getTitle() throws InterruptedException {
		Thread.sleep(1000);
		return driver.getTitle();
		}


}
