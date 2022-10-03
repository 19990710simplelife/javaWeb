package cn.simplelife.daodemo.domain;

import lombok.*;

import java.math.BigDecimal;

/**
 * @ClassName Student
 * @Description
 * @Author simplelife
 * @Date 2022/10/3 18:21
 * @Version 1.0
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Student {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
