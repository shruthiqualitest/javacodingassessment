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

    @FindBy(xpath = "(//ul[@class='menu-list']/li[2])")
    private WebElement checkBx;

    @FindBy(xpath = "//div[@class='rct-options']/button")
    private WebElement expandbutton;

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
        page.scrollToElement(angularChckBx, 20);
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

    public void terminate(){
        driver.quit();
    }
}
