package monitorbehaviors;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import monitorbehaviors.TODOClient.TODO;
import monitorbehaviors.TODOClient.TODONotFoundException;
import org.hamcrest.MatcherAssert;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.emptyList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StepDefinitions {

    public static final String WITH_AN_EMPTY_CONTENT = "";

    private final TODOClient client = new FakeTODOClient();

    private Exception expectedException;
    private final List<TODO> expectedTODOs = new ArrayList<>();

    private TODO actualTODO;
    private List<TODO> actualTODOs = emptyList();

    @When("I create a TODO")
    public void i_create_a_todo() {
        String id = client.createTODO(WITH_AN_EMPTY_CONTENT);
        expectedTODOs.add(new TODO(id, WITH_AN_EMPTY_CONTENT));
    }

    @Then("I get its identifier")
    public void i_get_its_identifier() {
        assertTrue(expectedTODOs.get(0).id.length() > 0);
    }

    @Given("An existing TODO with content {string}")
    public void an_existing_todo_with_content(String content) {
        String id = client.createTODO(content);
        expectedTODOs.add(new TODO(id, content));
    }

    @When("I try to get it")
    public void i_try_to_get_it() throws TODONotFoundException {
        actualTODO = client.findTODObyId(expectedTODOs.get(0).id);
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
        assertEquals(expectedTODOs.get(0), actualTODO);
    }

    @Then("I get an error telling that the TODO was not found")
    public void i_get_an_error_telling_that_the_todo_was_not_found() throws Exception {
        assertEquals(expectedException.getClass(), TODONotFoundException.class);
    }

    @When("I access the list of TODOs")
    public void i_access_the_list_of_todos() {
        actualTODOs = client.allTODOs();
    }

    @Then("I can see all the TODOs")
    public void i_can_see_all_the_todos() {
        assertTrue(expectedTODOs.containsAll(actualTODOs));
    }
}
