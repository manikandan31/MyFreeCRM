package com.crm.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.Base.TestBase;

public class ContactsPage extends TestBase {

	@FindBy(id = "first_name")
	WebElement firstname;

	@FindBy(id = "middle_initial")
	WebElement middlename;

	@FindBy(id = "surname")
	WebElement surname;

	@FindBy(xpath = "//select[@name='category']")
	WebElement category_dropdown;

	@FindBy(id = "phone")
	WebElement phoneno;

	@FindBy(xpath = "//input[@name='receive_email' and @value ='N' ")
	WebElement recievemail_no;

	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}

	public void createNewContact(String fname, String middle, String last, String category, String phone)
			throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(firstname));
		firstname.sendKeys(fname);
		middlename.sendKeys(middle);
		surname.sendKeys(last);

		Select select = new Select(category_dropdown);
		select.selectByValue(category);
		phoneno.sendKeys(phone);
		Thread.sleep(2000);
	}

}
