package comparator_test.search_type;

import appconfig.argument_parser.ParameterStore;
import comparator.search_type.MaskComparator;
import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)

@DisplayName("Mask type test")
public class MaskComparatorTest {

    private MaskComparator maskComparator;

    @DisplayName("Correct mask test *.java")
    @Test
    void PrintToConsoleCorrectMaskTest1(){
        ParameterStore.setMask("*.java");
        maskComparator = new MaskComparator();
        Assertions.assertFalse(maskComparator.compare("file-776194140.xml"));
        Assertions.assertTrue(maskComparator.compare("file-1073842118.java"));
        Assertions.assertFalse(maskComparator.compare("file-1498940214.xhtml"));
    }

    @DisplayName("Correct mask test *.xhtml")
    @Test
    void PrintToConsoleCorrectMaskTest2(){
        ParameterStore.setMask("*.xhtml");
        maskComparator = new MaskComparator();
        Assertions.assertFalse(maskComparator.compare("file-776194140.xml"));
        Assertions.assertFalse(maskComparator.compare("file-1073842118.java"));
        Assertions.assertTrue(maskComparator.compare("file-1498940214.xhtml"));
    }

    @DisplayName("Correct mask test *.xml")
    @Test
    void PrintToConsoleCorrectMaskTest3(){
        ParameterStore.setMask("*.xml");
        maskComparator = new MaskComparator();
        Assertions.assertTrue(maskComparator.compare("file-776194140.xml"));
        Assertions.assertFalse(maskComparator.compare("file-1073842118.java"));
        Assertions.assertFalse(maskComparator.compare("file-1498940214.xhtml"));
    }

    @DisplayName("Incorrect mask test")
    @Test
    void PrintToConsoleIncorrectMaskTest(){
        ParameterStore.setMask("*.sf");
        maskComparator = new MaskComparator();
        Assertions.assertFalse(maskComparator.compare("file-776194140.xml"));
        Assertions.assertFalse(maskComparator.compare("file-1073842118.java"));
        Assertions.assertFalse(maskComparator.compare("file-1498940214.xhtml"));
    }

    @AfterEach
    void afterEach(){
        maskComparator = null;
    }

}
