package com.pagefactory.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utills.ReusableMethods;


public class ShoppingPage extends ReusableMethods {
	
	WebDriverWait wait;

	
	public ShoppingPage() {
		
	PageFactory.initElements(driver, this);
	
	}
	
	
	@FindBy(xpath = "//*[@placeholder='Search for products, brands and more']")
	WebElement searchBar;
	
	@FindBy(xpath = "//li[contains(text(),'Tshirts For Men')]")
	WebElement searchIcon;
	
	@FindBy(xpath = "//div[@class='sort-sortBy']") 
	WebElement sort;
	
	@FindBy(xpath = "//*[contains(text(),'Price: Low to High')]")
	WebElement lowtohigh;
	
	@FindBy(xpath = "//*[contains(text(),'Price: High to Low')]")
	WebElement hightolow;
	
	public void searchProduct(String tshirt) throws Exception {
		
		typeValue(searchBar, tshirt);
	}
	
	public void clkSearch() {
		elementClk(searchIcon);
	}
	
	public void sort() {
		elementClkwithWait(sort);
	}
	
	public void lowtohigh() {
		
		elementClkwithWait(lowtohigh);
	}
	
	public void hightolow() {
		elementClkwithWait(hightolow);
	}
	
}
