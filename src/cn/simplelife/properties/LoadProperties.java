package cn.simplelife.properties;

import java.io.InputStream;
import java.util.Properties;

/**
 * @ClassName LoadProperties
 * @Description
 * @Author simplelife
 * @Date 2022/8/30 16:06
 * @Version 1.0
 */

public class LoadProperties {
    public static void main(String[] args) throws Exception {
        // 0、获取类加载器对象
        // ClassLoader classLoader = LoadProperties.class.getClassLoader();
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        InputStream resourceAsStream = contextClassLoader.getResourceAsStream("user.properties");
        // 1、创建properties对象
        Properties properties = new Properties();
        //FileInputStream fileInputStream = new FileInputStream("F:\\JavaWeb\\day01\\resources\\user.properties");
        // 2、使用load方法加载配置文件
        if (resourceAsStream != null) {
            properties.load(resourceAsStream);
        }
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        System.out.println("username = " + username);
        System.out.println("password = " + password);
    }
}
