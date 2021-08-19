package com.myntra.utility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	static ExtentReports  reports;
	static ExtentTest test;
	@BeforeTest
	public void setDriver(){
		Date date = new Date();
		String path = "./test-output/extentreports/reports.html";
		reports = new ExtentReports(path);
		test = reports.startTest("Myntra testCase");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		ChromeOptions options = new ChromeOptions();
		options.setPageLoadStrategy(PageLoadStrategy.EAGER);
		driver.get("https://www.myntra.com/");
		driver.manage().window().maximize();
		
	}
	public String getScreenShot(WebDriver driver) throws IOException{
		String path="./test-output/ScreenShot/screen1.png";
		File dest = new File(path);
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File src=screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, dest);		
		return path;
	}
	@AfterMethod
	public void endTest(ITestResult result) throws IOException{
		if(result.getStatus()==ITestResult.SUCCESS)
			test.log(LogStatus.PASS, result.getMethod() + "Pass");
		else
			if(result.getStatus()==ITestResult.FAILURE){
				test.log(LogStatus.FAIL, result.getMethod()+"fail");
				test.log(LogStatus.FAIL, "TestCase failed" + result.getThrowable());
			test.log(LogStatus.INFO, test.addScreenCapture(getScreenShot(driver)));
			//test.log(LogStatus.FAIL, test.);
			}
			else
				if(result.getStatus()==ITestResult.SKIP)
					test.log(LogStatus.SKIP, result.getMethod()+"Skip");
		
		
	}
	   	
	@AfterTest
	public void quitDriver(){
		driver.quit();
		reports.endTest(test);
		reports.flush();
	}
	
}
