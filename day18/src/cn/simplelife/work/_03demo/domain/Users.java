package cn.simplelife.work._03demo.domain;

import lombok.*;

/**
 * @ClassName Users
 * @Description
 * @Author simplelife
 * @Date 2022/10/28 17:24
 * @Version 1.0
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Users {
    private Long id;
    private String username;
    private String password;
    private String headImg;
}
