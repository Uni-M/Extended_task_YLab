package comparator_test.search_type;

import comparator.search_type.RegularType;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)

@DisplayName("Regular type test")
public class RegularTypeTest {

    private RegularType regularType;

    @BeforeEach
    void prepare(){
        regularType = new RegularType();
    }
    @DisplayName("Correct regular expression test")
    @Test
    void PrintToConsoleCorrectRegexTest() {
        Assertions.assertEquals("file-1073842118.java", regularType.printToConsole(".*?[a-z]{4}-\\d+\\.[a-z]+", "file-1073842118.java"));
        Assertions.assertEquals("file-1073842118.java", regularType.printToConsole("'.*?[a-z]{4}-\\d+\\.[a-z]+'", "file-1073842118.java"));
    }

    @DisplayName("Incorrect regular expression test")
    @Test
    void PrintToConsoleIncorrectRegexTest() {
        Assertions.assertNotEquals("file-1073842118.java", regularType.printToConsole("‘.*?[a-z]{4}-\\\\d+\\.[a-z]+’", "file-1073842118.java"));
    }

    @DisplayName("Exception catching test")
    @Test
    void PrintToConsoleExceptionTest() {
        Throwable thrown = assertThrows(Exception.class, () -> {
            Assertions.assertEquals("file-1073842118.java", regularType.printToConsole("\\", "file-1073842118.java"));
        });
        assertNotNull(thrown.getMessage());
    }

    @AfterEach
    void afterEach(){
        regularType = null;
    }
}
