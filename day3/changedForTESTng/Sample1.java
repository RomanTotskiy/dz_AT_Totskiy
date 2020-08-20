package org.example.day3changedForTESTng;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.*;

public class Sample1 {
    WebDriver chromeDriver;
    //WebDriver safariDriver;

    @BeforeClass
    public void Opensample() {
        System.setProperty("webdriver.chrome.driver","C:\WebDrivers/chromedriver.exe");
        driver = new ChromeDriver();
        //safariDriver = new SafariDriver();
    }

    @Test
    public void sample1() {
        String baseUrl = "http://demo.guru99.com/test/newtours/";

        //safariDriver.get(baseUrl);
        chromeDriver.get(baseUrl);

        //System.out.println("Safari title = " + safariDriver.getTitle());
        System.out.println("Chrome title = " + chromeDriver.getTitle());

    }

    @AfterClass
    public void closeBrowser() {
        chromeDriver.quit();
        //safariDriver.quit();
    }
}
