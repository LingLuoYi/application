package com.henglong.application.Util;

import com.henglong.application.Entity.Orders;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class WordUtil {
    public String Word(Orders orders) throws IOException {
        BarCode.createBarcode(orders.getNumber(),new File("C:/hostadmin/img/1.png"),"");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", orders.getName());
        map.put("kf",orders.getBusiness());
        map.put("rq",orders.getOrderDate());
        map.put("xh",orders.getMachineModel());
        map.put("shl",orders.getComputingPower());
        map.put("dy",orders.getPowerSupply());
        map.put("sl",orders.getQUANTITY());
        map.put("dj",orders.getUnitPrice());
        map.put("fh",orders.getDeliveryTime());
        map.put("z",orders.getAccountNumber());
        map.put("fs",orders.getPaymentMethod());
        map.put("fkxl",orders.getPaymentWay());
        map.put("jsr",orders.getHandMan());
        map.put("data",new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        map.put("img",BarCode.getImageString("C:/hostadmin/img/1.png"));

        File file = null;
        InputStream fin = null;
        ServletOutputStream out = null;
        try {
            file = DocUtil.createDoc(map, "resume");
            fin = new FileInputStream(file);
            FileOutputStream fs = new FileOutputStream("C:\\hostadmin\\apache-tomcat-6.0.37\\webapps\\henglong\\doc\\"+orders.getName()+".doc");
            byte[] buffer = new byte[512];  // 缓冲区
            int bytesToRead = -1;
            while((bytesToRead = fin.read(buffer)) != -1) {
                fs.write(buffer, 0, bytesToRead);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(fin != null) fin.close();
            if(out != null) out.close();
            if(file != null) file.delete(); // 删除临时文件
            return orders.getName();
        }
    }

}
