package com.getapi;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetApi implements Constant {

	@Test
	public void makeSureThatGoogleIsUp() {
		
		RestAssured.baseURI = baseURI;
		RestAssured.basePath = basePath;
		
		Response response = given().when().get();
		System.out.println(response.asString());
		
	}
}
