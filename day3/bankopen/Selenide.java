package org.example.BankOpen;

import day3.SelenidPages.openBank.OpenBankMainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class Selenide {

    @Test
    public void selenide() {
        OpenBankMainPage obmp = open("https://www.open.ru", OpenBankMainPage.class);
        System.out.println("USD: " + obmp.getUsdBuy() + " / " + obmp.getUsdTrade());
        System.out.println("EUR: " + obmp.getEurBuy() + " / " + obmp.getEurTrade());
        Assert.assertTrue(obmp.getUsdBuy() < obmp.getUsdTrade());
        Assert.assertTrue(obmp.getEurBuy() < obmp.getEurTrade());

    }
}