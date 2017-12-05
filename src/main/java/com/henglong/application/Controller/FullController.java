package com.henglong.application.Controller;


import com.henglong.application.Entity.FullName;
import com.henglong.application.Entity.Result;
import com.henglong.application.Repository.FullRepository;
import com.henglong.application.Util.ExceptionUtil;
import com.henglong.application.Util.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class FullController {

    @Autowired
    private FullRepository fullRepository;

    @GetMapping("/full")
    public Result<FullName> Word(){
        return ExceptionUtil.success(fullRepository.findAll(), SessionUtil.getRequest().getRemoteAddr(),SessionUtil.getRequest().getMethod());
    }

    @GetMapping("/full/{id}")
    public Result WordOne(@PathVariable("id") Integer id){
        return ExceptionUtil.success(fullRepository.findOne(id),SessionUtil.getRequest().getRemoteAddr(),SessionUtil.getRequest().getMethod());
    }

    @PostMapping("/full/add")
    public Result<FullName> Add(@RequestParam("fullname") String name){
        FullName fullName=new FullName();
        fullName.setFullName(name);
        return ExceptionUtil.success(fullRepository.save(fullName), SessionUtil.getRequest().getRemoteAddr(),SessionUtil.getRequest().getMethod());
    }

    @PostMapping("/full/updata/{id}")
    public Result UpData(@PathVariable("id") Integer id,@RequestParam("name") String name){
        FullName fullName=new FullName();
        fullName.setID(id);
        fullName.setFullName(name);
        return ExceptionUtil.success(fullRepository.save(fullName),SessionUtil.getRequest().getRemoteAddr(),SessionUtil.getRequest().getMethod());
    }

    @GetMapping("/full/delete/{id}")
    public Result Delete(@PathVariable("id") Integer id){
        fullRepository.delete(id);
        if (fullRepository.findOne(id)==null&&"".equals("")){
            return ExceptionUtil.success("删除成功",SessionUtil.getRequest().getRemoteAddr(),SessionUtil.getRequest().getMethod());
        }else {
            return ExceptionUtil.success("删除失败",SessionUtil.getRequest().getRemoteAddr(),SessionUtil.getRequest().getMethod());
        }

    }

}
