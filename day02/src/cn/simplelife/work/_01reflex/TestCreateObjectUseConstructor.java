package cn.simplelife.work._01reflex;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @ClassName TestCreateObjectUseConstructor
 * @Description
 * @Author simplelife
 * @Date 2022/9/9 11:53
 * @Version 1.0
 */

public class TestCreateObjectUseConstructor {
    public static void main(String[] args) {
        // 需求：利用构造器创建对象
        // 步骤：
        // 1、获取字节码对象
        // 2、获取指定的构造器
        // 3、调用newInstance(实参列表)方法创建对象
        Class<Person> personClass = Person.class;
        try {
            // 获取指定的公共构造器
            Constructor<Person> constructor = personClass.getConstructor(String.class, int.class);
            Person person = constructor.newInstance("张三", 19);
            System.out.println("person = " + person);

            // 获取指定的私有构造器
            Constructor<Person> declaredConstructor = personClass.getDeclaredConstructor(String.class);

            // 设置可以访问私有的构造器
            declaredConstructor.setAccessible(true);
            Person person1 = declaredConstructor.newInstance("张三");
            System.out.println("person1 = " + person1);

            // 快捷方式创建对象 利用字节码对象的newInstance()方法创建对象，条件，被创建的类中必须含有一个公共的无参构造器
            Person person2 = personClass.newInstance();
            System.out.println("person2 = " + person2);
        } catch (NoSuchMethodException | InstantiationException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
