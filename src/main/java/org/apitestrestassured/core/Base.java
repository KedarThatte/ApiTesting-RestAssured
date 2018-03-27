package org.apitestrestassured.core;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.apache.http.client.methods.RequestBuilder;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.io.IOException;
import java.util.Properties;

public class Base extends Config {


    protected RequestSpecification reqspec;
    RequestSpecBuilder reqbuild;

    @Parameters({"uritype"})
    @BeforeMethod

    public void requestSpec(String uri){

        reqbuild = new RequestSpecBuilder();
        reqbuild.setBaseUri(config.getProperty(uri));
        //reqbuild.setBasePath(testdata.getProperty("iso2schIN"));
        //reqbuild.addParam("","");
        reqspec=reqbuild.build();
    }

}
