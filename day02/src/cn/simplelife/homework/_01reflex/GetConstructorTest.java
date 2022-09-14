package cn.simplelife.homework._01reflex;

import java.lang.reflect.Constructor;

/**
 * @ClassName GetConstructorTest
 * @Description
 * @Author simplelife
 * @Date 2022/9/14 10:27
 * @Version 1.0
 */

public class GetConstructorTest {
    public static void main(String[] args) {
        // 1、获取字节码对象
        try {
            Class<?> aClass = Class.forName("cn.simplelife.homework._01reflex.Person");
            // 2、获取构造器getConstructors()获取所有的构造器
            Constructor<?>[] constructors = aClass.getConstructors();
            for (Constructor<?> constructor : constructors) {
                System.out.println(constructor);
            }
            System.out.println("------------------------------------");
            // 3、获取指定类型的构造器(此处获取的是无参构造器)
            Constructor<?> constructor = aClass.getConstructor();
            System.out.println(constructor);
            Constructor<?> constructor1 = aClass.getConstructor( Integer.class,String.class);
            System.out.println(constructor1);
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
