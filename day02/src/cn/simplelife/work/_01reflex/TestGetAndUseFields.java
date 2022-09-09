package cn.simplelife.work._01reflex;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * @ClassName TestGetAndUseFields
 * @Description
 * @Author simplelife
 * @Date 2022/9/9 15:38
 * @Version 1.0
 */

public class TestGetAndUseFields {
    public static void main(String[] args) {
        Class<Person> personClass = Person.class;
        try {

            // 获取单个字段
            Field name = personClass.getDeclaredField("name");
            name.setAccessible(true);
            System.out.println(name);
            System.out.println("===========================");

            // 获取所有字段
            Field[] fields = personClass.getDeclaredFields();
            for (Field field : fields) {
                System.out.println(field);
            }
            System.out.println("==============================");
            // 操作字段
            Person person = personClass.getConstructor(String.class, int.class).newInstance("张三", 18);
            name.set(person, "lisa");
            Object o = name.get(person);
            System.out.println(o);
        } catch (NoSuchFieldException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
