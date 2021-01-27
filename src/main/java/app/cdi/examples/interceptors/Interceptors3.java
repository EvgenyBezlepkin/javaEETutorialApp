package app.cdi.examples.interceptors;

import javax.interceptor.AroundConstruct;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 * Пример перехватчика на конструкторы и методы, описанного в отдельном классе
 * Максимальный уровень косвенности (без указания имен)
 * 1 Пишем аннотацию @Loggable для связывания перехватчика с целевыми классами (добавить @InterceptorBinding)
 * (помечаем ей перехватчик и целевые классы)
 * 2 Классу-перехватчику прописываем аннотацию @Interceptor
 * 3 Прописываем класс-перехватчик в дескрипторе
 */

@Interceptor
@Loggable
public class Interceptors3 {

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
