package tests;

import org.junit.Test;

import config.TestConfig;
import static io.restassured.RestAssured.*;
import org.hamcrest.CoreMatchers;

public class FootballApiTest extends TestConfig {

	@Test
	public void getAllCompetetionsOneSeason() {
		given()
			.spec(football_requestSpecc)
			.queryParam("season", 2016)
		.when()
			.get("competitions");
	}
	
	// extracting the body of http response
	@Test
	public void getTeamCount_OneComp() {
		given()
			.spec(football_requestSpecc)
			.when()
			.get("competeting/426/teams")
			.then()
				.body("count", CoreMatchers.equalTo(20));
	}
	
	
	@Test
	public void getTeamNameCount_OneComp() {
		given()
			.spec(football_requestSpecc)
		.when()
			.get("competeting/426/teams")
		.then()
			.body("teams[0]", CoreMatchers.equalTo("Hull City FC"));
	}
	
}
