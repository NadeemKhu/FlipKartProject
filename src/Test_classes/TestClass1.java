package Test_classes;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Base_classes.BaseClass1;
import Pom_classes.HomePage;
import Pom_classes.LoginPage;
import listeners_Classes.ListenerClass1;

@Listeners(ListenerClass1.class)

public class TestClass1 {
	
	WebDriver driver;
	LoginPage lp;
	HomePage hp;
	
	@DataProvider(name="productData")
	public String[] getData()
	{
		String data [] = {"realmi"};
		
		return data;
	}
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String k)
	{
		driver = BaseClass1.getDriver(k);
	}
	
	@BeforeMethod
	public void beforeMethod()
	{
		lp = new LoginPage(driver);
		
		hp = new HomePage(driver);
	}
	
	@Test
	public void verifyUserCanLogin() throws IOException
	{
		lp.putEmail();
		lp.putPassword();
		lp.clickLoginBtn();
		
		Assert.assertTrue(hp.isProfileNameVisible());
	}
	
	@Test (dataProvider="productData")
	public void verifyUserCanSearchProduct(String data)
	{
		
		hp.putSearchField(data);
		hp.clickSearchBtn();
	}
	
	@Test
	public void verfyUserCanGoToPDP()
	{
		
	}
	
	@AfterMethod
	public void afterMethod() throws IOException
	{
		hp.isProfileNameVisible();
		lp.screenshot(driver);
	}
	
	@AfterClass
	public void afterClass()
	{
		driver.close();
	}

	

}
