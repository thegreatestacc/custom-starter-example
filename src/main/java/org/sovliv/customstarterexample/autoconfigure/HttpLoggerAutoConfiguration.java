package org.sovliv.customstarterexample.autoconfigure;

import org.sovliv.customstarterexample.filter.HttpLoggingFilter;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;

/**
 * @author Vladimir Solovyov
 * @project custom-starter-example
 * @date on 03/08/2025
 */

@AutoConfiguration
@ConditionalOnProperty(prefix = "http.logger", name = "enabled", havingValue = "true")
@EnableConfigurationProperties(HttpLoggerProperties.class)
public class HttpLoggerAutoConfiguration {

    @Bean
    public FilterRegistrationBean<HttpLoggingFilter> loggingFilter(HttpLoggerProperties props) {
        FilterRegistrationBean<HttpLoggingFilter> registration = new FilterRegistrationBean<>();
        registration.setFilter(new HttpLoggingFilter(props));
        registration.addUrlPatterns("/*");
        registration.setOrder(Ordered.LOWEST_PRECEDENCE);
        return registration;
    }
}
