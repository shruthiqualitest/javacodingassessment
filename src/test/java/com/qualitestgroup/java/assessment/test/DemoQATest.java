package com.qualitestgroup.java.assessment.test;

import com.qualitestgroup.java.assessment.framework.TestBase.TestBase;
import com.qualitestgroup.java.assessment.framework.pages.DemoPage;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DemoQATest {
    public WebDriver driver;
    public TestBase base;
    public DemoPage demoPage;

    @BeforeClass
    public void launch() {
        base = new TestBase();
        driver = base.getDriver();
        demoPage = new DemoPage(driver);
    }


    @Test
    public void verifyWidgetSection() {
        boolean isStep;
        isStep = demoPage.validateWidgetSection();
        Assert.assertTrue(isStep, "Fail to change date time");
    }

    @AfterClass
    public void terminate(){
        demoPage.terminate();
    }
}