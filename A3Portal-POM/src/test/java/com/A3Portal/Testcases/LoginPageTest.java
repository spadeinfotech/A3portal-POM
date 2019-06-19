package com.A3Portal.Testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.A3Portal.TestPages.HomePage;
import com.A3Portal.TestPages.LoginPage;
import com.A3Portal.base.TestBase;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();	
	}
	
	@Test(priority=1,enabled=false)
	public void loginPageTitleTest(){
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Free CRM software for any Business");
	}
	
	@Test(priority=2, enabled=false)
	public void crmLogoImageTest(){
		boolean flag = loginPage.validateCCImage();
		Assert.assertTrue(flag);
	}
	
	
	
	@Test(priority=3, enabled=true)
	public void loginTest(){
		//loginPage.clickOnlogin();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	
	@AfterMethod
	public void tearDown() throws InterruptedException{
		closeDriver();
		System.out.println("browser closed");
		
	}
	
	
	
	

}
