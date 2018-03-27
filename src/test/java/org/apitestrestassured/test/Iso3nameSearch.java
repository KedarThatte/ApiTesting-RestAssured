package org.apitestrestassured.test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apitestrestassured.core.Base;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.util.concurrent.CopyOnWriteArraySet;

import static io.restassured.RestAssured.given;

public class Iso3nameSearch extends Base {


    @Test
    public void iso3namesearchIn() {

        CopyOnWriteArraySet jsonAsArrayList=null;
        Response resp ;
        resp=   given()
                .spec (reqspec)
                .when ()
                .log()
                .uri().log().parameters()
                .get (testdata.getProperty("iso3schInd"))
                .then ()
                .contentType (ContentType.JSON)
                .statusCode (200)
                .extract().response();
        Reporter.log(resp.prettyPrint());


    }
    @Test(dependsOnMethods = "iso3namesearchIn")
    public void iso3namesearchUs () {

        CopyOnWriteArraySet jsonAsArrayList=null;
        Response resp;
        resp=
                given()
                        .spec (reqspec)
                        .when ()
                        .log()
                        .uri().log().parameters()
                        .get (testdata.getProperty("iso3schUsa"))
                        .then ()
                        .contentType (ContentType.JSON)
                        .statusCode (200)
                        .extract().response();
        Reporter.log(resp.prettyPrint());


    }
}
