package stepDefinitions;

import com.message.app.messageapi.service.MessageService;
import com.message.app.messageapi.service.impl.MessageServiceImpl;

import config.SpringIntegrationTest;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.ContentType;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class AddNewMessage extends SpringIntegrationTest {

    @Autowired
    MessageService messageService;
    private Map<String,String> message1 = new HashMap<>();
    private Map<String,String> message2 = new HashMap<>();
    private Map<String,String> message3 = new HashMap<>();
    private Map<String,String> message4 = new HashMap<>();


    @Given("^I have a message$")
    public void iHaveAMessage() throws Throwable {

        message1.put("title", "Planets of the apes");
        message1.put("message","The apes have all left the planet and they are heading for earth");
        message2.put("title","Milk scarcity");
        message2.put("message","The price of cows has increased globally. It is now valued more than gold");
        message3.put("title","Acceptance test");
        message3.put("message", "cukes library is still being supported by JetBrains for now according to the CTO");


    }

    @When("^I add the message$")
    public void iAddTheMessage() throws Throwable {
        given()
                .contentType(ContentType.JSON)
                .body(message1)
                .when().post("/message")
                .then()
                .statusCode(200);
    }

    @Then("^I should receive an identifier of the message$")
    public void iShouldReceiveAnIdentifierOfTheMessage() throws Throwable {
        given()
                .contentType(ContentType.JSON)
                .body(message2)
                .when().post("/message")
                .then()
                .body(equalTo("2"))
                .statusCode(200);
    }

    @And("^the identifier should uniquely identify the added message$")
    public void theIdentifierShouldUniquelyIdentifyTheAddedMessage() throws Throwable {
        given()
                .contentType(ContentType.JSON)
                .body(message3)
                .when().post("/message")
                .then()
                .body(equalTo("3"))
                .statusCode(200);

        given()
                .when().get("/message/3")
                .then()
                .body("title",equalTo("Acceptance test"))
                .body("message", equalTo("cukes library is still being supported by JetBrains for now according to the CTO"))
                .statusCode(200);
    }

    @Given("^I have an empty message$")
    public void iHaveAnEmptyMessage() throws Throwable {
        message4.put("title","Empty message for exceptional case");
        message4.put("message","");
    }

    @When("^I add the empty message$")
    public void iAddTheEmptyMessage() throws Throwable {
        given()
                .contentType(ContentType.JSON)
                .body(message4)
                .when().post("/message")
                .then()
                .statusCode(400);
    }

    @Then("^I should be informed that the message is empty$")
    public void iShouldBeInformedThatTheMessageIsEmpty() throws Throwable {
        given()
                .contentType(ContentType.JSON)
                .body(message4)
                .when().post("/message")
                .then()
                //.statusLine() TODO check for custom status message
                .statusCode(400);
    }
}
