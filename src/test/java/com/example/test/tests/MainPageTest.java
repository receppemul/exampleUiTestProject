package com.example.test.tests;

import com.example.test.base.BaseTest;
import com.example.test.pages.CareersPage;
import com.example.test.pages.HomePage;
import com.example.test.pages.JobsLeverPage;
import org.testng.annotations.Test;

public class MainPageTest extends BaseTest {
  HomePage homePage = new HomePage();
  CareersPage careersPage = new CareersPage();
  JobsLeverPage jobsLeverPage = new JobsLeverPage();

  @Test
  public void checkRedirectionJobsLeverPage() throws InterruptedException {
    homePage.acceptAllCookies();
    homePage.checkHomePageIsOpened();
    homePage.selectCareersPageFromNav();
    careersPage.checkCareersPageIsOpened();
    careersPage.selectQAJobWithFilters();
    careersPage.checkOpenPositionsIsFound();
    careersPage.checkOpenPositionsLocationAreTrue();
    careersPage.checkOpenPositionsDepartmentsAreTrue();
    careersPage.selectOpenPosition();
    careersPage.switchToLeverApplicationFormPage();
    jobsLeverPage.checkJobsLeverPageIsOpened();
  }
}
