package app.cdi.app;

import javax.inject.Inject;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.util.logging.Logger;

@Interceptor
@Loggable
public class LoggingInterceptor {

    @Inject
    Logger logger;

    public Object logMethod(InvocationContext ic) {
        logger.entering(ic.getTarget().getClass().getName(), ic.getMethod().getName());
        try {
            return ic.proceed();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            logger.exiting(ic.getTarget().getClass().getName(), ic.getMethod().getName());
        }
        return null;
    }

}
