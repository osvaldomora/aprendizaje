package osvaldo.morales.company.demo.aopexample;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* osvaldo.morales.company.demo.aopexample.*.*(..))")
    public void logBefore() {
        System.out.println("Method started");
    }
}
