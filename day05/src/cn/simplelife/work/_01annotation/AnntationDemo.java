package cn.simplelife.work._01annotation;

import java.util.List;

/**
 * @ClassName AnntationDemo
 * @Description
 * @Author simplelife
 * @Date 2022/9/17 15:31
 * @Version 1.0
 */

public class AnntationDemo {
    @SuppressWarnings("all")
    public void doWork() {
        List<Integer> list = null;
        System.out.println(list.size());
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static void main(String[] args) {

    }
}
