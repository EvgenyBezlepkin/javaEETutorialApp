package app.cdi.examples.interceptors;


/**
 * указываем связывающую аннотацию
 */
@Loggable
public class ExForInterceptor2 {

    String name;
    Integer age;

    public ExForInterceptor2() {
    }

    public ExForInterceptor2(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String test() {
        ExForInterceptor2 exForInterceptor = new ExForInterceptor2("test", 10);
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
