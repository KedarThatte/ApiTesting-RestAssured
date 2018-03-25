package org.apitestrestassured.core;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.apache.http.client.methods.RequestBuilder;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.io.IOException;
import java.util.Properties;

public class Base {


    protected RequestSpecification reqspec;
    RequestSpecBuilder reqbuild;
    public static Properties config;
    public static Properties testdata;

    @BeforeSuite
    public void getdata() throws IOException {
        config = new Properties();
        config.load(Base.class.getClassLoader().getResourceAsStream("config.properties"));
        testdata = new Properties();
        testdata.load(Base.class.getClassLoader().getResourceAsStream("testdata.properties"));
    }

    @BeforeMethod
    @Parameters("uritype")
    public void requestSpec(){
        String uri ;
        reqbuild = new RequestSpecBuilder();
        reqbuild.setBaseUri(config.getProperty("iso2URI"));
        //reqbuild.setBasePath(testdata.getProperty("iso2schIN"));
        //reqbuild.addParam("","");
        reqspec=reqbuild.build();
    }

}
