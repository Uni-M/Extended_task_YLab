package appconfig_test.argument_parser_test;

import org.junit.jupiter.api.*;
import appconfig.argument_parser.ArgumentParser;
import exception.ArgumentException;

import static org.junit.jupiter.api.Assertions.*;
import static appconfig.argument_parser.ArgumentParser.*;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)

@DisplayName("Command line arguments parsing test")
class ArgumentParserTest {

    private ArgumentParser argumentParser;
    private String [] args;

    @BeforeEach
    void prepare(){
        argumentParser = new ArgumentParser();
    }

    @DisplayName("Test without arguments")
    @Test
    void noArgumentTest(){
        args = new String[0];
        Assertions.assertThrows(ArgumentException.class, () -> argumentParser.argumentProcess(args));
    }

    @DisplayName("File is not exist Test")
    @Test
    void fileExistenceTest(){
        args = new String[]{"-s", "file-1498940214.xhtml", "-f", "files.xml"};
        Assertions.assertThrows(ArgumentException.class, () -> argumentParser.argumentProcess(args));
    }

    @DisplayName("Test with incorrect key")
    @Test
    void unknownArgumentTest() {
         args = new String[]{"-t", "test-files.xml"};
        Assertions.assertThrows(ArgumentException.class, () -> argumentParser.argumentProcess(args));
    }


    @DisplayName("Test with switched keys")
    @Test
    void correctArgumentTest() {
        args = new String[]{"-f", "test-files.xml", "-s", "file-1498940214.xhtml"};

        try {
            argumentParser.argumentProcess(args);

            assertTrue( argumentParser.getInputFileName().contains("test-files.xml"));
            assertEquals("file-1498940214.xhtml", getStringToFilter());
            assertEquals("-s", getTypeOfFilter());

        } catch (ArgumentException e) {
            System.out.println("invalid arguments entered" + e);
        }
    }

    @DisplayName("Test with switched keys")
    @Test
    void switchedArgumentTest() {
        args = new String[]{"-s", "file-1498940214.xhtml", "-f", "test-files.xml"};

        try {
            argumentParser.argumentProcess(args);

            assertTrue( argumentParser.getInputFileName().contains("test-files.xml"));
            assertEquals("file-1498940214.xhtml", getStringToFilter());
            assertEquals("-s", getTypeOfFilter());

        } catch (ArgumentException e) {
            System.out.println("invalid arguments entered" + e);
        }
    }

    @DisplayName("Test with full file name in argument")
    @Test
    void fullFileNameInArgumentTest() {
       args = new String[]{"-s", "file-1498940214.xhtml", "-f",
                                    "D:\\JavaProjects\\YLab_Extended_task\\test-files.xml"};

        try {
            argumentParser.argumentProcess(args);

            assertEquals("D:\\JavaProjects\\YLab_Extended_task\\test-files.xml", argumentParser.getInputFileName());
            assertEquals("file-1498940214.xhtml", getStringToFilter());
            assertEquals("-s", getTypeOfFilter());

        } catch (ArgumentException e) {
            System.out.println("invalid arguments entered" + e);
        }
    }


    @AfterEach
    void afterEach(){
        argumentParser = null;
    }
}
