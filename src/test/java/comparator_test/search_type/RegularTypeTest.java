package comparator_test.search_type;

import appconfig.argument_parser.ParameterStore;
import comparator.search_type.RegularType;
import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)

@DisplayName("Regular type test")
public class RegularTypeTest {

    private RegularType regularType;

    @DisplayName("Correct regular expression test")
    @Test
    void PrintToConsoleCorrectRegexTest() {
        ParameterStore.setMack(".*?[a-z]{4}-\\d+\\.[a-z]+");
        regularType = new RegularType();
        Assertions.assertEquals("file-776194140.xml", regularType.printToConsole("file-776194140.xml"));
        Assertions.assertEquals("file-1073842118.java", regularType.printToConsole("file-1073842118.java"));
        Assertions.assertEquals("file-1498940214.xhtml", regularType.printToConsole("file-1498940214.xhtml"));
    }

    @DisplayName("Incorrect regular expression test")
    @Test
    void PrintToConsoleIncorrectRegexTest() {
        ParameterStore.setMack(".*?[a-z]{4}-\\\\d+\\.[a-z]+");
        regularType = new RegularType();
        Assertions.assertNotEquals("file-1073842118.java", regularType.printToConsole("file-1073842118.java"));
    }

    @AfterEach
    void afterEach(){
        regularType = null;
    }
}
