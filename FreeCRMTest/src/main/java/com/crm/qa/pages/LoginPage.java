package com.crm.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
//	// Page Factory - OR object Repository
//	
//	@FindBy(xpath="//input[@value='Login']")
//	WebElement cLoginBtn;
//	
//	@FindBy(xpath="//input[@name='username']")
//	WebElement username;
//	
//	@FindBy(xpath="//input[@name='password']")
//	WebElement password;
//	
//	@FindBy(xpath="//html[1]/body[1]/div[2]/div[1]/div[3]/form[1]/div[1]/div[1]/input[1]]")
//	WebElement loginBtn;
//	
////	@FindBy(xpath="//div[contains(text(),'Login')]")
////	WebElement loginBtn;
//	
//	@FindBy(xpath="//span[contains(text(),'sign up')]")
//	WebElement signUpBtn;
//	
//	@FindBy(xpath="/html[1]/body[1]/div[2]/div[1]/div[1]/a[1]/img[1]")
//	WebElement crmLogo;
//	
//	//Initializing the page objects
//	
//	public LoginPage() {
//		PageFactory.initElements(driver, this);
//	}
//	
//	// Actions:
//	
//	public String validateLoginPageTitle() {
//		return driver.getTitle();
//	}
//	
//	public boolean validateCRMImage() {
//		return crmLogo.isDisplayed();	
//	}
//	
//	public HomePage login(String eml, String pwd) {
//		cLoginBtn.click();
//		username.sendKeys(eml);
//		password.sendKeys(pwd);
//		loginBtn.click();
//		
//		return new HomePage();
//	}
	
	
	//Page Factory - OR:
		@FindBy(name="username")
		WebElement username;
		
		@FindBy(name="password")
		WebElement password;
		
		@FindBy(xpath="//input[@type='submit']")
		WebElement loginBtn;
		
		@FindBy(xpath="//button[contains(text(),'Sign Up')]")
		WebElement signUpBtn;
		
		@FindBy(xpath="//img[contains(@class,'img-responsive')]")
		WebElement crmLogo;
		
		//Initializing the Page Objects:
		public LoginPage(){
			PageFactory.initElements(driver, this);
		}
		
		//Actions:
		public String validateLoginPageTitle(){
			return driver.getTitle();
		}
		
		public boolean validateCRMImage(){
			return crmLogo.isDisplayed();
		}
		
		public HomePage login(String un, String pwd){
			username.sendKeys(un);
			password.sendKeys(pwd);
			//loginBtn.click();
			    	JavascriptExecutor js = (JavascriptExecutor)driver;
			    	js.executeScript("arguments[0].click();", loginBtn);
			    	
			return new HomePage();
		}
	
	
}
