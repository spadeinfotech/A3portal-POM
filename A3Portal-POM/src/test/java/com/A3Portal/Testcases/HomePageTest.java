package com.A3Portal.Testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.A3Portal.TestPages.ContactPage;
import com.A3Portal.TestPages.HomePage;
import com.A3Portal.TestPages.LoginPage;
import com.A3Portal.Testutil.Testutil;
import com.A3Portal.base.TestBase;


public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	Testutil testUtil;
	ContactPage contactsPage;

	public HomePageTest() {
		super();
	}



	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new Testutil();
		contactsPage = new ContactPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@Test(priority=1, enabled=true)
	public void verifyHomePageTitleTest(){
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Core Compete","Home page title not matched");
		System.out.println("running test1");
	}
	
	@Test(priority=2, enabled=false)
	public void verifyUserNameTest(){
		testUtil.switchToFrame();
		Assert.assertTrue(homePage.verifyCorrectUserName());
		System.out.println("running test2");
	}
	
	@Test(priority=3, enabled=false)
	public void verifyContactsLinkTest(){
		testUtil.switchToFrame();
		contactsPage = homePage.clickOnContactsLink();
	}
	
	
	
	@AfterMethod
	public void tearDown() throws InterruptedException{
		
		closeDriver();
		System.out.println("browser closed");
	}
	
	

}
