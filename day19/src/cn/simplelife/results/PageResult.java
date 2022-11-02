package cn.simplelife.results;

/**
 * @ClassName PageResult
 * @Description
 * @Author simplelife
 * @Date 2022/11/1 9:13
 * @Version 1.0
 */

import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 用来封装分页的结果数据
 */
@Getter
@Setter
public class PageResult {
    private int currentPage;// 当前页
    private int pageSize;   // 每页要显示的条数
    private List data;      // 当前页的数据
    private int totalCount; // 总条数
    private int totalPage;  // 总页数
    private int prevPage;   // 上一页
    private int nextPage;   // 下一页

    public PageResult(int currentPage, int pageSize, List data, int totalCount) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.data = data;
        this.totalCount = totalCount;
        // 计算上一页 总条数、下一页、
        this.prevPage = currentPage - 1 >= 1 ? currentPage - 1 : 1;
        this.totalPage = totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
        this.nextPage = currentPage + 1 <= this.totalPage ? currentPage + 1 : this.totalPage;
    }


    /**
     * 表中没有数据的时候
     * @param currentPage 当前页
     * @param pageSize 页面大小
     */
    public PageResult(int currentPage, int pageSize) {
        this(currentPage, pageSize, new ArrayList(), 0);
    }
}
