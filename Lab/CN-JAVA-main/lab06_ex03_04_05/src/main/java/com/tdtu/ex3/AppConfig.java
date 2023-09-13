package com.tdtu.ex3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public PlainTextWriter plainTextWriter() {
        return new PlainTextWriter();
    }

    @Bean
    public PDFTextWriter pdfTextWriter() {
        return new PDFTextWriter();
    }

    @Bean
    public TextEditor textEditor() {
        return new TextEditor(plainTextWriter());
    }

}
