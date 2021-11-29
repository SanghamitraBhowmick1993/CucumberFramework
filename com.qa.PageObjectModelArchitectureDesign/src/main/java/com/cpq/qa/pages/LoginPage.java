package com.cpq.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cpq.qa.base.TestBase;

public class LoginPage extends TestBase{
	//Page Factory or OR:
		@FindBy(name="email") WebElement usernm;
		@FindBy(name="password") WebElement passwrd;
		@FindBy(xpath="//*[text()='Login']") WebElement logIn;
		@FindBy(xpath="//div[text()='Classic FreeCRM or CRMPro User? Login to ']") WebElement crmLogo;
		@FindBy(id="forgot_password_link") WebElement forgotpwd;
		
		//initializing page objects
		public LoginPage(){
			PageFactory.initElements(driver, this);
		}
		//Actions:
		public String validateLoginPageTitle(){
			return driver.getTitle();
		}
		public boolean validateSalesforceLogo(){
			return crmLogo.isDisplayed();
		}
		
		

}
