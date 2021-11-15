import appconfig.argument_parser.ArgumentParser;
import appconfig.argument_parser.ParameterStore;
import comparator.Comparator;
import comparator.SearchFactory;
import org.xml.sax.SAXException;
import parser.SaxParser;

import java.io.IOException;


public class Main {
    public static void main(String[] args) {
        try {
            ArgumentParser argumentParser = new ArgumentParser();
            argumentParser.argumentProcess(args);

            SearchFactory searchFactory = new SearchFactory();
            Comparator comparator = searchFactory.create(ParameterStore.getSearchType());
            comparator.setMask(ParameterStore.getMack());
            new SaxParser(comparator, ParameterStore.getInputFileName());
        } catch (SAXException e) {
            System.out.println("sax parsing error " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO parsing error " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Open sax parser error " + e.getMessage());
        }
    }
}
