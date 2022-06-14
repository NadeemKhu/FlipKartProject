package Pom_classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility_classes.UtilityClass1;

public class HomePage extends UtilityClass1{
	
	WebDriver driver;
	
	@FindBy(xpath="//input[@type='text']")
	private WebElement searchField;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement searchButton;
	
	@FindBy(xpath="//div[text() = 'Nadeem']")
	private WebElement profileName;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void putSearchField(String data)        // taking it from data provider
	{
		searchField.sendKeys(data);
	}
	
	public void clickSearchBtn()
	{
		searchButton.click();
	}
	
	public boolean isProfileNameVisible()
	{
		try {
			WebElement element1 = explicitWait(driver, profileName);
			return true;
		}catch (Exception e)
		{
			return false;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	


}
