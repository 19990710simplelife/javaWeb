package cn.simplelife.homework._01loop;

/**
 * @ClassName TestOOP
 * @Description
 * @Author simplelife
 * @Date 2022/9/14 15:53
 * @Version 1.0
 */

public class TestOOP {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("开启一个线程处理点事情");
            }
        }).start();

        new Thread(() -> System.out.println("处理点事情")).start();
    }
}
