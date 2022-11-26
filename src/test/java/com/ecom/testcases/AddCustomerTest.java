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
	public void testValidLogin1() throws EncryptedDocumentException, IOException {
		SoftAssert softAssert = new SoftAssert();
		excelReader = new ExcelReader();
		Sheet sh = excelReader.getSheet("Newcustomer");
		Map<String, Object> data = excelReader.getData(sh);
		AddCustomerPom  addcustomerpom = new AddCustomerPom ();
		addcustomerpom.setLoginCredentials1(data.get("userid"), data.get("password"));
		softAssert.assertEquals(data.get("userid").toString(), "mngr455515");
		managerHomePom = addcustomerpom.clickOnsubmit();
		softAssert.assertAll();
	}
	
	
	public void clickOnNewCustomer() {
		Utility.applyImplicitWait();
		managerHomePom.clickOnNewCustomer();
	}




}


