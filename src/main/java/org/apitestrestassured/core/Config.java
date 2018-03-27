package org.apitestrestassured.core;

import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.util.Properties;

public class Config {

    public static Properties config;
    public static Properties testdata;

    @BeforeSuite
    public void loadData() throws IOException {
        config = new Properties();
        config.load(Base.class.getClassLoader().getResourceAsStream("config.properties"));
        testdata = new Properties();
        testdata.load(Base.class.getClassLoader().getResourceAsStream("testdata.properties"));
    }
}
