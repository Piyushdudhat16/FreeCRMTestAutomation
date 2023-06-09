package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {

//	LoginPage loginPage;
//	HomePage homePage;
//	TestUtil testUtil;
//	ContactsPage contactsPage;
//	DealsPage dealsPage;
//	TasksPage tasksPage;
//	
//	public HomePageTest() {
//		super();
//	}
//	
//	//test cases should be separated -- independent with each other 
//	//before each test cases -- launch the browser and login 
//	//@test--Execute test case
//	//after each test case -- close the browser
//		
//	@BeforeMethod
//	public void setUp() {
//		initialization();
//		testUtil = new TestUtil();
//		contactsPage = new ContactsPage();
//		dealsPage = new DealsPage();
//		tasksPage = new TasksPage();
//		loginPage = new LoginPage();
//		homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
//	}
//	
//	@Test(priority=1)
//	public void verifyHomePageTitleTest() {
//		String homePageTitle = homePage.verifyHomePageTitle();
//		Assert.assertEquals(homePageTitle, "CRMPRO", "Home page title not matched");
//	}
//	
//	@Test(priority=2)
//	public void verifyUserNameTest() {
//		//testUtil.switchToFrame();
//		Assert.assertTrue(homePage.verifyCorrectUserName());	
//	}
//	
//	@Test(priority=3)
//	public void verifyContactsLinkTest() {
//		contactsPage = homePage.clickOnContactsLink();
//		
//	}
//	
//	@Test(priority=4)
//	public void verifyDealsLinkTest() {
//		dealsPage = homePage.clickOnDealsLink();
//	}
//	
//	@Test(priority=5)
//	public void verifyTasksLinkTest() {
//		tasksPage = homePage.clickOnTasksLink();
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

	public HomePageTest() {
		super();
	}

	//test cases should be separated -- independent with each other
	//before each test case -- launch the browser and login
	//@test -- execute test case
	//after each test case -- close the browser
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		contactsPage = new ContactsPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@Test(priority=1)
	public void verifyHomePageTitleTest(){
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Free CRM - CRM software for customer relationship management, sales, and support.",
				"Home page title not matched");
	}
	
	@Test(priority=2)
	public void verifyUserNameTest(){
		testUtil.switchToFrame();
		Assert.assertTrue(homePage.verifyCorrectUserName());
	}
	
	@Test(priority=3)
	public void verifyContactsLinkTest(){
		testUtil.switchToFrame();
		contactsPage = homePage.clickOnContactsLink();
	}
	
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
