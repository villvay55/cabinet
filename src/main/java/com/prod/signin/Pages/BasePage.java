package com.prod.signin.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class BasePage {
	
	protected WebDriver driver;
	private By loginBtn = By.xpath(".//*[@id='navbar-collapse-1']/ul/li[2]/button");
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public SignInPage loginPage() {
		
		clickOnLoginIn();
		
		return new SignInPage(driver);
	}
	
	public String getPageTitle() {
		
		String title = driver.getTitle();
		return title;
	}
	
	
	public void clickOnLoginIn() {
		
		WebElement loginBtnElement =  driver.findElement(loginBtn);
		
		if(loginBtnElement.isDisplayed()) {
			
			loginBtnElement.click();
		}
		
		else System.out.println("Login Button not found");
		
	}

	

}