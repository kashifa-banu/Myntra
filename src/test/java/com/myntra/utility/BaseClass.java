package com.myntra.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
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
	static Properties prop;
	
	
	
	@BeforeTest(alwaysRun = true)
	public void setDriver() throws IOException{
		SimpleDateFormat format = new SimpleDateFormat("YYYY/MM/DD HH:MM:SS");
		Date date = new Date();
		SimpleDateFormat timeStamp = new SimpleDateFormat("MMddyyyy_HHmmss");
		//String path="http://localhost:8080/job/FreeStyleJob/ws/test-output/extentreports/reports.html";
	     String path = System.getProperty("user.dir")+"/test-output/extentreports/reports_" +timeStamp.format(date) +".html";		
		reports = new ExtentReports(path);
		reports.loadConfig(new File(System.getProperty("user.dir")+ "/Utilities/extent-config.xml"));
		test = reports.startTest("Myntra testCase");
		
		String propFilePath = "./Utilities/LoginProperty.properties";
		File propFile = new File(propFilePath);
		
		FileInputStream PropInFile = new FileInputStream(propFile);		
		prop=new Properties();
		prop.load(PropInFile);
		
		//driver.findElement(By.cssSelector("input[type='abc']")).click();
		
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		ChromeOptions options = new ChromeOptions();
		options.setPageLoadStrategy(PageLoadStrategy.EAGER);
		driver.get("https://www.myntra.com/");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		
	}
	
	public String getUserName(){
		return prop.getProperty("UserName");	
		
	}
	
	public String getPassword(){
		return prop.getProperty("Password");
	}
	public String getProduct(){
		return prop.getProperty("product");
	}
	
	/*@BeforeMethod
	public void startTest(){
		test = reports.startTest("Myntra testCase");
	}*/
	
	public String getScreenShot(WebDriver driver, String iTestNGMethod ) throws IOException{
		//String path = "./test-output/ScreenShot/screen1.png";
		//String path = "localhost:8080/job/MyntraMavenProject/ws/test-output/ScreenShot/screen1_"+iTestNGMethod+".png";
		String path=System.getProperty("user.dir") + "/test-output/ScreenShot/screen1_"+iTestNGMethod+".png";
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
			test.log(LogStatus.INFO, test.addScreenCapture(getScreenShot(driver,"abc")));
			//test.log(LogStatus.FAIL, test.);
			}
			else
				if(result.getStatus()==ITestResult.SKIP)
					test.log(LogStatus.SKIP, result.getMethod()+"Skip");
		
		
	}
 	
	@AfterTest(alwaysRun = true)
	public void quitDriver(){
		driver.quit();
		reports.endTest(test);
		reports.flush();
		
	}
	
	
}
