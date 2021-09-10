package testcase;
import org.testng.annotations.Test;
//import static com.jayway.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import com.api.util.DBUtil;
import com.api.util.PropertyFile;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.Matchers.hasItem;
//import com.jayway.restassured.RestAssured;
//import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.Matchers.hasItem;

public class TC001_GET_Request {
	// private String baseurl;
	@Test
	public void getresponse()
	{
		String baseurl = PropertyFile.getProperty("baseUrl");
		System.out.println(baseurl);
		DBUtil.performDatabaseQuery("select  * from ec_buyer");
		
		given().headers(
	              "Authorization",
	              "Bearer " +"eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJ6TzFCczlnOWV5T2N5TEpiUDI5bDllVEg3MG5VSFo4dCIsInN1YiI6IlNpbWFzSW52ZXN0In0.8bnIeLKa8WLo-MFIMeNEKD4G0zcgBuG57YLNZINqOKM",
	              "Content-Type",
	              ContentType.JSON,
	              "Accept",
	              ContentType.JSON).
		when().
			get(baseurl+"/api/v1/users/account/628441234567").
		then().
		statusCode(200).
		log().all();
	}
	@Test
	public void getresponce1()
	{
		String baseurl = PropertyFile.getProperty("baseUrl");
		System.out.println(baseurl);
		given().headers(
				"Authorization",
	              "Bearer " +"eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJ6TzFCczlnOWV5T2N5TEpiUDI5bDllVEg3MG5VSFo4dCIsInN1YiI6IlNpbWFzSW52ZXN0In0.8bnIeLKa8WLo-MFIMeNEKD4G0zcgBuG57YLNZINqOKM",
	              "Content-Type",
	              ContentType.JSON,
	              "Accept",
	              ContentType.JSON).
		expect().
			body("equity_kyc",equalTo("KYC is processing"))
.when()
	.get(baseurl+"/api/v1/users/account/628441234567");
		
	}

}
