package cn.simplelife.work._06functioninterfacec2;

import java.util.function.Function;

/**
 * @ClassName FunctionTest
 * @Description
 * @Author simplelife
 * @Date 2022/9/10 16:44
 * @Version 1.0
 */

public class FunctionTest {
    public static void main(String[] args) {
        // 需求3:编写getStringRealLength方法返回字符串真实长度
        Integer length = getStringRealLength("zhangsan", s -> s.trim().length());
        System.out.println("length = " + length);
    }

    public static Integer getStringRealLength(String str, Function<String, Integer> function) {
        return function.apply(str);
    }
}
