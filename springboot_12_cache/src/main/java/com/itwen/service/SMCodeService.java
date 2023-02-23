package com.itwen.service;

import com.itwen.pojo.SMCode;
import org.springframework.stereotype.Service;

/**
 * 作者：24岁没牵过女人的手
 * 日期：2022/12/11 16:04
 * 文件描述：
 */
public interface SMCodeService {
    String sendCodeToSMS(String tel);

    boolean checkCode(SMCode  smCode);
}
