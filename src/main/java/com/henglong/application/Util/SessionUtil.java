package com.henglong.application.Util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionUtil {
    private static ThreadLocal<HttpServletRequest> requestLocal = new ThreadLocal<HttpServletRequest>();

    public static HttpServletRequest getRequest() {
        return (HttpServletRequest) requestLocal.get();
    }

    public static void setRequest(HttpServletRequest request) {
        requestLocal.set(request);
    }

    public static HttpSession getSession() {
        if (requestLocal.get()==null)
            return null;
        else
            return (HttpSession) ((HttpServletRequest) requestLocal.get()).getSession();

    }
}
