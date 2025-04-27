package com.sun.yang.ognl;

import com.sun.yang.pojo.Cat;
import lombok.SneakyThrows;

import ognl.Ognl;
import ognl.OgnlContext;
import org.junit.Test;
import java.util.HashMap;
import java.util.StringJoiner;

public class OgnlTest {
    @Test
    @SneakyThrows
    public void test(){
        StringJoiner sj = new StringJoiner(",");
        sj.add("Java");
        sj.add("Python");
        sj.add("C++");
        System.out.println(sj);

    }
}
