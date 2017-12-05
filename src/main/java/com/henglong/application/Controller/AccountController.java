package com.henglong.application.Controller;

import com.henglong.application.Entity.Accountnumber;
import com.henglong.application.Entity.Result;
import com.henglong.application.Repository.AccountRepository;
import com.henglong.application.Util.ExceptionUtil;
import com.henglong.application.Util.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("/account")
    public Result<Accountnumber> Account(){
        return ExceptionUtil.success(accountRepository.findAll(), SessionUtil.getRequest().getRemoteAddr(),SessionUtil.getRequest().getMethod());
    }

    @GetMapping("/account/{id}")
    public Result<Accountnumber> AccountOne(@PathVariable("id") Integer id){
        return ExceptionUtil.success(accountRepository.findOne(id),SessionUtil.getRequest().getRemoteAddr(),SessionUtil.getRequest().getMethod());
    }

    @PostMapping("/account/updata")
    public Result updata(Accountnumber accountnumber){
        if (accountnumber.getID()!=null) {
            accountnumber.setID(accountnumber.getID());
        }
        accountnumber.setAccountNumber(accountnumber.getAccountNumber());
        accountnumber.setAccountOpening(accountnumber.getAccountOpening());
        accountnumber.setBank(accountnumber.getBank());
        return ExceptionUtil.success(accountRepository.save(accountnumber),SessionUtil.getRequest().getRemoteAddr(),SessionUtil.getRequest().getMethod());
    }

    @GetMapping("/account/delete/{id}")
    public Result Delete(@PathVariable("id") Integer id){
        accountRepository.delete(id);
        if (accountRepository.findOne(id)==null&&"".equals("")){
            return ExceptionUtil.success("删除成功",SessionUtil.getRequest().getRemoteAddr(),SessionUtil.getRequest().getMethod());
        }else {
            return ExceptionUtil.success("删除失败",SessionUtil.getRequest().getRemoteAddr(),SessionUtil.getRequest().getMethod());
        }

    }
}
