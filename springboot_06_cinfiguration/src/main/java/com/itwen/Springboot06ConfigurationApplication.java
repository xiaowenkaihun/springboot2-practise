package com.itwen;

import com.alibaba.druid.pool.DruidDataSource;
import com.itwen.config.ServletConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
// 开启Configuration，并且不能和@Component冲突
@EnableConfigurationProperties(ServletConfig.class)
public class Springboot06ConfigurationApplication {
    @Bean
    @ConfigurationProperties(prefix = "datasource")
    public DruidDataSource dataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        return druidDataSource;
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(Springboot06ConfigurationApplication.class, args);
        ServletConfig bean = ctx.getBean(ServletConfig.class);
        System.out.println(bean);
        DruidDataSource bean1 = ctx.getBean(DruidDataSource.class);
        System.out.println(bean1.getDriverClassName());
    }

}
