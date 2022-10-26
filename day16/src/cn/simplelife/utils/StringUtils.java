package cn.simplelife.utils;

/**
 * @ClassName StringEmptyUtils
 * @Description
 * @Author simplelife
 * @Date 2022/10/26 22:57
 * @Version 1.0
 */

public class StringUtils {

    public static boolean hasLength(String str) {
        return str != null && !"".equals(str.trim());
    }
}
