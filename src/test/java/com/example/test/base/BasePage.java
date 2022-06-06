package com.example.test.base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.Iterator;
import java.util.List;
import java.util.Set;


public class BasePage extends BaseTest {

  protected WebElement findElement(By by) {
    return wait.until(ExpectedConditions.presenceOfElementLocated(by));
  }

  protected List<WebElement> findElements(By by) {
    return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
  }

  protected void hoverElement(By by) throws InterruptedException {
    Thread.sleep(1000);
    Actions actions = new Actions(driver);
    actions.moveToElement(findElement(by)).build().perform();
  }

  protected void selectValueInList(By by, String text) throws InterruptedException {
    Thread.sleep(1000);
    List<WebElement> list = findElements(by);
    for (WebElement element : list) {
      System.out.println("Element List: " + element.getText());
      if (element.getText().contains(text)) {
        element.click();
        break;
      }
    }
  }

  public void switchToLastWindow() {
    Set windows = driver.getWindowHandles();
    Iterator i = windows.iterator();

    i.next();
    String activeWindow = (String) i.next();

    driver.switchTo().window(activeWindow);
  }

  public Boolean checkListValueIsTrue(By by, String text) {
    boolean isListValueTrue = false;
    for (WebElement element : findElements(by)) {
      if (!element.getText().contains(text)) {
        isListValueTrue = false;
        System.out.println("Element value:" + element.getText());
        break;
      } else {
        isListValueTrue = true;
      }
    }
    return isListValueTrue;
  }

  protected void clickElement(By by) {
    findElement(by).click();
  }

  protected void sendKeys(By by, String text) {
    findElement(by).sendKeys(text);
  }

  protected boolean isElementDisplayed(By by) {
    return findElement(by).isDisplayed();
  }

  protected void moveScrollAndClickToElement(By by) {
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("arguments[0].click();", findElement(by));
  }

  protected void moveScrollToElement(By by) {
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("arguments[0].scrollIntoView();", findElement(by));
  }

  protected String getPageUrl() {
    return driver.getCurrentUrl();
  }

  protected void isPageOpened(WebDriver driver) {
    ExpectedCondition<Boolean> expectation = new
        ExpectedCondition<Boolean>() {
          public Boolean apply(WebDriver driver) {
            return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
          }
        };

    try {
      wait.until(expectation);
    } catch (Throwable error) {
      Assert.assertFalse(true, "Timeout waiting for Page Load Request to complete.");
    }
  }
}
