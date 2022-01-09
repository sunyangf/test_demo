package com.sun.yang.regular;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName RegularTest
 * @Description TODO
 * @Author Administrator
 * @Date 2021/12/15
 **/
public class RegularTest {
    private static Pattern NOT_FOUNT_PATTERN=Pattern.compile("(?i)(?<=vhost )[^\"]*(?= not)");
    private static Pattern INSIDE_PATTERN=Pattern.compile("^.*?(?=,\"tenantCode)");
    public static void main(String[] args) {
//        String str1 = "method<connection.close>(reply-code=530, reply-text=NOT_ALLOWED - vhost /test11 not found, class-id=10, method-id=40)";
        String temp="{\"eventRecordId\":\"sdmb_distributorGoodsEvent318b85cf-c03c-41de-876b-56e54dd1cc78\",\"sourceId\":\"YXYBASEDOC\",\"eventType\":\"PC_PRODUCT_UPDATE\",\"nodecode\":\"sdmb_distributorGoodsEvent\",\"tenantCode\"";

//        Matcher m = NOT_FOUNT_PATTERN.matcher(str1);
        Matcher m = INSIDE_PATTERN.matcher(temp);
        StringBuilder stringBuilder = new StringBuilder();

        ArrayList<String> list = new ArrayList<String>();
        while (m.find()) {
            stringBuilder.append(m.group().trim()+" ");
//            list.add(m.group().trim()+" ");
        }
        System.out.println(stringBuilder.toString());
    }
}
