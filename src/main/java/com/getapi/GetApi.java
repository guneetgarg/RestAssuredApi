package RestAssuredApi.RestAssuredApi;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class GetApi {

	@Test
	public void makeSureThatGoogleIsUp() {
		Response response = given().when().get("http://echo.jsontest.com/title/ipsum/content/blah");
		System.out.println(response.asString());
	}
}
