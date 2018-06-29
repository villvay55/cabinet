package com.prod.estimate;


import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ProjectPage {


	private WebDriver driver;
	
	private By estimateTxtBox = By.xpath(".//*[@id='project_name']");
	private By saveButton = By.xpath(".//*[@id='div-name-your-plan']/form/div/div[3]/div/button");
	
	public ProjectPage(WebDriver driver) {
		this.driver=driver;
	}
	
	
	
	public ProjectFilesPage createEstimste(String name , String systemType) throws InterruptedException {
		
		enterProject(name);
		
		synchronized (driver)
		{
		    driver.wait(3000);
		}
		
		Select systemTypeDropDown = new Select(driver.findElement(By.xpath(".//*[@id='ikea_system']")));
		systemTypeDropDown.selectByValue(systemType);
		
		synchronized (driver)
		{
		    driver.wait(3000);
		}
		
		clickOnSave();
		
		synchronized (driver)
		{
		    driver.wait(3000);
		}
		
		return  new ProjectFilesPage(driver);
		
		
	}
	
	public void enterProject(String name) {
		
		
		WebElement estimateTxtBoxElement =  driver.findElement(estimateTxtBox);
		
		if(estimateTxtBoxElement.isDisplayed()) {
			
			estimateTxtBoxElement.sendKeys(name);
		}
		
		else System.out.println("Estimate TextBox not found");
		
	}

	
	public void clickOnSave() {
		
		WebElement saveButtonElement =  driver.findElement(saveButton);
		
		if(saveButtonElement.isDisplayed()) {
			
			saveButtonElement.click();
		}
		
		else System.out.println("Save button not found");
		
	}



}
