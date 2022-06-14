package Pom_classes;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility_classes.UtilityClass1;

public class LoginPage extends UtilityClass1{
	
	WebDriver driver;
	
	@FindBy(xpath="(//input[@type='text'])[2]")      
	private WebElement emailInput;
	
	@FindBy(xpath="//input[@type='password']")
	private WebElement passwordInput;
	
	@FindBy(xpath="(//button[@type='submit'])[2]")
	private WebElement loginButton;
	
	
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);      // initialize those webelemnt which has @FindBy attribute
		this.driver = driver;
	}
	
	public void putEmail() throws IOException            // taking from property file
	{
		String value = getDataFromPropertyFile("email");
		emailInput.sendKeys(value);
	}
	
	public void putPassword() throws EncryptedDocumentException, IOException        // taking from excel sheet
	{
		String data = getDataFromExcelSheet("Sheet1", 0, 1);
		passwordInput.sendKeys(data);
	}
	
	public void clickLoginBtn()
	{
		loginButton.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
