package com.javastar920905.dao.config;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class LoginTest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://192.168.1.170/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testLogin() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.linkText("登录")).click();
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("15975513113");
    Thread.sleep(3000);
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("123456");
    driver.findElement(By.name("password")).click();
    Thread.sleep(1000);
   // driver.findElement(By.id("check")).click();
   // driver.findElement(By.cssSelector("label")).click();
    driver.findElement(By.xpath("//input[@value='登  录']")).click();

    //如果出现验证提示
    if (driver.findElement(By.xpath(".//*[@id='userId']/span")).getText().contains("请输入手机号/用户名！")){
      driver.findElement(By.name("username")).click();
      Thread.sleep(1000);
      driver.findElement(By.name("password")).click();
      Thread.sleep(1000);
      driver.findElement(By.xpath("//input[@value='登  录']")).click();
    }
    Thread.sleep(1000);
    driver.findElement(By.xpath("//input[@value='登  录']")).click();
   // http://192.168.1.170/hirer/
    driver.findElement(By.cssSelector("div.user-account.active")).click();
    driver.findElement(By.linkText("退出")).click();
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
