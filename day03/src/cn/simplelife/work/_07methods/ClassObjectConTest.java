package cn.simplelife.work._07methods;

import java.util.function.Supplier;

/**
 * @ClassName ClassObjectConTest
 * @Description
 * @Author simplelife
 * @Date 2022/9/11 11:06
 * @Version 1.0
 */

public class ClassObjectConTest {
    public static void main(String[] args) {
        Supplier<Product> productSupplier = new Supplier<>() {
            @Override
            public Product get() {
                return new Product(2000L, "电脑", 20.0, "小米");
            }
        };
        Product product = productSupplier.get();
        System.out.println("product = " + product);
        System.out.println("--------------------------------------------------------");
        // 改造为lambda
        Supplier<Product> productSupplier1 = () -> new Product(3000L, "电脑1", 20.0, "小米");
        Product product1 = productSupplier1.get();
        System.out.println("product1 = " + product1);
        System.out.println("--------------------------------------------------------");
        // 改造为方法引用
        Supplier<Product> productSupplier2 = Product::new;
        Product product2 = productSupplier2.get();
        System.out.println("product2 = " + product2);
    }
}
