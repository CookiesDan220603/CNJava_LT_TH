package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(ProductBean.class);
        Product product1 =  context.getBean("product1", Product.class);
        Product product2 =  context.getBean("product2",Product.class);
        Product product3 =  context.getBean("product3",Product.class);

        System.out.println("Product 1: " + product1);
        System.out.println("Product 2: " + product2);
        System.out.println("Product 3: " + product3);

        System.out.println("Product 1 is prototype bean: " + context.isPrototype("product1"));
        System.out.println("Product 2 is prototype bean: " + context.isPrototype("product2"));
        System.out.println("Product 3 is singleton bean: " + context.isSingleton("product3"));
    }
}
