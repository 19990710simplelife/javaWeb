package cn.simplelife.homework._02introspection;


import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;

/**
 * @ClassName TestIntrospection
 * @Description
 * @Author simplelife
 * @Date 2022/9/14 11:44
 * @Version 1.0
 */

public class TestIntrospection {
    public static void main(String[] args) {
        try {
            // 1、获取字节码对象
            Class<?> aClass = Class.forName("cn.simplelife.homework._01reflex.Person");
            // 2、将JavaBean转为beanInfo
            BeanInfo beanInfo = Introspector.getBeanInfo(aClass);
            // 3、通过beanInfo获取所有的属性
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            // 4、得到每个属性
            for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
                System.out.println("propertyDescriptor.getName() = " + propertyDescriptor.getName());
                System.out.println("propertyDescriptor.getPropertyType() = " + propertyDescriptor.getPropertyType());
                System.out.println("propertyDescriptor.getReadMethod() = " + propertyDescriptor.getReadMethod());
                System.out.println("propertyDescriptor.getWriteMethod() = " + propertyDescriptor.getWriteMethod());
            }
        } catch (ClassNotFoundException | IntrospectionException e) {
            e.printStackTrace();
        }
    }
}
