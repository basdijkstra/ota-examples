package helpers;

import static io.restassured.RestAssured.given;

public class ApiHelpers {

    public static void initializeDatabaseBeforeTest() {

        given().
        when().
            post("http://parabank.parasoft.com/parabank/services/bank/initializeDB").
        then().
            assertThat().
            statusCode(204);
    }
}
