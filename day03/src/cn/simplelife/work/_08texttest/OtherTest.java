package cn.simplelife.work._08texttest;

import java.util.function.Supplier;

/**
 * @ClassName OtherTest
 * @Description
 * @Author simplelife
 * @Date 2022/9/13 9:46
 * @Version 1.0
 */

public class OtherTest {
    public static void main(String[] args) {
        testOld();
        testNew();
    }

    private static void testOld() {
        String name = "张无忌";
        String action = "夜店消费";
        String money = "20000元";
        long start = System.currentTimeMillis();
        logMethod("info", name + action + money);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    private static void logMethod(String info, String s) {
        if ("info".equals(info)) {
            System.out.println(s);
        }
    }

    public static void testNew() {
        String name = "张无忌";
        String action = "夜店消费";
        String money = "20000元";
        long start = System.currentTimeMillis();
        logLambdaMethod("info", () -> name + action + money);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    private static void logLambdaMethod(String level, Supplier<String> supplier) {
        if ("info".equals(level)) {
            System.out.println(supplier.get());
        }
    }
}
