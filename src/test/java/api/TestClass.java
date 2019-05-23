package api;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TestClass {
	
	@Test
	public void testapi() {
		
		Response resp =RestAssured.get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22");
		int code= resp.getStatusCode();
		System.out.println(code);
		
		Assert.assertEquals(code, 200);
	}
	
	
	@Test
	public void testBody() {
		Response resp =RestAssured.get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22");
		String data=resp.asString();
		//Assert.assertEquals(data, expected);
		System.out.println(data);
		System.out.println(resp.getTime());
		
	}

}
