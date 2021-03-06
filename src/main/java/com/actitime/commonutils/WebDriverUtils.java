package com.actitime.commonutils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class WebDriverUtils {
	WebDriver driver;
	public String  getDataFromProperties(String key) throws IOException
	{
		FileInputStream fs=new FileInputStream("C:\\Users\\DELL\\Desktop\\java 1.8.201\\ActitimeProject\\src\\main\\resources\\LoginData\\logincred.properties");
		Properties obj=new Properties();
		obj.load(fs);
		String value=obj.getProperty(key);
		return value;
		
		
	}
	public void capturefailedScreenshots(String tcname,WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File target=new File(System.getProperty("user.dir")+"\\FailedScriptScreenshot\\"+tcname+".png");
		FileUtils.copyFile(src,target);
		System.out.println("screenshot is taken");
	}
	public String readtestdata(String path,String sheet, int row,int cell) throws EncryptedDocumentException, FileNotFoundException, IOException
	{
		Workbook book=WorkbookFactory.create(new FileInputStream(path));
		String res=book.getSheet(sheet).getRow(row).getCell(cell).toString();
		return res;
		
		
	}
	
}
