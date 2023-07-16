package met.office.api.testbase;

import io.restassured.RestAssured;
import met.office.api.constants.Path;
import met.office.api.utils.PropertyReader;
import org.junit.BeforeClass;


public class TestBase {
    public static PropertyReader propertyReader;

    @BeforeClass
    public static void init() {
        propertyReader = PropertyReader.getInstance();
       RestAssured.baseURI = propertyReader.getProperty("baseUrl");
        System.out.println(propertyReader.getProperty("baseUrl"));
       RestAssured.basePath = Path.DATA;
    }

}
