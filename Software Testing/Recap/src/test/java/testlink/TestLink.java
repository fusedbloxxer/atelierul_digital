package testlink;

import testlink.api.java.client.TestLinkAPIClient;
import testlink.api.java.client.TestLinkAPIException;

public class TestLink {
    // HOMEWORK: Sa inchidem driver dupa ce ruleaza toate scenariile
    public static final String PROJECT_NAME = "TS7";
    public static final String TEST_PLAN_NAME = "TS7";
    public static final String TEST_CASE_NAME = "TS7";
    public static final String BUILD_NAME = "TS7";

    private String key = "61792539839b4eb3935f0f43aae6b751"; // generate key
    private String url = "http://127.0.0.1/testlink/lib/api/xmlrpc/v1/xmlrpc.php";
    private TestLinkAPIClient testLinkAPIClient = new TestLinkAPIClient(key, url);

    public TestLink updateTest(String testCaseName, String status) {
        try {
            testLinkAPIClient.reportTestCaseResult(PROJECT_NAME, TEST_PLAN_NAME, testCaseName, BUILD_NAME, "dfg", status);
        } catch (TestLinkAPIException e) {
            throw new RuntimeException("Error occurred while updating testlink!", e);
        }
        return this;
    }

    public TestLink ping() {
        try {
            System.out.println(testLinkAPIClient.ping());
        } catch (TestLinkAPIException e) {
            throw new RuntimeException("Couldn't ping !", e);
        }
        return this;
    }
}
