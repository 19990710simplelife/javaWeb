package cn.simplelife.work._06functioninterfacec2;

import java.util.Random;
import java.util.function.Supplier;

/**
 * @ClassName SupplierTest
 * @Description
 * @Author simplelife
 * @Date 2022/9/10 16:34
 * @Version 1.0
 */

public class SupplierTest {
    public static void main(String[] args) {
        String code = getCode(4, () -> new Random().nextInt(10) + "");
        System.out.println("code = " + code);
    }

    //需求2:编写getCode方法返回指定位数的随机验证码字符串
    public static String getCode(Integer num, Supplier<String> supplier) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < num; i++) {
            stringBuilder.append(supplier.get());
        }
        return stringBuilder.toString();
    }
}
