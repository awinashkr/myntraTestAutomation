package com.myntra.TestAutomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ProductListPage extends BasePage{
	private WebDriver driver;
	private WebDriverWait wait;
	
	private static final String EXPECTED_URL = "userquery=true";
	
	@FindBy(how = How.XPATH, using="//ul[@class='results-base']/li[1]")
	private WebElement firstResult;
	
	@FindBy(how = How.XPATH, using = "//ul[@class='results-base']/li[1]/div[3]/span[1]")
	private WebElement firstSaveButton;
	
	@FindBy(how = How.XPATH, using="//ul[@class='results-base']/li[2]")
	private WebElement secondResult;
	
	@FindBy(how = How.XPATH, using = "//ul[@class='results-base']/li[2]/div[3]/span[1]")
	private WebElement secondSaveButton;
	
	
	
	private ProductListPage() {
		
	}
	
	public ProductListPage(final WebDriver driver) {
		super(driver);
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 60);
		PageFactory.initElements(driver, this);
	}
	
	public boolean isAT() {
		
		try
		{
			System.out.println(driver.getCurrentUrl().toLowerCase());
			return driver.getCurrentUrl().toLowerCase().contains(EXPECTED_URL);
			
		}
		catch(Exception e ) {
			throw new RuntimeException("Add address page is not displayed" + e.getMessage(),e);
		}
	}
	
	public void clickOnSaveButtonForFirstProduct() {
		scrollAndClick(firstSaveButton);
	}
	
	public boolean checkResult() {
		try {
		return	isDisplayed(firstResult);
		}
		catch(Exception e) {
			return false;
		}
	}
	

}
