package cn.simplelife.work._03introspection;

import lombok.*;

/**
 * @ClassName Person
 * @Description
 * @Author simplelife
 * @Date 2022/9/9 19:07
 * @Version 1.0
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Person {
    private String name;
    private int age;
}
