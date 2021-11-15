package appconfig.argument_parser;

import comparator.search_type.SearchType;

public class ParameterStore {
    private static String inputFileName;
    private static String mack;
    private static SearchType searchType = SearchType.Full;

    public static String getMack() {
        return mack;
    }
    public static void setMack(String mack){
        ParameterStore.mack = mack;
    }

    public static String getInputFileName() {
        return inputFileName;
    }
    protected void setInputFileName(String inputFileName) {
        ParameterStore.inputFileName = inputFileName;
    }

    public static SearchType getSearchType() {
        return searchType;
    }
    public static void setSearchType(SearchType searchType) {
        ParameterStore.searchType = searchType;
    }
}
