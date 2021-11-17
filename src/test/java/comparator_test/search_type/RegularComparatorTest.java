package comparator_test.search_type;

import appconfig.argument_parser.ParameterStore;
import comparator.comparator_type.RegularComparator;
import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)

@DisplayName("Regular type test")
public class RegularComparatorTest {

    private RegularComparator regularComparator;

    @DisplayName("Correct regular expression test")
    @Test
    void PrintToConsoleCorrectRegexTest() {
        ParameterStore.setMask(".*?[a-z]{4}-\\d+\\.[a-z]+");
        regularComparator = new RegularComparator();
        Assertions.assertTrue(regularComparator.compare("file-776194140.xml"));
        Assertions.assertTrue(regularComparator.compare("file-1073842118.java"));
        Assertions.assertTrue(regularComparator.compare("file-1498940214.xhtml"));
    }

    @DisplayName("Incorrect regular expression test")
    @Test
    void PrintToConsoleIncorrectRegexTest() {
        ParameterStore.setMask(".*?[a-z]{4}-\\\\d+\\.[a-z]+");
        regularComparator = new RegularComparator();
        Assertions.assertFalse(regularComparator.compare("file-776194140.xml"));
        Assertions.assertFalse(regularComparator.compare("file-1073842118.java"));
        Assertions.assertFalse(regularComparator.compare("file-1498940214.xhtml"));
    }

    @AfterEach
    void afterEach(){
        regularComparator = null;
    }
}
