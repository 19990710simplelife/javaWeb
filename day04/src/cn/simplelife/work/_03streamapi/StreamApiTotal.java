package cn.simplelife.work._03streamapi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * @ClassName StreamApiTotal
 * @Description
 * @Author simplelife
 * @Date 2022/9/16 16:26
 * @Version 1.0
 */

public class StreamApiTotal {
    public static void main(String[] args) {
        // count():返回流中元素的总个数
        // max(Comparator<T>):返回流中最大值
        // min(Comparator<T>):返回流中最小值

        List<Integer> list = Arrays.asList(1, 3, 54, 6, 7, 89, 32, 2);
        // 需求1: 获取给定一个集合数据的总数
        long count = list.stream().count();
        System.out.println("集合数据的总数 = " + count);

        // 需求2: 获取给定一个集合中的最大值
        Integer integer1 = list.stream().max(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        }).get();
        System.out.println("集合中的最大值 = " + integer1);

        // 需求3: 获取给定一个集合中的最小值
        Integer integer = list.stream().min(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        }).get();
        System.out.println("集合中的最小值 = " + integer);

        System.out.println("==========新写法==========");
       // 需求2: 获取给定一个集合中的最大值
        System.out.println(list.stream().max((Integer::compareTo)).get());
        // 需求3: 获取给定一个集合中的最小值
        System.out.println(list.stream().min((Integer::compareTo)).get());
    }
}
