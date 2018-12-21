package com.spring.config;


import com.spring.formatters.CustomerFormatter;
import com.spring.repository.CustomerRepository;
import org.apache.catalina.filters.RemoteIpFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import java.time.Duration;

/**
 *Servlet filter to integrate HTTP headers.
 */

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    CustomerRepository customerRepository;



    /*
    Filter Logic
     */
    @Bean
    public RemoteIpFilter remoteIpFilter(){
        return new RemoteIpFilter();
    }


    /*
    Web Interceptor Logic
     */
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor(){
        return new LocaleChangeInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }


    /*
    Web Converter logic
    Support all media types by default
     */
    @Bean
    public ByteArrayHttpMessageConverter byteArrayHttpMessageConverter() {
        return new ByteArrayHttpMessageConverter();
    }


    /*
    Formatter Logic
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new CustomerFormatter(customerRepository));
    }

    /*
    Pattern Matching
     */

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        //configurer.setUseSuffixPatternMatch(false): This method indicates that we don't want to use the .* suffix,
        //so as to strip the trailing characters after the last dot.
        configurer.setUseSuffixPatternMatch(false)
                .setUseTrailingSlashMatch(true);

    }


    /*
    Let's say that we want to expose our internal application.properties file via the static web URL
    http://localhost:8080/internal/application.properties from our application.
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/internal/**")
                .addResourceLocations("classpath:/");
    }


    @Bean
    public ServletWebServerFactory servletWebServerFactory(){
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
        tomcat.getSession().setTimeout(Duration.ofMinutes(1));
        return tomcat;
    }

}
