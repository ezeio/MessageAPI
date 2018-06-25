package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetMessage {

    private Long messageId;
    @Given("^I have an identifier for a message$")
    public void iHaveAnIdentifierForAMessage() throws Throwable {
        messageId = new Long(1);
    }

    @When("^I attempt to retrieve a message using that identifier$")
    public void iAttemptToRetrieveAMessageUsingThatIdentifier() throws Throwable {
        given()
                .when().get("/message/1")
                .then()
                .body("title",equalTo("Acceptance test"))
                .body("message", equalTo("cukes library is still being supported by JetBrains for now according to the CTO"))
                .statusCode(200);
    }

    @Then("^the message linked to that identifier is returned$")
    public void theMessageLinkedToThatIdentifierIsReturned() throws Throwable {

    }

    @Given("^I have an invalid identifier for a message$")
    public void iHaveAnInvalidIdentifierForAMessage() throws Throwable {

    }

    @When("^I attempt to retrieve a message using the invalid identifier$")
    public void iAttemptToRetrieveAMessageUsingTheInvalidIdentifier() throws Throwable {

    }

    @Then("^I am informed that the message with the identifier is not found$")
    public void iAmInformedThatTheMessageWithTheIdentifierIsNotFound() throws Throwable {

    }
}
