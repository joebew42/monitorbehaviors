package monitorbehaviors;

public class FakeTODOClient implements TODOClient {
    @Override
    public String createTODO() {
        return "AN ID";
    }
}
