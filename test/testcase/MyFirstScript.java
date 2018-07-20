/*
  author: Tugba Sahin
  date: 14.07.2018
  definition: Selenium WebDriver Automation
  prerequisites:
  Download and install JDK(Java SE Development Kit)
  Download Eclipse IDE
  Download Selenium WebDriver(selenium-server-standolone jar file) and add it to the library in your project in Eclipse IDE.
  Download SafariDriver extension add that extension to your Safari browser.
   
*/

package com.demo.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;


public class MyFirstScript {
	public static boolean InvalidLogin(WebDriver driver) throws InterruptedException{
		driver.get("http://localhost:8888/MAMP/PHPtest/loginPage.php");
		driver.findElement(By.name("MSISDN")).sendKeys("5497952991");
		driver.findElement(By.name("Password")).sendKeys("yanlisparola");
		driver.findElement(By.className("LoginBtn")).click();
		Thread.sleep(2000);
		if(driver.getPageSource().contains("Invalid Login"))
		{ System.out.println("Please check your phone number and password then try again");}
		else
		{ System.out.println("error"); }
		return true;
	}
	public static boolean FieldsBlank(WebDriver driver) throws InterruptedException{
		driver.get("http://localhost:8888/MAMP/PHPtest/loginPage.php");
		driver.findElement(By.name("MSISDN")).sendKeys("");
		driver.findElement(By.name("Password")).sendKeys("");
		driver.findElement(By.className("LoginBtn")).click();
		Thread.sleep(2000);
		if(driver.getPageSource().contains("Fields can not be blank"))
		{ System.out.println("Fields can not be blank"); }
		else
		{ System.out.println("error"); }
		return true;
	}
	public static boolean PasswordsNotMatch(WebDriver driver) throws InterruptedException{
		
		driver.get("http://localhost:8888/MAMP/PHPtest/changePassword.php");
		driver.findElement(By.name("MSISDN")).sendKeys("5497952991");
		driver.findElement(By.name("Password")).sendKeys("turu");
		driver.findElement(By.name("confirmPassword")).sendKeys("turuturu");
		driver.findElement(By.className("LoginBtn")).click();
		Thread.sleep(2000);
		if(driver.getPageSource().contains("Your passwords should match"))
		{ System.out.println("Your passwords should match"); }
		else
		{ System.out.println("error"); }
		return true;
	}
	public static boolean MissingCharacter(WebDriver driver) throws InterruptedException{
		driver.findElement(By.name("MSISDN")).sendKeys("5497952991");
		driver.findElement(By.name("Password")).sendKeys("turuturu");
		driver.findElement(By.name("confirmPassword")).sendKeys("turuturu");
		driver.findElement(By.className("LoginBtn")).click();
		Thread.sleep(2000);
		if(driver.findElements(By.xpath("//body[contains(text(), 'Your password should be 8 character long and should contain at least one special character and number')]")) != null)
		{ System.out.println("Your password should be 8 character long and should contain at least one special character and number"); }
		else
		{ System.out.println("error"); }
		return true;
	}
	public static boolean PasswordConfirmed(WebDriver driver) throws InterruptedException{
		driver.get("http://localhost:8888/MAMP/PHPtest/changePassword.php");
		driver.findElement(By.name("MSISDN")).sendKeys("5497952991");
		driver.findElement(By.name("Password")).sendKeys("turuturu1.");
		driver.findElement(By.name("confirmPassword")).sendKeys("turuturu1.");
		driver.findElement(By.className("LoginBtn")).click();
		Thread.sleep(2000);
		if(driver.getPageSource().contains("Password Confirmed"))
		{ System.out.println("Password Confirmed"); }
		else
		{ System.out.println("error"); }
		return true;
	}
	public static boolean SuccessfulLogin(WebDriver driver) throws InterruptedException{
		driver.get("http://localhost:8888/MAMP/PHPtest/loginPage.php");
		driver.findElement(By.name("MSISDN")).sendKeys("5497952991");
		driver.findElement(By.name("Password")).sendKeys("turuturu1.");
		driver.findElement(By.className("LoginBtn")).click();
		Thread.sleep(9000);
		if(driver.getPageSource().contains("Esnaf Tarifesi"))
		{ System.out.println("Info Login"); }
		else
		{ System.out.println("error"); }
		return true;
	}
	public static boolean CheckInvoice(WebDriver driver) throws InterruptedException{
		driver.findElement(By.xpath("//*[@title='Faturalarım']")).click();
		Thread.sleep(4000);
     	if(driver.getPageSource().contains("JULY INVOICE"))
		{ System.out.println("Invoice Login"); }
     	else
     	{ System.out.println("error"); }	
		return true;
	}
	public static boolean CheckLogout(WebDriver driver) throws InterruptedException{
		driver.findElement(By.className("invoiceLogo")).click();
		Thread.sleep(6000);
		driver.findElement(By.xpath("//*[@title='Oturumu Kapat']")).click();
		if (driver.findElements(By.xpath("//body[contains(@class, 'LoginBtn')]")) != null)
		{ System.out.println("Logout"); }
		else
		{ System.out.println("error"); }
		return true;
	}
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new SafariDriver();
		//Resize Browser Window in WebDriver
		driver.manage().window().maximize();

		InvalidLogin(driver);
		
		FieldsBlank(driver);
		
		PasswordsNotMatch(driver);
		
		MissingCharacter(driver);
		
		PasswordConfirmed(driver);
		
		SuccessfulLogin(driver);
		
		CheckInvoice(driver);
		
		CheckLogout(driver);
		
		//driver.get("http://localhost:8888/MAMP/PHPtest/index.php");
		
	}
}
