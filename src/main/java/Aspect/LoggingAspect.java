package Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.example.demo.ResourceController.createResource(..))")
    public void logBeforeMethod() {
        System.out.println("Aspect: Before executing createResource method");
    }
}
