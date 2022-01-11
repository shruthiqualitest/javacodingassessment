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

    @FindBy(xpath = "//div[@class='category-cards']/div")
    private WebElement elementCard;

    @FindBy(id = "dateAndTimePickerInput")
    private WebElement dateTimePicker;

    @FindBy(xpath = "//div[@class='category-cards']/div[3]")
    private WebElement alertCard;

    @FindBy(xpath = "(//ul[@class='menu-list']/li[2])")
    private WebElement checkBx;


    @FindBy(xpath = "//ul[contains(@class,'time-list')]/li[6]")
    private WebElement timeSelection;

    @FindBy(xpath = "(//div[@class='mt-4 row'])[1]//button")
    private WebElement alertButton;

    @FindBy(xpath = "//div[@class='rct-options']/button")
    private WebElement expandbutton;

    @FindBy(xpath = "(//ul[@class='menu-list']/li[1])")
    private WebElement txtBox;

    @FindBy(xpath = "(//ul[@class='menu-list'])[3]/li[2]")
    private WebElement alertSection;

    @FindBy(xpath = "//div[contains(@class,'week')][5]/div[6]")
    private WebElement dateTimeSelection;

    @FindBy(xpath = "//div[contains(@class,'week')][5]/div[6]")
    private WebElement dateSelection;

    @FindBy(id = "datePickerMonthYearInput")
    private WebElement datePicker;

    @FindBy(id = "userName")
    private WebElement suerNameTxt;

    @FindBy(xpath = "//div[@id='currentAddress-wrapper']//textarea")
    private WebElement txtArea;

    @FindBy(id = "userEmail")
    private WebElement emailTxtBox;

    @FindBy(xpath = "//div[@id='permanentAddress-wrapper']//textarea")
    private WebElement addressTxtBox;

    @FindBy(id = "submit")
    private WebElement submitBtn;

    @FindBy(xpath = "//div[@class='category-cards']/div[4]")
    private WebElement widgetCard;

    @FindBy(xpath = "(//ul[@class='menu-list'])[4]/li[3]")
    private WebElement datePickerSection;


    String angularChckBx = "(//li[contains(@class,'rct-node-expanded')])[3]//li[2]//span[@class='rct-checkbox']";
    String svcElement = "/*[name()='svg']";


    public DemoPage(WebDriver driver) {
        this.driver = driver;
        global = new GlobalVars();
        page = new CommonPage(driver);
        PageFactory.initElements(driver, this);
        global.setProdURL();
    }

    public boolean angularCheckBox() {
        boolean isStep = false;
        page.navigateTo(global.getProdUrl());
        page.scrollToElement(elementCard, 30);
        page.clickElement(elementCard, 20);
        page.clickElement(checkBx, 20);
        page.clickElement(expandbutton, 20);
        page.scrollToElement(angularChckBx,20);
        page.clickElement(angularChckBx, 20);

        String value[] = page.getAttributeValueArray(angularChckBx + svcElement, 20, "class");
        if (value[3].equals("check")) {

            isStep = true;
        }
        page.clickElement(angularChckBx, 20);
        String updatedValue[] = page.getAttributeValueArray(angularChckBx + svcElement, 20, "class");
        if (updatedValue[3].equals("uncheck")) {

            isStep &= true;
        }
        return isStep;


    }

    public boolean validateElementCTxtBox() {
        boolean isStep = false;
        page.navigateTo(global.getProdUrl());
        page.scrollToElement(elementCard, 30);
        page.clickElement(elementCard, 20);
        page.clickElement(txtBox, 20);
        page.sendKeys(suerNameTxt, "John Doe", 20);
        page.scrollToElement(txtArea, 20);
        page.sendKeys(txtArea, " 78 Test Str, State, 12345", 20);
        page.sendKeys(emailTxtBox, "JohnDoe1", 20);

        page.sendKeys(addressTxtBox, " 78 Test Str, State, 12345", 20);
        page.scrollToElement(submitBtn, 20);
        page.clickElement(submitBtn, 20);
        String error = page.getAttributeValue(emailTxtBox, "class", 20);
        if (error.contains("field-error")) {
            isStep = true;
        }
        return isStep;
    }

    public boolean validateAlert() {
        boolean isStep = false;
        page.navigateTo(global.getProdUrl());
        page.scrollToElement(alertCard,20);
        page.clickElement(alertCard, 20);
        page.scrollToElement(alertSection, 20);
        page.clickElement(alertSection, 20);
        page.clickElementWithJS(alertButton, 20);
        isStep = page.isAlertPresent(20);
        return isStep;
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
