package cn.simplelife.work._01oop;

/**
 * @ClassName TestOOP
 * @Description
 * @Author simplelife
 * @Date 2022/9/10 10:12
 * @Version 1.0
 */

public class TestOOP {
    public static void main(String[] args) {
        // 需求：启动一个线程，输出一句话
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("开一个子线程来处理耗时操作");
            }
        }).start();

        // 函数式编程实现
        new Thread(() -> System.out.println("开一个子线程来处理耗时操作")).start();
    }
}
