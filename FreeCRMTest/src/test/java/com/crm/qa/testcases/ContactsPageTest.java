package com.crm.qa.testcases;

//import org.openqa.selenium.By;
//import org.testng.Assert;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//
//import com.crm.qa.base.TestBase;
//import com.crm.qa.pages.ContactsPage;
//import com.crm.qa.pages.DealsPage;
//import com.crm.qa.pages.HomePage;
//import com.crm.qa.pages.LoginPage;
//import com.crm.qa.pages.TasksPage;
//import com.crm.qa.util.TestUtil;

import java.io.IOException;

import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{

//	LoginPage loginPage;
//	HomePage homePage;
//	ContactsPage contactsPage;
//	DealsPage dealsPage;
//	TasksPage tasksPage;
//	TestUtil testUtil;
//	
//	public ContactsPageTest(){
//		super();
//	}
//	
//	@BeforeMethod
//	public void setUp(){
//		initialization();
//		contactsPage = new ContactsPage();
//		dealsPage = new DealsPage();
//		tasksPage = new TasksPage();
//		loginPage = new LoginPage();
//		testUtil = new TestUtil();
//		homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
//		//testUtil.switchToFrame();
//		contactsPage = homePage.clickOnContactsLink();
//	}
//	
//	@Test(priority=1)
//	public void verifyContactPageLabelTest() {
//		//contactsPage = homePage.clickOnContactsLink();
//		Assert.assertTrue(contactsPage.verifyContactsLabel(),"contacts label is missing on the page");
//	}
//	
//	@Test(priority=2)
//	public void selectSingleContactsTest() {
//		contactsPage = homePage.clickOnContactsLink();
//		//testUtil.switchToFrame();
//		//driver.findElement(By.xpath("//span[contains(text(),'Deals Unbeaten')]")).click();
//		
//		testUtil.switchToFrame();
//		driver.findElement(By.xpath("//a[contains(text(),'Jay Raval')]")).click();
//		//contactsPage.selectContactsByName("Paul Munro");
//	}
//	
////	@Test(priority=3)
////	public void selectMultipleContactsTest() {
//// 		contactsPage.selectContactsByName("Mark Smith");
//// 		contactsPage.selectContactsByName("Paul Munro");
////	}
//	
//	@Test(priority=3)
//	public void validateCreateNewContact() {
//		
//		contactsPage = homePage.clickOnContactsLink();
//		//testUtil.switchToFrame();
//		driver.findElement(By.xpath("//button[@class='ui linkedin button' and contains(text(),'Create')]")).click();
//		//Assert.assertTrue(contactsPage.verifyCreateNewContactLabel(),"contacts label is missing on the page");
//		testUtil.switchToFrame();
//		contactsPage.createNewContact("Jjjjjhoy", "Smith", "Manager");
//		
//		driver.findElement(By.xpath("//button[@class='ui linkedin button']")).click();
//		//homePage.clickOnCreateNewContactBtnLink();
//	}
//	
//	@AfterMethod
//	public void tearDown() {
//		driver.quit();
//	}
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	String sheetName = "contacts";
	
	   
	public ContactsPageTest(){
			super();
			
	}
	
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		
		initialization();
		testUtil = new TestUtil();
		contactsPage = new ContactsPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		//TestUtil.runTimeInfo("error", "login successful");
		testUtil.switchToFrame();
		contactsPage = homePage.clickOnContactsLink();
	}
	
	@Test(priority=1)
	public void verifyContactsPageLabel(){
		Assert.assertTrue(contactsPage.verifyContactsLabel(), "contacts label is missing on the page");
	}
	
	@Test(priority=2)
	public void selectSingleContactsTest(){
		contactsPage.selectContactsByName("Mark Wood");
	}
	
	@Test(priority=3)
	public void selectMultipleContactsTest(){
		contactsPage.selectContactsByName("Mark Wood");
		contactsPage.selectContactsByName("Mukta Sharma");

	}
	
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	
	@Test(priority=4, dataProvider="getCRMTestData")
	public void validateCreateNewContact(String title, String firstName, String lastName, String company){
		homePage.clickOnNewContactLink();
		//contactsPage.createNewContact("Mr.", "Tom", "Peter", "Google");
		contactsPage.createNewContact(title, firstName, lastName, company);
		
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
}
