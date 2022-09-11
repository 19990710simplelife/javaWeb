package cn.simplelife.work._07methods;

import java.util.function.Supplier;

/**
 * @ClassName ClassStaticMethodTest
 * @Description
 * @Author simplelife
 * @Date 2022/9/11 10:37
 * @Version 1.0
 */

public class ClassStaticMethodTest {
    public static void main(String[] args) {
        //类名 :: 静态方法名
        Supplier<Double> doubleSupplier = new Supplier<>() {
            @Override
            public Double get() {
                return Math.random();
            }
        };
        System.out.println(doubleSupplier.get());
        // 改造为lambda表达式
        Supplier<Double> doubleSupplier1 = () -> Math.random();
        System.out.println(doubleSupplier1.get());

        // 改造为方法引用
        Supplier<Double> doubleSupplier2 = Math::random;
        System.out.println(doubleSupplier2.get());
    }
}
