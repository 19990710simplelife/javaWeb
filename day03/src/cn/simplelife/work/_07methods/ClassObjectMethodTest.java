package cn.simplelife.work._07methods;

import java.util.function.Function;

/**
 * @ClassName ClassObjectMethodTest
 * @Description
 * @Author simplelife
 * @Date 2022/9/11 10:56
 * @Version 1.0
 */

public class ClassObjectMethodTest {
    public static void main(String[] args) {
        // 创建对象
        Product product = new Product(1000L, "shouji", 1000.0, "华为");
        // 函数式接口
        Function<Product, String> productStringFunction = new Function<>() {
            @Override
            public String apply(Product product) {
                return product.getName();
            }
        };
        String apply = productStringFunction.apply(product);
        System.out.println("apply = " + apply);
        System.out.println("-----------------------------------------------------");
        // 改造lambda
        Function<Product, String> productStringFunction1 = product1 -> product1.getName();
        String apply1 = productStringFunction1.apply(product);
        System.out.println("apply1 = " + apply1);
        System.out.println("-----------------------------------------------------");
        // 改造方法引用
        Function<Product, String> productStringFunction2 = Product::getName;
        String apply2 = productStringFunction2.apply(product);
        System.out.println("apply2 = " + apply2);
    }
}
