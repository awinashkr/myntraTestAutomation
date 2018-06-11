package com.myntra.TestAutomation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WishListPage extends BasePage {
	private WebDriver driver;
	private WebDriverWait wait;
	
	private static final String EXPECTED_URL = "wishlist";
	
	@FindBy(how = How.XPATH, using="//a[@class='itemcard-moveToBag itemcard-boldFont']")
	private WebElement addToBagButton;
	
	@FindBy(how = How.XPATH, using ="//div[@class='sizeselect-sizeButtonsContaier']/button[2]")
	private WebElement selectSizeButton;
	
	@FindBy(how = How.XPATH, using="//a[@class='itemcard-moveToBag itemcard-boldFont']")
	private WebElement doneButton;
	
	@FindBy(how = How.XPATH, using="//div[@class='wishlistEmpty-heading']")
	private WebElement emptyText;

	private WishListPage() {
		
	}
	
	public WishListPage(final WebDriver driver) {
		super(driver);
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 60);
		PageFactory.initElements(driver, this);
		
	}
	
	public boolean isAT() {
		
		try
		{
			return driver.getCurrentUrl().toLowerCase().contains(EXPECTED_URL);
		}
		catch(Exception e ) {
			throw new RuntimeException("Wish list page is not displayed" + e.getMessage(),e);
		}
	}
	

	public void clickOnAddToBagButton() {
		click(addToBagButton);
		
	}
	
	public boolean checkItemAddInWishList() {
		try {
			return	isDisplayed(addToBagButton);
			}
			catch(Exception e) {
				return false;
			}
		
	}
	
	public void selectSize() {
		if(isDisplayed(selectSizeButton))
			click(selectSizeButton);
	}
	
	public void clickDoneButton() {
		click(doneButton);
	}
	
	public void clearItemsFromWishList() {
		List<WebElement> webelement = driver.findElements(By.xpath("//div[@class='itemcard-removeIcon']"));
		
		for(WebElement element : webelement) {
			element.click();
		}
		
	}
	public boolean checkWishListEmptyText() {
		return isDisplayed(emptyText);
	}
	
}
