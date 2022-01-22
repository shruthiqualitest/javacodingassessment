package com.qualitestgroup.java.assessment.test;

import com.qualitestgroup.java.assessment.framework.pages.DemoPage;
import com.sun.org.glassfish.gmbal.Description;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.qualitestgroup.java.assessment.framework.TestBase.TestBase;

public class DemoQATest extends TestBase {
    public DemoPage demoPage;

    @BeforeClass
    public void launch(){
        demoPage = DemoPage.getInstance();
    }

    @Test
    @Description("Verify validation of email text box with invalid values")
    public void verifyElementsTextBox() {
        boolean isStep;
        isStep = demoPage.validateElementTextBox();
        Assert.assertTrue(isStep, "Fail to see validation error");
    }

    @AfterClass
    public void terminate() {
        demoPage.terminate();
    }
}