package com.itwen;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 作者：24岁没牵过女人的手
 * 日期：2022/11/24 16:02
 * 文件描述：
 */
@Data()
@AllArgsConstructor
@NoArgsConstructor
@Component
@ConfigurationProperties(prefix = "datasource")
public class MyDataSource {
    private String driver;
    private String url;
    private String username;
    private String password;
}