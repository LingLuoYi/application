package com.henglong.application.Util;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class DocUtil {
    private static Configuration configuration = null;
    private static Map<String, Template> allTemplates = null;

    static {
        configuration = new Configuration();
        configuration.setDefaultEncoding("utf-8");
        try {
            configuration.setDirectoryForTemplateLoading(new File("C:\\application\\src\\main\\java\\com\\henglong\\application\\rtl"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        allTemplates = new HashMap();
        try {
            allTemplates.put("resume", configuration.getTemplate("demo.xml"));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private DocUtil() {
        throw new AssertionError();
    }

    public static File createDoc(Map<?, ?> dataMap, String type) {
        String name = "temp" + (int) (Math.random() * 100000) + ".doc";
        File f = new File("C:\\hostadmin\\apache-tomcat-6.0.37\\webapps\\henglong\\doc\\"+name);
        Template t = allTemplates.get(type);
        try {
            // 这个地方不能使用FileWriter因为需要指定编码类型否则生成的Word文档会因为有无法识别的编码而无法打开
            Writer w = new OutputStreamWriter(new FileOutputStream(f), "utf-8");
            t.process(dataMap, w);
            w.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return f;
    }
}
