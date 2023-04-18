package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	// Page Factory - OR object Repository
//	
//	@FindBy(xpath="//span[contains(text(),'Deals Unbeaten')]")         
//	WebElement userNameLabel;
//	
//	@FindBy(xpath="//div[@id='main-nav']//div[3]")      	//span[contains(text(),'Contacts')]
//	WebElement contactsLink;
//	
//	@FindBy(xpath ="//body/div[@id='ui']/div[1]/div[1]/div[5]/a[1]/span[1]") ////div[@id='main-nav']//div[5]
//	WebElement dealsLink;
//	
//	@FindBy(xpath="//a//span[contains(text(),'Tasks')]")	 //div[@id='main-nav']//div[6]
//	WebElement tasksLink;
//	
//	@FindBy(xpath="//button[@class='ui linkedin button' and contains(text(),'Save')]")    
//	WebElement createNewContactBtn;
//	
//	//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/a[1]/button[1]
//	
//	
//	//Initializing the page objects 
//	
//		public HomePage() {
//			PageFactory.initElements(driver, this);
//		}
//	
//	
//		// Actions: 
//		
//		public String veryfyHomePageTitle() {
//			return driver.getTitle();
//		}
//		
//		public boolean verifyCorrectUserName() {
//			return userNameLabel.isDisplayed();
//			
//		}
//		
//		public ContactsPage clickOnContactsLink() {
//			contactsLink.click();
//			return new ContactsPage();
//		}
//		
//		
//		public DealsPage clickOnDealsLink() {
//			dealsLink.click();
//			return new DealsPage();
//		}
//		
//		public TasksPage clickOnTasksLink() {
//			tasksLink.click();
//			return new TasksPage();
//		}
//	
//		public void clickOnCreateNewContactBtnLink() {
//			Actions action = new Actions(driver);
//			action.moveToElement(contactsLink).build().perform();
//			createNewContactBtn.click();
//			
//		}
	
	@FindBy(xpath = "//td[contains(text(),'User: Deals Unbeaten')]")
	@CacheLookup
	WebElement userNameLabel;

	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement newContactLink;
	

	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement dealsLink;

	@FindBy(xpath = "//a[contains(text(),'Tasks')]")
	WebElement tasksLink;

	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	
	public boolean verifyCorrectUserName(){
		return userNameLabel.isDisplayed();
	}
	
	public ContactsPage clickOnContactsLink(){
		contactsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink(){
		dealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTasksLink(){
		tasksLink.click();
		return new TasksPage();
	}
	
	public void clickOnNewContactLink(){
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContactLink.click();
		
	}
	
	
}
