package com.henglong.application.Util;

import com.henglong.application.Entity.Result;
import org.springframework.stereotype.Service;

@Service
public class ExceptionUtil {
    public static Result success(Object o,String ip,String mode){
        Result result=new Result();
        result.setCode("1");
        result.setIp(ip);
        result.setMode(mode);
        result.setMsg("成功");
        result.setData(o);
        return result;
    }
    public static Result success(String ip,String mode){
        Result result=new Result();
        result.setCode("1");
        result.setIp(ip);
        result.setMode(mode);
        result.setMsg("成功");
        return result;
    }

    public static Result errer(String ip,String mode,String msg,Integer code){
        Result result=new Result();
        result.setCode(""+code);
        result.setIp(ip);
        result.setMode(mode);
        result.setMsg(msg);
        return result;
    }

    public static Result errer(Object o,String ip,String mode,String msg,Integer code){
        Result result=new Result();
        result.setCode(""+code);
        result.setIp(ip);
        result.setMode(mode);
        result.setMsg(msg);
        result.setData(o);
        return result;
    }

}
