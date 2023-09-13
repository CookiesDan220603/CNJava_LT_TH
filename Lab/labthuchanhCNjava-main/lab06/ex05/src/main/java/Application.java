import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConfigApplication.class);
        System.out.println(applicationContext.getBean("product1"));
        System.out.println(applicationContext.getBean("product2"));
        System.out.println(applicationContext.getBean("product3"));
    }
}
