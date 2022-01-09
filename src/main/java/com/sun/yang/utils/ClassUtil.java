package com.sun.yang.utils;

import com.sun.yang.pojo.SuperPO;

/**
 * @ClassName ClassUtil
 * @Description TODO
 * @Author Administrator
 * @Date 2021/12/27
 **/
public class ClassUtil<T extends SuperPO> {

    public boolean checkSameName(T oldObject, T newObject){
        String oldName=oldObject.getCreator();
        String newName=newObject.getCreator();
        if(oldName.equals(newName)){
            return true;
        }
        return false;
    }
}
