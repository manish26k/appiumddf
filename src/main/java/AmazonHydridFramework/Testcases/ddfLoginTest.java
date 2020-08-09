package AmazonHydridFramework.Testcases;

import java.util.HashMap;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;

import AmazonPageObjects.LoginPage;
import AmazonPageObjects.WelcomePage;
import androidCapabilities.androidCapabilities2;

public class ddfLoginTest extends androidCapabilities2 {
	
	
	LoginPage loginpage;
	WelcomePage welcomePage;
	
	@DataProvider(name="loginData")
	public Object[][] dataSource() throws FilloException{
		return getData("Login.xlsx","Sheet1");
	}
	
	@Test(dataProvider="loginData")
	public void testLogin(HashMap<String,String> data) {
		
		
		welcomePage = new WelcomePage(driver,wait);
		welcomePage.clickonSignIn();
		
		
		
		System.out.println(data.get("Email")+""+ data.get("Password")+""+ data.get("runMode"));
		
		loginpage=new LoginPage(driver, wait);
		
		if(data.get("runMode").equalsIgnoreCase("n")) {
			throw new SkipException("Run Mode for this set of data is Marked N");
		}
		
		loginpage.ddfLogin(data.get("Email"), data.get("Password"));
	}

}
