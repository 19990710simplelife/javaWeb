package cn.homework.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @ClassName LoadProperties
 * @Description
 * @Author simplelife
 * @Date 2022/8/30 19:43
 * @Version 1.0
 */

public class LoadProperties {
    public static void main(String[] args) throws IOException {
        InputStream resourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("user.properties");
        // 1、创建properties对象
        Properties properties = new Properties();
        // 2、调用load方法获取流
        if (resourceAsStream != null) {
            properties.load(resourceAsStream);
        }
        // 3、获取内容
        System.out.println(properties.getProperty("username"));
        System.out.println(properties.getProperty("password"));
    }
}
