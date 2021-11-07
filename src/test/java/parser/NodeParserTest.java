package parser;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)

@DisplayName("Node parser test")
public class NodeParserTest {

    private NodeParser nodeParser;

    @BeforeEach
    void prepare(){
        nodeParser = new NodeParser();
    }


    @Test
    void startDocumentTest() {
    }

    @Test
    void startElement() {
    }

    @Test
    void endElement() {
    }

    @Test
    void characters() {
    }
}
