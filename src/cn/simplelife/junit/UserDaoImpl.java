package cn.simplelife.junit;

/**
 * @ClassName UserDaoImpl
 * @Description
 * @Author simplelife
 * @Date 2022/8/30 11:23
 * @Version 1.0
 */

public class UserDaoImpl {
    public int add(int num1, int num2) {
        return num1 + num2;
    }

    public void delete(int index) {
        System.out.println("删除索引为" + index + "的数值！");
    }
}
