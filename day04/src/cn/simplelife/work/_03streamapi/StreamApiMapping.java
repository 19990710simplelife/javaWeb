package cn.simplelife.work._03streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * @ClassName StreamApiMapping
 * @Description
 * @Author simplelife
 * @Date 2022/9/16 11:45
 * @Version 1.0
 */

public class StreamApiMapping {
    public static void main(String[] args) {
        // map(Function<T, R> f)：接收一个函数作为参数，该函数会被应用到流中的每个元素上，并将其映射成一个新的元素。

        // 需求1：把给定的集合中的数据都变成大写
        System.out.println("--------------旧写法------------------");
        List<String> list = Arrays.asList("i", "love", "you");
        list.stream().map(new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s.toUpperCase();
            }
        }).forEach(System.out::println);
        System.out.println("--------------新写法------------------");
        list.stream().map(s -> s.toUpperCase()).forEach(System.out::println);


        System.out.println("--------------------------------------------");
        // flatMap(Function<T, Stream<R>> mapper)：接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流
        // 需求2: 把给定的两个集合进行合并
        List<Integer> integerList1 = Arrays.asList(1, 1, 3, 5, 67, 7);
        List<Integer> integerList2 = Arrays.asList(18, 12, 38, 54, 671, 71);
        // 将两个集合转为stream对象
        Stream<List<Integer>> listStream = Stream.of(integerList1, integerList2);
        listStream.flatMap(new Function<List<Integer>, Stream<?>>() {
            @Override
            public Stream<?> apply(List<Integer> integers) {
                return integers.stream();
            }
        }).forEach(System.out::println);

        System.out.println("--------------新写法------------------");
        listStream.flatMap(integers -> integers.stream()).forEach(System.out::println);
    }
}
