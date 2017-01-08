package com.funtl.framework.core.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * HttpServletRequest工具类
 * Created by 李卫民 on 2016/8/26.
 */
public class RequestUtils {
    /**
     * 获取Http请求的服务器名称（如：www.xxx.com）
     * @param request
     * @return
     */
    public static String getServerName(HttpServletRequest request) {
        String url = "";
        url = request.getScheme() + "://" + request.getServerName();
        return url;
    }

    /**
     * 获取Http请求的完整路径，包括参数
     *
     * @param request
     * @return
     */
    public static String getFullURL(HttpServletRequest request) {
        String url = "";
        url = request.getScheme() + "://" + request.getServerName()
                + ":" + request.getServerPort()
                + request.getServletPath();
        if (request.getQueryString() != null) {
            url += "?" + request.getQueryString();
        }
        return url;
    }

    /**
     * 获取Http请求的完整路径，包括参数，不包括端口号
     * @param request
     * @return
     */
    public static String getFullURLWithOutPort(HttpServletRequest request) {
        String url = "";
        url = request.getScheme() + "://" + request.getServerName() + request.getServletPath();
        if (request.getQueryString() != null) {
            url += "?" + request.getQueryString();
        }
        return url;
    }
}
