package cn.simplelife.query;

import lombok.*;

/**
 * @ClassName QueryObject
 * @Description
 * @Author simplelife
 * @Date 2022/11/1 9:38
 * @Version 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class QueryObject {
    private int currentPage = 1;// 当前页 需要默认值
    private int pageSize = 3;   // 每页要显示的条数 需要默认值

    public int getBeginIndex() {
        return (currentPage - 1) * pageSize;
    }
}
