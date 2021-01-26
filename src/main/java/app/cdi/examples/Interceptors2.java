package app.cdi.examples;

import javax.inject.Inject;
import javax.interceptor.AroundConstruct;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import java.util.logging.Logger;

public class Interceptors2 {

    @Inject
    Logger logger;

    @AroundConstruct
    public void init(InvocationContext ic) throws Exception {
        System.out.println("intercept constructor of '" + ic.getConstructor().getDeclaringClass().getName() + "' class");
        ic.proceed();
    }

    @AroundInvoke
    public Object method(InvocationContext ic) throws Exception {
        System.out.println("intercept '" + ic.getMethod().getName() + "' method of '" + ic.getMethod().getDeclaringClass().getName() + "' class");
        return ic.proceed();
    }


}
