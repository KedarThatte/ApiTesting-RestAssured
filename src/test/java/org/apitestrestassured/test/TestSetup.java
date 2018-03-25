package org.apitestrestassured.test;

import io.restassured.http.ContentType;
import io.restassured.internal.assertion.Assertion;
import io.restassured.response.Response;
import org.apitestrestassured.core.Base;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;

import static io.restassured.RestAssured.given;
import static io.restassured.path.json.JsonPath.from;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class TestSetup extends Base{

    @Test
    public void test01 () {

        CopyOnWriteArraySet jsonAsArrayList=null;
        Response resp;
        resp=
        given()
                .spec (reqspec)
                .when ()
                .log()
                .uri().log().parameters()
                .get (testdata.getProperty("iso2schIN"))
                .then ()
                .contentType (ContentType.JSON)
                .statusCode (200)
                .extract().response();
        System.out.println(resp.prettyPrint().toString());
        Assert.assertEquals("200",resp.statusCode());
        //System.out.println(resp);


    }
    @Test(dependsOnMethods = "test01")
    public void test02 () {

        CopyOnWriteArraySet jsonAsArrayList=null;
        String resp;
        resp=
                given()
                        .spec (reqspec)
                        .when ()
                        .log()
                        .uri().log().parameters()
                        .get (testdata.getProperty("iso2schUS"))
                        .then ()
                        .contentType (ContentType.JSON)
                        .statusCode (200)
                        .extract().response().prettyPrint();
        //System.out.println(resp);


    }
}
