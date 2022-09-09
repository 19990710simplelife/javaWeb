package cn.simplelife.work._01reflex;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @ClassName TestUseMethod
 * @Description
 * @Author simplelife
 * @Date 2022/9/9 15:09
 * @Version 1.0
 */

public class TestUseMethod {
    public static void main(String[] args) {
        // 使用反射获取方法并使用方法
        // 静态方法用类来访问
        // 非静态方法由对象来调用
        // 1、获取字节码对象
        Class<?> aClass = null;
        try {
            aClass = Class.forName("cn.simplelife.work._01reflex.Person");
            // 2、获取指定的方法
            Method doWork = aClass.getDeclaredMethod("doWork", String.class);
            // 设置私有方法可以被访问到
            doWork.setAccessible(true);
            // 获取非私有的指定方法
            Method eat = aClass.getMethod("eat");
            // 获取静态方法
            Method walk = aClass.getMethod("walk", String.class);
            // 3、获取构造器创建指定对象
            Object newInstance = aClass.getDeclaredConstructor(String.class, int.class).newInstance("张三", 18);
            // 4、调用方法
            doWork.invoke(newInstance, "张三");

            eat.invoke(newInstance);

            walk.invoke(null, "李四");

        } catch (ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }

    }
}
