package cn.simplelife.homework._01reflex;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @ClassName UseMethods
 * @Description
 * @Author simplelife
 * @Date 2022/9/14 11:13
 * @Version 1.0
 */

public class UseMethods {
    public static void main(String[] args) {
        // 1、获取字节码对象
        Class<Person> personClass = Person.class;
        try {
            // 2、获取构造器
            Constructor<Person> constructor = personClass.getConstructor(String.class, Integer.class, String.class);
            // 3、创建对象
            Person person = constructor.newInstance("张胜男", 15, "外星人");
            // 4、获取方法
            Method sleep = personClass.getMethod("sleep", String.class);
            // 5、调用方法
            sleep.invoke(person, person.getName());
            // 6、获取静态方法
            Method eat = personClass.getMethod("eat", String.class);
            // 7、调用静态方法 不需要对象直接传入参数null
            eat.invoke(null, "李四");
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
