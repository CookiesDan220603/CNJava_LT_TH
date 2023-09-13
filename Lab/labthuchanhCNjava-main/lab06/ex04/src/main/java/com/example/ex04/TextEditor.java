package com.example.ex04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.IOException;
@Component

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
