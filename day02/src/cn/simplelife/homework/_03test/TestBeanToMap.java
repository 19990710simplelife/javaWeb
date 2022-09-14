package cn.simplelife.homework._03test;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName TestBeanToMap
 * @Description
 * @Author simplelife
 * @Date 2022/9/14 15:24
 * @Version 1.0
 */

public class TestBeanToMap {
    public static void main(String[] args) {
        // 1、创建一个map集合来接收转换的数据
        Map<String, Object> map = new HashMap<>();
        try {
            // 2、获取字节码对象
            Class<?> aClass = Class.forName("cn.simplelife.homework._01reflex.Person");
            // 3、利用反射创建对象
            Object o = aClass.getConstructor(String.class, Integer.class, String.class).newInstance("张三", 18, "diqiu");
            // 4、JavaBean转为BeanInfo对象
            BeanInfo beanInfo = Introspector.getBeanInfo(o.getClass(), Object.class);
            // 5、获取所有的属性名称作为map的key
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            // 6、遍历转换
            for (PropertyDescriptor descriptor : propertyDescriptors) {
                String key = descriptor.getName();
                Object value = descriptor.getReadMethod().invoke(o);
                map.put(key, value);
            }
            System.out.println(map);
        } catch (ClassNotFoundException | IntrospectionException | NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

