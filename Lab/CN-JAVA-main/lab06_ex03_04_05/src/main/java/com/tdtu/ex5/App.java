package com.tdtu.ex5;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Product p = context.getBean("product", Product.class);
        System.out.println(p.getId());
        System.out.println(p.getName());
        System.out.println(p.getDescription());
    }
}
