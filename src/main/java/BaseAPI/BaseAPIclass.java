package BaseAPI;

import UtilityLayer.PropertiesClass;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;


public class BaseAPIclass {
	public static RequestSpecification getRequestSpecification() throws Exception
	{
		RestAssured.baseURI=PropertiesClass.getProperties("baseURI");
		
		return RestAssured.given()
				.auth()
				.preemptive()
				.oauth2(PropertiesClass.getProperties("accessToken"));
		
		
	}
}
