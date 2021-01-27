package app.cdi.examples.interceptors;

import javax.inject.Inject;
import javax.interceptor.AroundConstruct;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import java.util.logging.Logger;

/**
 * Пример перехватчика на конструкторы и методы, описанного в отдельном классе
 * Перехватчик указывается в аннотации @Interceptors(Interceptors2.class)
 */

public class Interceptors2 {

    @AroundConstruct
    public void init(InvocationContext ic) {
        System.out.println("intercept constructor of '" + ic.getConstructor().getDeclaringClass().getName() + "' class");
        try {
            ic.proceed();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AroundInvoke
    public Object method(InvocationContext ic) {
        System.out.println("intercept '" + ic.getMethod().getName() + "' method of '" + ic.getMethod().getDeclaringClass().getName() + "' class");
        try {
            return ic.proceed();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
