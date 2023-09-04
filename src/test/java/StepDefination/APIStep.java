package StepDefination;

import org.hamcrest.Matchers;

import BaseAPI.BaseAPIclass;
import Helper.RequestBody;
import UtilityLayer.PropertiesClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class APIStep {
	static RequestSpecification httpRequest;
	static Response postRequest;
	static String repositoryName;
	static ValidatableResponse validatedResponse;
	
	@Given("User add the BaseURI and access token and get theRequestSpecification object")
	public void user_add_the_base_uri_and_access_token_and_get_the_request_specification_object() throws Exception 
	{
		httpRequest = BaseAPIclass.getRequestSpecification();
	}
	
	@Given("User add {string} BasePath")
	public void user_add_base_path(String requestType) throws Exception 
	{
		if (requestType.equalsIgnoreCase("POST"))
		{
			httpRequest.basePath(PropertiesClass.getProperties("postBasePath"));		
		}
	}
	
	@Given("User add content type Header and Request Body for {string} request")
	public void user_add_content_type_header_and_request_body_for_request(String requestBody) throws Exception 
	{
		
		if (requestBody.equalsIgnoreCase("POST"))
		{
			httpRequest.contentType(ContentType.JSON).and().body(RequestBody.postRequestBody("createRepository"));
		}
	}
	
	@Then("user select the HTTP POST request")
	public void user_select_the_http_post_request() 
	{
		postRequest = httpRequest.post();
	}
	
	@Then("user capture Repository Name")
	public void user_capture_repository_name() 
	{
		repositoryName = postRequest.jsonPath().getString("name");
	}
	
	@Then("user validate StatusCode as {int} and StatusLine as {string}")
	public void user_validate_status_code_as_and_status_line_as(Integer StatusCode, String StatusLine) 
	{
		validatedResponse = postRequest.then().assertThat().statusCode(StatusCode).and().statusLine(StatusLine);
	}
	
	@Then("user validate the Response Header")
	public void user_validate_the_response_header() 
	{
		postRequest.then().assertThat().contentType(ContentType.JSON);
	}
	
	@Then("User validate Response Body")
	public void user_validate_response_body() 
	{
		String descrip = postRequest.jsonPath().getString("description");
		validatedResponse.body("", Matchers.hasKey("name"))
		.and().body("", Matchers.hasValue(true))
		.and().body("", Matchers.hasValue(descrip));
		
		System.out.println(descrip);
		
	}
}
