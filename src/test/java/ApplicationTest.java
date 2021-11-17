import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)

@DisplayName("Main test")
public class ApplicationTest {

    private final ByteArrayOutputStream OutputStream = new ByteArrayOutputStream();
    private final PrintStream standardOut = System.out;

    @BeforeEach
    void setUpStream(){
        System.setOut(new PrintStream(OutputStream));
    }


    @DisplayName("No search input")
    @Test
    void noSearchInput(){
        Main.main(new String[]{"-f", "test-files.xml"});

        String expected = """
                /file-776194140.xml\r
                /dir-880176375/file-1073842118.java\r
                /dir-880176375/dir-2145307015/file-1498940214.xhtml\r
                """;
        Assertions.assertEquals(expected, OutputStream.toString());
    }

    @DisplayName("Exact search input")
    @Test
    void exactSearchInput(){
        Main.main(new String[]{"-f", "test-files.xml", "-s", "file-1498940214.xhtml"});

        String expected = "/dir-880176375/dir-2145307015/file-1498940214.xhtml\r\n";
        Assertions.assertEquals(expected, OutputStream.toString());
    }

    @DisplayName("Simple search input")
    @Test
    void simpleSearchInput(){
        Main.main(new String[]{"-f", "test-files.xml", "-s", "'*.java'"});

        String expected = "/dir-880176375/file-1073842118.java\r\n";
        Assertions.assertEquals(expected, OutputStream.toString());
    }

    @DisplayName("Extended search input")
    @Test
    void extendedSearchInput(){
        Main.main(new String[]{"-f", "test-files.xml", "-S", "'.*?[a-z]{4}-\\d+\\.[a-z]+'"});

        String expected = """
                /file-776194140.xml\r
                /dir-880176375/file-1073842118.java\r
                /dir-880176375/dir-2145307015/file-1498940214.xhtml\r
                """;
        Assertions.assertEquals(expected, OutputStream.toString());
    }

    @AfterEach
    void tearDown(){
        System.setOut(standardOut);
    }
}