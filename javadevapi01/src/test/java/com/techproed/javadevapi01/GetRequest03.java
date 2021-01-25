package com.techproed.javadevapi01;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetRequest03 {
	/*
	 * When 
		 	I send a GET request to REST API URL https://jsonplaceholder.typicode.com/todos/23   
		    And Accept type is “application/JSON”
		 Then 
		    HTTP Status Code should be 200
		    And Response format should be "application/JSON"
		    And "title" is "et itaque necessitatibus maxime molestiae qui quas velit",
		    And "completed" is false
		    And "userId" is 2
	 */

	@Test
	public void get01() {
		//1st step set URL
		String url = "https://jsonplaceholder.typicode.com/todos/23";

		//2nd Step Set the Expected Data


		//3rd Way Send the Request
		Response response = given().accept(ContentType.JSON).when().get(url);
		response.prettyPrint();

		//4th STEP-- do assert== > HARD Assertion

		//		response.
		//		then().
		//		assertThat().
		//		statusCode(200).
		//		contentType(ContentType.JSON).
		//		body("title", equalTo("et itaque necessitatibus maxime molestiae qui quas velit")).
		//		body("completed", equalTo(false)).
		//		body("userId", equalTo(2));


		//2nd WAY 
		//		response.
		//		then().
		//		assertThat().
		//		statusCode(200).
		//		contentType(ContentType.JSON).
		//		body("title", equalTo("et itaque necessitatibus maxime molestiae qui quas velit"),
		//				"completed", equalTo(false),"userId", equalTo(2));

		//3rd Way
		assertEquals(200,response.getStatusCode());
		assertEquals("application/json; charset=utf-8",response.getContentType());
		assertTrue(response.asString().contains("et itaque necessitatibus maxime molestiae qui quas velit"));
		assertTrue(response.asString().contains("2"));
		assertTrue(response.asString().contains("false"));









	}
}
