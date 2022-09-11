package cn.simplelife.work._07methods;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @ClassName ObjectMethodTest
 * @Description
 * @Author simplelife
 * @Date 2022/9/11 10:30
 * @Version 1.0
 */

public class ObjectMethodTest {
    public static void main(String[] args) {
        //1.对象的引用 :: 实例方法名
        Arrays.asList("a", "b", "c").forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
        System.out.println("--------------------------------------");
        // 2、改造为lambda
        Arrays.asList("a", "b", "c").forEach(s -> System.out.println(s));
        System.out.println("--------------------------------------");
        // 3、改造为方法引用
        Arrays.asList("a", "b", "c").forEach(System.out::println);
    }
}
