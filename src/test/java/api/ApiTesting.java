package api;
import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;
import org.testng.annotations.Test;
public class ApiTesting {
	
	@Test
	public void getdata() {
		given().get("https://reqres.in/api/users?page=2")
		.then().assertThat().log().all()
		.statusCode(200)
		.and().statusLine("HTTP/1.1 200 OK")
		.and().header("very", "Accept-Encoding")
		.and().body("total_pages", equalTo(4));
		}	
	
	
}
