package com.qualitestgroup.java.assessment.test;

import com.qualitestgroup.java.assessment.framework.TestBase.TestBase;
import com.qualitestgroup.java.assessment.framework.pages.DemoPage;
import com.sun.org.glassfish.gmbal.Description;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DemoQATest extends TestBase {
    public DemoPage demoPage;

    @BeforeClass
    public void launch(){
        demoPage = DemoPage.getInstance();
    }

    @Test
    @Description("Verify alert should appear when user click on button that trigger alert event")
    public void verifyAlertsSection() {
        boolean isStep;
        isStep = demoPage.validateAlert();
        Assert.assertTrue(isStep, "Fail as alert is not present");
    }

    @AfterClass
    public void terminate() {
        demoPage.terminate();
    }
}