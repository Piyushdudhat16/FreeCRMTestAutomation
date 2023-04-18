package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {

//	// Page Factory - OR object Repository   //span[@class='selectable ']  //button[contains(text(),'Show Filters')]  //div[@id='main-nav']//div[3]
//	
//	////body/div[@id='ui']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]			//span[@class='selectable ']
//	
//	
//	//body/div[@id='ui']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]
//	
//	@FindBy(xpath="//span[@class='selectable ' and contains(text(),Contacts)]")
//	WebElement contactsLabel;
//	
//	@FindBy(xpath="//body/div[@id='ui']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/span[1]")
//	WebElement createNewContactLabel;
//	
//		
////	@FindBy(xpath="//iframe[@id='downloadFrame']//input[@name='first_name']")
////	WebElement firstName;
//	
//	@FindBy(name="first_name") 
//	WebElement firstName;
//	
//	@FindBy(xpath="//input[@name='last_name']")
//	WebElement lastName;
//	
//	@FindBy(xpath="//input[@name='department']")
//	WebElement department;
//	
//	@FindBy(xpath="//button[@class='ui linkedin button']")   //button[@fdprocessedid='daakeb']  //i[@class='save icon']
//	WebElement saveBtn;
//	
//	@FindBy(xpath="//tbody/tr[1]/td[1]/div[1]/label[1]")    /*//tbody/tr[1]/td[1]/div[1]/label[1]*/    ////iframe[@id='downloadFrame']
//	WebElement checkboxClick;
//	
//	
//	//Initializing the page objects
//	
//		public ContactsPage() {
//			PageFactory.initElements(driver, this);
//		}
//		
//		public boolean verifyContactsLabel() {
//			return contactsLabel.isDisplayed();
//		}
//		
//		public boolean verifyCreateNewContactLabel() {
//			return createNewContactLabel.isDisplayed();
//		}
//
//		public void selectContactsByName(String name) {
//			driver.findElement(By.xpath("//*[contains(text(),'"+name+"')]")).click();
//		}
//		
//		
//
//		public void createNewContact(String ftName, String ltname, String dement) {
//		//public void createNewContact(String title) {
//			//Select select = new Select(driver.findElement(By.xpath("//body/div[@id='ui']/div[1]/div[2]/div[2]/div[1]"
//			//		+ "/div[2]/form[1]/div[4]/div[2]/div[1]/div[1]/div[2]/div[3]/span[1]")));
//			// select.selectByVisibleText(title);
//			
//			firstName.sendKeys(ftName);	
//			lastName.sendKeys(ltname);
//			department.sendKeys(dement);
//			
//			saveBtn.click();
//			
//		}
	
	@FindBy(xpath = "//td[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	
	
	
	
//	@FindBy(xpath = "//body[1]/table[2]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[1]/td[1]/form[1]/form[1]/table[1]/tbody[1]/tr[5]/td[1]/input[1]")
//	WebElement firstName;
	
	@FindBy(id="first_name")
	WebElement firstName;
	
	@FindBy(id="surname")
	WebElement lastName;
	
	@FindBy(name="client_lookup")
	WebElement company;
	
	@FindBy(xpath = "//input[@type='submit' and @value='Save']")
	WebElement saveBtn;
	
	
	
	// Initializing the Page Objects:
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean verifyContactsLabel(){
		return contactsLabel.isDisplayed();
	}
	
	
	public void selectContactsByName(String name){
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']"
				+ "//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
	}
	
	
	public void createNewContact(String title, String ftName, String ltName, String comp){
		Select select = new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
		
		firstName.sendKeys(ftName);
		lastName.sendKeys(ltName);
		company.sendKeys(comp);
		saveBtn.click();
		
	}
	
	
	
}

