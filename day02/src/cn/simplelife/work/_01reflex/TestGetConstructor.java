package cn.simplelife.work._01reflex;

import java.lang.reflect.Constructor;

/**
 * @ClassName TestGetConstructor
 * @Description
 * @Author simplelife
 * @Date 2022/9/9 11:25
 * @Version 1.0
 */

public class TestGetConstructor {
    public static void main(String[] args) {
        // 需求：利用反射获取所有的构造器
        try {
            // 1、获取字节码对象
            Class<?> aClass = Class.forName("cn.simplelife.work._01reflex.Person");
            // 2、调用getConstructors()方法获取所有的public构造器,返回一个构造器数组
            Constructor<?>[] constructors = aClass.getConstructors();
            for (Constructor<?> constructor : constructors) {
                System.out.println(constructor);
            }
            System.out.println("-------------------------------------------------");
            // 3、获取所有的构造器 调用getDeclaredConstructors()方法，返回一个构造器数组
            Constructor<?>[] declaredConstructors = aClass.getDeclaredConstructors();
            for (Constructor<?> declaredConstructor : declaredConstructors) {
                System.out.println(declaredConstructor);
            }
            // 4、获取所有类型的指定的构造器,参数携带name
            System.out.println("-------------------------------------------------");
            Constructor<?> constructor = aClass.getDeclaredConstructor(String.class);
            System.out.println(constructor);
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
