package cn.simplelife.work._03streamapi;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName StreamApi
 * @Description
 * @Author simplelife
 * @Date 2022/9/15 16:42
 * @Version 1.0
 */

public class StreamApi {
    public static void main(String[] args) {
        // 需求1：对制定的集合进行过滤出偶数并去重复并保留其中三个并跳过指定1个后进行打印输出
        List<Integer> list = Arrays.asList(1, 8, 5, 6, 21, 45, 265, 15, 12, 33, 32, 36, 6);

        list.stream().filter(integer -> integer % 2 == 0).distinct().limit(3).skip(1).forEach(System.out::println);
    }
}
