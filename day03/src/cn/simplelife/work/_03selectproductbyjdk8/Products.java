package cn.simplelife.work._03selectproductbyjdk8;

import lombok.*;

/**
 * @ClassName Product
 * @Description
 * @Author simplelife
 * @Date 2022/9/10 10:23
 * @Version 1.0
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Products {
    private Long id; //商品编号
    private String name;// 商品名称
    private Double price; // 商品价格
    private String brand;// 商品类别
}
