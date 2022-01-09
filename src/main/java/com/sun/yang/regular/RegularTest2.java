package com.sun.yang.regular;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ClassName RegularTest2
 * @Description TODO
 * @Author Administrator
 * @Date 2021/12/24
 **/
public class RegularTest2 {
    private static Pattern p1=Pattern.compile("\\(.*\\)");
    private static Pattern p2=Pattern.compile("(?i)(?<=\\()[^\"]*(?=\\))");
    public static void main(String[] args) {
        String str="com.yonyou.iuap.yms.entry.TestForError.<init>(Ljava/lang/String;Ljava/lang/String;)V";
        String[] split1 = str.split(".<init>");
        System.out.println("构造："+split1[0]);
        Matcher m = p2.matcher(str);
        StringBuilder stringBuilder = new StringBuilder();
        while (m.find()) {
            stringBuilder.append(m.group().trim()+"");
//            list.add(m.group().trim()+" ");
        }
        String tyemp = stringBuilder.toString().replace("/",".");
        String[] split = tyemp.split(";");
        String collect = Arrays.stream(split).map(parameter -> parameter.substring(1, parameter.length()-1)).collect(Collectors.joining(",","(",")"));
        System.out.println(collect);

    }
}
