package cn.simplelife.work._02javabean;

import lombok.*;

import javax.management.ConstructorParameters;
import java.beans.ConstructorProperties;

/**
 * @ClassName Student
 * @Description
 * @Author simplelife
 * @Date 2022/9/9 15:53
 * @Version 1.0
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {
    private String id;
    private String name;
    private int age;
    private String address;
}
