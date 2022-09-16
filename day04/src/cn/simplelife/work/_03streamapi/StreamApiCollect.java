package cn.simplelife.work._03streamapi;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

/**
 * @ClassName StreamApiCollect
 * @Description
 * @Author simplelife
 * @Date 2022/9/16 16:42
 * @Version 1.0
 */

public class StreamApiCollect {
    public static void main(String[] args) {
        List<Integer> streamList = Arrays.asList(1, 2, 1, 3, -1, 2, 4);
        // collect:将流转换为其他形式:list
        List<Integer> collect = streamList.stream().collect(Collectors.toList());
        // collect:将流转换为其他形式:set
        Set<Integer> collect1 = streamList.stream().collect(Collectors.toSet());
        // collect:将流转换为其他形式:TreeSet
        TreeSet<Integer> collect2 = streamList.stream().collect(Collectors.toCollection(() -> new TreeSet<>()));
        // collect:将流转换为其他形式:map
        Map<Integer, Integer> collect3 = streamList.stream().collect(Collectors.toMap(integer -> integer, integer -> integer));
        // collect:将流转换为其他形式:sum
        Integer collect4 = streamList.stream().collect(Collectors.summingInt(value -> value.intValue()));
        // collect:将流转换为其他形式:avg
        Double collect5 = streamList.stream().collect(Collectors.averagingDouble(value -> value));
        // collect:将流转换为其他形式:max
        Optional<Integer> collect6 = streamList.stream().max((o1, o2) -> o1.compareTo(o2));
        // collect:将流转换为其他形式:min
        Optional<Integer> collect7 = streamList.stream().min(Integer::compareTo);
    }
}

