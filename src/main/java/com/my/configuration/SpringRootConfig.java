package com.my.configuration;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.*;
import org.springframework.core.io.ClassPathResource;

@Configuration
@ComponentScan(basePackages = "com.my")
@EnableAspectJAutoProxy
@Import({DaoConfig.class, RedisConfig.class})
public class SpringRootConfig {

    @Bean
    public PropertyPlaceholderConfigurer getPpc() {
        PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
        ppc.setLocations(new ClassPathResource("jdbc.properties"), new ClassPathResource("redis.properties"));
        return ppc;
    }

}
