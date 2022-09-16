package cn.simplelife.work._03streamapi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @ClassName StreamApiSort
 * @Description
 * @Author simplelife
 * @Date 2022/9/16 12:03
 * @Version 1.0
 */

public class StreamApiSort {
    public static void main(String[] args) {
        // sorted()：自然排序使用Comparable<T>的int compareTo(T o)方法
        // sorted(Comparator<T> com)：定制排序使用Comparator的int compare(T o1, T o2)方法
        // 需求：给指定的集合（ List list = Arrays.asList(1, 2, 1, 3, 3, 2, 4);）进行升序和降序排序
        List<Integer> list = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        // 1、自然排序 从大到小
        list.stream().sorted().forEach(System.out::print);
        System.out.println("\n---------------------------------------");
        // 2、定制排序(升序)
        list.stream().sorted(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        }).forEach(System.out::print);
        System.out.println("\n---------------------------------------");
        // 3、定制排序(降序)
        list.stream().sorted(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        }).forEach(System.out::print);
        System.out.println("\n---------------------------------------");
        list.stream().sorted((o1, o2) -> o2 - o1).forEach(System.out::print);
    }
}
