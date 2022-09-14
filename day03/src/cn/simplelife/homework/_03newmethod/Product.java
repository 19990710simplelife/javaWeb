package cn.simplelife.homework._03newmethod;

import lombok.*;

/**
 * @ClassName Product
 * @Description
 * @Author simplelife
 * @Date 2022/9/14 16:19
 * @Version 1.0
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Product {
    private Long id; //商品编号
    private String name;// 商品名称
    private Double price; // 商品价格
    private String brand;// 商品类别
}
