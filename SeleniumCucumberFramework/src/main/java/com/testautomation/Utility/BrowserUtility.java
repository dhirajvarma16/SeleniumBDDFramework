package com.testautomation.Utility;

import java.util.Collections;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserUtility {

	public static WebDriver OpenBrowser(WebDriver driver,String browserName,String url) throws InterruptedException {
		if(browserName.equals("Chrome")){
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dhiraj varma\\Desktop\\Selenium\\chromedriver.exe"); 
			ChromeOptions options = new ChromeOptions(); 
			options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
			options.setExperimentalOption("useAutomationExtension", false);
			driver = new ChromeDriver(options); 
					//driver=new ChromeDriver();
					driver.manage().window().maximize();
					driver.get(url);
					//options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"}); 
					Thread.sleep(500);
					return driver;
		}else
			if(browserName.equals("Firefox")){
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dhiraj varma\\Desktop\\Selenium\\chromedriver.exe"); 
						driver=new ChromeDriver();
						driver.manage().window().maximize();
						driver.get(url);
						Thread.sleep(500);
						return driver;
			}
			else if(browserName.equals("IE")){
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dhiraj varma\\Desktop\\Selenium\\chromedriver.exe"); 
				driver=new ChromeDriver();
				driver.manage().window().maximize();
				driver.get(url);
				Thread.sleep(500);
				return driver;
	}
		return null;		
	}
	
	
}
