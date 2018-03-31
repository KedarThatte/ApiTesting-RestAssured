package org.apitestrestassured.test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apitestrestassured.core.Base;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.util.concurrent.CopyOnWriteArraySet;

import static io.restassured.RestAssured.given;

public class CountryStateTextSearch extends Base {

    @Test
    public void txtCountryStateTxtSearch1() {

        CopyOnWriteArraySet jsonAsArrayList=null;
        Response resp ;
        resp=   given()
                .spec (reqspec)
                .when ()
                .log()
                .uri().log().parameters()
                .get (testdata.getProperty("txtIndstatesearch"))
                .then ()
                .contentType (ContentType.JSON)
                .statusCode (200)
                .extract().response();
        Reporter.log(resp.prettyPrint());
    }
    @Test(dependsOnMethods = "txtCountryStateTxtSearch1")
    public void txtCountryStateTxtSearch2() {

        CopyOnWriteArraySet jsonAsArrayList=null;
        Response resp;
        resp=
                given()
                        .spec (reqspec)
                        .when ()
                        .log()
                        .uri().log().parameters()
                        .get (testdata.getProperty("txtUsastatesearch"))
                        .then ()
                        .contentType (ContentType.JSON)
                        .statusCode (200)
                        .extract().response();
        Reporter.log(resp.prettyPrint());
    }
}
