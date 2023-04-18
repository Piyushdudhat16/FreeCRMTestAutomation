package com.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;



public class LoginTest {
	
	WebDriver driver;
	Logger log = Logger.getLogger(LoginTest.class);
	
	@BeforeMethod
	public void setup() {
		
		log.info("****************************** Starting test cases execution  *****************************************");

		System.setProperty("webdriver.gecko.driver", "C:\\Users\\impiy\\OneDrive\\Desktop\\QA\\geckodriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		log.info("Launching Firefox browser");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://classic.crmpro.com/");	
		log.info("Entering into application URL");
		log.warn("Hey this is just warning messege");
		log.fatal("This is just fatal error messege");
	}
	
	@Test(priority=1)
	public void freeCrmTitleTest() {
	log.info("****************************** starting test case *****************************************");
	log.info("****************************** freeCrmTitleTest *****************************************");
	String title = driver.getTitle();
	System.out.println(title);
	Assert.assertEquals(title, "Free CRM - CRM software for customer relationship management, sales, and support.");
	log.info("****************************** ending test case *****************************************");
	log.info("****************************** freeCrmTitleTest *****************************************");
	}
	
	@Test(priority=2)
	public void freecrmLogoImageTest() {
		log.info("****************************** starting test case *****************************************");
		log.info("****************************** freemCRMLogoTest *****************************************");
		boolean flag = driver.findElement(By.xpath("//img[contains(@class,'img-responsive')]")).isDisplayed();
		Assert.assertTrue(flag);
		log.info("****************************** ending test case *****************************************");
		log.info("****************************** freemCRMLogoTest *****************************************");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
