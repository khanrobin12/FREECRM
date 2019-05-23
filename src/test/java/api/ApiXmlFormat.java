package api;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;
public class ApiXmlFormat {
	
	
	@Test
	public void StatusBodyHeaderTest() {
		
		given().get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22").then()
		.assertThat().log().all()
		.statusCode(200)
		.and().statusLine("HTTP/1.1 200 OK")
		.and().header("Connection", "keep-alive")
		.and().headers("Transfer-Encoding", "chunked","X-Frame-Options","SAMEORIGIN")
		.and().body("base", equalTo("stations"))
		.and().body("weather[0].id", equalTo(300));
	}

	@Test
	public void postUser() {
		given().when()
		.body("{\r\n" + 
				"    \"name\": \"AliNoor\",\r\n" + 
				"    \"job\": \"tester\"\r\n" + 
				"}")
		.post("https://reqres.in/api/users")
		.then().assertThat().log().all()
		.statusCode(201);
	}
	
	
	@Test
	public void PutUpdate() {
		
		given().when().body("{\r\n" + 
				"    \"name\": \"morpheus\",\r\n" + 
				"    \"job\": \"resident\"\r\n" + 
				"}\r\n" + 
				"")
		.put("https://reqres.in/api/users/2")
		.then().assertThat().log().all()
		.statusCode(200);
	}
	
	@Test
	public void deleteAuser(){
		
		given().when().log().ifValidationFails().delete("https://reqres.in/api/users/2")
		.then().assertThat()
		.statusCode(204);
	}
	
	@Test
	public void loginForValidate() {
		given().auth().preemptive().basic("peter@klaven", "cityslicka")
		.when()
		.get("https://reqres.in/api/login")
		.then().assertThat().log().all().statusCode(200);
	}
	
	
	
	
	
	}