package monitorbehaviors;

public class ClientFactory {
    public static final String TEST_NAME_RESTAPI = "restapi";

    public static TODOClient createFrom(String testName) {
        if (TEST_NAME_RESTAPI.equals(testName)) {
            return new RestAPITODOClient();
        }
        return new FakeTODOClient();
    }
}
