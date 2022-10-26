package cn.simplelife.work.demo.domain;

import lombok.*;

import java.math.BigDecimal;

/**
 * @ClassName User
 * @Description
 * @Author simplelife
 * @Date 2022/10/26 9:20
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
