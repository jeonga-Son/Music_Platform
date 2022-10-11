package com.ll.exam.app__2022_10_11.app;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Getter
    // ApplicationContext는 해당 애플리케이션에 대한 구성정보를 제공하는 인터페이스이다.
    // 애플리케이션에 대한 구성정보라는 것은 등록한 Bean에 대한 또한 포함이어서 특정 타입의 Bean의 리스트(Test 객체를 상속 받은 하위 객체까지 전부)를 가져온다거나 하는 등 Bean의 정보를 가져올 수 있다.
    private static ApplicationContext context;

    private static String activeProfile;

    @Getter
    private static String siteName;

    @Getter
    private static String siteBaseUrl;

    @Autowired
    public void setContext(ApplicationContext context) {
        AppConfig.context = context;
    }

    @Value("${spring.profiles.active:}")
    public void setActiveProfile(String value) {
        activeProfile = value;
    }

    @Value("${custom.site.name}")
    public void setSiteName(String siteName) {
        AppConfig.siteName = siteName;
    }

    @Value("${custom.site.baseUrl}")
    public void setSiteBaseUrl(String siteBaseUrl) {
        AppConfig.siteBaseUrl = siteBaseUrl;
    }

    public static boolean isNotProd() {
        return isProd() == false;
    }

    public static boolean isProd() {
        return activeProfile.equals("prod");
    }

    public static boolean isNotDev() {
        return isLocal() == false;
    }

    public static boolean isLocal() {
        return activeProfile.equals("local");
    }

    public static boolean isNotTest() {
        return isLocal() == false;
    }

    public static boolean isTest() {
        return activeProfile.equals("test");
    }

    // 스프링부트를 사용하는 경우 직접 ObjectMapper를 생성해서 사용하지 않고 스프링부트가 등록 해주는 ObjectMapper 빈을 주입받아 사용하면
    // 아무런 추가 작업 없이 LocalDateTime 타입을 직렬화/역직렬화 할 수 있다.
    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper().registerModule(new JavaTimeModule()); //JavaTimeModule 등록
    }
}