package org.example.BankOpen;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class SeleniumTest {

    WebDriver driver;

    @BeforeClass
    public void selen() {
        System.setProperty("webdriver.chrome.driver","C:\WebDrivers/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void selenium() {
        String baseURL = "https://www.open.ru";

        driver.get(baseURL);
        Double usdBuy = getCourse("//tr[2]//td[2]//*[@class=\"main-page-exchange__rate\"]");
        Double usdTrade = getCourse("//tr[2]//td[4]//*[@class=\"main-page-exchange__rate\"]");
        Double eurBuy = getCourse("//tr[3]//td[2]//*[@class=\"main-page-exchange__rate\"]");
        Double eurTrade = getCourse("//tr[3]//td[4]//*[@class=\"main-page-exchange__rate\"]");
        System.out.println("usdBuy " + usdBuy);
        System.out.println("usdTrade " + usdTrade);
        System.out.println("eurBuy " + eurBuy);
        System.out.println("eurTrade " + eurTrade);
        Assert.assertTrue(usdBuy < usdTrade);
        Assert.assertTrue(eurBuy < eurTrade);
    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }

    public Double getCourse(String xPath) {
        return Double.parseDouble(driver.findElement(By.xpath(xPath)).getText().replace(",","."));
    }
}