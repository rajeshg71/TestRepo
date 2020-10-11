package com.restAPI;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredExample {


//	@Test
//	void getWeatherDetails() {
//		RestAssured.baseURI= "https://jsonplaceholder.typicode.com/posts";
//		RequestSpecification httpRequest = RestAssured.given();
//		Response response = httpRequest.request(Method.GET,"/1");
//		String responseBody = response.getBody().asString();
//		System.out.println(responseBody);
//	}
	@Test
	void postDetails() {
		RestAssured.baseURI= "https://jsonplaceholder.typicode.com/posts";
		RequestSpecification httpRequest = RestAssured.given();
		JSONObject  requestParams = new JSONObject();
		requestParams.put("userId", "1");
		requestParams.put("id", "1");
		requestParams.put("title", "Rest Api example");
		requestParams.put("body", "true reprehenderit");
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(requestParams.toJSONString());
		Response response=httpRequest.request(Method.POST,"/1");
		 String responseBody=response.getBody().asString();
		  System.out.println("Response Body is:" +responseBody);
}
}
