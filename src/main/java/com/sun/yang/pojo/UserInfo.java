package com.sun.yang.pojo;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * @ClassName UserInfo
 * @Description TODO
 * @Author Administrator
 * @Date 2022/1/7
 **/
@Builder(toBuilder = true)
@Getter
@ToString
public class UserInfo {
    private String name;
    private String email;
}
