package com.example.test.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.time.Duration;

import static com.example.test.data.TestData.homePageUrl;


public class BaseTest {
  public static WebDriver driver;
  public static WebDriverWait wait;

  @BeforeTest
  @Parameters({"browser"})
  public void setupBrowser(String browser) {
    if (browser.contains("Chrome")) {
      WebDriverManager.chromedriver().setup();
      driver = new ChromeDriver(chromeOptions());

    }
    if (browser.contains("Firefox")) {
      WebDriverManager.firefoxdriver().setup();
      driver = new FirefoxDriver(firefoxOptions());
    }

    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.manage().deleteAllCookies();
    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    driver.get(homePageUrl);

  }

  private ChromeOptions chromeOptions() {
    ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.addArguments("--test-type");
    chromeOptions.addArguments("--disable-popup-blocking");
    chromeOptions.addArguments("--ignore-certificate-errors");
    chromeOptions.addArguments("--disable-translate");
    chromeOptions.addArguments("--start-maximized");
    chromeOptions.addArguments("--disable-notifications");
    return chromeOptions;
  }

  private FirefoxOptions firefoxOptions() {
    FirefoxOptions firefoxOptions = new FirefoxOptions();
    firefoxOptions.addArguments("--test-type");
    firefoxOptions.addArguments("--disable-popup-blocking");
    firefoxOptions.addArguments("--ignore-certificate-errors");
    firefoxOptions.addArguments("--disable-translate");
    firefoxOptions.addArguments("--start-maximized");
    firefoxOptions.addArguments("--disable-notifications");
    return firefoxOptions;
  }

  @AfterTest
  public void teardown() throws InterruptedException {
    if (driver != null) {
      driver.quit();
      System.out.println("********** Test is successfully completed! **********");
    }
  }
}
