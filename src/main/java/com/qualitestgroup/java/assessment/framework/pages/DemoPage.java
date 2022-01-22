package com.qualitestgroup.java.assessment.framework.pages;

import com.qualitestgroup.java.assessment.framework.utils.CommonPage;
import com.qualitestgroup.java.assessment.framework.utils.GlobalVars;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Properties;

/**
 * Placeholder for {@link "www.demoqa.com" DemoQA} web elements
 */
public class DemoPage {
    public static DemoPage demo;
    public WebDriver driver;
    public CommonPage page;
    public GlobalVars global;

    @FindBy(xpath = "//div[contains(@class,'week')][5]/div[6]")
    private WebElement dateTimeSelection;

    @FindBy(xpath = "//div[contains(@class,'week')][5]/div[6]")
    private WebElement dateSelection;

    @FindBy(id = "datePickerMonthYearInput")
    private WebElement datePicker;

    @FindBy(css= "div.category-cards > div:nth-of-type(4)")
    private WebElement widgetCard;

    @FindBy(css= "#item-2")
    private List<WebElement> datePickerSection;

    @FindBy(id = "dateAndTimePickerInput")
    private WebElement dateTimePicker;

    @FindBy(css="ul[class*=time-list] > li:nth-of-type(2)")
    private WebElement timeSelection;

    public static DemoPage getInstance(){
        if(demo==null){
            demo=new DemoPage();
        }
        return demo;
    }
    public DemoPage() {
        global = GlobalVars.getInstance();
        driver=global.getWebDriver();
        page = CommonPage.getInstance();
        PageFactory.initElements(driver, this);
        global.setProdURL();
    }

    public boolean validateWidgetSection() {
        navigateToHmePage();
        selectCard(widgetCard);
        selectCard(datePickerSection.get(2));
        String date =getAttributeValue(datePicker, "value");
        clickElement(datePicker);
        clickElement(dateSelection);
        String changedDate =getAttributeValue(datePicker, "value");
        String dateNTime = getAttributeValue(dateTimePicker, "value");
        clickElement(dateTimePicker);
        clickElement(dateTimeSelection);
        clickElement(timeSelection);
        String changedDateNTime = getAttributeValue(dateTimePicker, "value");
        return !date.equals(changedDate) && !dateNTime.equals(changedDateNTime);
    }

    ///Helper Functions
    public void selectCard(WebElement element) {
        scrollToElement(element);
        clickElement(element);
    }

    public void openCheckBoxSection(final List<WebElement> checkBoxSection) {
        clickElement(checkBoxSection.get(0));
    }

    public void expandCurrentSection(final WebElement expandButton) {
        clickElement(expandButton);
    }

    public void selectCard(String element) {
        scrollToElement(element);
        clickElement(element);
    }

    public void scrollToElement(String element){
        page.scrollToElement(element, 20);
    }

    public void clickElement(String element){
        page.clickElement(element, 20);
    }

    public void navigateToHmePage() {
        page.navigateTo(global.getProdUrl());
    }
    public String getAttributeValue(WebElement element, String attribute){
        return page.getAttributeValue(element,attribute,20);
    }

    public void scrollToElement(WebElement element){
        page.scrollToElement(element, 30);
    }
    public void clickElement(WebElement element){
        page.clickElement(element,20);
    }
    public void sendKeysTextBox(WebElement element, String keys){
        page.sendKeys(element,keys,20);;
    }

    public void submitForm(final WebElement submitButton){
        scrollToElement(submitButton);
        clickElement(submitButton);;
    }

    public boolean isErrorReturned(WebElement element, String attribute){
        return getAttributeValue(element,attribute).contains("field-error");
    }

    public void terminate(){
        driver.quit();
    }
}
