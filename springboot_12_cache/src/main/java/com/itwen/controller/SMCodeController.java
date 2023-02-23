package com.itwen.controller;

import com.itwen.pojo.SMCode;
import com.itwen.service.SMCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 作者：24岁没牵过女人的手
 * 日期：2022/12/11 16:07
 * 文件描述：
 */
@RequestMapping("/sms")
@RestController
public class SMCodeController {
    @Autowired
    private SMCodeService smCodeService;

    @GetMapping("/{tel}")
    public String getCode( @PathVariable String tel){

        return smCodeService.sendCodeToSMS(tel);
    }

    @PostMapping()
    public boolean checkCode(SMCode smCode){
        return smCodeService.checkCode(smCode);
    }
}
