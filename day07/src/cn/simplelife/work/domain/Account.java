package cn.simplelife.work.domain;

import lombok.*;

import java.math.BigDecimal;

/**
 * @ClassName Account
 * @Description
 * @Author simplelife
 * @Date 2022/10/4 20:16
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
