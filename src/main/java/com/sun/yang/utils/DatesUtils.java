package com.sun.yang.utils;

import java.time.*;
import java.time.format.DateTimeFormatter;

/**
*@ClassName DatesUtils
*@Description TODO
*@Author Administrator
*@Date 2021/12/29
**/
public class DatesUtils {

    public static final DateTimeFormatter TABLE_SUFFIX_FORMATTER = DateTimeFormatter.ofPattern("_yyyy_MM_dd");
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd");
    public static final DateTimeFormatter DATE_FORMATTER_UNDERSCORE = DateTimeFormatter.ofPattern("yyyy_MM_dd");
    public static final DateTimeFormatter DATE_FORMATTER_MIDCOURT = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static final DateTimeFormatter DATETIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public static final DateTimeFormatter DATETIME_HOUR = DateTimeFormatter.ofPattern("HH");
    public static final ZoneId ZONE_ID = ZoneId.of("Asia/Shanghai"); // .systemDefault();


    public static String formatDateTime(Long mills) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(mills), ZONE_ID).format(DATETIME_FORMATTER);
    }
    public static String formatDateTimeMinusMinute(Long mills,int minusMinutes) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(mills), ZONE_ID).minusMinutes(minusMinutes).format(DATETIME_FORMATTER);
    }
    public static String formatDate(Long mills) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(mills), ZONE_ID).format(DATE_FORMATTER);
    }
    public static String formatDateHour(Long mills) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(mills), ZONE_ID).format(DATETIME_HOUR);
    }
    public static String formatDate(Long mills, int minusDays) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(mills), ZONE_ID).minusDays(minusDays).format(DATE_FORMATTER);
    }
    public static String formatDateMinus(Long mills, int minusDays) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(mills), ZONE_ID).minusDays(minusDays).format(DATETIME_FORMATTER);
    }
    public static String formatDateUnderscore(Long mills) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(mills), ZONE_ID).format(DATE_FORMATTER_UNDERSCORE);
    }
    public static String formatDateMidcourt(Long mills) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(mills), ZONE_ID).format(DATE_FORMATTER_MIDCOURT);
    }
    public static String formatDateMidcourtMinusDays(Long mills,int minusDays) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(mills), ZONE_ID).minusDays(minusDays).format(DATE_FORMATTER_MIDCOURT);
    }
    public static String formatTableSuffix(Long mills) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(mills), ZONE_ID).format(TABLE_SUFFIX_FORMATTER);
    }

    public static Long parseDate(String date) {
        return LocalDate.parse(date, DATE_FORMATTER).atStartOfDay(ZONE_ID).toEpochSecond() * 1000L;
    }

    public static long startMills(LocalDate localDate) {
        return localDate.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    public static long endMills(LocalDate localDate) {
        return localDate.atTime(LocalTime.MAX).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    public static long toMills(LocalDateTime localDateTime) {
        return localDateTime.atZone(DatesUtils.ZONE_ID).toInstant().toEpochMilli();
    }

    public static LocalDateTime currDateTime() {
        return LocalDateTime.now(DatesUtils.ZONE_ID);
    }

    public static LocalDate currDate() {
        return LocalDate.now(DatesUtils.ZONE_ID);
    }

    public static void main(String[] args) {
//        long l=System.currentTimeMillis();
//        System.out.println("formatDateTime:"+formatDateTime(l));
//        System.out.println("formatDateTimeMinusMinute:"+formatDateTimeMinusMinute(l,10));
//        System.out.println("formatDate:"+formatDate(l));
//        System.out.println("formatDateHour:"+formatDateHour(l));
//        System.out.println("formatDateMinus:"+formatDateMinus(l,1));
//        System.out.println("formatDateMidcourt:"+formatDateMidcourt(l));
//        System.out.println("formatDateMidcourtMinusDays:"+formatDateMidcourtMinusDays(l,1));
        long l1 = System.currentTimeMillis();
        long now =l1 - 10 * 60 * 1000;
        System.out.println("now:"+now);
        System.out.println(formatDateTime(l1));
        System.out.println(formatDateTime(now));


    }

}