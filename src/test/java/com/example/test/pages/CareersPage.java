package com.example.test.pages;

import com.example.test.base.BasePage;
import org.testng.Assert;

import static com.example.test.constants.Constants.btnApplyNow;
import static com.example.test.constants.Constants.btnSeeAllQaJobs;
import static com.example.test.constants.Constants.btnSeeAllTeams;
import static com.example.test.constants.Constants.crdOpenPosition;
import static com.example.test.constants.Constants.crdOpenPositions;
import static com.example.test.constants.Constants.crdOpenPositionsDepartment;
import static com.example.test.constants.Constants.crdOpenPositionsLocation;
import static com.example.test.constants.Constants.drpFilterByLocation;
import static com.example.test.constants.Constants.drpFilterDepartment;
import static com.example.test.constants.Constants.mnuQualityAssurance;
import static com.example.test.data.TestData.*;

public class CareersPage extends BasePage {

  public void checkCareersPageIsOpened() {
    isPageOpened(driver);
    Assert.assertEquals(getPageUrl(), careersPageUrl, "Careers page url is not true!");
  }

  public void selectQAJobWithFilters() throws InterruptedException {
    moveScrollAndClickToElement(btnSeeAllTeams);
    moveScrollAndClickToElement(mnuQualityAssurance);
    moveScrollAndClickToElement(btnSeeAllQaJobs);
    selectValueInList(drpFilterByLocation, locationName);
    selectValueInList(drpFilterDepartment, departmentName);
  }

  public void selectOpenPosition() throws InterruptedException {
    moveScrollToElement(crdOpenPosition);
    hoverElement(crdOpenPosition);
    clickElement(btnApplyNow);
  }

  public void switchToLeverApplicationFormPage(){
    switchToLastWindow();
  }

  public void checkOpenPositionsIsFound() {
    Assert.assertTrue(findElements(crdOpenPositions).size() > 0, "Open positions are not found!");
  }

  public void checkOpenPositionsLocationAreTrue() {
    Assert.assertTrue(checkListValueIsTrue(crdOpenPositionsLocation, locationName), "Open position locations are not true!");
  }

  public void checkOpenPositionsDepartmentsAreTrue() {
    Assert.assertTrue(checkListValueIsTrue(crdOpenPositionsDepartment, departmentName), "Open position departments are not true!");
  }
}
