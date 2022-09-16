package cn.simplelife.work._03streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * @ClassName StreamApiMatch
 * @Description
 * @Author simplelife
 * @Date 2022/9/16 12:15
 * @Version 1.0
 */

public class StreamApiMatch {
    public static void main(String[] args) {
        // allMatch:检查是否匹配所有元素
        // anyMatch:检查是否至少匹配一个元素
        // noneMatch:检查是否没有匹配的元素
        // findFirst:返回第一个元素(返回值为Optional<T>)
        // findAny:返回当前流中的任意元素(一般用于并行流)
        List<Integer> list = Arrays.asList(5, 2, 1, 3, -1, 2, 4);
        // 需求1: 检查是否每一个元素都是大于0
        boolean allMatch = list.stream().allMatch(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer > 0;
            }
        });
        System.out.println("检查是否每一个元素都是大于0 = " + allMatch);

        // 需求2: 检查是否存在一个元素是小于0
        boolean anyMatch = list.stream().anyMatch(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer < 0;
            }
        });
        System.out.println("检查是否存在一个元素是小于0 = " + anyMatch);
        // 需求3: 检查是否真的没有匹配到为0的元素
        boolean noneMatch = list.stream().noneMatch(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer == 0;
            }
        });

        System.out.println("检查是否真的没有匹配到为0的元素 = " + noneMatch);
        // 需求4: 返回集合中的第一个元素
        Optional<Integer> first = list.stream().findFirst();
        // Optional<Integer> 新容器 isPresent() 判断改容器是否有值存在 get()获取改值
        if (first.isPresent()) {
            System.out.println("返回集合中的第一个元素 = " + first.get());
        }
        // 需求5: 返回集合中的任意一个元素
        Optional<Integer> any = list.stream().findAny();
        System.out.println("返回集合中的任意一个元素 = " + any.get());
        System.out.println("=====================新写法====================");
        // 需求1: 检查是否每一个元素都是大于0
        System.out.println("检查是否每一个元素都是大于0 = " + list.stream().allMatch(integer -> integer > 0));
        // 需求2: 检查是否存在一个元素是小于0
        System.out.println("检查是否存在一个元素是小于0 = " + list.stream().anyMatch(integer -> integer < 0));
        // 需求3: 检查是否真的没有匹配到为0的元素
        System.out.println("检查是否真的没有匹配到为0的元素 = " + list.stream().noneMatch(integer -> integer == 0));
    }
}