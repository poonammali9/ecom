package com.ecom.testcases;

import java.io.FileNotFoundException;

	import java.io.IOException;
	import java.util.Map;

	import org.apache.poi.EncryptedDocumentException;
	import org.apache.poi.ss.usermodel.Sheet;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ecom.base.BaseClass;
	import com.ecom.pom.LoginPagePom;
	import com.ecom.utility.ExcelReader;
import com.ecom.utility.Utility;

	
	public class LoginTest extends BaseClass{
		
		LoginPagePom loginPagePom;
		ExcelReader excelReader;
		Utility utility;
		
		
		@BeforeClass
		public void setUp() {
			initDriver();
		}
		
		@AfterClass
		public void tearDown() {
			driver.quit();
		}
	
		@Test
		public void testTitle() {
			utility = new Utility();
			String title = utility.getTitle();
			Assert.assertEquals(title, "GTPL Bank Home Page");
		}
		
		@Test
		public void testValidLogin() throws EncryptedDocumentException, IOException {
			SoftAssert softAssert = new SoftAssert();
			excelReader = new ExcelReader();
			Sheet sh = excelReader.getSheet("Glogin");
			Map<String, Object> data = excelReader.getData(sh);
			loginPagePom = new LoginPagePom();
			loginPagePom.setLoginCredentials(data.get("userid"), data.get("password"));
			softAssert.assertEquals(data.get("userid").toString(), "mngr456948");
			loginPagePom.clickOnLogin();
			softAssert.assertAll();
		}
	}

