package cn.simplelife.utils;

/**
 * @ClassName StringUtils
 * @Description
 * @Author simplelife
 * @Date 2022/10/28 20:28
 * @Version 1.0
 */

public class StringUtils {
    public static boolean hasLength(String str) {
        return str != null && !"".equals(str.trim());
    }
}
