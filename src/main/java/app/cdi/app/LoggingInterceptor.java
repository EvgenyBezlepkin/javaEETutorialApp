package app.cdi.app;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.util.logging.Logger;

@Interceptor
@LoggableForApp
public class LoggingInterceptor {

    @Inject
    Logger logger;

    @AroundInvoke
    public Object logMethod(InvocationContext ic) {
        logger.entering(ic.getTarget().getClass().getName(), ic.getMethod().getName());
        try {
            logger.info("method '" + ic.getMethod().getDeclaringClass().getName() + "'was invoked");
            Object proceed = ic.proceed();
            logger.info("method result :" + proceed);
            return proceed;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            logger.exiting(ic.getTarget().getClass().getName(), ic.getMethod().getName());
        }
        return null;
    }

}
