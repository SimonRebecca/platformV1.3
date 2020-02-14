package com.zx.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 常用工具类
 * <p/>
 * Created by zhangxin on 2015-07-28.
 */
public class WebUtil {

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static SimpleDateFormat simpleDateFormatYMD = new SimpleDateFormat("yyyyMMdd");
    private static SimpleDateFormat simpleDateFormatYYYY = new SimpleDateFormat("yyyy");
    private static SimpleDateFormat simpleDateFormatMM = new SimpleDateFormat("MM");

    /**
     * 获取客户端真实ip地址
     *
     * @param request
     * @return
     */
    public static String getRemoteHost(javax.servlet.http.HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip.equals("0:0:0:0:0:0:0:1") ? "127.0.0.1" : ip;
    }

    /**
     * 获取当前时间，以 yyyy-MM-dd HH:mm:ss 形式返回字符串
     *
     * @return
     */
    public static String getStringDate() {
        return simpleDateFormat.format(new Date());
    }

    /**
     * 获取当前年份
     *
     * @return
     */
    public static String getCurrentYear() {
        return simpleDateFormatYYYY.format(new Date());
    }

    /**
     * 获取当前月份
     *
     * @return
     */
    public static String getCurrentMonth() {
        return simpleDateFormatMM.format(new Date());
    }

    /**
     * 获取当前日期，形式：yyyyMMdd
     *
     * @return
     *
     */
    public static String getCurrentYMD() {
        return simpleDateFormatYMD.format(new Date());
    }
}
