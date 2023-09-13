package com.example.ex03;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PdfTextWriter implements TextWriter{
    @Override
    public void write(String fileName, String text) throws IOException {
        PrintWriter printWriter = new PrintWriter(new FileWriter(fileName));
        printWriter.println("write pdf formatting:");
        printWriter.print(text);
        printWriter.close();
    }
}
