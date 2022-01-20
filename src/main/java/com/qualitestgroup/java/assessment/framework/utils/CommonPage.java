package com.qualitestgroup.java.assessment.framework.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * CommonPage represents the utilities functions for finding and clicking web elements.
 */
public class CommonPage {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static GlobalVars global;
    public static CommonPage common;

    public static CommonPage getInstance(){
        if(common==null) {
            common = new CommonPage();
        }
        return common;
    }

    /**
     * Constructor for CommonPage
     */
    public CommonPage(){
        global=GlobalVars.getInstance();
        driver=global.getWebDriver();
    }

    /**
     * Clicks a given element
     * @param element element to click
     * @param timeOut max time for searching for the element.
     */
    public void clickElement(String element, int timeOut){
        try {
            driver.manage().timeouts().pageLoadTimeout(timeOut, TimeUnit.SECONDS);
            wait = new WebDriverWait(driver, timeOut);
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(element))));
            driver.findElement(By.xpath(element)).click();
        } catch (ElementNotVisibleException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns an array of values for a given attribute.
     * @param element Element to look for
     * @param timeOut max time to look for a given element.
     * @param attribute name of the attribute
     * @return
     */
    public String[] getAttributeValueArray(String element, int timeOut,String attribute){
        String []str={};
        try {
            wait = new WebDriverWait(driver, timeOut);
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(element))));
            str=driver.findElement(By.xpath(element)).getAttribute(attribute).split("-");
            return str;
        } catch (ElementNotVisibleException e) {
            e.printStackTrace();
        }
        return str;
    }

    /**
     * Takes a screenshot
     * @param method file name of the screenshot.
     */
    public static void takeScreenshot(String method) {
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File dest = new File(method+"snapshot.png");
            FileUtils.copyFile(src, dest);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Checks if a given alert is present.
     * @param timeOut max time to search presence of a given alert.
     * @return true if alert is present, false otherwise
     */
    public boolean isAlertPresent(int timeOut){
        boolean isStep=false;
        try {
            wait = new WebDriverWait(driver, timeOut);
            wait.until(ExpectedConditions.alertIsPresent());

            Alert alert = driver.switchTo().alert();
            alert.dismiss();
            isStep=true;
        } catch (NoAlertPresentException e) {
            e.printStackTrace();
        }
        return isStep;
    }

    /**
     * Gets attribute value for a given web element.
     * @param element Web element to get the attribute value for.
     * @param attribute The attribute to retrieve
     * @param timeOut max time to search for attribute for given web element.
     * @return
     */
    public String  getAttributeValue(WebElement element, String attribute, int  timeOut){
        String attributeValue="";
        try {
            wait = new WebDriverWait(driver, timeOut);
            wait.until(ExpectedConditions.visibilityOf(element));
            attributeValue= element.getAttribute(attribute);
        } catch (ElementNotVisibleException e) {
            e.printStackTrace();
        }
        return attributeValue;
    }

    /**
     * Clicks a given web element using java script executor.
     * @param element Web element to click for
     * @param timeOut Max time to wait for finding the element.
     */
    public void clickElementWithJS(WebElement element, int timeOut){
        try {
            wait = new WebDriverWait(driver, timeOut);
            wait.until(ExpectedConditions.visibilityOf(element));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", element);
        }
        catch (ElementNotVisibleException e) {
            e.printStackTrace();
        }
    }

    /**
     * Clicks a given web element
     * @param element Web element to click for
     * @param timeOut Max time to wait for finding the element.
     */
    public void clickElement( WebElement element,int timeOut) {
        try {
            wait = new WebDriverWait(driver, timeOut);
            wait.until(ExpectedConditions.visibilityOf(element));
            element.click();
        } catch (ElementNotVisibleException e) {
            e.printStackTrace();
        }
    }

    /**
     * Send keys to a given web element
     * @param element Web element to send keys for
     * @param key The text to be entered in the given web element.
     * @param timeOut Max time to wait for finding the element.
     */
    public void sendKeys(WebElement element,String key,int timeOut) {

        try{
            wait = new WebDriverWait(driver, timeOut);
            wait.until(ExpectedConditions.visibilityOf(element));
            element.sendKeys(key);
        }
        catch (ElementNotVisibleException e) {
            e.printStackTrace();
        }
    }
    /**
     * Scroll to a given web element.
     * @param element Web element to be scrolled for.
     * @param timeOut Max time to wait for finding the element.
     */
    public void scrollToElement(WebElement element, int timeOut){
        try {
            wait = new WebDriverWait(driver, timeOut);
            wait.until(ExpectedConditions.visibilityOf(element));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", element);
        }
        catch (ElementNotVisibleException e) {
            e.printStackTrace();
        }
    }

    /**
     * Scroll to a given element.
     * @param element Element to be scrolled for.
     * @param timeOut Max time to wait for finding the element.
     */
    public void scrollToElement(String  element, int timeOut){
        try {
            wait = new WebDriverWait(driver, timeOut);
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(element))));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(element)));
        }
        catch (ElementNotVisibleException e) {
            e.printStackTrace();
        }
    }

    /**
     * Navigates to the given url
     * @param url URL to navigate to
     */
    public void navigateTo(String url){
        driver.manage().window().maximize();
        driver.get(url);
    }
}
