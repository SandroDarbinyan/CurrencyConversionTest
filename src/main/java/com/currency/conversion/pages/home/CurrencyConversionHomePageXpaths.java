package com.currency.conversion.pages.home;

public class CurrencyConversionHomePageXpaths {
    public static final String NOT_EMPTY_SELL_INPUT_FIELD = "//form/div[1]/input[1][contains(@class, 'ng-not-empty')]";
    public static final String EMPTY_SELL_INPUT_FIELD = "//form/div[1]/input[1][contains(@class, 'ng-empty')]";
    public static final String NOT_EMPTY_BUY_INPUT_FIELD = "//form/div[3]/input[1][contains(@class, 'ng-not-empty')]";
    public static final String EMPTY_BUY_INPUT_FIELD = "//form/div[3]/input[1][contains(@class, 'ng-empty')]";
    public static final String CURRENCY_CALCULATOR_TITLE = "//form/div[3]/input[1]";
    public static final String COUNTRY_FLAG_ICON = "//span[@class='caret']";
    public static final String COUNTRIES_DROP_DOWN = "//button[@id='countries-dropdown']";
    public static final String POLAND_FLAG = "//li//span[contains(@class, 'flag-icon-pl')]";
    public static final String COUNTRY_INDEX = "//form/div[1]//span[@class='ng-binding ng-scope']";
    public static final String CURRENCY_TABLE = "//table[contains(@class, 'table')]";
    public static final String POLAND_CURRENCY = "//td/span[contains(@class, 'flag-icon-pl')]";
    public static final String TABLE_ELEMENTS = "//table[contains(@class, 'table')]//td[1]";
    public static final String TABLE_FIRST_ITEM = "//table[contains(@class, 'table')]//tr[1]/td[1]";
    public static final String TABLE_FIRST_ROW_RECOMMENDED_AMOUNT = "//table[contains(@class, 'table')]//tr[1]/td[4]";
    public static final String TABLE_FIRST_ROW_BANK_AMOUNT = "//table[contains(@class, 'table')]//tr[1]/td[5]/span/span/span[1]";
    public static final String TABLE_FIRST_ROW_BANK_AMOUNT_AND_DIFF = "//table[contains(@class, 'table')]//tr[1]/td[5]";
}
