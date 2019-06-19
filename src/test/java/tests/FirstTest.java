package tests;

import static io.restassured.RestAssured.given;
import org.junit.Test;

import config.EndPoint;
import config.TestConfig;

public class FirstTest extends TestConfig {

	@Test
	public void status_success() {
		given()
			.spec(reqres_requestSpecc)
			.log()  			  // logs everything for API calls
			.ifValidationFails()  // logs everything if only test fails
		.when().get("users/2")
		.then()
			.log()
			.all()
		.statusCode(200);
	}
	
	
	
	@Test
	public void status_success2() {
		given()
			.spec(reqres_requestSpecc)
			.log()  			 
			.ifValidationFails()  
		.when().get("users/2")
		.then()
			.spec(responseSpec)
			.log()
			.all();
	}
	
	@Test
	public void get_all_user_page_1() {
		given()
			.spec(reqres_requestSpecc)
			.log()
			.all()
		.when().get(EndPoint.GET_USERSPG1)
		.then()
			.spec(responseSpec)
			.log()
			.all();
	}
}
