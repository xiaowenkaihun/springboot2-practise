package com.itwen.service.impl;

import com.itwen.pojo.SMCode;
import com.itwen.service.SMCodeService;
import com.itwen.utils.CodeUtils;
import net.oschina.j2cache.CacheChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * 作者：24岁没牵过女人的手
 * 日期：2022/12/11 16:06
 * 文件描述：
 */
@Service
public class SMCodeServiceImpl implements SMCodeService {

    @Autowired
    private CodeUtils codeUtils;
    @Autowired
    private CacheChannel cacheChannel;

    @Override
    public String sendCodeToSMS(String tel) {
        String code = codeUtils.codeGenerator(tel);
        cacheChannel.set("sms", tel, code);
        return code;
    }

    @Override
    public boolean checkCode(SMCode smCode) {
        String code = smCode.getCode();
        String cacheCode = cacheChannel.get("sms", smCode.getTel()).asString();
        return code.equals(cacheCode);
    }


}
