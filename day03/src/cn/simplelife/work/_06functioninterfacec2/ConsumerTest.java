package cn.simplelife.work._06functioninterfacec2;

import java.util.function.Consumer;

/**
 * @ClassName ConsumerTest
 * @Description
 * @Author simplelife
 * @Date 2022/9/10 16:24
 * @Version 1.0
 */

public class ConsumerTest {
    public static void main(String[] args) {
        // 需求1:编写shop方法输出消费多少元
        shop(1000, integer -> {
            integer -= 100;
            System.out.println("本次消费后剩余:" + integer);
        });
    }

    /**
     * @param money
     * @param consumer
     */
    public static void shop(Integer money, Consumer<Integer> consumer) {
        consumer.accept(money);
    }
}
