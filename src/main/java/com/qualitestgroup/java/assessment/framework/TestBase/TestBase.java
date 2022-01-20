package com.qualitestgroup.java.assessment.framework.TestBase;

import com.qualitestgroup.java.assessment.framework.utils.Constants;
import com.qualitestgroup.java.assessment.framework.utils.GlobalVars;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Base test plan that can be extended by all tests.
 */
public class TestBase {

    public static WebDriver driver;

    public static Properties prop;

    public static FileInputStream file;

    public static GlobalVars global;

    @BeforeSuite
    public static void  getDriver() {
        global = new GlobalVars();
        global.setApplicationName(Constants.file);
        global.setFilePath(global.getApplicationName());
        prop = getProperties(global.getFilePath());

        if (prop.getProperty("browser").equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if ((prop.getProperty("browser").equals("firefox"))) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        global.setWebDriver(driver);
    }

    public static Properties getProperties(String filepath) {
        try {
            file = new FileInputStream(filepath);
            prop = new Properties();
            prop.load(file);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }
}

