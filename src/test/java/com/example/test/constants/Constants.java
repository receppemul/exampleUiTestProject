package com.example.test.constants;

import org.openqa.selenium.By;

public class Constants {
  public static By btnAcceptAllCookies = By.id("wt-cli-accept-all-btn");
  public static By mnuMore = By.xpath("//div[@id='navbarNavDropdown']/ul/li[6]/a/span[.='More']");
  public static By mnuCareers = By.xpath("//div[@class='dropdown-menu show']//a[@href='https://useinsider.com/careers/']");
  public static By btnSeeAllTeams = By.xpath("//section[@id='career-find-our-calling']//a[.='See all teams']");
  public static By mnuQualityAssurance = By.xpath("//section[@id='career-find-our-calling']//a[.='Quality Assurance']");
  public static By btnSeeAllQaJobs = By.xpath("//section[contains(@class,'career-subs')]//a[.='See all QA jobs']");
  public static By drpFilterByLocation = By.xpath("//select[@id='filter-by-location']/option");
  public static By drpFilterDepartment = By.xpath("//select[@id='filter-by-department']/option");
  public static By crdOpenPositions = By.xpath("//section[@id='career-position-list']//div[contains(@class,'position-list-item-wrapper')]");
  public static By crdOpenPosition = By.xpath("(//section[@id='career-position-list']//div[contains(@class,'position-list-item-wrapper')])[1]");
  public static By crdOpenPositionsDepartment = By.xpath("//section[@id='career-position-list']//div[contains(@class,'position-list-item-wrapper')]/span");
  public static By crdOpenPositionsLocation = By.xpath("//section[@id='career-position-list']//div[contains(@class,'position-list-item-wrapper')]/div[contains(@class,'position-location')]");
  public static By btnApplyNow = By.xpath("(//section[@id='career-position-list']//div[contains(@class,'position-list-item-wrapper')]/a)[1]");
  public static By btnApplyForThisJob = By.xpath("//div[@class='postings-btn-wrapper']/a[.='Apply for this job']");
}
