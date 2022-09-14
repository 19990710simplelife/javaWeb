package cn.simplelife.homework._01reflex;

import lombok.*;

/**
 * @ClassName Person
 * @Description
 * @Author simplelife
 * @Date 2022/9/14 10:13
 * @Version 1.0
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Person {
    private String name;
    private Integer age;
    private String address;

    public Person(Integer age, String address) {
        this.age = age;
        this.address = address;
    }

    public void sleep(String name) {
        System.out.println(name + "睡觉");
    }

    public static void eat(String name) {
        System.out.println(name + "吃饭");
    }
}
