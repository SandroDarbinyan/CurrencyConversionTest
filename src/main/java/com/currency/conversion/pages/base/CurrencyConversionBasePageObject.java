package com.currency.conversion.pages.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CurrencyConversionBasePageObject {

    protected WebDriver driver;

    public CurrencyConversionBasePageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void waitForElementPresent(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public boolean isElementPresent(String xpath) {
        if(driver.findElements(By.xpath(xpath)).size()>0)
            return true;
        else return false;
    }

    public boolean doesCountryExistOnTable(List<WebElement> elements, String countryDetails) {
        return elements.stream().anyMatch(e->e.getText().trim().equals(countryDetails));
    }

    public double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
}
