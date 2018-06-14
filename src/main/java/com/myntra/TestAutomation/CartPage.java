package com.myntra.TestAutomation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends BasePage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	private static final String EXPECTED_URL = "checkout/cart";
	
	@FindBy(how = How.XPATH, using="//button[@class='btn primary-btn btn-remove m-button']")
	private WebElement removeButton;
	
	@FindBy(how = How.XPATH, using="//div[@class='empty-cart-icon']")
	private WebElement emptyCartIcon;
	
	@FindBy(how = How.XPATH, using="//button[contains(text(),'PLACE ORDER')]")
	private WebElement placeOrderButton;
	
	
	private CartPage() {
		
	}
	
	public CartPage(WebDriver driver) {
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
			throw new RuntimeException("cart page is not displayed" + e.getMessage(),e);
		}
	}
	
	public boolean checkCart() {
			boolean result = false;
			try {
				List<WebElement> web=driver.findElements(By.xpath("//span[@class='text m-gray confirm-delete-item tappable']"));
				if(web.size()>0) {
					result = true;
				}
				return result;	
				}
				catch(Exception e) {
					return result;
				}
	}
	
	public void clickOnPlaceOrderButton() {
		click(placeOrderButton);
	}
	
	

}
