package com.crm.qa.Tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.Base.TestBase;
import com.crm.qa.Pages.ContactsPage;
import com.crm.qa.Pages.HomePage;
import com.crm.qa.Pages.LoginPage;
import com.crm.qa.Utils.TestUtils;

public class ContactsPageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	TestUtils utils;

	public ContactsPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException{
		initialization();
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		utils = new TestUtils();
		utils.switchFrame();
		
	}
	
	@DataProvider
	public Object[][] testDataNewContact() {
		utils = new TestUtils();
		Object data[][] = utils.getTestdata("NewContact");
		return data;
	}
	@Test(dataProvider = "testDataNewContact" )
	public void createNewContactTest(String first, String middle, String last, String category, String phone) throws InterruptedException{
		contactspage = homepage.clickOnNewContactsLink();
		contactspage.createNewContact(first, middle, last, category, phone);
		Thread.sleep(3000);
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
