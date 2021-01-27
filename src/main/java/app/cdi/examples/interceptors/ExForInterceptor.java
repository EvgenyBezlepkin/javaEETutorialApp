package app.cdi.examples.interceptors;

import javax.interceptor.Interceptors;

/**
 * указываем конкретный клаcс перехватчика
 */
@Interceptors(Interceptors2.class)
public class ExForInterceptor {

    String name;
    Integer age;

    public ExForInterceptor() {
    }

    public ExForInterceptor(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String test() {
        ExForInterceptor exForInterceptor = new ExForInterceptor("test", 10);
        return exForInterceptor.toString();
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "ExForInterceptor{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
