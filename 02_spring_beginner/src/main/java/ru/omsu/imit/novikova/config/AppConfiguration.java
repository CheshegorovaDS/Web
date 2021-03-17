package ru.omsu.imit.novikova.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.omsu.imit.novikova.lang.Language;
import ru.omsu.imit.novikova.lang.impl.Deutch;

@Configuration
@ComponentScan("ru.omsu.imit.novikova.bean")
public class AppConfiguration {

    @Bean(name = "language")
    public Language getLanguage(){
        return new Deutch();
    }
}
