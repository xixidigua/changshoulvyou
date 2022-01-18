package com.yida.changshoulvyoudemo.config;


import com.yida.changshoulvyoudemo.web.LoginInterceptor;
import org.apache.ibatis.mapping.DatabaseIdProvider;
import org.apache.ibatis.mapping.VendorDatabaseIdProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Properties;

@Configuration
public class MyConfig implements WebMvcConfigurer {
    //设置数据库厂商提供者
    @Bean
    public DatabaseIdProvider getDatabaseIdProvider(){
        DatabaseIdProvider databaseIdProvider = new VendorDatabaseIdProvider();
        Properties properties = new Properties();
        properties.setProperty("MySQL","mysql");
        properties.setProperty("Oracle","oracle");
        databaseIdProvider.setProperties(properties);
        return databaseIdProvider;
    }

  //  添加一个拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getLoginInterceptor())
                .addPathPatterns("/**") //拦截所有userurl
                .excludePathPatterns("/userLogin","/login","/logout","/**/*.css","/**/*.js","/**/*.jpg","/**/*.png,/**/*.ico");
    }

    @Bean
    public LoginInterceptor getLoginInterceptor() {
        return new LoginInterceptor();
    }
}
