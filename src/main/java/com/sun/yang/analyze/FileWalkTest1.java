package com.sun.yang.analyze;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @ClassName FileWalkTest1
 * @Description TODO
 * @Author Administrator
 * @Date 2021/12/21
 **/
public class FileWalkTest1 {
    private static final String prefix = "\\{\"eventRecordId\":\"";
    private static final String suffix = "\",\"sourceId";
    private static final Pattern pattern = Pattern.compile("(?:" + prefix + ")(.*)(?:" + suffix + ")");

    @Test
    public void testRegex() {
        Matcher matcher = pattern.matcher("back_cost ALiLogDelimiter{\"eventRecordId\":\"write_back_costf0e6e16b-cc4d-448a-8f0b-aff144e5c084\",\"sourceId\":\"USTOCK\",\"eventType\":\"WRITE_BACK_COST\",\"nodecode\":\"write_back_cost\",\"tenantCode\":\"itgmuybk\",\"status\":\"success\",\"url\":\"rpc://ustock-service-extend@c87e2267-1001-4c70-bb2a-ab41f3b81aa3/eventFiInfoReceiveService\",\"userObject\":\"{\\\"enterTime\\\":1635695376540,\\\"eventType\\\":\\\"WRITE_BACK_COST\\\",\\\"isEOS\\\":0,\\\"sourceID\\\":\\\"USTOCK\\\",\\\"tenantCode\\\":\\\"itgmuybk\\\",\\\"transfer\\\":true,\\\"userObject\\\":\\\"[{\\\\\\\"vouchType\\\\\\\":4,\\\\\\\"costUnitPrice\\\\\\\":13.50000000,\\\\\\\"costMoney\\\\\\\":108.00000000,\\\\\\\"id\\\\\\\":2498483325653249}]\\\",\\\"uuid\\\":\\\"f0e6e16b-cc4d-448a-8f0b-aff144e5c084\\\"}\",\"enterTime\":\"Oct 31, 2021 11:49:36 PM\",\"endTime\":\"Oct 31, 2021 11:49:36 PM\",\"returnMsg\":\"{\\\"success\\\":true,\\\"msg\\\":\\\"[]\\\"}\",\"retryTimes\":0,\"historyResult\":\"[{\\\"costMillTimes\\\":13,\\\"requestTime\\\":1635695376544,\\\"response\\\":\\\"{\\\\\\\"success\\\\\\\":true,\\\\\\\"msg\\\\\\\":\\\\\\\"[]\\\\\\\"}\\\",\\\"resultType\\\":0}]\"} 2021-10-31 23:47:36.400 ERROR [rabbitmq-task-consumer-26] [c.y.i.e.s.i.EventRecordALiLogServiceImpl] [399ae5d33e14e393] [ab4bcac161e59bb1] [399ae5d33e14e393] [cr] [] [] [] [spring.domain.name_IS_UNDEFINED,spring.application.name_IS_UNDEFINED,,,,,] - eventRecordIdwrite_back_cost3593488c-19af-470a-af9d-4270e585ca9f sourceIdUSTOCK eventTypeWRITE_BACK_COST tenantCodeitgmuybk statussuccess nodecodewrite_back_cost ALiLogDelimiter{\"eventRecordId\":\"write_back_cost3593488c-19af-470a-af9d-4270e585ca9f\",\"sourceId\":\"USTOCK\",\"eventTyp");
        while (matcher.find()) {
            String id = matcher.group(0);
            System.err.println(id);
            System.out.println(id.substring(prefix.length(), id.length() - suffix.length()));
        }
    }

    @Test
    public void testEventSuccess() throws IOException {
        String dir = "D:\\eventCenter\\eventcenter202112\\eventcenter";
        File fileDir = new File(dir);

        Set<String> allSuccessIds = new HashSet<>();
        File[] successHtml = fileDir.listFiles((d, name) -> name.endsWith("-success.html"));
        List<String> errorList=new ArrayList<>();
        for (File file : successHtml) {
            List<String> lines=null;
            try{
                lines=Files.readAllLines(Paths.get(file.toURI()), StandardCharsets.UTF_8);
            }catch(Exception e){
                errorList.add(file.getName());
                System.out.println("====="+file.getName());
                e.printStackTrace();
            }
            if(CollectionUtils.isNotEmpty(lines)){
                lines.stream().forEach(l -> {
                    Matcher matcher = pattern.matcher(l);
                    if (matcher.find()) {
                        String id = matcher.group();
                        id = id.substring(prefix.length()-1, id.length() - suffix.length());
                        if(!allSuccessIds.add(id)) {
                            System.err.println(id);
                        }
                    }
                });
            }
//            System.out.println(file);

        }
        String allSuccessIdStr = String.join(",", allSuccessIds);
        System.out.println(allSuccessIdStr);
        System.out.println(errorList.toString());
//        Files.write(Paths.get("c:/etc/success.txt"),allSuccessIdStr.getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE);
    }

    @Test
    public void testEventFail() throws IOException {
        String dir = "C:\\etc\\2021-11";
        File fileDir = new File(dir);

        File[] successHtml = fileDir.listFiles((d, name) -> name.length() == 19);
        for (File file : successHtml) {
            String content = Files.readAllLines(Paths.get(file.toURI()), StandardCharsets.UTF_8).stream().collect(Collectors.joining());
            System.out.println(content);
        }
    }

}
