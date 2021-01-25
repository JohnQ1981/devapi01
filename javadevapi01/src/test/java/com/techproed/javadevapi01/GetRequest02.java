package com.techproed.javadevapi01;

import static io.restassured.RestAssured.given;

import org.junit.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetRequest02 {

	/*
	 *When
	  	I send a GET request to REST API URL https://restful-booker.herokuapp.com/booking/1001
	  Then
		 HTTP Status code should be 404
	  And
		 Status Line should be HTTP/1.1 404 Not Found
	  And
	     Response body contains "Not Found"
	  And
	     Response body does not contain "TechProEd"
	 */
	@Test
	public void get02() {

		//1. Set the URL
		String url = "https://restful-booker.herokuapp.com/booking/1001";


		//2nd  Step: Set the Expected Data

		//3rd Step: Send the Request to API.==> it is like clicking on send button on POASTMAN
		Response response = given().accept(ContentType.JSON).when().get(url);
		response.prettyPrint();

		//4. Step:  Make assertions.
		//JAVA STOPS EXECUTION IN FIRST FAILURE, THIS IS "HARD ASSERTION"(assertion)
		//response.then().assertThat().statusCode(404).contentType(ContentType.JSON).statusLine("HTTP/1.1 404 Not Found");
		response.then().assertThat().statusCode(404).and().statusLine("HTTP/1.1 404 Not Found");

		//System.out.println(response.getBody());
		//System.out.println(response.getBody());

		//assertTrue(response.asString().contains("Not Found"));
		//assertFalse(response.asString().contains("TechProEd"));


		//Execute All assertion even some of them fails. This is called SOFT Assertion.
		//How to do "Soft Assertion"

		//a)  Create SoftAssert object
		SoftAssert softAssert = new SoftAssert();


		//b) Step, use assertions with softAssert(verification) object

		System.out.println("======");
		softAssert.assertTrue(response.asString().contains("Not found"));
		System.out.println("======2");
		softAssert.assertFalse(response.asString().contains("TechProEd"));
		System.out.println("======3");
		//c) LAST STEP Important==> user assertAll()
		softAssert.assertAll();





	}


}
