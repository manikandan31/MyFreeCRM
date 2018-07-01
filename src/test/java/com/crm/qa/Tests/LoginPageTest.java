package com.crm.qa.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.Base.TestBase;
import com.crm.qa.Pages.HomePage;
import com.crm.qa.Pages.LoginPage;

public class LoginPageTest extends TestBase {

	public LoginPage loginpage;
	public HomePage homepage;

	LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		loginpage = new LoginPage();
	}

	@Test
	public void loginPageTitleTest() {
		String title = loginpage.validateLoginPageTile();
		System.out.println(title);
	}
	
	@Test
	public void CRMLogoTest() {
		boolean flag = loginpage.validateCRMLogo();
		Assert.assertTrue(flag);
	}

	@Test (dependsOnMethods= { "CRMLogoTest" , "loginPageTitleTest" })
	public void loginTest() {
		homepage= loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
