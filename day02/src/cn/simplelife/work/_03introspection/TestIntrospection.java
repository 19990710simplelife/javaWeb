package cn.simplelife.work._03introspection;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @ClassName TestIntrospection
 * @Description
 * @Author simplelife
 * @Date 2022/9/9 19:06
 * @Version 1.0
 */

public class TestIntrospection {
    public static void main(String[] args) {
        // 内省
        try {
            Class<Person> personClass = Person.class;
            Person person = personClass.newInstance();
            // 加载某个JavaBean字节码对象，转化为JavaBean的信息描述对象
            BeanInfo beanInfo = Introspector.getBeanInfo(personClass);
            // 获取所有的属性描述器
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();

            // 遍历数组
            for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
                // 获取属性的名称
                System.out.println(propertyDescriptor.getName());
                // 获取属性名和属性类型
                System.out.println(propertyDescriptor.getPropertyType());
                // 获取属性方法
                Method readMethod = propertyDescriptor.getReadMethod();
                Method writeMethod = propertyDescriptor.getWriteMethod();
                // 判断获取的属性名称是不是name
                if ("name".equals(propertyDescriptor.getName())) {
                    writeMethod.invoke(person, "张三");
                }
                System.out.println(readMethod.invoke(person));
            }
        } catch (IntrospectionException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
