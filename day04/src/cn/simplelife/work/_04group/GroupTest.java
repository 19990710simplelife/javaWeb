package cn.simplelife.work._04group;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @ClassName GroupTest
 * @Description
 * @Author simplelife
 * @Date 2022/9/16 17:06
 * @Version 1.0
 */

public class GroupTest {
    private static List<Product> products = new ArrayList<>();

    static {
        products.add(new Product(1L, "苹果手机", 8888.88, "手机"));
        products.add(new Product(2L, "华为手机", 6666.66, "手机"));
        products.add(new Product(3L, "联想笔记本", 7777.77, "电脑"));
        products.add(new Product(4L, "机械键盘", 999.99, "键盘"));
        products.add(new Product(5L, "雷蛇鼠标", 222.22, "鼠标"));
    }

    public static void main(String[] args) {
        // 需求1: 根据商品分类名称进行分组
        Map<String, List<Product>> collect = products.stream().collect(Collectors.groupingBy(new Function<Product, String>() {
            @Override
            public String apply(Product product) {
                return product.getBrand();
            }
        }));
        collect.forEach((key, value) -> System.out.println(key + "=" + value));
        System.out.println("=================================================");
        // 需求2: 根据商品价格是否大于1000进行分区
        Map<Boolean, List<Product>> collect1 = products.stream().collect(Collectors.partitioningBy(new Predicate<Product>() {
            @Override
            public boolean test(Product product) {
                return product.getPrice() > 1000;
            }
        }));
        collect1.forEach((k, v) -> System.out.println(k + "=" + v));
    }
}
