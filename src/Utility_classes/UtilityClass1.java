package Utility_classes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UtilityClass1 {
	
	public static void screenshot(WebDriver driver) throws IOException
	{
		Date date = new Date();
		SimpleDateFormat f = new SimpleDateFormat("hh-mm-ss");
		String currentDate = f.format(date);
		
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("D:\\Selenium\\ScreenShots\\image"+currentDate+".jpg");
		FileHandler.copy(source, dest);
	}
	
	public static WebElement explicitWait(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement element1 = wait.until(ExpectedConditions.visibilityOf(element));
		
		return element1;
	}
	
	public String getDataFromPropertyFile(String key) throws IOException
	{
		FileInputStream file = new FileInputStream("Configuration\\config.properties");
		
		Properties prop = new Properties();
		
		prop.load(file);
		
		String value = prop.getProperty(key);
		
		return value;
	}
	
	public String getDataFromExcelSheet(String sheetName, int row, int cell) throws EncryptedDocumentException, IOException
	{
		FileInputStream file = new FileInputStream("C:\\Users\\eminence\\Desktop\\data.xlsx");
		
		 String data = WorkbookFactory.create(file).getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();
		 
		 return data;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
