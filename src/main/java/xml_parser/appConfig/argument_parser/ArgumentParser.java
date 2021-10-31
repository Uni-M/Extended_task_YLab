package xml_parser.appConfig.argument_parser;

import xml_parser.appConfig.exeptions.*;

import java.io.File;

import static xml_parser.appConfig.XConstant.*;

public class ArgumentParser {

    private String inputFileName;
    private String typeOfFilter = "";
    private String stringToFilter = "";


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
        String path = System.getProperty("user.dir");
        File f = new File(path + File.separator + fileName);
        if(f.exists() && f.isFile()){
            return f.getAbsolutePath();
        }else{
            throw new ArgumentException("input file doesn't exists");
        }
    }


    public String getStringToFilter() {
        return stringToFilter;
    }

    public String getTypeOfFilter() {
        return typeOfFilter;
    }

    public String getInputFileName() {
        return inputFileName;
    }
}





