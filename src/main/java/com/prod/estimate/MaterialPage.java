package com.prod.estimate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MaterialPage {

private WebDriver driver;
	
	private By unfinishCheckBox = By.xpath(".//*[@id='div-select-options']/div[4]/div/div[4]/div[3]/label[3]/span");
	private By discountTxt = By.xpath(".//*[@id='div-select-options']/div[5]/div[4]/span");
	
	
	public MaterialPage(WebDriver driver) {
		
		this.driver=driver;
	}
	
	
	public CalculateDiscountPage calculateDiscount() throws InterruptedException {
		
		clickOnUnfinish();
		
		synchronized (driver)
		{
		    driver.wait(3000);
		}
		
		displayDiscount();
		
		synchronized (driver)
		{
		    driver.wait(3000);
		}
		
		return  new CalculateDiscountPage(driver);
		
	}
	
	
	
	
	public void clickOnUnfinish() {
		
		WebElement unfinishCheckBoxElement =  driver.findElement(unfinishCheckBox);
		
		if(unfinishCheckBoxElement.isDisplayed()) {
			
			unfinishCheckBoxElement.click();
		}
		
		else System.out.println("Unfinish Checkbox not found");
		
	}
	
	public void displayDiscount() {
		
		WebElement discountTxtElement =  driver.findElement(discountTxt);
		
		if(discountTxtElement.isDisplayed()) {
			
			String discount = discountTxtElement.getText();
			System.out.println("Total Discount amount "+discount);
		}
		
		else System.out.println("Discount amount not found");
		
	}
	
}
