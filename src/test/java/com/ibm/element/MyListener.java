package com.ibm.element;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.ibm.basetest.BaseTest;

public class MyListener extends BaseTest implements ITestListener {
	String screenshotFolder;

    public void onTestStart(ITestResult result) {
        System.out.println("Started: " + result.getName());
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("PASSED: " + result.getName());
    }

    public void onTestFailure(ITestResult result) {
        System.out.println("FAILED: " + result.getName());
        System.out.println("Reason: " + result.getThrowable());
        
        try {
			captureScreenshot(result.getName()+".jpg");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
        
    }
    public void captureScreenshot(String fileName) throws Exception {
		 if(screenshotSubFolderName== null) {
			 LocalDateTime myDateObj = LocalDateTime.now();
			 DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy-HH-mm-ss");
			 screenshotSubFolderName = myDateObj.format(myFormatObj);
		 }
		 TakesScreenshot takeScreenshot = (TakesScreenshot) driver;
		 File sourceFile = takeScreenshot.getScreenshotAs(OutputType.FILE);
		 File destinationFile = new File("./src/test/resources/screenshot/"+screenshotSubFolderName+"/"+fileName);
		 FileUtils.copyFile(sourceFile, destinationFile);
		 System.out.println("----> Screenshot Captured <------");
		 	
		  
			
		}
}

