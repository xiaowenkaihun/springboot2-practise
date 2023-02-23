package com.itwen.service.impl;

import com.itwen.service.MsgService;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * 作者：24岁没牵过女人的手
 * 日期：2022/12/10 15:07
 * 文件描述：
 */

@Service
public class MsgServiceImpl implements MsgService {

    private HashMap<String, String> cache = new HashMap<String, String>();

    @Override
    public String get(String tel) {
        String code = tel.substring(tel.length() - 6);
        cache.put(tel, code);
        return code;
    }

    @Override
    public boolean check(String tel, String code) {
        String queryCode = cache.get(tel);
        return queryCode.equals(code);
    }
}
