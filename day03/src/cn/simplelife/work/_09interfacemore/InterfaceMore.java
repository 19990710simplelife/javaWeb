package cn.simplelife.work._09interfacemore;

/**
 * @ClassName InterfaceMore
 * @Description
 * @Author simplelife
 * @Date 2022/9/13 10:05
 * @Version 1.0
 */

public interface InterfaceMore {
    /**
     * 添加的接口
     */
    void add();

    /**
     * 查找方法
     */
    default void select() {
        System.out.println("通用的查找方法");
    }

    /**
     * 修改方法
     */
    static void update() {
        System.out.println("静态的修改方法执行");
    }
}
