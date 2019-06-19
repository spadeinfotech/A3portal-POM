package com.A3Portal.TestPages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.A3Portal.base.TestBase;

public class LoginPage extends TestBase{
	
	//Page Factory - OR:
	
	
	
	@FindBy(id="inputEmail")
	WebElement username;
	
	
	@FindBy(id="inputPassword")
	WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement loginbutton;
	
	
	
	@FindBy(xpath="//button[contains(text(),'Sign Up')]")
	WebElement signUpBtn;
	
	@FindBy(xpath="//a[contains(@class,'brand-')]")
	WebElement crmLogo;
	
	@FindBy(xpath="//a[@class='btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left']")
	WebElement clicklogin;
	

	
	
	//Initializing the Page Objects:
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	

	
	
	//Actions:
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public boolean validateCCImage(){
		return crmLogo.isDisplayed();
	}
	
	public void clickOnlogin(){
		loginbutton.click();
	}
	
	public HomePage login(String un, String pwd){
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginbutton.click();
		    	//JavascriptExecutor js = (JavascriptExecutor)driver;
		    	//js.executeScript("arguments[0].click();", loginBtn);
		    	
		return new HomePage();
	}
	
	
	
	
}
