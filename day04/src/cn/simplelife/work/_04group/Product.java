package cn.simplelife.work._04group;

import lombok.*;

/**
 * @ClassName Product
 * @Description
 * @Author simplelife
 * @Date 2022/9/16 17:06
 * @Version 1.0
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Product {
    private Long id;
    private String name;
    private Double price;
    private String brand;
}
