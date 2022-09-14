package cn.simplelife.homework._03newmethod;

import java.util.ArrayList;
import java.util.List;
import java.util.PropertyResourceBundle;

/**
 * @ClassName Test
 * @Description
 * @Author simplelife
 * @Date 2022/9/14 16:19
 * @Version 1.0
 */

public class Test {
    private static List<Product> product = new ArrayList<>();

    static {
        product.add(new Product(1L, "苹果手机", 8888.88, "手机"));
        product.add(new Product(2L, "华为手机", 6666.66, "手机"));
        product.add(new Product(3L, "联想笔记本", 7777.77, "电脑"));
        product.add(new Product(4L, "机械键盘", 999.99, "键盘"));
        product.add(new Product(5L, "雷蛇鼠标", 222.22, "鼠标"));
    }

    public static void main(String[] args) {
        // 需求1: 筛选出所有名称包含手机的商品
        List<Product> productList = findPhoneByCondition(product, new MyCondation() {
            @Override
            public boolean test(Product product) {
                return product.getName().contains("手机");
            }
        });
        System.out.println(productList);
        // 需求2: 筛选出所有价格大于1000的商品

        List<Product> phoneByCondition = findPhoneByCondition(product, product -> product.getPrice() > 1000);

        System.out.println(phoneByCondition);
    }

    public static List<Product> findPhoneByCondition(List<Product> product, MyCondation myCondation) {
        List<Product> list = new ArrayList<>();
        for (Product product1 : product) {
            if (myCondation.test(product1)) {
                list.add(product1);
            }
        }
        return list;
    }
}
