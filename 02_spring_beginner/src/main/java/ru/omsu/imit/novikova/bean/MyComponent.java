package ru.omsu.imit.novikova.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyComponent {
    @Autowired
    private MyRepository repository;

    public void showAppInfo() {
        System.out.println("Date is "+ repository.getSystemDateTime());
        System.out.println("App Name "+ repository.getAppName());
    }
}
