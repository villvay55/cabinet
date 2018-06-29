package com.prod.estimate;

import java.text.DecimalFormat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class CategoryPage {

	
	private WebDriver driver;
	
	
	private By addPartBtn = By.xpath(".//*[@id='div-materials-parts']/div[3]/div/div[3]/table/tbody/tr[2]/td/button");
	private By PartsTxtBox = By.xpath(".//*[@id='div-materials-parts']/div[3]/div/div[3]/table/tbody/tr[2]/td[8]/div/input");
	private By addBtn = By.xpath(".//*[@id='div-materials-parts']/div[3]/div/div[3]/table/tbody/tr[2]/td[11]/button[1]");
	private By saveBtn = By.xpath(".//*[@id='save']");
	private By continuePopBtn = By.xpath(".//*[@id='div-materials-parts']/div[7]/button");
	
	
	private By unfinishCheckBox = By.xpath(".//*[@id='div-select-options']/div[4]/div/div[4]/div[2]/label[3][text() = 'Unfinished (price reduced)']");
	private By discountTxt = By.xpath(".//*[@id='div-select-options']/div[4]/div/div[4]/div[2]/span");
	
	private By paintCheckBox = By.xpath(".//*[@id='div-select-options']/div[4]/div/div[4]/div[2]/label[2]/span");
	private By discountDYITxt = By.xpath(".//*[@id='div-review-save']/div[3]/div/div[5]/div[2]/span");
	
	
	public CategoryPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public MaterialPage estimsteProcess(String materials , String products , String cabinet , String partName , String partSize , String parts , String height , String weight) throws InterruptedException {
	
		
		//int materialsInt = Integer.parseInt(materials);
		//int productsInt = Integer.parseInt(products);
		//int cabinetInt = Integer.parseInt(cabinet);
		//int partNameInt = Integer.parseInt(partName);
		// partSizeInt = Integer.parseInt(partSize);
		double heightDouble = Double.valueOf(height);
		double weightDouble = Double.valueOf(weight);

		
		synchronized (driver)
		{
		    driver.wait(3000);
		}
		
		System.out.println("Print value "+materials);
		driver.findElement(By.xpath(".//*[@id='div-materials-parts']/div[3]/div/div[2]/div[1]/div")).click();
		driver.findElement(By.xpath(".//*[@id='div-materials-parts']/div[3]/div/div[2]/div[1]/div/select/option[text() = '"+materials+"' ]")).click();
		
		synchronized (driver)
		{
		    driver.wait(3000);
		}
		
		driver.findElement(By.xpath(".//*[@id='div-materials-parts']/div[3]/div/div[2]/div[2]/div")).click();
		driver.findElement(By.xpath(".//*[@id='div-materials-parts']/div[3]/div/div[2]/div[2]/div/select/option[text() = '"+products+"' ]")).click();
	
		
		synchronized (driver)
		{
		    driver.wait(6000);
		}
		
	
		clickOnAddPart();
	
		synchronized (driver)
		{
		    driver.wait(3000);
		}
		
		
		//driver.findElement(By.xpath(".//*[@id='div-materials-parts']/div[3]/div/div[3]/table/tbody/tr[2]/td[2]/div")).click();
		//driver.findElement(By.xpath(".//*[@id='div-materials-parts']/div[3]/div/div[3]/table/tbody/tr[2]/td[2]/div/select/option[text() = '"+cabinet+"' ]")).click();
		Select cabinetDropDown = new Select(driver.findElement(By.xpath(".//*[@id='div-materials-parts']/div[3]/div/div[3]/table/tbody/tr[2]/td[2]/div/select")));
		cabinetDropDown.selectByIndex(2);
		
		synchronized (driver)
		{
		    driver.wait(3000);
		}
		
		
		driver.findElement(By.xpath(".//*[@id='div-materials-parts']/div[3]/div/div[3]/table/tbody/tr[2]/td[3]/div[1]")).click();
		driver.findElement(By.xpath(".//*[@id='div-materials-parts']/div[3]/div/div[3]/table/tbody/tr[2]/td[3]/div[1]/select/option[text() =  '"+partName+"' ]")).click();
		
		
		synchronized (driver)
		{
		    driver.wait(3000);
		}
		
		
		
		/*if(partName.endsWith("Doors")) {
			
			driver.findElement(By.xpath(".//*[@id='div-materials-parts']/div[3]/div/div[3]/table/tbody/tr[2]/td[4]/div")).click();
			driver.findElement(By.xpath(".//*[@id='div-materials-parts']/div[3]/div/div[3]/table/tbody/tr[2]/td[4]/div/select/option[text() =  'R' ]")).click();
			
			
	
			//Select userRoleDropDown = new Select(driver.findElement(By.xpath(".//*[@id='div-materials-parts']/div[3]/div/div[3]/table/tbody/tr[2]/td[4]/div/select")));
			//userRoleDropDown.selectByIndex(1);
			
		}

		synchronized (driver)
		{
		    driver.wait(3000);
		}*/
		

		driver.findElement(By.xpath(".//*[@id='div-materials-parts']/div[3]/div/div[3]/table/tbody/tr[2]/td[5]/div")).click();
		driver.findElement(By.xpath(".//*[@id='div-materials-parts']/div[3]/div/div[3]/table/tbody/tr[2]/td[5]/div/select/option[text() = '"+partSize+"' ]")).click();
		
		enterParts(parts);
		
		synchronized (driver)
		{
		    driver.wait(3000);
		}
		
		
		clickAddBtn();
		
		synchronized (driver)
		{
		    driver.wait(3000);
		}
		
		clickOnSaveBtn();
		
		synchronized (driver)
		{
		    driver.wait(3000);
		}
		
		
		clickOnContinueBtn();
		
		synchronized (driver)
		{
		    driver.wait(3000);
		}
		
		if(products.equals("DIY Paint Grade MDF Flat Panel") || products.equals("DIY Paint Grade Solid Wood Shaker") ) {
			System.out.println("Click on paint button");
			clickOnPaint();
			
			synchronized (driver)
			{
			    driver.wait(3000);
			}
			
			driver.findElement(By.xpath(".//*[@id='submit']")).click();
			
			synchronized (driver)
			{
			    driver.wait(3000);
			}
			
			
			displayDYIDiscount();
			
			synchronized (driver)
			{
			    driver.wait(3000);
			}
			
			double totalInches = heightDouble * weightDouble;
			System.out.println("Total Inches "+totalInches);
			double totalSquare = totalInches/144;
			System.out.println("Total square feet "+totalSquare);
			
			double finalDiscount = totalSquare * 12.50;
			
			DecimalFormat df2 = new DecimalFormat(".##");
			String totalDiscount = df2.format(finalDiscount);
			double totalDiscountDouble = Double.valueOf(totalDiscount);
			
			System.out.println("Calucated Discount "+totalDiscountDouble );
			
			if(displayDYIDiscount() == totalDiscountDouble) {
				
				System.out.println(materials +" "+products+" "+cabinet+" "+partName+" "+partSize+" "+parts+" "+height+" "+weight);
				System.out.println("Discount Match .... Pass");
			}else {
				System.out.println(materials +" "+products+" "+cabinet+" "+partName+" "+partSize+" "+parts+" "+height+" "+weight);
				System.out.println("Discount Miss match  .... Failed");
				
			}
		
			
			Assert.assertEquals(displayDYIDiscount(),totalDiscountDouble);

			System.out.println("----------------------------End of iteration------------------------"
					+ " "
					+ " "
					+ " "
					+ " ");
			
			
			driver.get("http://dev.villvay.com/thecabinetface");
			synchronized (driver)
			{
			    driver.wait(4000);
			}
			
		}else {
			System.out.println("Click on unfinish button");
			clickOnUnfinish();
			synchronized (driver)
			{
			    driver.wait(3000);
			}
			clickOnUnfinish();
			synchronized (driver)
			{
			    driver.wait(4000);
			}
			synchronized (driver)
			{
			    driver.wait(3000);
			}
			
			displayDiscount();
			
			
			synchronized (driver)
			{
			    driver.wait(3000);
			}
			
			double totalInches = heightDouble * weightDouble;
			System.out.println("Total Inches "+totalInches);
			double totalSquare = totalInches/144;
			System.out.println("Total square feet "+totalSquare);
			
			double price = totalSquare * 2.04;
			double finalDiscount = price / 0.52;
			
			DecimalFormat df2 = new DecimalFormat(".##");
			String totalDiscount = df2.format(finalDiscount);
			double totalDiscountDouble = Double.valueOf(totalDiscount);
			System.out.println("Calucated Discount "+totalDiscountDouble );
			
			if(displayDiscount() == totalDiscountDouble) {
				System.out.println(materials +" "+products+" "+cabinet+" "+partName+" "+partSize+" "+parts+" "+height+" "+weight);
				System.out.println("Discount Match .... Pass");
			}else {
				System.out.println(materials +" "+products+" "+cabinet+" "+partName+" "+partSize+" "+parts+" "+height+" "+weight);
				System.out.println("Discount Miss match  .... Failed");
				
			}
			
			Assert.assertEquals(displayDiscount(),totalDiscountDouble);
			
			System.out.println("----------------------------End of iteration------------------------"
					+ " "
					+ " "
					+ " "
					+ " ");
			
			driver.get("http://dev.villvay.com/thecabinetface");
			
			
			
			synchronized (driver)
			{
			    driver.wait(4000);
			}
			
			
		}
		
		
		
		return  new MaterialPage(driver);
		
		
	}
	
	
	public void clickOnAddPart() {
		
		
		//WebDriverWait wait = new WebDriverWait(driver, 15);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='div-materials-parts']/div[3]/div/div[3]/table/tbody/tr[2]/td/button']")));
		
		WebElement addPartBtnElement =  driver.findElement(addPartBtn);
		
		if(addPartBtnElement.isDisplayed()) {
			
			addPartBtnElement.click();
		}
		
		else {
			System.out.println("Add Part Button not found");
			driver.get("http://dev.villvay.com/thecabinetface");
		}
		
		
	}
	
	public void enterParts(String parts) {
		
		WebElement partsElement =  driver.findElement(PartsTxtBox);
		
		if(partsElement.isDisplayed()) {
			
			partsElement.clear();
			partsElement.sendKeys(parts);
		}
		
		else {
			System.out.println("Parts Text Box not found");
			driver.get("http://dev.villvay.com/thecabinetface");
		}
		
	}
	
	
	public void clickAddBtn() {
		
		WebElement addBtnElement =  driver.findElement(addBtn);
		
		if(addBtnElement.isDisplayed()) {
			
			addBtnElement.click();
		}
		
		else {
			
			System.out.println("Add button not found");
			driver.get("http://dev.villvay.com/thecabinetface");
		}
		
	}
	
	public void clickOnSaveBtn() {
		
		WebElement saveBtnElement =  driver.findElement(saveBtn);
		
		if(saveBtnElement.isDisplayed()) {
			
			saveBtnElement.click();
		}
		
		else {
			
			System.out.println("Save button not found");
			driver.get("http://dev.villvay.com/thecabinetface");
		}
		
	}
	
	public void clickOnContinueBtn() {
		
		WebElement continuePopBtnElement =  driver.findElement(continuePopBtn);
		
		if(continuePopBtnElement.isDisplayed()) {
			
			continuePopBtnElement.click();
		}
		
		else {
			
			System.out.println("Continue button not found");
			driver.get("http://dev.villvay.com/thecabinetface");
		}
		
	}

		public void clickOnUnfinish() {
			
			WebElement unfinishCheckBoxElement =  driver.findElement(unfinishCheckBox);
			
			unfinishCheckBoxElement.click();
			
			if(unfinishCheckBoxElement.isSelected()) {
				
				System.out.println("Already Check");
			}
			
			else {
				
				unfinishCheckBoxElement.click();
				
				
			}
			
		}
		
		public double displayDiscount() {
			
			WebElement discountTxtElement =  driver.findElement(discountTxt);
			
			if(discountTxtElement.isDisplayed()) {
				
				String discount = discountTxtElement.getText();
				System.out.println("Total Discount amount "+discount);
			}
			
			else System.out.println("Discount amount not found");
			String naturaldiscount = discountTxtElement.getText();
			naturaldiscount = naturaldiscount.substring(2);
			naturaldiscount = naturaldiscount.substring(0, naturaldiscount.length()-1);
			System.out.println("Discount "+naturaldiscount);
			double naturaldiscountDouble  = Double.valueOf(naturaldiscount);
			return naturaldiscountDouble;
		}
		
		public void clickOnPaint() {
			
			WebElement paintCheckBoxElement =  driver.findElement(paintCheckBox);
			
			if(paintCheckBoxElement.isDisplayed()) {
				
				paintCheckBoxElement.click();
			}
			
			else {
				
				System.out.println("Paint Checkbox not found");
				driver.get("http://dev.villvay.com/thecabinetface");
			}
			
		}	
		
		
		public double displayDYIDiscount() {
			
			WebElement discountDYITxtElement =  driver.findElement(discountDYITxt);
			
			if(discountDYITxtElement.isDisplayed()) {
				
				String discount = discountDYITxtElement.getText();
				System.out.println("Total DYI Discount amount "+discount);
				
			}
			
			else System.out.println("Discount amount not found");
			
			String dyeDiscount = discountDYITxtElement.getText();
			dyeDiscount = dyeDiscount.substring(2);
			//dyeDiscount = dyeDiscount.substring(0, dyeDiscount.length()-1);
			System.out.println("Discount "+dyeDiscount);
			double dyeDiscountDouble  = Double.valueOf(dyeDiscount);
			return dyeDiscountDouble;
		}
		
		
		
		

}
