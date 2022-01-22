package com.qualitestgroup.java.assessment.framework.utils;


import com.qualitestgroup.java.assessment.framework.TestBase.TestBase;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

/*
 * Represents global variables used across tests.
 */
public class GlobalVars {
    private static WebDriver driver;
    private static  String file;
    private static String applicationName;
    private static Properties prop;
    private static String prodUrl;
    private static GlobalVars global;

    public static GlobalVars getInstance(){
        if(global==null){
            global=new GlobalVars();
        }
        return global;
    }

    public void setWebDriver(WebDriver driver){
        this.driver = driver;
    }

    public void setProdURL(){
        setApplicationName(Constants.file);
        setFilePath(getApplicationName());
        prop= TestBase.getProperties(getFilePath());
        prodUrl= prop.getProperty("url");
    }

    public String getProdUrl(){
        return prodUrl;
    }

    public WebDriver getWebDriver(){
        return driver;
    }

    public void setFilePath(String applicationName){
        file ="src/main/resources/com.qualitestgroup.java.assessment.propertyfiles/"+applicationName+".properties";
    }

    public String getFilePath(){
        return file;
    }

    public void setApplicationName(String applicationName){
        this.applicationName= applicationName;
    }

    public String getApplicationName(){
        return this.applicationName;
    }
}

