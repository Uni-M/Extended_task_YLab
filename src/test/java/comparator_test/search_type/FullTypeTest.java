package comparator_test.search_type;

import comparator.search_type.FullType;
import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)

@DisplayName("Full type test")
public class FullTypeTest {

    private FullType fullType;

    @BeforeEach
    void prepare(){
        fullType = new FullType();
    }

    @DisplayName("Test with different arguments")
    @Test
    void fullTypeTest(){
        Assertions.assertEquals("file-1073842118.java",
                                fullType.printToConsole("", "file-1073842118.java"));
        Assertions.assertEquals("file-1498940214.xhtml",
                                fullType.printToConsole("", "file-1498940214.xhtml"));
        Assertions.assertEquals("file-776194140.xml",
                                fullType.printToConsole("", "file-776194140.xml"));

    }

    @AfterEach
    void afterEach(){
        fullType = null;
    }
}
