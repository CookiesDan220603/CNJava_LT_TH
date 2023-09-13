package com.example.ex03;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class ApplicationConfig {
    @Bean
    public PlainTextWriter plainTextWriter(){
        return new PlainTextWriter();
    }
    @Bean
    public TextEditor textEditor(){
        return new TextEditor();
    }
    @Bean
    public PdfTextWriter pdfTextWriter(){
        return new PdfTextWriter();
    }
}
