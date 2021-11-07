package comparator_test.search_type;

import comparator.search_type.MaskType;
import comparator.search_type.RegularType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)

@DisplayName("Regular type test")
public class RegularTypeTest {

    private RegularType regularType;

    @DisplayName("Correct regular expression test")
    @Test
    void PrintToConsoleCorrectRegexTest() {
        regularType = new RegularType();
        Assertions.assertEquals("file-1073842118.java", regularType.printToConsole(".*?[a-z]{4}-\\d+\\.[a-z]+", "file-1073842118.java"));
        Assertions.assertEquals("file-1073842118.java", regularType.printToConsole("'.*?[a-z]{4}-\\d+\\.[a-z]+'", "file-1073842118.java"));
    }

    @DisplayName("Incorrect regular expression test")
    @Test
    void PrintToConsoleIncorrectRegexTest() {
        regularType = new RegularType();
        Assertions.assertNotEquals("file-1073842118.java", regularType.printToConsole("‘.*?[a-z]{4}-\\\\d+\\.[a-z]+’", "file-1073842118.java"));
    }

    @DisplayName("Exception catching test")
    @Test
    void PrintToConsoleExceptionTest() {
        regularType = new RegularType();

        Throwable thrown = assertThrows(Exception.class, () -> {
            Assertions.assertEquals("file-1073842118.java", regularType.printToConsole("\\", "file-1073842118.java"));
        });
        assertNotNull(thrown.getMessage());
    }
}
