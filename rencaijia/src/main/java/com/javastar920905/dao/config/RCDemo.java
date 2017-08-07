package com.javastar920905.dao.config;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by ouzhx on 2016/12/1.
 * 参考自官方文档
 * http://www.seleniumhq.org/docs/03_webdriver.jsp
 */
public class RCDemo {
    public static void main(String [] args){
        System.setProperty("webdriver.gecko.driver","D:\\ide-recorder\\IEDriverServer_x64_2.53.1\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.baidu.com");
        WebElement element = driver.findElement(By.id("kw"));

        element.sendKeys("让我来百度一下 ouzhx!");

        // Now submit the form. WebDriver will find the form for us from the element
        element.submit();

        System.out.println("Page title is: " + driver.getTitle());

        // search is rendered dynamically with JavaScript.
        // Wait for the page to load, timeout after 10 seconds
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("让我来百度一下");
            }
        });

        // Should see: "cheese! - Google Search"
        System.out.println("Page title is: " + driver.getTitle());

        try {
            driver.wait(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Close the browser
       driver.quit();
    }
}
