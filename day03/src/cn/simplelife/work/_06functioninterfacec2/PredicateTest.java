package cn.simplelife.work._06functioninterfacec2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @ClassName PridicateTest
 * @Description
 * @Author simplelife
 * @Date 2022/9/10 16:50
 * @Version 1.0
 */

public class PredicateTest {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("apple");
        strings.add("abandon");
        strings.add("airplane");

        List<String> string = getString(strings, s -> s.length() > 5);
        System.out.println("string = " + string);
    }

    public static List<String> getString(List<String> list, Predicate<String> predicate) {
        List<String> stringList = new ArrayList<>();
        for (String s : list) {
            if (predicate.test(s)) {
                stringList.add(s);
            }
        }
        return stringList;
    }
}
