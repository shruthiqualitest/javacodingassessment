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

    @FindBy(xpath = "//div[@class='category-cards']/div[3]")
    private WebElement alertCard;

    @FindBy(xpath = "(//div[@class='mt-4 row'])[1]//button")
    private WebElement alertButton;

    @FindBy(xpath = "(//ul[@class='menu-list'])[3]/li[2]")
    private WebElement alertSection;

    public DemoPage(WebDriver driver) {
        this.driver = driver;
        global = new GlobalVars();
        page = new CommonPage(driver);
        PageFactory.initElements(driver, this);
        global.setProdURL();
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

    public void terminate(){
        driver.quit();
    }
}
