package com.crm.qa.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.Base.TestBase;
import com.crm.qa.Pages.ContactsPage;
import com.crm.qa.Pages.HomePage;
import com.crm.qa.Pages.LoginPage;
import com.crm.qa.Utils.TestUtils;

public class HomePageTest extends TestBase{

	LoginPage loginpage;
	HomePage homepage;
	TestUtils utils;
	ContactsPage contactspage;
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		utils = new TestUtils();
		utils.switchFrame();
		//contactspage = homepage.clickOnContactsLink();
	}
	
	@Test
	public void verifyHomepageUsername(){
		String uname = homepage.verifyUsername();
		System.out.println(uname);
		Assert.assertEquals("Naveen K", uname);
	}
	
	@Test
	public void verifyContactLinkTest(){
		homepage.clickOnContactsLink();
	}
	
	@Test
	public void newContactsTest(){
		contactspage = homepage.clickOnNewContactsLink();
	}
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}

