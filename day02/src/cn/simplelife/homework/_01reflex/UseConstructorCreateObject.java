package cn.simplelife.homework._01reflex;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @ClassName UseConstructorCreateObject
 * @Description
 * @Author simplelife
 * @Date 2022/9/14 10:57
 * @Version 1.0
 */

public class UseConstructorCreateObject {
    public static void main(String[] args) {
        try {
            // 1、获取字节码对象
            Class<?> aClass = Class.forName("cn.simplelife.homework._01reflex.Person");
            // 2、利用字节码对象获取构造器
            Constructor<?> constructor = aClass.getConstructor(String.class, Integer.class, String.class);
            // 3、调用方法创建对象
            Object o = constructor.newInstance("张三", 18, "地球");
            System.out.println(o);
        } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
