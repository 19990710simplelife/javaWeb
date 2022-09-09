package cn.simplelife.work._01reflex;

import java.lang.reflect.Method;

/**
 * @ClassName TestGetMethods
 * @Description
 * @Author simplelife
 * @Date 2022/9/9 14:50
 * @Version 1.0
 */

public class TestGetMethods {
    public static void main(String[] args) {
        // 需求：使用反射获取对象的方法
        // 步骤：
        /**
         * 1、获取字节码对象
         * 2、调用方法获取对象的方法
         */
        Class<Person> personClass = Person.class;

        // 1、获取所有的public方法，包含继承的方法
        Method[] methods = personClass.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        System.out.println("=======================================");
        // 2、获取所有的方法，不包含继承的、（私有的、非私有的）
        Method[] declaredMethods = personClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }

        System.out.println("=======================================");
        // 3、获取指定public类型的方法
        try {
            Method method = personClass.getMethod("getName");
            System.out.println("method = " + method);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        System.out.println("=======================================");
        // 4、获取所有的类型的指定方法
        try {
            Method person = personClass.getDeclaredMethod("doWork", String.class);
            System.out.println("person = " + person);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
