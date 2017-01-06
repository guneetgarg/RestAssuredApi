package com.api;

import static io.restassured.RestAssured.given;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class CookiesGet {

	@Test
	public void cookiesTest() {


		Response response = given().when().get("http://cookie.jsontest.com/");
		System.out.println(response.asString());

		System.out.println(response.getCookie("jsontestdotcom"));
		
		
		Map<String, String> cookies = response.getCookies();
		for (String cc : cookies.keySet()) {
			System.out.println(cc.toString() + "   " + cookies.get(cc));
		}

	}
}
