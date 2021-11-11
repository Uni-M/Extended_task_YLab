package main;

import appconfig.argument_parser.ArgumentParser;
import exception.ArgumentException;
import parser.SaxParser;


public class Main {
    public static void main(String[] args) {
        try {
            ArgumentParser argumentParser = new ArgumentParser();
            argumentParser.argumentProcess(args);

            SaxParser parser = new SaxParser();
            parser.parse(args);
        }catch (ArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
