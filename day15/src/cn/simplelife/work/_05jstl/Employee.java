package cn.simplelife.work._05jstl;

import lombok.*;

import java.math.BigDecimal;
/**
 * @ClassName Employee
 * @Description
 * @Author simplelife
 * @Date 2022/10/25 16:13
 * @Version 1.0
 */
@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private String name;
    private BigDecimal salary;
}
