package ru.omsu.imit.novikova;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.omsu.imit.novikova.config.AppConfiguration;
import ru.omsu.imit.novikova.lang.Language;

public class MainProgram {

   public static void main(String[] args) {
       ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfiguration.class);

       Language language = (Language) appContext.getBean("language");

       System.out.println(language);
       System.out.println(language.sayHello());
   }

}
