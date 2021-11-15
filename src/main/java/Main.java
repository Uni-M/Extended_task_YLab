import appconfig.argument_parser.ArgumentParser;
import appconfig.argument_parser.ParameterStore;
import comparator.Comparator;
import comparator.SearchFactory;
import exception.ArgumentException;
import parser.SaxParser;


public class Main {
    public static void main(String[] args) {
        try {
            ArgumentParser argumentParser = new ArgumentParser();
            argumentParser.argumentProcess(args);

            SearchFactory searchFactory = new SearchFactory();
            Comparator comparator = searchFactory.create(ParameterStore.getSearchType());
            comparator.setMask(ParameterStore.getMack());
            new SaxParser(comparator, ParameterStore.getInputFileName());

        }catch (ArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
