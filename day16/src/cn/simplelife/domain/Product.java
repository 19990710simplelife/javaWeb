package cn.simplelife.domain;

import lombok.*;

/**
 * @ClassName Product
 * @Description
 * @Author simplelife
 * @Date 2022/10/26 20:01
 * @Version 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Product {
    private Long id;
    private String productName;
    private Long dirId;
    private Double salePrice;
    private String supplier;
    private String brand;
    private Double cutoff;
    private Double costPrice;
}
