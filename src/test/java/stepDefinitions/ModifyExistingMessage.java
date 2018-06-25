package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.ContentType;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.is;

public class ModifyExistingMessage {

    String messageId;
    private Map<String, String> message;
    private Map<String, String> message2;
    private Map<String, String> message3;

    @Given("^I have a message and an identifier$")
    public void iHaveAMessageAndAnIdentifier() throws Throwable {
        message = new HashMap<>();
        message.put("title", "Modify me");
        message.put("message", "I have not yet been modified");
        messageId = "1";

        Map<String, String> messageToBeModified = new HashMap<>();
        messageToBeModified.put("title", "Modify me");
        messageToBeModified.put("message", "Message will be modified");

        given()
                .contentType(ContentType.JSON)
                .body(messageToBeModified)
                .post("/message")
                .then()
                .statusCode(200);

    }

    @When("^I send the message with the identifier$")
    public void iSendTheMessageWithTheIdentifier() throws Throwable {
        given()
                .contentType(ContentType.JSON)
                .body(message)
                .put("/message/" + messageId)
                .then()
                .statusCode(200);
    }

    @Then("^the message linked to that modifier is replaced with the new message$")
    public void theMessageLinkedToThatModifierIsReplacedWithTheNewMessage() throws Throwable {
        given()
                .get("/message/" + messageId)
                .then()
                .body("title", equalTo(message.get("title")))
                .body("message", equalTo(message.get("message")));
    }

    @Given("^I have a message and an invalid identifier$")
    public void iHaveAMessageAndAnInvalidIdentifier() throws Throwable {
        message2 = new HashMap<>();
        message2.put("title", "Invalid identifier");
        message2.put("message", "The identifier does not exist");

        messageId = "44";
    }

    @When("^I send the message with the invalid identifier$")
    public void iSendTheMessageWithTheInvalidIdentifier() throws Throwable {
        //
    }

    @Then("^I am informed that there is no message linked to the identifier$")
    public void iAmInformedThatThereIsNoMessageLinkedToTheIdentifier() throws Throwable {
        given()
                .contentType(ContentType.JSON)
                .body(message2)
                .put("/message/" + messageId)
                .then()
                .statusCode(404);
    }

    @Given("^I have an empty message and an valid identifier$")
    public void iHaveAnEmptyMessageAndAnValidIdentifier() throws Throwable {
        message3 = new HashMap<>();
        message3.put("title", "");
        message3.put("message", "");

        messageId = "2";

    }

    @When("^I send the empty message with the identifier$")
    public void iSendTheEmptyMessageWithTheIdentifier() throws Throwable {
        //
    }

    @Then("^I am informed that the message is empty$")
    public void iAmInformedThatTheMessageIsEmpty() throws Throwable {
        given()
                .contentType(ContentType.JSON)
                .body(message3)
                .put("/message/" + messageId)
                .then()
                .statusCode(anyOf(is(404), is(400)));
    }
}
