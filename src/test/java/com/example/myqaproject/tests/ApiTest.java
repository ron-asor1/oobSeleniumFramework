package com.example.myqaproject.tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.Assert;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import io.qameta.allure.*;

@Feature("API Testing")
@Epic("Automated Tests")
public class ApiTest {

    private static final String BASE_URI = "https://jsonplaceholder.typicode.com";

    @Test(description = "Verify fetching a single todo item")
    @Description("Test to fetch a single todo item by ID and validate its properties")
    @Story("API Tests")
    @Severity(SeverityLevel.NORMAL)
    @Link("https://jsonplaceholder.typicode.com/todos/1")
    public void testGetTodoItem() {
        RestAssured.baseURI = BASE_URI;

        given()
            .log().all() // Log request details
        .when()
            .get("/todos/1")
        .then()
            .log().all() // Log response details
            .statusCode(200) // Assert status code is 200
            .body("id", equalTo(1)) // Assert 'id' in response body is 1
            .body("title", not(emptyOrNullString())); // Assert 'title' is not empty or null
    }

    @Test(description = "Verify creating a new post")
    @Description("Test to create a new post with a JSON body and validate the response")
    @Story("API Tests")
    @Severity(SeverityLevel.CRITICAL)
    @Link("https://jsonplaceholder.typicode.com/posts")
    public void testCreatePost() {
        RestAssured.baseURI = BASE_URI;

        String requestBody = "{\"title\": \"foo\", \"body\": \"bar\", \"userId\": 1}";

        given()
            .contentType(ContentType.JSON) // Specify content type as JSON
            .body(requestBody) // Set the request body
            .log().all() // Log request details
        .when()
            .post("/posts")
        .then()
            .log().all() // Log response details
            .statusCode(201) // Assert status code is 201 (Created)
            .body("title", equalTo("foo")); // Assert 'title' in response body is "foo"
    }
}