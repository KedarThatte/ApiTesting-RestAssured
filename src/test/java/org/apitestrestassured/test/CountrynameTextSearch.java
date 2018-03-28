package org.apitestrestassured.test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apitestrestassured.core.Base;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.util.concurrent.CopyOnWriteArraySet;

import static io.restassured.RestAssured.given;

public class CountrynameTextSearch extends Base {

    @Test
    public void txtCountryNameSearch1() {

        CopyOnWriteArraySet jsonAsArrayList=null;
        Response resp ;
        resp=   given()
                .spec (reqspec)
                .when ()
                .log()
                .uri().log().parameters()
                .get (testdata.getProperty("txtschAfg"))
                .then ()
                .contentType (ContentType.JSON)
                .statusCode (200)
                .extract().response();
        Reporter.log(resp.prettyPrint());
    }
    @Test(dependsOnMethods = "txtCountryNameSearch1")
    public void txtCountryNameSearch2() {

        CopyOnWriteArraySet jsonAsArrayList=null;
        Response resp;
        resp=
                given()
                        .spec (reqspec)
                        .when ()
                        .log()
                        .uri().log().parameters()
                        .get (testdata.getProperty("txtschChi"))
                        .then ()
                        .contentType (ContentType.JSON)
                        .statusCode (200)
                        .extract().response();
        Reporter.log(resp.prettyPrint());
    }
}
