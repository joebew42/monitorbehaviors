package monitorbehaviors;

import kong.unirest.GenericType;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

import java.util.List;

public class RestAPITODOClient implements TODOClient {

    private final String endpoint = "https://private-b7eec-todolist1.apiary-mock.com/todos";

    @Override
    public String createTODO(String content) {
        String response = Unirest.post(endpoint)
                .header("accept", "application/json")
                .field("content", content)
                .asJson()
                .getHeaders()
                .getFirst("location");

        return response.replace("/todos/", "");
    }

    @Override
    public TODO findTODObyId(String todoId) throws TODONotFoundException {
        HttpResponse<TODO> response = Unirest.get(endpoint + "/{id}")
                .routeParam("id", todoId)
                .asObject(TODO.class);

        if (response.isSuccess()) {
            return response.getBody();
        }

        throw new TODONotFoundException();
    }

    @Override
    public List<TODO> allTODOs() {
        return Unirest.get(endpoint)
                .asObject(new GenericType<List<TODO>>(){})
                .getBody();
    }
}
