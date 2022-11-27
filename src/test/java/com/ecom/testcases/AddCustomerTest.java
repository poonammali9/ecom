package com.ecom.testcases;

import java.io.IOException;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ecom.base.BaseClass;
import com.ecom.pom.AddCustomerPom;
import com.ecom.pom.LoginPagePom;
import com.ecom.pom.ManagerHomePom;
import com.ecom.utility.ExcelReader;
import com.ecom.utility.Utility;


public class AddCustomerTest extends BaseClass {
	LoginPagePom loginpagepom;
	ExcelReader excelReader;
	Utility utility;
	ManagerHomePom managerHomePom;
	
	@BeforeClass
	public void setUp() {
		initDriver();
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void testValidLogin1() throws EncryptedDocumentException, IOException, InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		excelReader = new ExcelReader();
		Sheet sh = excelReader.getSheet("Glogin");
		Map<String, Object> data = excelReader.getData(sh);
		
		LoginPagePom loginpagepom = new LoginPagePom();
		loginpagepom.setLoginCredentials(data.get("userid"), data.get("password"));
		
		softAssert.assertEquals(data.get("userid").toString(), "mngr456948");
		loginpagepom.clickOnLogin();
		
		softAssert.assertAll();
		managerHomePom  =new ManagerHomePom();
		managerHomePom .clickOnNewCustomer();
		
		excelReader.closeResource();
		
		excelReader = new ExcelReader();
		Sheet sh1 = excelReader.getSheet("Newcustomer");
		Map<String, Object> data1 = excelReader.getData(sh1);
		AddCustomerPom  addcustomerpom = new AddCustomerPom ();
		addcustomerpom.setLoginCredentials1(data.get("CustomerName"), data.get("Address"));
		softAssert.assertEquals(data.get("CustomerName").toString(), "rstuv");
		managerHomePom = addcustomerpom.clickOnsubmit();
		softAssert.assertAll();
	}
	
	
	public void clickOnNewCustomer() {
		Utility.applyImplicitWait();
		managerHomePom.clickOnNewCustomer();
	}




}


