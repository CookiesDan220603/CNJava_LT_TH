package com.tdtu.ex01;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		// load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("appConfig.xml");

		// retrieve bean from spring container
		Product propertyProduct = context.getBean("myPropertyProduct", Product.class);
		Product alphaPropertyProduct = context.getBean("myPropertyProduct", Product.class);

		Product constructorArgProduct = context.getBean("myConstructorArgProduct", Product.class);
		Product alphaConstructorArgProduct = context.getBean("myConstructorArgProduct", Product.class);

		Product singletonProduct = context.getBean("mySingletonProduct", Product.class);
		Product alphaSingletonProduct = context.getBean("mySingletonProduct", Product.class);

		Product singletonProduct1 = context.getBean("mySingletonProduct1", Product.class);
		Product alphaSingletonProduct1 = context.getBean("mySingletonProduct1", Product.class);

		// call methods on the bean
		System.out.println(propertyProduct.getId());
		System.out.println(propertyProduct.getName());
		System.out.println(propertyProduct.getDescription());
		System.out.println();

		System.out.println(constructorArgProduct.getId());
		System.out.println(constructorArgProduct.getName());
		System.out.println(constructorArgProduct.getDescription());
		System.out.println();

		System.out.println(singletonProduct.getId());
		System.out.println(singletonProduct.getName());
		System.out.println(singletonProduct.getDescription());
		System.out.println();

		System.out.println(singletonProduct1.getId());
		System.out.println(singletonProduct1.getName());
		System.out.println(singletonProduct1.getDescription());
		System.out.println();

		boolean result1 = propertyProduct == alphaPropertyProduct;
		boolean result2 = constructorArgProduct == alphaConstructorArgProduct;
		boolean result3 = singletonProduct == alphaSingletonProduct;
		boolean result4 = singletonProduct == alphaSingletonProduct;

		System.out.println("First bean: Pointing to the same instance " + result1);
		System.out.println("Second bean: Pointing to the same instance " + result2);
		System.out.println("Third bean: Pointing to the same instance " + result3);
		System.out.println("Fouth bean: Pointing to the same instance " + result4);

		// close the context
		context.close();
	}
}
