package com.myntra.TestAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.log4testng.Logger;

public class BasePage {
	private WebDriver driver;
	private WebDriverWait wait;
	private JavascriptExecutor jsExecutor;
	private final static Logger logger = Logger.getLogger(BasePage.class);
	
	protected BasePage() {
		
	}
	
	protected BasePage(final WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver , 60);
		jsExecutor = (JavascriptExecutor)driver;		
	}
	
	protected WebDriver getDriver() {return this.driver;}
	
	protected void click(final WebElement element) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
        } catch (Exception e) {
            if (!isDisplayed(element)) {
                throw new NoSuchElementException(String.format("%s is not displayed on %s. ", element, driver.getCurrentUrl()), e);
            } else {
                if (!isEnabled(element)) {
                    throw new RuntimeException(String.format("%s is displayed, but not enabled. on %s ", element, driver.getCurrentUrl()), e);
                }
            }
        }
    }

    protected void clickByJs(WebElement element) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

        } catch (Exception e) {

            throw new RuntimeException(e.getMessage(), e);
        }
    }


    protected void mouseOverThenClick(final WebElement element) {
        Actions builder = new Actions(driver);
        builder.moveToElement(element).build().perform();
        builder.click();
    }
    
    protected void mouseOverOneElementAndClickOnButton(final WebElement element, final WebElement element2) {
        Actions builder = new Actions(driver);
        builder.moveToElement(element).click(element2).build().perform();
       
    }
    
    protected boolean mouseOverAndCheck(final WebElement element, final WebElement element2) {
    	try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        Actions builder = new Actions(driver);
        builder.moveToElement(element).build().perform();
        return isDisplayed(element2);
    }

    /**
     * This method waits until page is loaded, then scroll and click the element by javascript
     *
     * @param element UIElement that appears on the page.
     */
    protected void scrollAndClick(final WebElement element) {
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
        jsExecutor.executeScript("arguments[0].click();", element);

      
    }
    
    protected void waitUntilLoaded() {
    	jsExecutor.executeScript("return document.readyState").equals("complete");
    }

    protected void scrollandCheck(final WebElement element) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            if (!element.isSelected()) {
                jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
                jsExecutor.executeScript("arguments[0].click();", element);
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

   
    protected void check(final WebElement element) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            if (!element.isSelected()) {
                element.click();
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
   
    protected void typeIn(final WebElement element, final String input) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            element.clear();
            element.sendKeys(input);
            wait.until(ExpectedConditions.textToBePresentInElementValue(element, input));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

   protected boolean isDisplayed(final WebElement element) {
        try {
        	wait.until(ExpectedConditions.visibilityOf(element));
            return element.isDisplayed();
        } catch (Exception e) {
           
            return false;
        }
    }

   
    protected boolean isDisplayed(final String locator) {
        try {
            return driver.findElement(By.xpath(locator)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    protected boolean isEnabled(final WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return element.isEnabled();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

}
