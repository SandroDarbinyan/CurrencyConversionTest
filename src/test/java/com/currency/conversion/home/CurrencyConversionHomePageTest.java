package com.currency.conversion.home;

import com.currency.conversion.base.CurrencyConversionBaseTest;
import com.currency.conversion.pages.home.CurrencyConversionHomePage;
import com.currency.conversion.pages.home.CurrencyConversionHomePageXpaths;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CurrencyConversionHomePageTest extends CurrencyConversionBaseTest {

    @Test
    public void buyAndSellFieldsTest () {

        CurrencyConversionHomePage homePage = new CurrencyConversionHomePage(driver);

        //Scroll to Currency Calculator Title
        Actions actions = new Actions(driver);
        actions.moveToElement(homePage.currencyCalculatorTitle);
        homePage.waitForElementPresent(homePage.notEmptySellInputField);

        //Assert that "Sell" input field is not empty
        Assert.assertTrue(homePage.isElementPresent(CurrencyConversionHomePageXpaths.NOT_EMPTY_SELL_INPUT_FIELD));

        //Fill in "Buy" input field and assert that "Sell" input field is empty, "Buy" input field is empty
        homePage.fillInBuyInputField("300");
        Assert.assertTrue(homePage.isElementPresent(CurrencyConversionHomePageXpaths.EMPTY_SELL_INPUT_FIELD));
        Assert.assertTrue(homePage.isElementPresent(CurrencyConversionHomePageXpaths.NOT_EMPTY_BUY_INPUT_FIELD));

        //Fill in "Sell" input field and assert that "Buy" input field is empty, "Sell" input field is not empty
        homePage.fillInSellInputField("200");
        Assert.assertTrue(homePage.isElementPresent(CurrencyConversionHomePageXpaths.EMPTY_BUY_INPUT_FIELD));
        Assert.assertTrue(homePage.isElementPresent(CurrencyConversionHomePageXpaths.NOT_EMPTY_SELL_INPUT_FIELD));
    }

    @Test
    public void selectCountryTest () {

        CurrencyConversionHomePage homePage = new CurrencyConversionHomePage(driver);

        //Assert that currency table contains a row for Poland currency
        homePage.waitForElementPresent(homePage.tableFirstItem);
        Assert.assertTrue(homePage.doesCountryExistOnTable(homePage.tableElements, "PLN (Polish Zloty)"));

        //Scroll to Country flag icon
        Actions actions = new Actions(driver);
        actions.moveToElement(homePage.countryFlagIcon);

        // Change default country to Poland
        homePage.clickOnCountryFlagIcon();
        homePage.clickOnCountriesDropDown();
        homePage.waitForElementPresent(homePage.polandFlag);
        homePage.selectCountry("Poland");

        //Assert that currency option is changed to the respective default currency for the country
        homePage.waitForElementPresent(homePage.countryIndex);
        Assert.assertEquals(homePage.getCountryIndex(), "PLN");

        //Assert that currency table does not contain row with Poland flag and "PLN (Polish Zloty)" text
        homePage.waitForElementPresent(homePage.currencyTable);
        Assert.assertEquals(homePage.isElementPresent(CurrencyConversionHomePageXpaths.POLAND_CURRENCY), false);
        Assert.assertFalse(homePage.doesCountryExistOnTable(homePage.tableElements, "PLN (Polish Zloty)"));
    }

    @Test
    public void bankAndRecommendedAmountsDifferenceTest () {

        CurrencyConversionHomePage homePage = new CurrencyConversionHomePage(driver);

        //Scroll to Currency Calculator Title
        Actions actions = new Actions(driver);
        actions.moveToElement(homePage.currencyCalculatorTitle);
        homePage.waitForElementPresent(homePage.notEmptySellInputField);

        Double bankAmount = homePage.getBankAmount();
        Double recommendedAmount = homePage.getRecommendedAmount();
        Double expectedDiffAmount = homePage.getExpectedDiffAmount();


        //Assert that if bankAmount < recommendedAmount then Bank Amount column contains the difference of two amounts,
        // else Bank Amount column does not contain the difference of two amounts
        if(bankAmount < recommendedAmount) {
            Assert.assertTrue(homePage.getActualDiffAmount().contains(String.valueOf(homePage.round(expectedDiffAmount, 2))));
        } else {
            Assert.assertTrue(!homePage.getActualDiffAmount().contains(String.valueOf(homePage.round(expectedDiffAmount, 2))));
        }
    }
}
