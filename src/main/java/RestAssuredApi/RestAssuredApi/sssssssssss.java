package RestAssuredApi.RestAssuredApi;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class sssssssssss {

	@Test
	public void makeSureThatGoogleIsUp() {
		Response response = given().when().get("https://reqres.in/api/users?page=2");
		System.out.println(response.asString());
	}
}
