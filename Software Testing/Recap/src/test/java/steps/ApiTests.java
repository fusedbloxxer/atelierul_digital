package steps;

import backpack.TestBackpack;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.request.LoginUser;
import model.request.RegisterUser;
import model.response.Data;
import model.response.Response;
import model.response.User;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Random;

import static io.restassured.RestAssured.given;

public class ApiTests {

    private Data response;
    private User user;

    @Autowired
    private TestBackpack backpack;

    @Given("I get all the  users from {string}")
    public void iGetAllTheUsersFrom(String url) {
        response = given().when().get(url).as(Data.class);
        System.out.println(response);
        response.getUsers().forEach(Assert::assertNotNull);
    }

    @And("I save an email from a random user")
    public void iSaveAnEmailFromARandomUser() {
        List<User> users = response.getUsers();
        User user = users.get(new Random().nextInt(users.size()));
        backpack.setEmail(user.getEmail());
    }

    @When("I register another user using the saved email at {string}")
    public void iRegisterAnotherUserUsingTheSavedEmailAt(String url) {
        backpack.setPassword("passw@rd");
        RegisterUser registerUser = new RegisterUser(backpack.getEmail(), backpack.getPassword());
        String token = given().contentType("application/json")
                .body(registerUser).post(url)
                .jsonPath().getString("token");
        backpack.setRegisterToken(token);
        System.out.println(token);
    }

    @And("I login with the newly created user at {string}")
    public void iLoginWithTheNewlyCreatedUserAt(String url) {
        LoginUser loginUser = new LoginUser(backpack.getEmail(), backpack.getPassword());
        String token = given().contentType("application/json")
                .body(loginUser).post(url)
                .jsonPath().getString("token");
        backpack.setLoginToken(token);
    }

    @Then("the register user token and login token should be the same.")
    public void theRegisterUserTokenAndLoginTokenShouldBeTheSame() {
        Assert.assertEquals(backpack.getRegisterToken(), backpack.getRegisterToken());
    }

    @Given("I check testbackpack")
    public void iCheckTestbackpack() {
        System.out.println("TestBackpack maintains state: ");
        System.out.println(backpack.getEmail());
    }

//    @Before("@backpack")
//    public void cleanup() {
//        backpack = new TestBackpack();
//    }
}