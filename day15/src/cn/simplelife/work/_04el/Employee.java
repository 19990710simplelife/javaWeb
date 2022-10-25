package cn.simplelife.work._04el;

import lombok.*;

import java.math.BigDecimal;
import java.util.*;

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
    private String name = "张三";
    private BigDecimal salary = new BigDecimal("10000");
    private List<String> list = Arrays.asList("妲己", "王昭君", "安琪拉");
    private String[] hobby = {"吃饭", "睡觉", "打豆豆"};
    private Map<String, String> map = new HashMap<>() {
        {
            this.put("name", "李四");
            this.put("host", "cn.ss.sim");
            this.put("port", "8080");
        }
    };
}
