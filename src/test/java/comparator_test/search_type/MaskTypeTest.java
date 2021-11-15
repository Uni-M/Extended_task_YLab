package comparator_test.search_type;

import appconfig.argument_parser.ParameterStore;
import comparator.search_type.MaskType;
import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)

@DisplayName("Mask type test")
public class MaskTypeTest {

    private MaskType maskType;

    @DisplayName("Correct mask test *.java")
    @Test
    void PrintToConsoleCorrectMaskTest1(){
        ParameterStore.setMack("*.java");
        maskType = new MaskType();
        Assertions.assertEquals("file-1073842118.java",
                                maskType.printToConsole("file-1073842118.java"));
    }

    @DisplayName("Correct mask test *.xhtml")
    @Test
    void PrintToConsoleCorrectMaskTest2(){
        ParameterStore.setMack("*.xhtml");
        maskType = new MaskType();
        Assertions.assertEquals("file-1498940214.xhtml",
                maskType.printToConsole("file-1498940214.xhtml"));
    }

    @DisplayName("Incorrect mask test")
    @Test
    void PrintToConsoleIncorrectMaskTest(){
        ParameterStore.setMack("*sf*’");
        maskType = new MaskType();
        Assertions.assertNotEquals("file-1073842118.java",
                                   maskType.printToConsole("file-1073842118.java"));
    }

    @AfterEach
    void afterEach(){
        maskType = null;
    }

}
