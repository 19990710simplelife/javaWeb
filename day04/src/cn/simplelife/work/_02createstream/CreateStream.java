package cn.simplelife.work._02createstream;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

/**
 * @ClassName CreateStream
 * @Description
 * @Author simplelife
 * @Date 2022/9/15 15:39
 * @Version 1.0
 */

public class CreateStream {
    public static void main(String[] args) {
        // 创建流的几种方法
        // 1、Collection的默认方法stream()和parallelStream()
        System.out.println("====1、stream()和parallelStream()获取流对象====");
        List<Integer> list = Arrays.asList(4, 9, 8, 1, 3, 2, 4);

        // 获取流对象(顺行流 顺序与源数据相同)
        Stream<Integer> stream = list.stream();
        stream.forEach(System.out::println);
        System.out.println("----------------------------");

        // 获取流对象(并行流，顺序与源数据顺序不一致)
        Stream<Integer> integerStream = list.parallelStream();
        integerStream.forEach(System.out::println);

        // 2、Arrays.stream() 是顺序流
        System.out.println("=====2、Arrays.stream()获取流对象=====");
        Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6}).forEach(System.out::println);

        // 3、Stream.of() 是顺序流
        System.out.println("======3、Stream.of()获取流对象======");
        Stream.of("张三", "李四", "王五", "赵六").forEach(System.out::println);

        // 4、Stream.iterate()
        System.out.println("=========4、Stream.iterate()获取流对象=========");
        Stream.iterate(1, new UnaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return integer + 2;
            }
        }).limit(10).forEach(System.out::println);

        // 简化操作
        System.out.println("=============4.1、简化操作=============");
        Stream.iterate(1, integer -> integer + 2).limit(10).forEach(System.out::println);

        // 5、Stream.generate()
        System.out.println("=========5、Stream.generate()创建流=========");
        Stream.generate(new Supplier<Integer>() {
            @Override
            public Integer get() {
                return new Random().nextInt(10);
            }
        }).limit(10).forEach(System.out::println);
        System.out.println("=========5.1、Stream.generate()创建流简化=========");
        Stream.generate(() -> new Random().nextInt(10)).limit(10).forEach(System.out::println);
    }
}
