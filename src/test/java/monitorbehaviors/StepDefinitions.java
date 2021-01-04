package monitorbehaviors;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import monitorbehaviors.TODOClient.TODO;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StepDefinitions {

    private final TODOClient client = new FakeTODOClient();

    private String expectedId = "";
    private String expectedContent = "";

    private TODO actualTodo;

    @When("I create a TODO")
    public void i_create_a_todo() {
        expectedId = client.createTODO(expectedContent);
    }

    @Then("I should receive its identifier")
    public void i_should_receive_its_identifier() {
        assertTrue(expectedId.length() > 0);
    }

    @Given("An existing TODO with content {string}")
    public void an_existing_todo_with_content(String content) {
        expectedContent = content;
        expectedId = client.createTODO(content);
    }

    @When("I try to get it")
    public void i_try_to_get_it() {
        actualTodo = client.findTODObyId(expectedId);
    }

    @Then("I can read its content")
    public void i_can_read_its_content() {
        assertEquals(new TODO(expectedId, expectedContent), actualTodo);
    }

}
