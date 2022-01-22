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

    @FindBy(xpath = "//div[@class='category-cards']/div")
    private WebElement elementCard;

    @FindBy(id = "userName")
    private WebElement userNameTxt;

    @FindBy(xpath = "//div[@id='currentAddress-wrapper']//textarea")
    private WebElement txtArea;

    @FindBy(id = "userEmail")
    private WebElement emailTxtBox;

    @FindBy(xpath = "//div[@id='permanentAddress-wrapper']//textarea")
    private WebElement addressTxtBox;

    @FindBy(id = "submit")
    private WebElement submitBtn;

    @FindBy(xpath = "(//ul[@class='menu-list']/li[1])")
    private WebElement txtBox;

    public DemoPage(WebDriver driver) {
        this.driver = driver;
        global = new GlobalVars();
        page = new CommonPage(driver);
        PageFactory.initElements(driver, this);
        global.setProdURL();
    }

    public boolean validateElementCTxtBox() {
        boolean isStep = false;
        page.navigateTo(global.getProdUrl());
        page.scrollToElement(elementCard, 30);
        page.clickElement(elementCard, 20);
        page.clickElement(txtBox, 20);
        page.sendKeys(userNameTxt, "John Doe", 20);
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

    public void terminate(){
        driver.quit();
    }
}
