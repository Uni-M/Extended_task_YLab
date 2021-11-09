package main;

import exception.ArgumentException;
import parser.SaxParser;

public class Main {
    public static void main(String[] args) {
        try {
            SaxParser parser = new SaxParser();
            parser.parse(args);
        }catch (ArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
