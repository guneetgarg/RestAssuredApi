package com.api;

import org.testng.annotations.Test;
import com.util.Helper;

import io.restassured.response.Response;

public class View1 {
	Helper helper;
	Response response;

	@Test
	public void val_view1() {
		
		helper = new Helper();
		response = helper.getPostResponse(helper.readPropertyFile("baseUrl"), helper.readJsonFile("View1"));
		System.out.println(response.asString());
		System.out.println(helper.getResponseStatus(response));
		System.out.println(response.getStatusLine());
		
		
		
		
		
		
	}

}
