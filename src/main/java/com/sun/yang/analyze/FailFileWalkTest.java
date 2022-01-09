package com.sun.yang.analyze;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;


import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
/**
 * @ClassName FailFileWalkTest
 * @Description TODO
 * @Author Administrator
 * @Date 2021/12/22
 **/
public class FailFileWalkTest {
    @Test
    public void testEventSuccess() throws IOException {
        String dir = "C:\\etc\\2021-11";
//        String dir="C:\\Users\\Administrator\\Desktop\\test";
        Map<String, Receiver> stringReceiverMap = acquireResult(dir);
        String allFailIds = String.join(",", stringReceiverMap.keySet());
        Files.write(Paths.get("c:/etc/failids.txt"), allFailIds.getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE);
//        stringReceiverMap.values().stream().forEach(receiver->{
//            System.out.println(receiver.toString()+"\n");
//        });
    }

    public static Map<String, Receiver> acquireResult(String dir) {
        File fileDir = new File(dir);
        File[] noSuccessHtml = fileDir.listFiles((d, name) -> !name.endsWith("success.html"));
        List<File> htmlcollect = Arrays.stream(noSuccessHtml).collect(Collectors.toList());
        List<List<File>> lists = devideList(htmlcollect, 50);
        List<List<String>> resultList = new ArrayList<>();
        lists.parallelStream().forEach(list -> {
            List<String> messageList = new ArrayList<>();
            list.parallelStream().forEach(file -> {
                String content = null;
                try {
                    content = Files.readAllLines(Paths.get(file.toURI()), StandardCharsets.UTF_8).stream().collect(Collectors.joining());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                readTargetHtml(content, messageList);
            });
            resultList.add(messageList);
        });
        Map<String, Receiver> resultMap = new HashMap<>();
        if (CollectionUtils.isNotEmpty(resultList)) {
            System.out.println("一共：" + resultList.size() + "条");
            resultList.stream().forEach(templists -> {
                templists.stream().filter(msg -> null != msg && msg.trim().length() > 0).forEach(message -> {
                    String[] aLiLogDelimiters = message.split("ALiLogDelimiter");
                    String mainMessage="";
                    if(aLiLogDelimiters.length>1){
                        mainMessage = aLiLogDelimiters[1];
                    }else{
                        analyzeMessage(message,resultMap);
                    }
                    if(StringUtils.isNotBlank(mainMessage)){
                        JSONObject jsonObject = null;
                        try {
                            jsonObject = JSONObject.parseObject(mainMessage);
                            Receiver receiver = new Receiver();
                            String eventRecordId = (String) jsonObject.get("eventRecordId");
                            receiver.setEventRecordId(eventRecordId);
                            receiver.setUuid(eventRecordId.substring(eventRecordId.length() - 36, eventRecordId.length()));
                            receiver.setSourceId((String) jsonObject.get("sourceId"));
                            receiver.setEventType((String) jsonObject.get("eventType"));
                            receiver.setNodecode((String) jsonObject.get("nodecode"));
                            resultMap.put(eventRecordId, receiver);
                        } catch (Exception e) {
                            assimbleMap(mainMessage, resultMap);
                        }
                    }
                });
            });
        }
        return resultMap;
    }
    public static void analyzeMessage(String mainMessage,Map<String, Receiver> resultMap){
        if(mainMessage.startsWith("{")&&mainMessage.endsWith("}")){
            JSONObject jsonObject = null;
            try {
                jsonObject = JSONObject.parseObject(mainMessage);
                Receiver receiver = new Receiver();
                String nodecode = (String) jsonObject.get("nodecode");
                String uuid = (String) jsonObject.get("uuid");
                receiver.setNodecode(nodecode);
                receiver.setUuid(uuid);
                receiver.setEventRecordId(nodecode+uuid);
                receiver.setSourceId((String) jsonObject.get("sourceId"));
                receiver.setEventType((String) jsonObject.get("eventType"));
                receiver.setNodecode((String) jsonObject.get("nodecode"));
                resultMap.put(nodecode+uuid, receiver);
            } catch (Exception e) {
                System.out.println("========"+e.getMessage());
            }
        }
    }

    public static void readTargetHtml(String html, List<String> messageList) {
        Document doc = Jsoup.parse(html);
        Elements select = doc.select("div[class=hid_div]");
        if (!Objects.isNull(select)) {
            for (Element element : select) {
                Elements childrens = element.select("p");
                if (childrens.size() > 1) {
                    for (Element child : childrens) {
                        String childmessage = child.select("p").html();
                        messageList.add(childmessage);
                    }
                } else {
                    String message = element.select("p").html();
                    messageList.add(message);
                }


            }

        }
    }

    private static void assimbleMap(String errorMessage, Map<String, Receiver> resultMap) {
        String substring = errorMessage.substring(0, 300);
        String jsonstr = acquireMessage(substring) + "}";
        JSONObject jsonObject = null;
        try {
            jsonObject = JSONObject.parseObject(jsonstr);
            Receiver receiver = new Receiver();
            String eventRecordId = (String) jsonObject.get("eventRecordId");
            receiver.setEventRecordId(eventRecordId);
            receiver.setUuid(eventRecordId.substring(eventRecordId.length() - 36, eventRecordId.length()));
            receiver.setSourceId((String) jsonObject.get("sourceId"));
            receiver.setEventType((String) jsonObject.get("eventType"));
            receiver.setNodecode((String) jsonObject.get("nodecode"));
            resultMap.put(eventRecordId, receiver);
        } catch (Exception e) {
            System.out.println("-------" + e.getMessage());
        }

    }

    private static Pattern INSIDE_PATTERN = Pattern.compile("^.*?(?=,\"tenantCode)");

    private static String acquireMessage(String message) {
        Matcher m = INSIDE_PATTERN.matcher(message);
        StringBuilder stringBuilder = new StringBuilder();
        while (m.find()) {
            stringBuilder.append(m.group().trim() + " ");
        }
        return stringBuilder.toString();
    }


    private static <E> List<List<E>> devideList(List<E> list, int devideNum) {
        List<List<E>> reslist = new ArrayList<>();
        if (list.size() > devideNum) {
            int i = 0;
            int j = devideNum;
            while (true) {
                if (j > list.size()) {
                    j = list.size();
                }
                reslist.add(list.subList(i, j));
                if (j == list.size()) {
                    break;
                }
                i = j;
                j = j + devideNum;
            }
        } else {
            reslist.add(list);
        }

        return reslist;
    }
}
