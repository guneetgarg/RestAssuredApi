package com.util;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Properties;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import groovy.json.JsonTokenType;
import io.restassured.response.Response;

public class Helper {

	Response response;
	Properties prop;
	InputStream input = null;

	public Response getPostResponse(String url, String jsonRequest) {
		response = given().contentType("application/json").body(jsonRequest).post(url);
		return response;
	}

	public String readPropertyFile(String key) {
		prop = new Properties();
		try {
			input = new FileInputStream("data.properties");
			prop.load(input);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return (prop.getProperty(key));
	}

	public int getResponseStatus(Response response) {
		return response.getStatusCode();
	}

	private Boolean checkExtension(String val) {
		String extension = "";
		int i = val.lastIndexOf('.');
		if (i > 0) {
			extension = val.substring(i + 1);
			if (extension.equalsIgnoreCase("json")) {
				return true;
			}
		}
		return false;
	}
	
	public String readJsonFile(String Url) {

		Path file;
		if (checkExtension(Url)) {
			file = Paths.get(System.getProperty("user.dir") + "/src/main/resources/" + Url);
		} else {
			file = Paths.get(System.getProperty("user.dir") + "/src/main/resources/" + Url + ".json");
		}
		System.out.println(file.toAbsolutePath());
		try {
			return new String(Files.readAllBytes(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//send data ==>jsonObject.get("status")
	private void checkJsonType(Object obj) {
		System.out.println("inside checkJsonType method  -- "+obj);
		if (obj instanceof JSONArray) {
			System.out.println("Type is JSONArray");
		} else if (obj instanceof JSONObject) {
			System.out.println("Type is JSONObject");
		}
	}
	//@Test
	public void JsonRead() throws FileNotFoundException, IOException, ParseException{
		JSONParser parser = new JSONParser();

		Object obj = parser.parse(new FileReader("dummy.json"));
		JSONObject jsonObject = (JSONObject) obj;
		
		System.out.println(jsonObject.get("status"));
		
		
		
		checkJsonType(jsonObject.get("status"));
//		if (jsonObject.get("status") instanceof JSONArray) {
//			System.out.println("*********");
//		} else if (jsonObject.get("status") instanceof JSONObject) {
//			System.out.println("---------");
//		}
		
		JSONObject structure = (JSONObject) jsonObject.get("status");
        System.out.println(structure.get("statusCode"));

		
		
		
		jsonObject = (JSONObject) jsonObject.get("headers");
		checkJsonType(jsonObject.get("data"));

		jsonObject = (JSONObject) jsonObject.get("fgname");
		System.out.println(jsonObject.get("id"));
		
		
//		JSONArray jsonArray = (JSONArray) jsonObject.get("organizationList");
//		System.out.println(jsonArray.get(0));
//
//		JSONObject jsonObject2 = (JSONObject)jsonArray.get(0);
//		System.out.println(jsonObject2.get("name"));

	/*	JSONArray msg = (JSONArray) jsonObject.get("organizationList");
		Iterator<Object> iterator = msg.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}		*/
		
	}
}
