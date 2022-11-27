package com.ecom.utility;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.ecom.base.BaseClass;


	public class ExtentReport extends BaseClass {
		
		public static ExtentSparkReporter extentSparkReporter;
		
		public static void generateExtentReport() {
			
			 extentSparkReporter = new ExtentSparkReporter(projectPath+"//extentreport//testreport.html");
			
		}
		public static void flushReport() {
			ExtentReport.flushReport();
		}
		
		

	}



