package cn.simplelife.work._03selectproductbyjdk8;

import cn.simplelife.work._02selectproduct.Product;

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
    private static List<Products> products = new ArrayList<>();

    static {
        products.add(new Products(1L, "苹果手机", 8888.88, "手机"));
        products.add(new Products(2L, "华为手机", 6666.66, "手机"));
        products.add(new Products(3L, "联想笔记本", 7777.77, "电脑"));
        products.add(new Products(4L, "机械键盘", 999.99, "键盘"));
        products.add(new Products(5L, "雷蛇鼠标", 222.22, "鼠标"));
    }

    public static void main(String[] args) {
        // 需求1、筛选出所有名称包含手机的商品
        List<Products> productsList = getProductsByCondition(products, new MyCondition() {
            @Override
            public boolean test(Products product) {
                return product.getName().contains("手机");
            }
        });
        for (Products products1 : productsList) {
            System.out.println(products1);
        }
        System.out.println("================================================");

        // 需求2: 筛选出所有价格大于1000的商品
        List<Products> products1 = getProductsByCondition(products, product -> product.getPrice() > 1000);
        for (Products products2 : products1) {
            System.out.println(products2);
        }


        System.out.println("================================================");
        products.stream().filter(p -> p.getName().contains("手机")).forEach(System.out::println);
    }

    /**
     * 根据条件获取符合条件的商品
     *
     * @param list        商品集合
     * @param myCondition 条件接口
     * @return 返回符合条件的商品集合
     */
    public static List<Products> getProductsByCondition(List<Products> list, MyCondition myCondition) {
        List<Products> productsList = new ArrayList<>();
        for (Products products : list) {
            if (myCondition.test(products)) {
                productsList.add(products);
            }
        }
        return productsList;
    }
}
