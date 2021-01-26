package app.cdi;

import app.cdi.examples.ExForInterceptor;
import app.cdi.examples.Interceptors1;
import app.cdi.examples.Interceptors2;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;


public class Main {

    public static void main(String[] args) {

        Weld weld = new Weld();
        WeldContainer container = weld.initialize();
        Interceptors1 i1 = container.instance().select(Interceptors1.class).get();
        i1.hello();

        ExForInterceptor exForInterceptor = container.instance().select(ExForInterceptor.class).get();
        exForInterceptor.test();


        weld.shutdown();
    }
}
