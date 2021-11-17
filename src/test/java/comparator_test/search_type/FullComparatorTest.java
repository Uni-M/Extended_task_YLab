package comparator_test.search_type;

import comparator.search_type.FullComparator;
import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)

@DisplayName("Full type test")
public class FullComparatorTest {

    private FullComparator fullComparator;

    @BeforeEach
    void prepare(){
        fullComparator = new FullComparator();
    }

    @DisplayName("Test with different arguments")
    @Test
    void fullTypeTest(){
        Assertions.assertTrue(fullComparator.compare("file-1073842118.java"));
        Assertions.assertTrue(fullComparator.compare( "file-1498940214.xhtml"));
        Assertions.assertTrue(fullComparator.compare("file-776194140.xml"));

    }

    @AfterEach
    void afterEach(){
        fullComparator = null;
    }
}
