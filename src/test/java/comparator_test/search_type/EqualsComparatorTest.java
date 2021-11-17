package comparator_test.search_type;

import appconfig.argument_parser.ParameterStore;
import comparator.comparator_type.EqualsComparator;
import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)

@DisplayName("Equals type test")
public class EqualsComparatorTest {

    private EqualsComparator equalsComparator;

    @BeforeEach
    void prepare(){
        equalsComparator = new EqualsComparator();
    }

    @DisplayName("Equals test")
    @Test
    void PrintToConsoleEqualsTest() {
        ParameterStore.setMask("file-776194140.xml");
        Assertions.assertTrue(equalsComparator.compare("file-776194140.xml"));

        ParameterStore.setMask("file-1073842118.java");
        Assertions.assertTrue(equalsComparator.compare( "file-1073842118.java"));

        ParameterStore.setMask("file-1498940214.xhtml");
        Assertions.assertTrue(equalsComparator.compare("file-1498940214.xhtml"));
    }

    @DisplayName("Not equals test")
    @Test
    void PrintToConsoleNotEqualsTest() {
        ParameterStore.setMask("file-776194140.xml");
        Assertions.assertFalse(equalsComparator.compare("file-1073842118.java"));

        ParameterStore.setMask("file-1073842118.java");
        Assertions.assertFalse(equalsComparator.compare("file-1498940214.xhtml"));

        ParameterStore.setMask("file-1498940214.xhtml");
        Assertions.assertFalse(equalsComparator.compare("file-776194140.xml"));
    }

    @AfterEach
    void afterEach(){
        equalsComparator = null;
    }
}
