package com.tdtu.ex3;

import java.io.FileWriter;
import java.io.IOException;

public class PlainTextWriter implements TextWriter {
	public void write(String fileName, String text) {
        try {
            FileWriter myWriter = new FileWriter(fileName);
            myWriter.write(text);
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }
}
