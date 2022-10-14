package cn.simplelife.homework.demo01.domain;

import lombok.*;

/**
 * @ClassName Employess
 * @Description
 * @Author simplelife
 * @Date 2022/10/14 10:38
 * @Version 1.0
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Employee {
    private Long id;
    private String username;
    private String password;
    private int age;
    private String job;
}
