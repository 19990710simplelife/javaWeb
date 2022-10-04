package cn.simplelife.homework.domain;

import lombok.*;

/**
 * @ClassName Student
 * @Description
 * @Author simplelife
 * @Date 2022/10/4 17:51
 * @Version 1.0
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Student {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
