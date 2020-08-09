package AmazonPageObjects;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import androidCapabilities.androidCapabilities2;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;

public class TestAllureListener<Scenario> extends androidCapabilities2 implements ITestListener {

	 private static String getTestMethodName(ITestResult iTestResult) {
	        return iTestResult.getMethod().getConstructorOrMethod().getName();
	    }
	 
	 
	   // Text attachments for Allure
		@Attachment(value = "Page screenshot", type = "image/png")
		public byte[] saveScreenshotPNG(WebDriver driver) {
			return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			
		}
	 
	/* public void embedScreenshot(Scenario scenario) {
	        try {
	            Allure.addAttachment(((ITestContext) scenario).getName(), new ByteArrayInputStream(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES)));
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}*/
	 
	 
	 
		
		// Text attachments for Allure
		@Attachment(value = "{0}", type = "text/plain")
		public static String saveTextLog(String message) {
			return message;
		}

		// HTML attachments for Allure
		@Attachment(value = "{0}", type = "text/html")
		public static String attachHtml(String html) {
			return html;
		}
	
	
	
	
	public void onTestStart(ITestResult result) {
		System.out.println("I am in onTestStart method " +  getTestMethodName(result) + " start");
		
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("I am in onTestStart method " +  getTestMethodName(result) + " succeed");
		
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("I am in onTestFailure method " + getTestMethodName(result) + " failed");
		Object testClass = result.getInstance();
		AndroidDriver<AndroidElement> driver=((androidCapabilities2) testClass).getDriver();
		
		//AndroidDriver<AndroidElement> driver=androidCapabilities2.getDriver();
		
		
		
		
		
		if(driver instanceof AndroidDriver<?> ) {
			System.out.println("Screenshot captured for test case:" + getTestMethodName(result));
			saveScreenshotPNG(driver);
	}
			
			
			
			
			
		
		
		// Save a log on allure.
		saveTextLog(getTestMethodName(result) + " failed and screenshot taken!");	
		
	}

	private void failScreenCapture(String name) {
		// TODO Auto-generated method stub
		
	}


	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		System.out.println("I am in onStart method " + context.getName());
        context.setAttribute("AndroidDriver<AndroidElement>", androidCapabilities2.driver);
		
	}

	public void onFinish(ITestContext context) {
		System.out.println("I am in onFinish method " + context.getName());
		
	}

}
