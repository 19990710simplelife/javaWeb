package cn.simplelife.homework._04interface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @ClassName Test
 * @Description
 * @Author simplelife
 * @Date 2022/9/14 16:57
 * @Version 1.0
 */

public class Test {
    public static void main(String[] args) {
        // 普通调用
        shop(100, new Consumer<Float>() {
            @Override
            public void accept(Float aFloat) {
                System.out.println("消费了" + aFloat);
            }
        });
        //改写调用
        shop(100, money -> System.out.println("消费了" + money));
        System.out.println("-----------------------------------------------");
        String code = getCode(4, () -> new Random().nextInt(10));
        System.out.println(code);
        System.out.println("-----------------------------------------------");
        int helloworld = getStringRealLength("helloworld", s -> s.trim().length());
        System.out.println(helloworld);
        System.out.println("-----------------------------------------------");
        List<String> list = Arrays.asList("asda", "ffasfas", "asdasdaw", "grgsdfsaedf", "wqwrerertet");
        List<String> string = getString(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.length() > 5;
            }
        });
        System.out.println(string);
    }

    // 需求1:编写shop方法输出消费多少元
    public static void shop(float money, Consumer<Float> consumer) {
        consumer.accept(money);
    }

    // 需求2:编写getCode方法返回指定位数的随机验证码字符串
    public static String getCode(int num, Supplier<Integer> supplier) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < num; i++) {
            stringBuilder.append(supplier.get());
        }
        return stringBuilder.toString();
    }

    // 需求3:编写getStringRealLength方法返回字符串真实长度
    public static int getStringRealLength(String str, Function<String, Integer> function) {
        return function.apply(str);
    }

    // 需求4:编写getString方法返回长度大于5的字符串的集合
    public static List<String> getString(List<String> list, Predicate<String> predicate) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (String s : list) {
            if (predicate.test(s)) {
                arrayList.add(s);
            }
        }
        return arrayList;
    }
}
