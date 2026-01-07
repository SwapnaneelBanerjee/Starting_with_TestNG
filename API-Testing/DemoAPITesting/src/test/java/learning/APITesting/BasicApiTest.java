package learning.APITesting;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class BasicApiTest {
	@Test(enabled = false)
	public void savePetInfo() {
		// Request specification
		Response response = RestAssured.given().baseUri("https://petstore.swagger.io/v2/pet")
				.header("Content-Type", "application/json").pathParam("petId", 77232).log().all().
				// HTTP Method
				when().get("/{petId}");
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody().asPrettyString());

		String petStatus = response.then().extract().path("status");

		response.then().statusCode(200);
	}

	// https://petstore.swagger.io/v2/pet/findByStatus?status=sold
	@Test(priority = 2)
	public void getPetInfo() {
		// Request specification
		RestAssured.given().baseUri("https://petstore.swagger.io/v2/pet").header("Content-Type", "application/json")
				.pathParam("petId", 77232).log().all().
				// HTTP Method
				when().get("/{petId}").
				// Response Specification
				then().log().all().statusCode(200).body("[0].status", equalTo("sold"));
	}

	// https://petstore.swagger.io/v2/pet
	@Test(priority = 1)
	public void addPetInfo() {
		// Give JSON body as Map
//		Map<String, Object> reqBody = new HashMap<>();
//		reqBody.put("id", 77232);
//		reqBody.put("name", "Hansel");
//		reqBody.put("status", "alive");
		
		// OR through a file. NOT BOTH
		File inputFile = new File("src/test/resources/pet.json");
		// Request specification
		RestAssured.given().baseUri("https://petstore.swagger.io/v2/pet").header("Content-Type", "application/json")
				.body(inputFile).log().all().
				// HTTP Method
				when().post().
				// Response Specification
				then().log().all().statusCode(200).body("status", equalTo("alive"));
	}
}