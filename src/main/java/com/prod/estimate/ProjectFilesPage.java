package com.prod.estimate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProjectFilesPage {
	
	private WebDriver driver;
	
	private By skipBtn = By.xpath(".//*[@id='image-upload-estimate']");
	
	public ProjectFilesPage(WebDriver driver) {
	
		this.driver=driver;
	}
	
	
	
	public CategoryPage skipFile() throws InterruptedException {
		
		clickOnSkip();
		
		synchronized (driver)
		{
		    driver.wait(3000);
		}
		
		return  new CategoryPage(driver);
		
		
	}
	
	public void clickOnSkip() {
		
		WebElement skipBtnElement =  driver.findElement(skipBtn);
		
		if(skipBtnElement.isDisplayed()) {
			
			skipBtnElement.click();
		}
		
		else System.out.println("Skip button not found");
		
	}
}
