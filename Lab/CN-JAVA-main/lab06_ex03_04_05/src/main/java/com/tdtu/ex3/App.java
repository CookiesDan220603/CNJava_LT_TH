package com.tdtu.ex3;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
	public static void main(String[] args) {
		try (// read spring java configuration class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class)) {
			TextEditor textEditor = context.getBean("textEditor", TextEditor.class);
			textEditor.input("testing exercise 3 of lab 6 of Java Technology");
			textEditor.save();
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}