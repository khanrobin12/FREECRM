package api;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.hamcrest.Matcher;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;


public class VeryfyResponse {
	
	//status code verification.
	//@Test(priority=1)
	public void veryfyStatusCode() {
		given().get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22").then().assertThat().statusCode(200).log().all();
	}
	//@Test(priority=2)
	public void verifyStatusCodeFull() {
		given().get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22").then().assertThat().statusLine("HTTP/1.1 200 OK");
	}
	
	
	
	//headers verification.
	//@Test(priority=3)
	public void testHeaderResponse() {
	given().get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22").then().assertThat().header("Connection", "keep-alive");
		}
	//@Test
	public void testHeadersResposeMulti() {
		given().get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22").then().assertThat().headers("Content-Encoding", "gzip", "X-Frame-Options","SAMEORIGIN","X-Content-Type-Options","nosniff");
		}
	
	
	
	
	//Verification body.
	//@Test
	public void varifiyingBody() {
		given().get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22").then().log().all();
	}
	
	
	//@Test
	public void varifiyingBodyText1() {
		given().get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22").then().body("base", equalTo("stations"));
	}
	
	@Test
	public void varifiyingBodyTextHarerKey() {
		given().get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22").then().body("weather[0].id", equalTo(300));
	}
	
	
	
	
}
