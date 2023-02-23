package com.itwen.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 作者：24岁没牵过女人的手
 * 日期：2022/11/30 16:10
 * 文件描述：
 */
@Data
// @Component
@ConfigurationProperties(prefix = "servers")
public class ServletConfig {
    private String ipAddress;
    private int port;
    private long timeout;
}
