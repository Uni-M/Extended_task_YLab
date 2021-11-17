package appconfig.argument_parser;

import appconfig.constant.SearchType;

public abstract class ParameterStore {
    private static String inputFileName;
    private static String mask;
    private static SearchType searchType = SearchType.Full;

    public static String getMask() {
        return mask;
    }
    public static void setMask(String mask){
        ParameterStore.mask = mask;
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
