package config;

import org.junit.BeforeClass;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
/*
 * This class contains methods that will be executed before any test
 * 
 */
public class TestConfig {
	
	public static RequestSpecification reqres_requestSpecc;
	public static ResponseSpecification responseSpec;
	
	// spec for football data api
	public static RequestSpecification football_requestSpecc;

	
	
	@BeforeClass
	public static void setUp() {
		
		// -- Setting up individual request spec for REQRES api 
		reqres_requestSpecc = new RequestSpecBuilder()
				.setBaseUri("https://reqres.in")
				.setBasePath("/api/")
				.addHeader("Content-Type", "application/json")
				.addHeader("Accept", "application/json")
				.build();
		
		// if you want these request specification for all the request
		//RestAssured.requestSpecification = reqres_requestSpecc;
		
		
		// -- Setting up individual request specification for FOOTBALL API
		football_requestSpecc = new RequestSpecBuilder()
				.setBaseUri("http://api.football-data.org")
				.setBasePath("/v2/")
				.addHeader("X-Response-Control", "minified")
				.build();
		
		
		// Setting up individual response specification
		responseSpec = new ResponseSpecBuilder()
				.expectStatusCode(200)
				.build();
		// if you want to the response specification for all of your response
		RestAssured.responseSpecification = responseSpec;
		
		
	}
	
	
	// This is for every test 
	public static void testSetUp() {
		RestAssured.baseURI = "https://reqres.in";
		RestAssured.port = 8080;  // if you have a port
		RestAssured.basePath = "/api/";
		
		// Every request will contain these specification
		RequestSpecification reqSpec = new RequestSpecBuilder()
				.addHeader("Content-Type", "application/json")
				.addHeader("Accept", "application/json")
				.build();
		
		RestAssured.requestSpecification = reqSpec;
		
		
		// Response Specificaiton 
		ResponseSpecification responseSpec = new ResponseSpecBuilder()
				.expectStatusCode(200)
				.build();
		RestAssured.responseSpecification = responseSpec;
	}
}
