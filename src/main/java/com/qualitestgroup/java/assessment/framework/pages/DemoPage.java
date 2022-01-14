package com.qualitestgroup.java.assessment.framework.pages;

import com.qualitestgroup.java.assessment.framework.utils.CommonPage;
import com.qualitestgroup.java.assessment.framework.utils.GlobalVars;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Properties;

public class DemoPage {

    public WebDriver driver;
    public Properties prop;
    public CommonPage page;
    public GlobalVars global;

    @FindBy(id = "dateAndTimePickerInput")
    private WebElement dateTimePicker;

    @FindBy(xpath = "//ul[contains(@class,'time-list')]/li[6]")
    private WebElement timeSelection;

    @FindBy(xpath = "//div[contains(@class,'week')][5]/div[6]")
    private WebElement dateTimeSelection;

    @FindBy(xpath = "//div[contains(@class,'week')][5]/div[6]")
    private WebElement dateSelection;

    @FindBy(id = "datePickerMonthYearInput")
    private WebElement datePicker;

    @FindBy(xpath = "//div[@class='category-cards']/div[4]")
    private WebElement widgetCard;

    @FindBy(xpath = "(//ul[@class='menu-list'])[4]/li[3]")
    private WebElement datePickerSection;

    public DemoPage(WebDriver driver) {
        this.driver = driver;
        global = new GlobalVars();
        page = new CommonPage(driver);
        PageFactory.initElements(driver, this);
        global.setProdURL();
    }

    public boolean validateWidgetSection() {
        boolean isStep = false;
        page.navigateTo(global.getProdUrl());
        page.scrollToElement(widgetCard,20);
        page.clickElement(widgetCard, 20);
        page.scrollToElement(datePickerSection, 20);
        page.clickElement(datePickerSection, 20);
        String date = page.getAttributeValue(datePicker, "value", 20);
        page.clickElement(datePicker, 20);
        page.clickElement(dateSelection, 20);
        String changedDate = page.getAttributeValue(datePicker, "value", 20);
        String dateNTime = page.getAttributeValue(dateTimePicker, "value", 20);
        page.clickElement(dateTimePicker, 20);
        page.clickElement(dateTimeSelection, 20);
        page.clickElement(timeSelection, 20);
        String changedDateNTime = page.getAttributeValue(dateTimePicker, "value", 20);
        ;
        if (!date.equals(changedDate) && (!dateNTime.equals(changedDateNTime))) {
            isStep = true;
        }
        return isStep;
    }

    public void terminate(){
        driver.quit();
    }
}
