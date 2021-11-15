package parser;

import appconfig.argument_parser.ParameterStore;
import comparator.search_type.*;
import org.junit.jupiter.api.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;


@TestInstance(TestInstance.Lifecycle.PER_METHOD)

@DisplayName("Sax parser test")
public class SaxParserTest {

    @DisplayName("Test with incorrect file name in argument")
    @Test
    void incorrectFileNameInArgumentTest() {
        ParameterStore.setMack("*.xhtml");

        try {
            new SaxParser(new MaskType(), "files.xml");
        } catch (IOException | ParserConfigurationException | SAXException e) {
            System.out.println(e.getMessage());
        }
    }

    @DisplayName("Test with mask type in argument")
    @Test
    void MaskTypeTest() {
        ParameterStore.setMack("*.xhtml");
        try {
            new SaxParser(new MaskType(), "test-files.xml");
        } catch (IOException | ParserConfigurationException | SAXException e) {
            System.out.println(e.getMessage());
        }
    }

    @DisplayName("Test with full type in argument")
    @Test
    void FullTypeTest() {
        try {
            new SaxParser(new FullType(), "test-files.xml");
        } catch (IOException | ParserConfigurationException | SAXException e) {
            System.out.println(e.getMessage());
        }
    }

    @DisplayName("Test with equals type in argument")
    @Test
    void equalsTypeTest() {
        ParameterStore.setMack("file-1073842118.java");
        try {
            new SaxParser(new EqualsType(), "test-files.xml");
        } catch (IOException | ParserConfigurationException | SAXException e) {
            System.out.println(e.getMessage());
        }
    }

    @DisplayName("Test with regular type in argument")
    @Test
    void regularTypeTest() {
        ParameterStore.setMack(".*?[a-z]{4}-\\d+\\.[a-z]+");
        try {
            new SaxParser(new RegularType(), "test-files.xml");
        } catch (IOException | ParserConfigurationException | SAXException e) {
            System.out.println(e.getMessage());
        }
    }
}
