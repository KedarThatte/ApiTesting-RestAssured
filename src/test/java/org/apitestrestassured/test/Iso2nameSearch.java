package org.apitestrestassured.test;

import io.restassured.http.ContentType;
import io.restassured.internal.assertion.Assertion;
import io.restassured.response.Response;
import org.apitestrestassured.core.Base;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;

import static io.restassured.RestAssured.given;
import static io.restassured.path.json.JsonPath.from;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class Iso2nameSearch extends Base{

    @Test
    public void iso2NameSearchIn() {

        CopyOnWriteArraySet jsonAsArrayList=null;
        Response resp ;
        resp=   given()
                .spec (reqspec)
                .when ()
                .log()
                .uri().log().parameters()
                .get (testdata.getProperty("iso2schIN"))
                .then ()
                .contentType (ContentType.JSON)
                .statusCode (200)
                .extract().response();
        Reporter.log(resp.prettyPrint());


    }
    @Test(dependsOnMethods = "iso2NameSearchIn")
    public void iso2NameSearchUs () {

        CopyOnWriteArraySet jsonAsArrayList=null;
        Response resp;
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
                        .extract().response();
        Reporter.log(resp.prettyPrint());


    }
}
