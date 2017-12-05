package com.henglong.application.Controller;


import com.henglong.application.Entity.Result;
import com.henglong.application.Repository.OrderRepository;
import com.henglong.application.Util.ExceptionUtil;
import com.henglong.application.Util.SessionUtil;
import com.henglong.application.Util.WordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@CrossOrigin
@RestController
public class WordController {

    @Autowired
    private WordUtil wordUtil;

    @Autowired
    private OrderRepository repository;


    @GetMapping("/word/dow/{id}")
    public Result word(@PathVariable("id") Integer id) throws IOException {
        String name=wordUtil.Word(repository.findOne(id));
        return ExceptionUtil.success("http://linglouyi.link:8085/"+name+".doc",SessionUtil.getRequest().getLocalAddr(),SessionUtil.getRequest().getMethod());
    }
}
