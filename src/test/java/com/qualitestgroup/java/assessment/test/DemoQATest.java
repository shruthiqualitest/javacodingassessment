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
    public void verifyElementsAngularCheckBx() {
        boolean isStep;
        isStep = demoPage.angularCheckBox();
        Assert.assertTrue(isStep, "Not able to change the value for checkbox");
    }

    @AfterClass
    public void terminate() {
        demoPage.terminate();
    }
}