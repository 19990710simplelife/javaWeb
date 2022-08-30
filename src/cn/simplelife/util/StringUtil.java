package cn.simplelife.util;

/**
 * @ClassName StringUtil
 * @Description
 * @Author simplelife
 * @Date 2022/8/30 10:55
 * @Version 1.0
 */

public class StringUtil {
    //字符串判断是否为空
    public static boolean hasLength(String val) {
        return val != null && "".equals(val.trim());
    }
}
