package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.StringContains.containsString;

public class GetMessages {


    private String numberOfMessages;

    @Given("^I have a limited number of messages that I want to retrieve$")
    public void iHaveALimitedNumberOfMessagesThatIWantToRetrieve() throws Throwable {

        numberOfMessages = "?limit=3";

    }

    @When("^I attempt to retrieve those messages using the limited number$")
    public void iAttemptToRetrieveThoseMessagesUsingTheLimitedNumber() throws Throwable {

        given()
                .when().get("/messages/" + numberOfMessages)
                .then()
                .statusCode(200);
    }

    @Then("^the limited number of messages specified is returned in order of a last in first out bases$")
    public void theLimitedNumberOfMessagesSpecifiedIsReturnedInOrderOfALastInFirstOutBases() throws Throwable {

        //Using the messages setUp in the cucumber MessageHooK class

        given()
                .when().get("/messages/" + numberOfMessages)
                .then()
                .body(containsString("Messages in string"));

        given()
                .when().get("/messages/" + numberOfMessages)
                .then()
                .body(containsString("African safari"));

        given()
                .when().get("/messages/" + numberOfMessages)
                .then()
                .body(containsString("Exam day headline"));

        given()
                .when().get("/messages/" + numberOfMessages)
                .then()
                .assertThat()
                .body("size()", is(3));
    }

    @Given("^there are no messages$")
    public void thereAreNoMessages() throws Throwable {
        //The hook is not set to run when this scenario is executed so there is no content in the database
    }

    @When("^I attempt to retrieve those messages$")
    public void iAttemptToRetrieveThoseMessages() throws Throwable {
        //Using the HTTP GET method to retrieve the messages using the provided query parameter
    }

    @Then("^I am informed that there are no messages to be retrieved$")
    public void iAmInformedThatThereAreNoMessagesToBeRetrieved() throws Throwable {
        given()
                .when().get("/messages/" + numberOfMessages)
                .then()
                .statusCode(404);
    }
}
