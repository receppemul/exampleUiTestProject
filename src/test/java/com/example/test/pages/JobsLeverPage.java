package com.example.test.pages;

import com.example.test.base.BasePage;
import org.testng.Assert;

import static com.example.test.data.TestData.jobsLeverPageUrl;
import static com.example.test.constants.Constants.*;

public class JobsLeverPage extends BasePage {

  public void checkJobsLeverPageIsOpened() {
    isPageOpened(driver);
    Assert.assertTrue(getPageUrl().contains(jobsLeverPageUrl), "Jobs lever page url is not true!");
    Assert.assertTrue(isElementDisplayed(btnApplyForThisJob), "Apply for this is job button is not displayed!");
  }
}
