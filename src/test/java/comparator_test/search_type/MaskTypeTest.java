package comparator_test.search_type;

import comparator.search_type.MaskType;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;


@TestInstance(TestInstance.Lifecycle.PER_METHOD)

@DisplayName("Mask type test")
public class MaskTypeTest {

    private MaskType maskType;

    @BeforeEach
    void prepare(){
        maskType = new MaskType();
    }

    @DisplayName("Correct mask test")
    @Test
    void PrintToConsoleCorrectMaskTest(){
        Assertions.assertEquals("file-1073842118.java",
                                maskType.printToConsole("‘*.java’", "file-1073842118.java"));
        Assertions.assertEquals("file-1073842118.java",
                                maskType.printToConsole("file-*.java", "file-1073842118.java"));
        Assertions.assertEquals("file-1073842118.java",
                                maskType.printToConsole("f*a", "file-1073842118.java"));
    }

    @DisplayName("Incorrect mask test")
    @Test
    void PrintToConsoleIncorrectMaskTest(){
        Assertions.assertNotEquals("file-1073842118.java",
                                   maskType.printToConsole("‘*sf*’", "file-1073842118.java"));
        Assertions.assertNotEquals("file-1073842118.java",
                                   maskType.printToConsole("‘*.ja'va’", "file-1073842118.java"));
    }

    @DisplayName("Exception catching test")
    @Test
     void PrintToConsoleExceptionTest() throws StringIndexOutOfBoundsException {
        Throwable thrown = assertThrows(StringIndexOutOfBoundsException.class, () -> {
            Assertions.assertEquals("file-1073842118.java",
                    maskType.printToConsole("*", "file-1073842118.java"));
        });
        assertNotNull(thrown.getMessage());
    }

    @AfterEach
    void afterEach(){
        maskType = null;
    }

}
