package tests;

import org.junit.Test;

import config.EndPoint;
import config.TestConfig;
import static io.restassured.RestAssured.*;

public class REQRESTests extends TestConfig {

	// GET REQUEST
	//@Test
	public void getAllUsers() {
		
		given().spec(reqres_requestSpecc).
		when().get(EndPoint.GET_USERSPG1);
		
	}
	
	// With parameters 
	@Test 
	public void getUser() {
		given()
		.spec(reqres_requestSpecc)
			.pathParam("id", 2)
		.when()
			.get("users/{id}")
		.then()
			.log()
			.all();
		
	}
	
	
	// POST REQUEST
	//@Test
	public void createNewUser() {
		String bodyJson = "{\n" + 
				"    \"name\": \"Nejat\",\n" + 
				"    \"job\": \"leader\"\n" + 
				"}";
		
		given()
		.spec(reqres_requestSpecc)
		.body(bodyJson)
		.when().post(EndPoint.USERS)
		.then().log().all().statusCode(201);
	}
	
	//@Test
	public void updateUesr() {
		String bodyJason = "{\n" + 
				"    \"name\": \"Nejat\",\n" + 
				"    \"job\": \"zion resident\"\n" + 
				"}";
		
		given()
			.spec(reqres_requestSpecc)
		.when()
			.put("users/2")
		.then();
	}
	
	//@Test
	public void deleteUser() {
		given()
			.spec(reqres_requestSpecc)
		.when()
			.delete("users/2")
		.then();
	}
	
}
