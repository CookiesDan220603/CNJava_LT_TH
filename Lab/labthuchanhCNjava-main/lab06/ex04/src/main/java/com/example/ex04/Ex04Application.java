package com.example.ex04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@ComponentScan
@Configuration
public class Ex04Application {
	public static void main(String[] args) throws IOException {
		ApplicationContext context = new AnnotationConfigApplicationContext(Ex04Application.class);
		TextEditor textEditor = context.getBean(TextEditor.class);
		textEditor.input("Hello ban ne");
		textEditor.save("hello.txt");
	}

}
