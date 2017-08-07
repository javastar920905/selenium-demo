package com.javastar920905.dao.config;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaiduTest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://offlintab.firefoxchina.cn/";
   // driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @org.junit.Test
  public void test() throws Exception {
    driver.get(baseUrl + "/?cachebust=20150714");
    driver.findElement(By.name("q")).click();
    driver.findElement(By.name("q")).clear();
    driver.findElement(By.name("q")).sendKeys("baidu");
    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
  }

  @After
  public void tearDown() throws Exception {
    try {
      driver.wait();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
