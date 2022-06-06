package com.example.test.pages;

import com.example.test.base.BasePage;
import org.testng.Assert;

import static com.example.test.constants.Constants.*;
import static com.example.test.data.TestData.homePageUrl;

public class HomePage extends BasePage {

  public void acceptAllCookies() {
    if (isElementDisplayed(btnAcceptAllCookies)) {
      clickElement(btnAcceptAllCookies);
    } else {
      Assert.assertTrue(isElementDisplayed(btnAcceptAllCookies), "Accept All cookies button is not displayed!");
    }
  }

  public void checkHomePageIsOpened() {
    isPageOpened(driver);
    Assert.assertEquals(getPageUrl(), homePageUrl, "Home page url is not true!");
  }

  public void selectCareersPageFromNav() {
    clickElement(mnuMore);
    clickElement(mnuCareers);
  }
}
