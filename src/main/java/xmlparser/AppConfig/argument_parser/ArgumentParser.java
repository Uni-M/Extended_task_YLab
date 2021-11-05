package xmlparser.AppConfig.argument_parser;

import xmlparser.AppConfig.exeptions.*;
import static xmlparser.AppConfig.XConstant.*;

import java.io.File;
import java.util.Arrays;

public class ArgumentParser {

    private String inputFileName;
    private static String typeOfFilter = "";
    private static String stringToFilter = "";


    public void ArgumentProcess(String[] args) throws ArgumentException { //Это старт парсинга
        validator(args);
        storeParams(args);
    }

    private void storeParams(String[] args) throws ArgumentException{

        for (int i = 0; i < args.length; i++){
            switch (args[i]) {
                case KEY_INPUT_FILE -> inputFileName = fileExists(args[i + 1]); // — это получение имени файла + проверка//

                case KEY_MACK, KEY_MACK_REGULAR -> {
                    typeOfFilter += args[i];
                    stringToFilter += args[i + 1];
                }
            }
        }
    }

    private void validator(String[] args) throws ArgumentException {

        if (!Arrays.asList(args).contains(KEY_INPUT_FILE)) {
            throw new ArgumentException("absent key input file");
        }

        if (!args[0].equals(KEY_INPUT_FILE) && !args[0].equals(KEY_MACK_REGULAR) && !args[0].equals(KEY_MACK)){
            throw new ArgumentException("not supported key: " + args[0]);
        }

        if (args.length > 2 && !args[2].equals(KEY_INPUT_FILE) && !args[2].equals(KEY_MACK_REGULAR) && !args[2].equals(KEY_MACK)){
            throw new ArgumentException("not supported key: " + args[2]);
        }
    }

    
    private String fileExists(String fileName) throws ArgumentException {  //Вот проверка
        String path = System.getProperty("user.dir");
        File f = new File(path + File.separator + fileName);

        //version for full name of input file
//        File f;
//        if (!fileName.contains(path)) {
//            f = new File(path + File.separator + fileName);
//        }else{
//            f = new File(fileName);
//        }

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





