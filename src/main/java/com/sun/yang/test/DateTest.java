package com.sun.yang.test;

import com.sun.yang.utils.DatesUtils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @ClassName DateTest
 * @Description TODO
 * @Author Administrator
 * @Date 2021/12/29
 **/
public class DateTest {
    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        System.out.println("当前时间："+l);
        String s = DatesUtils.formatDate(System.currentTimeMillis());
        System.out.println("日期练好"+s);
//        String s1 = DatesUtils.formatDateTime(l);
//        System.out.println("正常日期："+s1);
//        String s2 = DatesUtils.formatDateHour(l);
//        System.out.println("hour："+s2);
//        String s3 = DatesUtils.formatDateUnderscore(l);
//        System.out.println("年_月_日："+s3);
//        LocalDate date = LocalDate.parse(DatesUtils.formatDate(l,1));
//        System.out.println(date);
//        LocalDateTime date1 = date.atStartOfDay();
//        System.out.println(date1);





    }
}
