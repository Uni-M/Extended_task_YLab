package xml_parser.AppConfig.argument_parser;

import xml_parser.AppConfig.exeptions.*;

import java.io.File;

import static xml_parser.AppConfig.XConstant.*;

public class ArgumentParser {

    private String inputFileName;
    private static String typeOfFilter;
    private static String stringToFilter;


    public void ArgumentProcess(String[] args) throws ArgumentException { //Это старт парсинга
        validator(args);
        storeParams(args);
    }

    private void storeParams(String[] args) throws ArgumentException{
        inputFileName = fileExists(args[1]); // — это получение имени файла + проверка//
        if (args.length > 2){
            typeOfFilter = args[2];
            stringToFilter = args[3];
        }
    }

    private void validator(String[] args) throws ArgumentException {
        if (!args[0].equals(KEY_INPUT_FILE)) {
            throw new ArgumentException("not supported key:" + args[0]);
        }
        if (args.length > 2 && args[2].equals(KEY_MACK_REGULAR) && args[2].equals(KEY_MACK)){
            throw new ArgumentException("not supported key:" + args[2]);
        }
    }

    
    private String fileExists(String fileName) throws ArgumentException {  //Вот проверка
        String path = System.getProperty("test_files.xml");
        File f = new File(path + File.separator + fileName);
        if(f.exists() && f.isFile()){
            return f.getAbsolutePath();
        }else{
            throw new ArgumentException("input file doesn't exists");
        }
    }


    public static String getStringToFilter() {
        return stringToFilter;
    }

    public static String getTypeOfFilter() {
        return typeOfFilter;
    }

    public String getInputFileName() {
        return inputFileName;
    }
}





