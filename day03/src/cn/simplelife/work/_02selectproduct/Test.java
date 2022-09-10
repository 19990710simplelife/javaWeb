package cn.simplelife.work._02selectproduct;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Test
 * @Description
 * @Author simplelife
 * @Date 2022/9/10 10:31
 * @Version 1.0
 */

public class Test {
    private static List<Product> products = new ArrayList<>();

    static {
        products.add(new Product(1L, "苹果手机", 8888.88, "手机"));
        products.add(new Product(2L, "华为手机", 6666.66, "手机"));
        products.add(new Product(3L, "联想笔记本", 7777.77, "电脑"));
        products.add(new Product(4L, "机械键盘", 999.99, "键盘"));
        products.add(new Product(5L, "雷蛇鼠标", 222.22, "鼠标"));
    }

    public static void main(String[] args) {
        // 需求：
        // 需求1: 筛选出所有名称包含手机的商品
        for (Product product : getProductsByName(products)) {
            System.out.println(product);
        }
        System.out.println("=========================================");
        // 需求2: 筛选出所有价格大于1000的商品
        for (Product product : getProductsByPrice(products)) {
            System.out.println(product);
        }
    }

    // 需求1: 筛选出所有名称包含手机的商品
    public static List<Product> getProductsByName(List<Product> list) {
        List<Product> productList = new ArrayList<>();
        for (Product product : list) {
            if (product.getName().contains("手机")) {
                productList.add(product);
            }
        }
        return productList;
    }

    // 需求2: 筛选出所有价格大于1000的商品
    public static List<Product> getProductsByPrice(List<Product> list) {
        List<Product> productList = new ArrayList<>();
        for (Product product : list) {
            if (product.getPrice() > 1000) {
                productList.add(product);
            }
        }
        return productList;
    }
}
