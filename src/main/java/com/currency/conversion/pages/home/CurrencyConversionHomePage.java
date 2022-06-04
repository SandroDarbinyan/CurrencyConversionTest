package com.currency.conversion.pages.home;

import com.currency.conversion.pages.base.CurrencyConversionBasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CurrencyConversionHomePage extends CurrencyConversionBasePageObject {

    public CurrencyConversionHomePage(WebDriver driver) {
        super(driver);
    };

    @FindBy(xpath = CurrencyConversionHomePageXpaths.EMPTY_SELL_INPUT_FIELD)
    public WebElement emptySellInputField;

    @FindBy(xpath = CurrencyConversionHomePageXpaths.NOT_EMPTY_SELL_INPUT_FIELD)
    public WebElement notEmptySellInputField;

    @FindBy(xpath = CurrencyConversionHomePageXpaths.EMPTY_BUY_INPUT_FIELD)
    public WebElement emptyBuyInputField;

    @FindBy(xpath = CurrencyConversionHomePageXpaths.CURRENCY_CALCULATOR_TITLE)
    public WebElement currencyCalculatorTitle;

    @FindBy(xpath = CurrencyConversionHomePageXpaths.COUNTRY_FLAG_ICON)
    public WebElement countryFlagIcon;

    @FindBy(xpath = CurrencyConversionHomePageXpaths.COUNTRIES_DROP_DOWN)
    public WebElement countriesDropDown;

    @FindBy(xpath = CurrencyConversionHomePageXpaths.COUNTRY_INDEX)
    public WebElement countryIndex;

    @FindBy(xpath = CurrencyConversionHomePageXpaths.POLAND_FLAG)
    public WebElement polandFlag;

    @FindBy(xpath = CurrencyConversionHomePageXpaths.CURRENCY_TABLE)
    public WebElement currencyTable;

    @FindBy(xpath = CurrencyConversionHomePageXpaths.POLAND_CURRENCY)
    public WebElement plnCurrency;

    @FindBy(xpath = CurrencyConversionHomePageXpaths.TABLE_ELEMENTS)
    public List<WebElement> tableElements;

    @FindBy(xpath = CurrencyConversionHomePageXpaths.TABLE_FIRST_ITEM)
    public WebElement tableFirstItem;

    @FindBy(xpath = CurrencyConversionHomePageXpaths.TABLE_FIRST_ROW_RECOMMENDED_AMOUNT)
    public WebElement tableFirstRowRecommendedAmount;

    @FindBy(xpath = CurrencyConversionHomePageXpaths.TABLE_FIRST_ROW_BANK_AMOUNT)
    public WebElement tableFirstRowBankAmount;

    @FindBy(xpath = CurrencyConversionHomePageXpaths.TABLE_FIRST_ROW_BANK_AMOUNT_AND_DIFF)
    public WebElement actualDiffAmount;


    public CurrencyConversionHomePage fillInBuyInputField(String value) {
        emptyBuyInputField.sendKeys(value);
        return new CurrencyConversionHomePage(driver);
    }

    public CurrencyConversionHomePage fillInSellInputField(String value) {
        emptySellInputField.sendKeys(value);
        return new CurrencyConversionHomePage(driver);
    }

    public void clickOnCountryFlagIcon() {
        countryFlagIcon.click();
    }

    public void clickOnCountriesDropDown() {
        countriesDropDown.click();
    }

    public void selectCountry(String countryName) {
        WebElement country =  driver.findElement(By.partialLinkText(countryName));
        country.click();
    }

    public String getCountryIndex() {
        return countryIndex.getText();
    }

    public Double getRecommendedAmount() {
        return Double.valueOf(tableFirstRowRecommendedAmount.getText().trim());
    }

    public Double getBankAmount() {
        return Double.valueOf(tableFirstRowBankAmount.getText().trim());
    }

    public Double getExpectedDiffAmount() {
        return getBankAmount() - getRecommendedAmount();
    }

    public String getActualDiffAmount() {
        return actualDiffAmount.getText();
    }


}
