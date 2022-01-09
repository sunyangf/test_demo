package com.sun.yang.regular;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName RegexMatchesReplace
 * @Description TODO
 * @Author Administrator
 * @Date 2021/12/17
 **/
public class RegexMatchesReplace {
    private static String REGEX = "a*b";
    private static String INPUT = "aabfooaabfooabfoobkkk";
    private static String REPLACE = "-";
    public static void main(String[] args) {
        Pattern p = Pattern.compile(REGEX);
        // 获取 matcher 对象
        Matcher m = p.matcher(INPUT);
        StringBuffer sb = new StringBuffer();
        while(m.find()){
            m.appendReplacement(sb,REPLACE);
        }
        m.appendTail(sb);
        System.out.println(sb.toString());
    }
}
