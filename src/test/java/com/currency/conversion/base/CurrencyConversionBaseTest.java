package com.currency.conversion.base;

import dataProvider.ConfigFileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

public class CurrencyConversionBaseTest {

    protected WebDriver driver;
    ConfigFileReader configFileReader;

    @BeforeClass
    public void prepareEnv() throws IOException {

        configFileReader= new ConfigFileReader();

        System.setProperty("webdriver.chrome.driver", configFileReader.getDriverPath());
        driver = new ChromeDriver();

        //Step *.1: Navigate to https://www.paysera.bg/v2/en-LT/fees/currency-conversion-calculator page
        driver.get(configFileReader.getUrl());

        driver.manage().window().maximize();
        String title =  driver.getTitle();
        Assert.assertEquals(title, "Online Currency Exchange | Currency Converter | Paysera");

    }

    @AfterClass
    public void cleanUp() {
        driver.quit();
    }
}
