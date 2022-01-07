package com.qualitestgroup.java.assessment.framework.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class CommonPage {
    public static WebDriver driver;
    public WebDriverWait wait;
    public CommonPage(WebDriver driver){
        this.driver= driver;
    }

    public void clickElement(String element, int timeOut){

        try {
            wait = new WebDriverWait(driver, timeOut);
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(element))));
            driver.findElement(By.xpath(element)).click();
        } catch (ElementNotVisibleException e) {
            e.printStackTrace();
        }
    }

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
    public void clickElement( WebElement element,int timeOut) {
        try {

            wait = new WebDriverWait(driver, timeOut);
            wait.until(ExpectedConditions.visibilityOf(element));
            element.click();
        } catch (ElementNotVisibleException e) {
            e.printStackTrace();
        }
    }
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

    public void navigateTo(String url){
        driver.manage().window().maximize();
        driver.get(url);

    }


}
