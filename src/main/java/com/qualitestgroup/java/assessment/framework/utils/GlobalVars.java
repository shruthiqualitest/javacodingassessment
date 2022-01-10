package com.qualitestgroup.java.assessment.framework.utils;


import com.qualitestgroup.java.assessment.framework.TestBase.TestBase;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class GlobalVars {

    private WebDriver driver;
    private String file;
    private String applicationName;
    private Properties prop;
    private String prodUrl;

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

    public void setFilePath(String filepath){

            file = filepath;

    }
    public String getFilePath(){
        return file;

    }
    public void setApplicationName(String applicationName){
        this.applicationName= "src/main/resources/PropertyFile/"+applicationName+".properties";
    }
    public String getApplicationName(){
        return this.applicationName;
    }

}

