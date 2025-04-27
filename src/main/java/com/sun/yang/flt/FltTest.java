//package com.sun.yang.flt;
//
//import freemarker.template.Configuration;
//import freemarker.template.Template;
//import freemarker.template.TemplateException;
//import org.apache.commons.io.IOUtils;
//
//import java.io.*;
//import java.nio.charset.StandardCharsets;
//import java.util.*;
//import java.util.stream.Collectors;
//
///**
// * @ClassName FltTest
// * @Description TODO
// * @Author Administrator
// * @Date 2022/1/4
// **/
//public class FltTest {
//    public static void main(String[] args) throws IOException, TemplateException {
////        Map<String,String> childMap=new HashMap<>();
////        Map<String,Map<String,String>> partentMap=new HashMap<>();
////        childMap.put("1","ceshi1");
////        childMap.put("2","ceshi2");
////        partentMap.put("tenantCode1",childMap);
//        List<List<Object>> list=new ArrayList<>();
//        List<Object> l1=new ArrayList<>();
//        l1.add("表格");
//        l1.add("表格1");
//        l1.add("表格2");
//        List<Object> l2=new ArrayList<>();
//        l2.add("1");
//        l2.add("2");
//        Map<String,String> map2=new HashMap<>();
//        map2.put("3","https://www.baidu.com/");
//        l2.add(map2);
//        List<Object> l3=new ArrayList<>();
//        l3.add("2");
//        l3.add("2");
//        Map<String,String> map3=new HashMap<>();
//        map3.put("3","https://www.baidu.com/");
//        l3.add(map3);
//        List<Object> l4=new ArrayList<>();
//        l4.add("2");
//        l4.add("2");
//        Map<String,String> map4=new HashMap<>();
//        map4.put("3","https://www.baidu.com/");
//        l4.add(map4);
//        list.add(l1);
//        list.add(l2);
//        list.add(l3);
//        list.add(l4);
//        String templateName = "alarm-async-callback-fail-collect";
//        Map<String, Object> freemarkerParam = new HashMap<>();
//        freemarkerParam.put("title", "ceshi");
//        freemarkerParam.put("datas", list);
//        String templateContent = IOUtils.toString(Thread.currentThread().getContextClassLoader().getResourceAsStream(templateName + ".ftl"), StandardCharsets.UTF_8);
//        Configuration cfg = new Configuration(Configuration.VERSION_2_3_22);
//        cfg.setDefaultEncoding("UTF-8");
//        Template template = new Template(templateName, templateContent, cfg);
//        StringWriter ret = new StringWriter();
//        template.process(freemarkerParam, ret);
//        test(ret.toString());
//
//    }
//
//    public static void test(String target){
//        File file = new File("D:\\test.html");
//        try {
//            if(!file.exists()) {
//                file.createNewFile();
//            } else {
//                file.delete();
//                file.createNewFile();
//            }
//
//            FileWriter fw = new FileWriter(file, true);
//            BufferedWriter bw = new BufferedWriter(fw);
//
//            List<String> actions = Arrays.asList("riding", "running", "swimming");
//            List<String> userNames = Arrays.asList("lily", "tom", "bob");
//            List<String> times = Arrays.asList("2018-2-2", "2018-3-3");
//
//            bw.write(target);
//            bw.flush();
//            bw.close();
//            fw.close();
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//
//        System.out.println("Write is over");
//    }
//}
