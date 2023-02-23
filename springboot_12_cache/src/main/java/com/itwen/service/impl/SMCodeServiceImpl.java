package com.itwen.service.impl;

import com.itwen.pojo.SMCode;
import com.itwen.service.SMCodeService;
import com.itwen.utils.CodeUtils;
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
    @Override
    @Cacheable(value = "smCode", key = "#tel")
    public String sendCodeToSMS(String tel) {
        return codeUtils.codeGenerator(tel);
    }

    @Override
    public boolean checkCode(SMCode smCode) {
        String code = smCode.getCode();
        String cacheCode = codeUtils.getCodeInCache(smCode.getTel());
        return code.equals(cacheCode);
    }


}
