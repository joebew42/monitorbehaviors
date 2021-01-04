package monitorbehaviors;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import monitorbehaviors.TODOClient.TODO;
import monitorbehaviors.TODOClient.TODONotFoundException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StepDefinitions {

    private final TODOClient client = new FakeTODOClient();

    private String expectedId = "";
    private String expectedContent = "";
    private Exception expectedException;

    private TODO actualTodo;

    @When("I create a TODO")
    public void i_create_a_todo() {
        expectedId = client.createTODO(expectedContent);
    }

    @Then("I get its identifier")
    public void i_get_its_identifier() {
        assertTrue(expectedId.length() > 0);
    }

    @Given("An existing TODO with content {string}")
    public void an_existing_todo_with_content(String content) {
        expectedContent = content;
        expectedId = client.createTODO(content);
    }

    @When("I try to get it")
    public void i_try_to_get_it() throws TODONotFoundException {
        actualTodo = client.findTODObyId(expectedId);
    }

    @When("I try to get a non existing TODO")
    public void i_try_to_get_a_non_existing_todo() {
        try {
            client.findTODObyId("NON EXISTING ID");
        } catch (TODONotFoundException e) {
            expectedException = e;
        }
    }

    @Then("I can read its content")
    public void i_can_read_its_content() {
        assertEquals(new TODO(expectedId, expectedContent), actualTodo);
    }

    @Then("I get an error telling that the TODO was not found")
    public void i_get_an_error_telling_that_the_todo_was_not_found() throws Exception {
        assertEquals(expectedException.getClass(), TODONotFoundException.class);
    }
}
