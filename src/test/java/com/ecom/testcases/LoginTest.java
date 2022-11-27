package com.ecom.testcases;

import java.io.FileNotFoundException;

	import java.io.IOException;
	import java.util.Map;

	import org.apache.poi.EncryptedDocumentException;
	import org.apache.poi.ss.usermodel.Sheet;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
	import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.ecom.base.BaseClass;
	import com.ecom.pom.LoginPagePom;
	import com.ecom.utility.ExcelReader;
import com.ecom.utility.Utility;
import com.listner.MyListner;


    @Listeners(MyListner.class)
	public class LoginTest extends BaseClass{
		
		LoginPagePom loginPagePom;
		ExcelReader excelReader;
		Utility utility;
		
		ExtentSparkReporter extentSparkReporter ;
		ExtentReports extentReports ;
		ExtentTest logger;
		
		
		
		
		@BeforeClass
		public void setUp() {
			initDriver();
			extentSparkReporter = new ExtentSparkReporter(projectPath+"//extentReport//testReport.html");
			extentReports = new ExtentReports();
			extentReports.attachReporter(extentSparkReporter);
		}
		
		
		@AfterClass
		public void tearDown() {
			extentReports.flush();
			driver.quit();
		}
	
		@Test
		public void testTitle() {
			logger = extentReports.createTest("testTitle");
			utility = new Utility();
			String title = utility.getTitle();
			logger.log(Status.PASS, "i am getting the exact title");
			Assert.assertEquals(title, "GTPL Bank Home Page");
				}
		
		@Test (groups = {"validLogin"})
		public void testValidLogin() throws EncryptedDocumentException, IOException {
			logger = extentReports.createTest("testValidLogin");
			SoftAssert softAssert = new SoftAssert();
			excelReader = new ExcelReader();
			Sheet sh = excelReader.getSheet("Glogin");
			Map<String, Object> data = excelReader.getData(sh);
			loginPagePom = new LoginPagePom();
			loginPagePom.setLoginCredentials(data.get("userid"), data.get("password"));
			softAssert.assertEquals(data.get("userid").toString(), "mngr456948");
			loginPagePom.clickOnLogin();
			softAssert.assertAll();
			utility.takeScreenShot("login page");
		}
	}

