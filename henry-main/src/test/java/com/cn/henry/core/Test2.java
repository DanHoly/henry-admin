
package com.cn.henry.core;
import cn.hutool.core.date.DateUtil;
import com.cn.henry.core.util.PastTimeFormatUtil;

/**
 * 纯test
 *
 * @author xuyuxiang
 * @date 2020/5/2014:29
 */
public class Test2 {

    public static void main(String[] args) {
        String s = PastTimeFormatUtil.formatPastTime(DateUtil.parseDateTime("2020-08-05 19:24:33"));
        System.out.println(s);
    }
}
