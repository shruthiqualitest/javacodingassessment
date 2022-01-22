package com.qualitestgroup.java.assessment.framework.pages;

import com.qualitestgroup.java.assessment.framework.utils.CommonPage;
import com.qualitestgroup.java.assessment.framework.utils.GlobalVars;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Placeholder for {@link "www.demoqa.com" DemoQA} web elements
 */
public class DemoPage {
    public static DemoPage demo;
    public WebDriver driver;
    public CommonPage page;
    public GlobalVars global;

    @FindBy(css = "div.category-cards>div")
    private WebElement elementCard;

    @FindBy(css = "ul.menu-list > li:nth-of-type(1)")
    private List<WebElement> textBox;

    @FindBy(id = "userName")
    private WebElement userNameTextBox;

    @FindBy(css = "div#currentAddress-wrapper textarea")
    private WebElement textArea;

    @FindBy(id = "userEmail")
    private WebElement emailTextBox;

    @FindBy(css = "div#permanentAddress-wrapper textarea")
    private WebElement addressTextBox;

    @FindBy(id = "submit")
    private WebElement submitButton;

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

    public boolean validateElementTextBox() {

        navigateToHmePage();
        selectCard(elementCard);
        selectCard(textBox.get(0));

        sendKeysTextBox(userNameTextBox,"John Doe");
        sendKeysTextBox(textArea, " 78 Test Str, State, 12345");
        sendKeysTextBox(emailTextBox, "JohnDoe1");
        sendKeysTextBox(addressTextBox, "78 Test Str, State, 12345");
        submitForm(submitButton);

        return isErrorReturned(emailTextBox, "class");
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