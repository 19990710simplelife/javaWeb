package cn.simplelife.work.domain;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * @ClassName User
 * @Description
 * @Author simplelife
 * @Date 2022/10/14 15:08
 * @Version 1.0
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class User {
    private Long id;
    private String name;
    private Integer age;
    private BigDecimal salary;
}
