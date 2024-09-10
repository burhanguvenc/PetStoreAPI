package api.test;

import org.apache.logging.log4j.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;
import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests {

	Faker faker;
	User userPayload;
	
	public Logger logger;

	@BeforeClass
	public void setup() {
		faker = new Faker();
		userPayload = new User();

		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5, 10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		
		// logs
		
		logger= org.apache.logging.log4j.LogManager.getLogger(this.getClass());
		logger.debug("Debugging..............");
	}

	@Test(priority = 1)
	public void testPostUser() {
		logger.info("******** Creating User ********");
		Response response = UserEndPoints.createUser(userPayload);
		response.then().log().all();

		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("******** User is created ********");

	}

	@Test(priority = 2)
	public void testGetUserByName() {
		logger.info("******** Reading User info********");
		Response response = UserEndPoints.readUser(userPayload.getUsername());
		response.then().log().all();

		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("******** User info is Displayed ********");

	}

	@Test(priority = 3)
	public void testUpdateUserByName() {

		logger.info("******** Updating User info********");

		// Update Data Using Faker
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());

		Response response = UserEndPoints.updateUser(userPayload, this.userPayload.getUsername());
		response.then().log().body();

		Assert.assertEquals(response.getStatusCode(), 200);

		logger.info("******** User is Updated ********");
		
		// Checking data after update

		Response responseAfterUpdate = UserEndPoints.readUser(this.userPayload.getUsername());
		Assert.assertEquals(responseAfterUpdate.getStatusCode(), 200);

	}

	@Test(priority = 4)
	public void testDeleteUserByName() {
		logger.info("******** User is Deleting ********");

		Response response = UserEndPoints.deleteUser(this.userPayload.getUsername());

		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("******** User is Deleted ********");

	}

}
