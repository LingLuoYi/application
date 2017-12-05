package com.henglong.application.Exception;

import com.henglong.application.Entity.Result;
import com.henglong.application.Util.ExceptionUtil;
import com.henglong.application.Util.SessionUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class WordException {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result AntiEvil(Exception e){
        return ExceptionUtil.errer(SessionUtil.getRequest().getRemoteAddr(), SessionUtil.getRequest().getMethod(), "未知错误", -1);
    }
}
