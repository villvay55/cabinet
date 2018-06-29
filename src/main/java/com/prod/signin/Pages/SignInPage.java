package com.prod.signin.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.prod.estimate.EstimatePage;

public class SignInPage {
	
	private WebDriver driver;
	private By usernameTextBox = By.xpath(".//*[@id='username']");
	private By passwordTextBox = By.xpath(".//*[@id='password']");
	private By loginBtn = By.xpath(".//*[@id='customer_login']/div[1]/form/p[3]/input[3]");
	private By homePageTxt = By.xpath("html/body/div[1]/div/div[1]/nav/ul/li[1]/a[text() = 'My Estimates']");
	
	
	public SignInPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void enterUserName(String userName) {
		
		WebElement emailTxtBox  = driver.findElement(usernameTextBox);
	
		if(emailTxtBox.isDisplayed()) {
			
			emailTxtBox.sendKeys(userName);
		}
		
		else System.out.println("Username Textbox not found");
		
	}

	public void enterPassword(String userPassword) {
		
		WebElement passTxtBox = driver.findElement(passwordTextBox);
		
		if(passTxtBox.isDisplayed()) {
			
			passTxtBox.sendKeys(userPassword);
		}
		
		else System.out.println("password textbox not found");
	}
	
	public void clickOnLoginIn() {
		
		WebElement loginBtnElement =  driver.findElement(loginBtn);
		
		if(loginBtnElement.isDisplayed()) {
			
			loginBtnElement.click();
		}
		
		else System.out.println("Login Button not found");
		
	}


	public EstimatePage verifySigin(String user , String pass) throws InterruptedException {
		enterUserName(user);
		synchronized (driver)
		{
		    driver.wait(3000);
		}
		enterPassword(pass);
		synchronized (driver)
		{
		    driver.wait(3000);
		}
		clickOnLoginIn();
		synchronized (driver)
		{
		    driver.wait(3000);
		}
		return  new EstimatePage(driver);
		
		
	}
	
	public boolean verifySignInPage() {
		
		WebElement homeLinkTxtElement  = driver.findElement(homePageTxt);
		boolean status = homeLinkTxtElement.isDisplayed();
		
		return status;
	}


}
