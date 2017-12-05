package com.henglong.application.Controller;

import com.henglong.application.Entity.Orders;
import com.henglong.application.Entity.Result;
import com.henglong.application.Repository.OrderRepository;
import com.henglong.application.Util.ExceptionUtil;
import com.henglong.application.Util.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/hl")
    public Result<Orders> henglong(){
        return ExceptionUtil.success(orderRepository.findAll(), SessionUtil.getRequest().getRemoteAddr(),SessionUtil.getRequest().getMethod());
    }

    @GetMapping("/hl/{id}")
    public Result<Orders> henglongOne(@PathVariable("id") Integer id){
        return ExceptionUtil.success(orderRepository.findOne(id),SessionUtil.getRequest().getRemoteAddr(),SessionUtil.getRequest().getMethod());
    }

    @PostMapping("/hl/add")
    public Result<Orders> Add(Orders orders){
        if (orders.getID()!=null) {
            orders.setID(orders.getID());
        }
       orders.setNumber(orders.getNumber());
       orders.setName(orders.getName());
       orders.setBusiness(orders.getBusiness());
       orders.setOrderDate(orders.getOrderDate());
       orders.setMachineModel(orders.getMachineModel());
       orders.setComputingPower(orders.getComputingPower());
       orders.setPowerSupply(orders.getPowerSupply());
       orders.setQUANTITY(orders.getQUANTITY());
       orders.setUnitPrice(orders.getUnitPrice());
       orders.setDeliveryTime(orders.getDeliveryTime());
       orders.setAccountNumber(orders.getAccountNumber());
       orders.setPaymentMethod(orders.getPaymentMethod());
       orders.setPaymentWay(orders.getPaymentWay());
       orders.setHandMan(orders.getHandMan());

       return ExceptionUtil.success(orderRepository.save(orders),SessionUtil.getRequest().getRemoteAddr(),SessionUtil.getRequest().getMethod());

    }

    @GetMapping("/hl/delete/{id}")
    public Result Delete(@PathVariable("id") Integer id){
        orderRepository.delete(id);
        if (orderRepository.findOne(id)==null&&"".equals("")){
            return ExceptionUtil.success("删除成功",SessionUtil.getRequest().getRemoteAddr(),SessionUtil.getRequest().getMethod());
        }else {
            return ExceptionUtil.success("删除失败",SessionUtil.getRequest().getRemoteAddr(),SessionUtil.getRequest().getMethod());
        }

    }
}
