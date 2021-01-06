package monitorbehaviors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    public TODO findTODObyId(String todoId) throws TODONotFoundException {
        if (!TODOs.containsKey(todoId)) {
            throw new TODONotFoundException();
        }
        return TODOs.get(todoId);
    }

    @Override
    public List<TODO> allTODOs() {
        return new ArrayList<>(TODOs.values());
    }
}
