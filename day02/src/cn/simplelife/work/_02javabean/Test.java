package cn.simplelife.work._02javabean;

/**
 * @ClassName Test
 * @Description
 * @Author simplelife
 * @Date 2022/9/9 16:16
 * @Version 1.0
 */

public class Test {
    public static void main(String[] args) {
        Student student=new Student();
        student.setId("5415");
        student.setName("张三");
        student.setAge(18);
        student.setAddress("diqiu");
        System.out.println(student);
    }
}
