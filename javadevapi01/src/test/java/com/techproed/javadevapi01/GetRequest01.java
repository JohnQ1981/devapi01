package com.techproed.javadevapi01;

import static io.restassured.RestAssured.given;

import org.junit.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
//import io.restassured.response.Response;
public class GetRequest01 {

	/*
	 Gherkin Language: used to create Test Case, write test steps and follow.
	 Gherkin Language has very easy structure, that is why it is being used.
	 it has 4 keywords:
	 1==> Given:  It Declares prerequisites
	 2==> When:  It defines the action which user will perform
	 3==> Then:  Talk about outputs
	 4==> And:   It can be used in 'Given', in 'When' and in 'Then' if you have multiple options.

	 */
	/*
	 When
		     I send a GET Request to the URL https://restful-booker.herokuapp.com/booking/3
		 Then
		     HTTP Status Code should be 200
		 And
		     Content Type should be JSON
		 And
		     Status Line should be HTTP/1.1 200 OK


	 */

	@Test
	public void get01() {
		//to Test API we have 4 STEPS:
		//1st Step: Set the URL,
		String url = "https://restful-booker.herokuapp.com/booking/3";


		//2nd Step: Set the Expected Data 


		//3rd Step: Send the Request to API.==> it is like clicking on send button on POASTMAN
		Response response = given().accept("application/json").when().get(url);

		response.prettyPrint();


		//4. Step:  Make assertions.
		response.then().assertThat().statusCode(200).contentType(ContentType.JSON).statusLine("HTTP/1.1 200 OK");

		//	HOW TO PRINT ==>content-type, status code, status line, etc. on the console...

		System.out.println(response.getContentType());
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeaders());
		System.out.println(response.getHeader("Date"));






	}

}
