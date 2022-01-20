package com.qualitestgroup.java.assessment.framework.pages;

import com.qualitestgroup.java.assessment.framework.utils.CommonPage;
import com.qualitestgroup.java.assessment.framework.utils.GlobalVars;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Properties;

/**
 * Placeholder for {@link "www.demoqa.com" DemoQA} web elements
 */
public class DemoPage {
    public static DemoPage demo;
    public WebDriver driver;
    public Properties prop;
    public CommonPage page;
    public GlobalVars global;

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

    public void terminate(){
        driver.quit();
    }
}
