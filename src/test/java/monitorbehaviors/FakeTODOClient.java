package monitorbehaviors;

import java.util.HashMap;
import java.util.Map;

import static java.util.UUID.randomUUID;

public class FakeTODOClient implements TODOClient {

    Map<String, TODO> TODOs = new HashMap<>();

    @Override
    public String createTODO(String content) {
        String id = randomUUID().toString();
        TODOs.put(id, new TODO(id, content));
        return id;
    }

    @Override
    public TODO findTODObyId(String todoId) {
        return TODOs.get(todoId);
    }
}
