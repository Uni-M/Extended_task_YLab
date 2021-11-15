package parser;

import exception.ArgumentException;
import org.junit.jupiter.api.*;


@TestInstance(TestInstance.Lifecycle.PER_METHOD)

@DisplayName("Sax parser test")
public class SaxParserTest {

    private SaxParser saxParser;
    private String [] args;

    @BeforeEach
    void prepare(){
        saxParser = new SaxParser();
    }

    @DisplayName("Test without arguments")
    @Test
    void noArgumentTest(){
        args = new String[0];
        Assertions.assertThrows(NullPointerException.class, () -> saxParser.parse(args));
    }

    @DisplayName("File is not exist Test")
    @Test
    void fileExistenceTest(){
        args = new String[]{"-s", "file-1498940214.xhtml", "-f", "files.xml"};
        Assertions.assertThrows(ArgumentException.class, () -> saxParser.parse(args));
    }

    @DisplayName("Test with correct keys")
    @Test
    void correctArgumentTest() {
        args = new String[]{"-f", "test-files.xml", "-s", "file-1498940214.xhtml"};
        Assertions.assertThrows(ArgumentException.class, () -> saxParser.parse(args));
    }

    @DisplayName("Test with switched keys")
    @Test
    void switchedArgumentTest() {
        args = new String[]{"-s", "file-1498940214.xhtml", "-f", "test-files.xml"};
        Assertions.assertThrows(ArgumentException.class, () -> saxParser.parse(args));
    }

    @DisplayName("Test with full file name in argument")
    @Test
    void fullFileNameInArgumentTest() {
        args = new String[]{"-s", "file-1498940214.xhtml", "-f",
                "D:\\JavaProjects\\YLab_Extended_task\\test-files.xml"};

        Assertions.assertThrows(ArgumentException.class, () -> saxParser.parse(args));
    }


    @AfterEach
    void afterEach(){
        saxParser = null;
    }
}
