package cn.simplelife.work.domain;

import lombok.*;

import java.math.BigDecimal;

/**
 * @ClassName User
 * @Description
 * @Author simplelife
 * @Date 2022/10/15 8:35
 * @Version 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {
    private Long id;
    private String name;
    private Integer age;
    private BigDecimal salary;
}
