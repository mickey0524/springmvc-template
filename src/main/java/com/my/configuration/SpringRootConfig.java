package com.my.configuration;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.*;
import org.springframework.core.io.ClassPathResource;

@Configuration
@ComponentScan(basePackages = "com.my")
@EnableAspectJAutoProxy
@Import(DaoConfig.class)
public class SpringRootConfig {

    @Bean
    public PropertyPlaceholderConfigurer getPpc() {
        PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
        ppc.setLocation(new ClassPathResource("jdbc.properties"));

        return ppc;
    }

}
