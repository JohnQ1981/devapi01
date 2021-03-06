package com.techproed.javadevapi01;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import testbaseclasses.TestBaseJsonPlaceHolder;

public class GetRequest05 extends TestBaseJsonPlaceHolder{

	/*
	 	When 
	   		I send a GET request to REST API URL https://jsonplaceholder.typicode.com/todos/123
	    Then 
	   		HTTP Status Code should be 200
		    And "Server" in Headers should be "cloudflare"
		    And response content type is “application/JSON”
		    And "userId" should be 7,
		    And "title" should be "esse et quis iste est earum aut impedit"
			And "completed" should be false
	 */

	@Test
	public void get01() {

		//Set the url
		spec.pathParams("todoName", "todos", 
				"id", 123);

		//Set the expected data

		//Send the request
		Response response = given().accept(ContentType.JSON).spec(spec).when().get("/{todoName}/{id}");

		response.prettyPrint();

		//Assertions
		response.then().
		assertThat().
		statusCode(200)./// must 
		header("Server", "cloudflare").
		contentType(ContentType.JSON).
		body("completed", equalTo(false),
				"userId", equalTo(7),
				"title", equalTo("esse et quis iste est earum aut impedit"));

		//assertTrue(response.asString().contains("esse et quis iste est earum aut impedit"));
		//assertTrue(response.asString().contains("7"));







	}


















}
