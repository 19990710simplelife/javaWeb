package cn.simplelife.query;

/**
 * @ClassName ProductQueryByConditionParams
 * @Description
 * @Author simplelife
 * @Date 2022/11/2 9:50
 * @Version 1.0
 */

import lombok.*;

/**
 * 封装过滤查询的条件数据
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ProductQueryByConditionParams extends QueryObject {
    private String productName;  // 商品名称
    private Double minSalePrice; // 最小价格
    private Double maxSalePrice; // 最大价格
    private String keyWord; // 关键字
}
