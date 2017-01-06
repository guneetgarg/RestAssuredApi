package com.api;

import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.mapper.ObjectMapper;
import io.restassured.response.Response;


public class GetApi implements Constant {

	// @Test
	public void makeSureThatGoogleIsUp() {

		RestAssured.baseURI = baseURI;
		// RestAssured.basePath = basePath;

		Response response = given().when().get("http://cookie.jsontest.com/");
		System.out.println(response.asString());

		System.out.println(response.getCookie("jsontestdotcom"));
		Map<String, String> cookies = response.getCookies();

		for (String cc : cookies.keySet()) {
			System.out.println(cc.toString() + "   " + cookies.get(cc));
		}
		response = given().when().get("http://validate.jsontest.com/?json=%7B%22key%22:%22value%22%7D");

		System.out.println(response.asString());

	}

	@Test
	public void testView() throws FileNotFoundException, IOException, ParseException {
		
		/*
		RestAssured.baseURI = "http://10.5.3.245/MercuryServices/rest/mercuryview/getData";
		Response response = given().contentType("application/json")
				.body("{\"lobList\":[{\"name\":\"Residential\",\"id\":\"1200004\"}],\"subLobList\":[{\"id\":\"1300006\",\"name\":\"Residential\",\"lobCode\":null}],\"functionalGroupList\":[{\"name\":\"Account Services\",\"sbFGId\":null,\"id\":\"1400010\"},{\"name\":\"Collections\",\"sbFGId\":null,\"id\":\"1400002\"},{\"name\":\"Inbound Sales\",\"sbFGId\":null,\"id\":\"1400026\"},{\"name\":\"Retention\",\"sbFGId\":null,\"id\":\"1400030\"},{\"name\":\"Technical Support\",\"sbFGId\":null,\"id\":\"1400004\"}],\"subfunctionsList\":[],\"organizationList\":[{\"id\":\"6\",\"name\":\"C3\"},{\"id\":\"1000\",\"name\":\"Cox\"},{\"id\":\"10\",\"name\":\"Plus One\"},{\"id\":\"11\",\"name\":\"Sitel\"},{\"id\":\"12\",\"name\":\"Sutherland\"},{\"id\":\"16\",\"name\":\"Xerox\"}],\"functionsList\":[],\"regionList\":[{\"name\":\"A\",\"id\":\"1\"}],\"coeList\":[],\"lenguage\":\"1100001\",\"timezone\":\"1\",\"length\":0,\"pageNo\":0,\"firstHitFlag\":\"true\",\"viewDetail\":{\"viewName\":\"RTP View\",\"baseViewId\":\"VIEW_1\",\"viewId\":\"VIEW_1\",\"customStatus\":\"false\"}}")
				.post();
		System.out.println(response.asString());
		String jsonAsString = response.asString();*/

	}
}
