package com.example.ex04;

import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
@Component
public class PdfTextWriter implements TextWriter{
    @Override
    public void write(String fileName, String text) throws IOException {
        PrintWriter printWriter = new PrintWriter(new FileWriter(fileName));
        printWriter.println("write pdf formatting:");
        printWriter.print(text);
        printWriter.close();
    }
}
