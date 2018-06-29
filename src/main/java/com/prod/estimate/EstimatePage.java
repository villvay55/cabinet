package com.prod.estimate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EstimatePage {

	private WebDriver driver;

	private By PricingLink = By.xpath(".//*[@id='menu-item-28276']/a[text() = 'Pricing']");
	private By estimateLink = By.xpath(".//*[@id='menu-item-28279']/a[text() = 'Create an Estimate']");
	
	
	
	public EstimatePage(WebDriver driver) {
		this.driver=driver;
	}
	
	
	
	public ProjectPage estimsteProcess() throws InterruptedException {
	
		clickOnPricing();
		
		synchronized (driver)
		{
		    driver.wait(3000);
		}
		
		clickOnEstimate();
		
		synchronized (driver)
		{
		    driver.wait(4000);
		}
		
		return  new ProjectPage(driver);
		
		
	}
	
	
	public void clickOnPricing() {
		
		WebElement PricingLinkElement =  driver.findElement(PricingLink);
		
		if(PricingLinkElement.isDisplayed()) {
			
			PricingLinkElement.click();
		}
		
		else System.out.println("Pricing Link not found");
		
	}
	
	public void clickOnEstimate() {
		
		WebElement estimateLinkElement =  driver.findElement(estimateLink);
		
		if(estimateLinkElement.isDisplayed()) {
			
			estimateLinkElement.click();
		}
		
		else System.out.println("Estimate Link not found");
		
	}
	
}
