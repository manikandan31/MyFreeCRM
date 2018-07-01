package com.crm.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.Base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "/html/body/table[1]/tbody/tr[1]/td/table/tbody/tr/td[1]/font")
	WebElement username;

	@FindBy(xpath = "//*[@id='navmenu']/ul/li[4]/a")
	WebElement contactlink;

	@FindBy(xpath = "//*[@id='navmenu']/ul/li[4]/ul/li[1]/a")
	WebElement newcontactlink;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyUsername() {
		String uname = username.getText();
		uname = uname.replace("User: ", "");
		System.out.println(uname);
		return uname.trim();
	}

	public ContactsPage clickOnContactsLink() {
		contactlink.click();
		return new ContactsPage();
	}

	public ContactsPage clickOnNewContactsLink() {
		Actions action = new Actions(driver);
		action.moveToElement(contactlink).build().perform();
		newcontactlink.click();
		return new ContactsPage();
	}
}
