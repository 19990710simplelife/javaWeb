package cn.simplelife.work._05test;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName JavaBeanToMap
 * @Description
 * @Author simplelife
 * @Date 2022/9/9 19:38
 * @Version 1.0
 */

public class JavaBeanToMap {
    public static void main(String[] args) {
        // 需求：通过内省讲JavaBean转为map
        // 1、创建一个map容器
        Map<String, Object> objectMap = new HashMap<>();
        try {
            // 2、获取JavaBean的字节码对象
            Class<Student> studentClass = Student.class;
            // 2.1 获取指定的构造器
            Constructor<Student> constructor = studentClass.getConstructor(String.class, String.class, int.class, String.class);
            Student student = constructor.newInstance("1001", "zhangsan", 15, "地球");
            // 3、内省获取JavaBean对象信息
            BeanInfo beanInfo = Introspector.getBeanInfo(studentClass, Object.class);
            // 4、获取所有的属性
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
                String key = propertyDescriptor.getName();
                Object value = propertyDescriptor.getReadMethod().invoke(student);
                objectMap.put(key, value);
            }
            System.out.println(objectMap);
        } catch (IntrospectionException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
