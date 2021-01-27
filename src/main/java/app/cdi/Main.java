package app.cdi;

import app.cdi.examples.eventApi.EventProducer;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;


public class Main {

    public static void main(String[] args) {

        Weld weld = new Weld();
        WeldContainer container = weld.initialize();

//        Interceptors1 i1 = container.instance().select(Interceptors1.class).get();
//        i1.hello();
//
//        ExForInterceptor exForInterceptor = container.instance().select(ExForInterceptor.class).get();
//        exForInterceptor.test();

//        ExForInterceptor2 exForInterceptor2 = container.instance().select(ExForInterceptor2.class).get();
//        exForInterceptor2.test();

        EventProducer eventProducer = container.instance().select(EventProducer.class).get();
        eventProducer.createBook();
        eventProducer.createBook2();

        weld.shutdown();
    }
}
