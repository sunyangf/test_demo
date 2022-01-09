package com.sun.yang.flt;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.yang.pojo.Data1;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName FltTest1
 * @Description TODO
 * @Author Administrator
 * @Date 2022/1/5
 **/
public class FltTest1 {
    public static void main(String[] args) throws IOException, TemplateException {
        Data1 data1 = new Data1(1,"ceshi1",12);
        Data1 data2 = new Data1(1,"ceshi1",12);
        List<Data1> datalist=new ArrayList<>();
        datalist.add(data1);
        datalist.add(data2);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(datalist);
        Map<String, Object> freemarkerParam = new HashMap<>();
        freemarkerParam.put("title", "ceshi");
        freemarkerParam.put("text", json);
        String templateContent = IOUtils.toString(Thread.currentThread().getContextClassLoader().getResourceAsStream( "event_alarm.ftl"), StandardCharsets.UTF_8);
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_22);
        cfg.setDefaultEncoding("UTF-8");
        Template template = new Template("event_alarm", templateContent, cfg);
        StringWriter ret = new StringWriter();
        template.process(freemarkerParam, ret);
        System.out.println(ret);
    }
}
