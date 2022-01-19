package com.qualitestgroup.java.assessment.framework.pages;

import com.qualitestgroup.java.assessment.framework.utils.CommonPage;
import com.qualitestgroup.java.assessment.framework.utils.GlobalVars;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Properties;

public class DemoPage {

    public WebDriver driver;
    public Properties prop;
    public CommonPage page;
    public GlobalVars global;

    @FindBy(xpath = "//div[@class='category-cards']/div")
    private WebElement elementCard;

    @FindBy(xpath = "(//ul[@class='menu-list']/li[2])")
    private WebElement checkBx;

    @FindBy(xpath = "//div[@class='rct-options']/button")
    private WebElement expandButton;

    private static String angularCheckBox = "(//span[@class='rct-checkbox'])[8]";
    String svcElement = "/*[name()='svg']";

    @FindBy(xpath = "(//ul[@class='menu-list']/li[2])[1]")
    private WebElement checkBoxSection;

    public DemoPage(WebDriver driver) {
        this.driver = driver;
        global = new GlobalVars();
        page = new CommonPage(driver);
        PageFactory.initElements(driver, this);
        global.setProdURL();
    }

    /**
     * Checks whether angular checkbox is selectable or not.
     * @return
     */
    public boolean isAngularCheckBoxSelectable() {
        boolean booleanValue;
        navigateToHomePage();
        selectCard(elementCard);
        openCheckBoxSection();
        expandCurrentSection();
        selectCard(angularCheckBox);
        booleanValue = isAngularCheckBoxSelectedOrNotSelected("check");
        selectCard(angularCheckBox);
        booleanValue &= isAngularCheckBoxSelectedOrNotSelected("uncheck");
        return booleanValue;
    }

    /**
     * Clicks a given element
     * @param element Text of an element to be clicked.
     */
    public void clickElement(String element){
        page.clickElement(element, 20);
    }

    public void openCheckBoxSection() {
        clickElement(checkBoxSection);
    }

    /**
     * Expands a section of element.
     */
    public void expandCurrentSection() {
        clickElement(expandButton);
    }

    /**
     * Navigates to home page.
     */
    public void navigateToHomePage() {
        page.navigateTo(global.getProdUrl());
    }

    public void selectCard(WebElement element) {
        scrollToElement(element);
        clickElement(element);
    }

    /**
     * Clicks a given element
     * @param element Clickable web element
     */
    public void clickElement(WebElement element){
        page.clickElement(element,20);
    }

    /**
     * Selects and clicks an element using text.
     * @param element text element used for selecting an element.
     */
    public void selectCard(String element) {
        scrollToElement(element);
        clickElement(element);
    }

    /**
     * Scrolls down to a given element
     * @param element text element used to scroll until it's found.
     */
    public void scrollToElement(String element){
        page.scrollToElement(element, 20);
    }

    /**
     * Scrolls down to a given element
     * @param element Web element used to scroll until it's found.
     */
    public void scrollToElement(WebElement element){
        page.scrollToElement(element, 30);
    }

    /**
     * Checks if the element is checked or un-checked
     * @param param Name of the element to be checked/un-checked
     * @return true if the given element is checked/un-checked.
     */
    public boolean isAngularCheckBoxSelectedOrNotSelected(String param) {
        String[] value = page.getAttributeValueArray(angularCheckBox + svcElement, 20, "class");
        return value[3].equals(param);
    }

    public void terminate(){
        driver.quit();
    }
}
