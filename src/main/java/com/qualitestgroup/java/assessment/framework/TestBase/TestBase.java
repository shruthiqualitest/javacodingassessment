package com.qualitestgroup.java.assessment.framework.TestBase;

import com.qualitestgroup.java.assessment.framework.utils.Constants;
import com.qualitestgroup.java.assessment.framework.utils.GlobalVars;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestBase {

    public WebDriver driver;

    public static Properties prop;

    public static FileInputStream file;

    public static GlobalVars global;

    public WebDriver getDriver() {

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
        return driver;
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
