package appconfig.argument_parser;

public class ParameterStore {
    private static String inputFileName;
    private static String typeOfFilter = "";
    private static String stringToFilter = "";

    public static String getStringToFilter() {
        return stringToFilter;
    }
    public void setStringToFilter(String stringToFilter){
        ParameterStore.stringToFilter = stringToFilter;
    }

    public static String getTypeOfFilter() {
        return typeOfFilter;
    }
    public void setTypeOfFilter(String typeOfFilter){
        ParameterStore.typeOfFilter = typeOfFilter;
    }

    public static String getInputFileName() {
        return inputFileName;
    }

    public void setInputFileName(String inputFileName) {
        ParameterStore.inputFileName = inputFileName;
    }
}
