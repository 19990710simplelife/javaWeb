package cn.simplelife.work._09interfacemore;

/**
 * @ClassName Test
 * @Description
 * @Author simplelife
 * @Date 2022/9/13 10:08
 * @Version 1.0
 */

public class Test {
    public static void main(String[] args) {
        InterfaceMore interfaceMore = new InterfaceMoreImpl();
        /**
         * 测试添加
         */
        interfaceMore.add();

        /**
         * 测试通用的查找方法
         */
        interfaceMore.select();

        /**
         * 测试静态的修改方法
         */
        InterfaceMore.update();
    }
}
