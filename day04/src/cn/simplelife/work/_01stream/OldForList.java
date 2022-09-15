package cn.simplelife.work._01stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @ClassName OldForList
 * @Description
 * @Author simplelife
 * @Date 2022/9/15 15:05
 * @Version 1.0
 */

public class OldForList {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("马云");
        arrayList.add("马化腾");
        arrayList.add("雷军");
        arrayList.add("刘强东");
        for (String s : arrayList) {
            System.out.println(s);
        }
        System.out.println("----------------------------------------");
        // 改写
        arrayList.forEach(System.out::println);
        System.out.println("----------------------------------------");
        /**
         * 循环遍历的弊端 是过程的一种体现，而不是做什么、是怎么做
         */
        // 需求：
        // 1、找出包含马的人名
        List<String> newArray = new ArrayList<>();
        for (String s : arrayList) {
            if (s.startsWith("马")) {
                newArray.add(s);
            }
        }
        // 2、找出名字为三个字的人名
        for (String s : newArray) {
            if (s.length() == 3) {
                System.out.println(s);
            }
        }
        System.out.println("--------------------------------------------------------");
        // 需求改写
        // 1、选择出满足姓马的
        arrayList.stream().filter(s -> s.startsWith("马")).forEach(System.out::println);
        // 2、找出姓马的人的名字长度为3的人
        System.out.println("---------------------------------------------------------");
        arrayList.stream().filter(x -> x.startsWith("马")).filter(x -> x.length() == 3).forEach(System.out::println);
    }
}
