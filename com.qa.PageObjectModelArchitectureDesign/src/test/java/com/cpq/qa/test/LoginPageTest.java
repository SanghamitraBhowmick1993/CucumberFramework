package com.cpq.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cpq.qa.base.TestBase;
import com.cpq.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage login;
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initilization();
		login = new LoginPage();
	}
	@Test(priority = 1)
	public void loginPageTitleTest(){
		String title =login.validateLoginPageTitle();
		Assert.assertEquals(title, "Cogmento CRM");
	}
	
	@Test(priority = 2)
		public void salesforceLogoTest(){
			boolean flag = login.validateSalesforceLogo();
			Assert.assertTrue(flag);
		}	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
