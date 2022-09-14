package cn.simplelife.homework._01reflex;

/**
 * @ClassName GetClassTest
 * @Description
 * @Author simplelife
 * @Date 2022/9/14 10:15
 * @Version 1.0
 */

public class GetClassTest {
    public static void main(String[] args) {
        // 获取字节码对象的三种方式
        // 1、Class.forName()——最常用
        try {
            Class<?> aClass = Class.forName("cn.simplelife.homework._01reflex.Person");
            System.out.println("aClass = " + aClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // 2、对象名.getClass()或类名.class
        Class<? extends Person> aClass = Person.class;
        System.out.println("aClass = " + aClass);

        // 3、基本类型的class字段获取基本类型的字节码对象
        Class<Integer> integerClass = int.class;
        Class<Byte> byteClass = byte.class;
        Class<Short> shortClass = short.class;
        Class<Long> longClass = long.class;
        Class<Boolean> booleanClass = boolean.class;
        Class<Double> doubleClass = double.class;
        Class<Float> floatClass = float.class;
        System.out.println("floatClass = " + floatClass);
        System.out.println("doubleClass = " + doubleClass);
        System.out.println("booleanClass = " + booleanClass);
        System.out.println("longClass = " + longClass);
        System.out.println("shortClass = " + shortClass);
        System.out.println("byteClass = " + byteClass);
        System.out.println("integerClass = " + integerClass);
    }
}
