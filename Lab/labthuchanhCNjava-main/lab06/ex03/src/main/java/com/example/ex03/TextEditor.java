package com.example.ex03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.io.IOException;

public class TextEditor {
    public String text;
    @Autowired
    @Qualifier("pdfTextWriter")
    public TextWriter textWriter;
    public void save(String fileName) throws IOException {
        textWriter.write(fileName,text);
    }
    public void input(String text){
    this.text = text;
    }
}
