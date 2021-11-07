package parser;

import org.junit.jupiter.api.*;

import static appconfig.constant.XConstant.*;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)

@DisplayName("Node parser test")
public class NodeParserTest {

    private NodeParser nodeParser;
    String qName;

    @BeforeEach
    void prepare(){
        nodeParser = new NodeParser();
    }

    @DisplayName("Expected qName in endElement")
    @Test
    void endElementExpectedTest() {

        try {
            nodeParser.endElement("", "", ACTIVE_NODE);
            nodeParser.endElement("", "", INCLUDE_NODE);
            nodeParser.endElement("", "", FOLDER_NODE);
        }catch (IllegalStateException e){
            System.out.println("Unexpected qName: " + e);
        }
    }

    @DisplayName("Unexpected qName in endElement")
    @Test
    void endElementUnexpectedTest() {
        qName = "Unexpected qName";
        Assertions.assertThrows(IllegalStateException.class, () -> nodeParser.endElement("", "", qName));
    }

    @DisplayName("Correct reading characters")
    @Test
    void correctReadingCharacters() {
        char[] file = {' ','f','i','l','e','-','1','0','7','3','8','4','2','1','1','8','.','j','a','v','a', ' '};
        nodeParser.characters(file, 0, file.length);
        Assertions.assertEquals("file-1073842118.java", nodeParser.getCurrentValue());
    }

    @DisplayName("Incorrect reading characters")
    @Test
    void incorrectReadingCharacters() {
        char[] file = {' ','f','i','l','e','-','1','0','7','3','8','4','2','1','1','8','.','j','a','v','a', ' '};
        nodeParser.characters(file, 0, file.length);
        Assertions.assertNotEquals(" file-1073842118.java ", nodeParser.getCurrentValue());
    }

    @AfterEach
    void afterEach(){
        nodeParser = null;
    }
}
