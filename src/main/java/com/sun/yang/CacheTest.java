package com.sun.yang;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName CacheTest
 * @Description TODO
 * @Author Administrator
 * @Date 2021/12/13
 **/
public class CacheTest {
    public static void main(String[] args) {
        Cache<Object, Map<String,String>> SIGN_KEY_CACHES = CacheBuilder.newBuilder().maximumSize(10000L).expireAfterWrite(5,TimeUnit.HOURS).build();
        try {
            SIGN_KEY_CACHES.get("allTenants", ()->{
                Map<String,String> ret = new HashMap<>();
                return ret;
            });
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

}
