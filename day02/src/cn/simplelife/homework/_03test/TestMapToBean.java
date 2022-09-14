package cn.simplelife.homework._03test;

import cn.simplelife.work._01reflex.Person;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName TestMapToBean
 * @Description
 * @Author simplelife
 * @Date 2022/9/14 15:14
 * @Version 1.0
 */

public class TestMapToBean {
    public static void main(String[] args) {
        // 1、创建一个map集合来接收转换的数据
        Map<String, Object> map = new HashMap<>();
        map.put("name", "lisi");
        map.put("age", 18);
        map.put("address", "huoxing");
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
                Object value = map.get(key);
                descriptor.getWriteMethod().invoke(o, value);
            }
            System.out.println(o);
        } catch (ClassNotFoundException | IntrospectionException | NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
