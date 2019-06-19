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
import org.testng.annotations.DataProvider;


public class ContactPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	Testutil testUtil;
	ContactPage contactsPage;
	
	String sheetName = "contacts";
	
	   
	public ContactPageTest(){
			super();
			
	}
	
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		
		initialization();
		testUtil = new Testutil();
		contactsPage = new ContactPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		Testutil.runTimeInfo("error", "login successful");
		testUtil.switchToFrame();
		contactsPage = homePage.clickOnContactsLink();
	}
	
	@Test(priority=1)
	public void verifyContactsPageLabel(){
		Assert.assertTrue(contactsPage.verifyContactsLabel(), "contacts label is missing on the page");
	}
	
	@Test(priority=2)
	public void selectSingleContactsTest(){
		contactsPage.selectContactsByName("test2 test2");
	}
	
	@Test(priority=3)
	public void selectMultipleContactsTest(){
		contactsPage.selectContactsByName("test2 test2");
		contactsPage.selectContactsByName("ui uiii");

	}
	
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = Testutil.getTestData(sheetName);
		return data;
	}
	
	
	@Test(priority=4, dataProvider="getCRMTestData")
	public void validateCreateNewContact(String title, String firstName, String lastName, String company){
		homePage.clickOnNewContactLink();
		//contactsPage.createNewContact("Mr.", "Tom", "Peter", "Google");
		contactsPage.createNewContact(title, firstName, lastName, company);
		
	}
	
	

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
	
}
