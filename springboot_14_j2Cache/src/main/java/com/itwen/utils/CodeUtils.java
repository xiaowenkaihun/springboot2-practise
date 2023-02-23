package com.itwen.utils;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * 作者：24岁没牵过女人的手
 * 日期：2022/12/11 16:12
 * 文件描述：
 */

@Component
public class CodeUtils {

    private String [] patch = {"00000", "0000", "000", "00", "0", ""};

    public String codeGenerator(String tel){
        int hash = tel.hashCode();
        int encryption = 2020666;
        long result = hash ^ encryption;
        long nowTime = System.currentTimeMillis();
        result = result ^ nowTime;
        long code = result % 1000000;
        code  = code < 0 ? -code : code;
        String codeStr = code + "";
        int length = codeStr.length();
        return patch[length-1]+codeStr;
    }


    public static void main(String[] args) {
        CodeUtils codeUtils = new CodeUtils();
        String s = codeUtils.codeGenerator("1842384792387");
        System.out.println(s);
    }
}
