package cn.simplelife.domain;

import lombok.*;

/**
 * @ClassName Users
 * @Description
 * @Author simplelife
 * @Date 2022/10/31 17:55
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
