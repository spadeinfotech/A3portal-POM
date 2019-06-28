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
		System.out.println("opening browser");
	}
	
	@Test(enabled=true)
	public void loginPageTitleTest(){
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Core Compete");
		System.out.println("running test1");
	}

	
	@Test(enabled=true)
	public void loginTest(){
		//loginPage.clickOnlogin();
		System.out.println("running test2");
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	
	}
	
	
	@Test( enabled=false)
	public void crmLogoImageTest(){
		boolean flag = loginPage.validateCCImage();
		Assert.assertTrue(flag);
	}
	
	
	
	@AfterMethod
	public void tearDown() throws InterruptedException{
		closeDriver();
		System.out.println("browser closed");
		
	}
	
	
	
	

}
