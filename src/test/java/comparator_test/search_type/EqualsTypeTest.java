package comparator_test.search_type;

import appconfig.argument_parser.ParameterStore;
import comparator.search_type.EqualsType;
import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)

@DisplayName("Equals type test")
public class EqualsTypeTest {

    private EqualsType equalsType;

    @BeforeEach
    void prepare(){
        equalsType = new EqualsType();
    }

    @DisplayName("Equals test")
    @Test
    void PrintToConsoleEqualsTest() {
        ParameterStore.setMack("file-1073842118.java");
        Assertions.assertEquals("file-1073842118.java",
                                equalsType.printToConsole( "file-1073842118.java"));

        ParameterStore.setMack("file-1498940214.xhtml");
        Assertions.assertEquals("file-1498940214.xhtml",
                                equalsType.printToConsole("file-1498940214.xhtml"));
    }

    @DisplayName("Not equals test")
    @Test
    void PrintToConsoleNotEqualsTest() {
        ParameterStore.setMack("file-1498940214.xhtml");
        Assertions.assertNotEquals("file-1073842118.java",
                                    equalsType.printToConsole("file-1073842118.java"));

        ParameterStore.setMack("file-1073842118.java");
        Assertions.assertNotEquals("file-1498940214.xhtml",
                                    equalsType.printToConsole("file-1498940214.xhtml"));
    }

    @AfterEach
    void afterEach(){
        equalsType = null;
    }
}
