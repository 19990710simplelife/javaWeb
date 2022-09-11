package cn.simplelife.work._05lambda;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName LambdaTest
 * @Description
 * @Author simplelife
 * @Date 2022/9/10 15:54
 * @Version 1.0
 */

public class LambdaTest {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("a", "b", "c");
        Map<String, String> stringHashMap = new HashMap<>();
        stringHashMap.put("手机", "小米");
        stringHashMap.put("电脑", "拯救者");
        stringHashMap.put("鼠标", "罗技");
        // 1.可选类型声明：不需要声明参数类型，编译器可以统一识别参数值。
        strings.forEach((val) -> System.out.print(val));
        System.out.println("\n------------------------------------------------");
        // 2.可选的参数圆括号()：一个参数无需定义圆括号，但多个参数需要定 义圆括号()。
        strings.forEach(val -> System.out.print(val));
        System.out.println("\n------------------------------------------------");
        stringHashMap.forEach((key, val) -> System.out.println(key + " = " + val));
        System.out.println("\n------------------------------------------------");
        // 3.可选的大括号{}：如果主体包含了一个语句，就不需要使用{}。
        System.out.println("\n------------------------------------------------");
        stringHashMap.forEach((key, val) -> System.out.println(key + " = " + val));
        System.out.println("\n------------------------------------------------");
        stringHashMap.forEach((key, val) -> {
            System.out.print("key = " + key);
            System.out.println(" val = " + val);
        });
        // 4.可选的返回关键字return：如果主体只有一个表达式返回值则可以省 略return和{}

    }
}
