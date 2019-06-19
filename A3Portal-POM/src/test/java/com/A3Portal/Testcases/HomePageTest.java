package com.A3Portal.Testcases;

import org.testng.annotations.Test;

import com.A3Portal.TestPages.ContactPage;
import com.A3Portal.TestPages.HomePage;
import com.A3Portal.TestPages.LoginPage;
import com.A3Portal.Testutil.Testutil;
import com.A3Portal.base.TestBase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	Testutil testUtil;
	ContactPage contactsPage;

	public HomePageTest() {
		super();
	}

	//test cases should be separated -- independent with each other
	//before each test case -- launch the browser and login
	//@test -- execute test case
	//after each test case -- close the browser
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new Testutil();
		contactsPage = new ContactPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@Test(priority=1)
	public void verifyHomePageTitleTest(){
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO","Home page title not matched");
	}
	
	@Test(priority=2)
	public void verifyUserNameTest(){
		testUtil.switchToFrame();
		Assert.assertTrue(homePage.verifyCorrectUserName());
	}
	
	@Test(priority=3)
	public void verifyContactsLinkTest(){
		testUtil.switchToFrame();
		contactsPage = homePage.clickOnContactsLink();
	}
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	

}
