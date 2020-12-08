package com.NATE.utils;

import org.junit.jupiter.api.Test;

import java.util.UUID;

@SuppressWarnings("all")  // 抑制警告
public class IDutils {

    public static String getId(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }


    @Test
    public void test(){
        System.out.println(IDutils.getId());
        System.out.println(IDutils.getId());
        System.out.println(IDutils.getId());
    }


}
