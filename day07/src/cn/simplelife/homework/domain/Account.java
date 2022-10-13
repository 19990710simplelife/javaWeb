package cn.simplelife.homework.domain;

import lombok.*;

import java.math.BigDecimal;

/**
 * @ClassName Account
 * @Description
 * @Author simplelife
 * @Date 2022/10/13 21:58
 * @Version 1.0
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Account {
    private Long id;
    private String name;
    private BigDecimal balance;
}
