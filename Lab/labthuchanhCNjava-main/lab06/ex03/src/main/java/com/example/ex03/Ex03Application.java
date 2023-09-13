package com.example.ex03;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class Ex03Application {
	public static void main(String[] args) throws IOException {
		ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		TextEditor textEditor = context.getBean("textEditor",TextEditor.class);
		textEditor.input("Hello ban nho");
		textEditor.save("hello.txt");
	}

}
