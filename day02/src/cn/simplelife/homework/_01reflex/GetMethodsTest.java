package cn.simplelife.homework._01reflex;

import java.lang.reflect.Method;

/**
 * @ClassName GetMethodsTest
 * @Description
 * @Author simplelife
 * @Date 2022/9/14 11:02
 * @Version 1.0
 */

public class GetMethodsTest {
    public static void main(String[] args) {
        // 0、利用反射获取方法
        // 1、获取字节码对象
        Class<Person> personClass = Person.class;
        // 2、利用字节码对象获取方法（包含继承的方法）
        Method[] methods = personClass.getMethods();
        // 3、遍历输出方法数组
        for (Method method : methods) {
            System.out.println(method);
        }
        System.out.println("----------------------------------------------------------");
        // 4、获取不包含继承的所有方法，包含非public的
        Method[] declaredMethods = personClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }

        System.out.println("----------------------------------------------------------");
        // 5、获取指定的方法getDeclaredMethod(方法名,参数类型的字节码对象)
        try {
            Method sleep = personClass.getDeclaredMethod("sleep", String.class);
            System.out.println(sleep);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
