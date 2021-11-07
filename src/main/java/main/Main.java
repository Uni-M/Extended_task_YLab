package main;

import exception.ArgumentException;
import parser.SaxParser;

public class Main {
    public static void main(String[] args) throws ArgumentException {
        SaxParser parser = new SaxParser();
        parser.parse(args);
    }
}
