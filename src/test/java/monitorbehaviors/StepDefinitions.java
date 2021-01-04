package monitorbehaviors;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertTrue;

public class StepDefinitions {

    private TODOClient client = new FakeTODOClient();

    String todoId = "";

    @When("I create a TODO")
    public void i_create_a_todo() {
        todoId = client.createTODO();
    }

    @Then("I should receive its identifier")
    public void i_should_receive_its_identifier() {
        assertTrue(todoId.length() > 0);
    }
}
