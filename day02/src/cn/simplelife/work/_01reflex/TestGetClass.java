package cn.simplelife.work._01reflex;

/**
 * @ClassName TestGetClass
 * @Description
 * @Author simplelife
 * @Date 2022/9/9 10:59
 * @Version 1.0
 */

class TestGetClass {
    public static void main(String[] args) {
        try {
            //1、 通过Class类中的forname()方法来获取字节码对象
            Class<?> aClass = Class.forName("cn.simplelife.work._01reflex.Person");
            System.out.println("aClass = " + aClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //2、通过对象的getclass()方法来获取字节码对象
        Person person = new Person();
        Class<? extends Person> aClass = person.getClass();
        System.out.println("aClass = " + aClass);

    }
}
