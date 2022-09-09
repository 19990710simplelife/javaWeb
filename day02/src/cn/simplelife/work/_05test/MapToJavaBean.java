package cn.simplelife.work._05test;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName MapToJavaBean
 * @Description
 * @Author simplelife
 * @Date 2022/9/9 19:54
 * @Version 1.0
 */

public class MapToJavaBean {
    public static void main(String[] args) throws Exception {
        // 1、创建一个map集合
        Map<String, Object> objectMap = new HashMap<>();
        objectMap.put("id", "1002");
        objectMap.put("name", "1002");
        objectMap.put("age", 15);
        objectMap.put("address", "1002");
        // 2、获取JavaBean的字节码对象
        Class<Student> studentClass = Student.class;
        Student student = studentClass.getConstructor().newInstance();
        // 3、获取javabean对象
        BeanInfo beanInfo = Introspector.getBeanInfo(studentClass, Object.class);
        // 4、获取JavaBean的属性
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        // 5、遍历JavaBean的属性数组
        for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
            // 获取属性的名称作为key
            String key = propertyDescriptor.getName();
            // 根据key获取map的值
            Object value = objectMap.get(key);
            // 将获取到的值赋值给JavaBean对象student
            propertyDescriptor.getWriteMethod().invoke(student, value);
        }
        System.out.println(student);
    }
}
