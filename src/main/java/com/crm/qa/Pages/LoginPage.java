package com.crm.qa.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.Base.TestBase;

public class LoginPage extends TestBase {
	
	//Page Factory - Object Repository Storing all elements in this page:
	@FindBy (name="username")
	WebElement username;
	
	@FindBy (name="password")
	WebElement password;
	
	@FindBy (xpath="//*[@id=\"loginForm\"]/div/div/input")
	WebElement loginbutton;
	
	@FindBy (xpath="/html/body/div[2]/div/div[1]/a/img")
	WebElement crmlogo;
	
	// Initializing all the objects created in this page
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions to be performed in this page
	public String validateLoginPageTile() {
		return driver.getTitle();
	}

	public Boolean validateCRMLogo() {
		return crmlogo.isDisplayed();
	}
	
	public HomePage login(String uname, String pwd) {
		username.sendKeys(uname);
		password.sendKeys(pwd);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", loginbutton);
		return new HomePage();
	}
	
	
	
}
