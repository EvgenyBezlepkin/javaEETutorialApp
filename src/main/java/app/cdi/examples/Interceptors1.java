package app.cdi.examples;

import javax.inject.Inject;
import javax.inject.Named;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import java.util.Arrays;
import java.util.logging.Logger;


/**
 * Пример перехватчика, описанного в том же классе
 */

@Named(value = "ex1")
public class Interceptors1 {

    @Inject
    Logger logger;

    public void hello() {
        System.out.println("Hello");
    }

    // описывается перехватчик для всех методов данного класса
    @AroundInvoke
    public Object logMethod(InvocationContext ic) throws Exception{
        logger.info("in method");
        System.out.println("intercept '" + ic.getMethod().getName() + "' method");
        System.out.println("arguments: " + Arrays.toString(ic.getMethod().getParameterTypes()));
        return ic.proceed();
    }

}
