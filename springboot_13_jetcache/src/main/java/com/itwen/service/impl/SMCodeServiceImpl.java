package com.itwen.service.impl;

import com.alicp.jetcache.Cache;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.CreateCache;
import com.itwen.pojo.SMCode;
import com.itwen.service.SMCodeService;
import com.itwen.utils.CodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * 作者：24岁没牵过女人的手
 * 日期：2022/12/11 16:06
 * 文件描述：
 */
@Service
public class SMCodeServiceImpl implements SMCodeService {

    @Autowired
    private CodeUtils codeUtils;
    // @CreateCache(area = "sms", name = "jetCache_", expire = 3600, timeUnit = TimeUnit.SECONDS)
    @CreateCache(name = "jetCache_", expire = 3600, timeUnit = TimeUnit.SECONDS, cacheType = CacheType.LOCAL)
    private Cache<String, String> jetCache;
    @Override
    public String sendCodeToSMS(String tel) {
        String code = codeUtils.codeGenerator(tel);
        jetCache.put(tel, code);
        return code;
    }

    @Override
    public boolean checkCode(SMCode smCode) {
        String code = smCode.getCode();
        String cacheCode = jetCache.get(smCode.getTel());
        return code.equals(cacheCode);
    }


}
