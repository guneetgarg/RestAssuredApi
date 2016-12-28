package RestAssuredApi.RestAssuredApi;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class sssssssssss {

	@Test
	public void makeSureThatGoogleIsUp() {
		RestAssured.baseURI = "https://reqres.in";
		RestAssured.basePath ="/api/users?page=2";
		System.out.println(given().when().get(RestAssured.basePath));
	}
}
