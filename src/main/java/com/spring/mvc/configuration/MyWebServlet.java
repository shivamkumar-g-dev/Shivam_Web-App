package com.spring.mvc.configuration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class MyWebServlet implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext ctx) throws ServletException {

        AnnotationConfigWebApplicationContext annWebConfig = new AnnotationConfigWebApplicationContext();

        annWebConfig.register(SpringConfig.class);
        annWebConfig.setServletContext(ctx);

        ServletRegistration.Dynamic servlet = ctx.addServlet("dispatcher", new DispatcherServlet(annWebConfig));

        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");
    }
}







//
//<?xml version="1.0" encoding="UTF-8"?>
//
//<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
//         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
//         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee
//         http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
//         version="4.0">
//
//    <display-name>Shivam_Web-App</display-name>
//
//    <servlet>
//        <servlet-name>spring</servlet-name>
//        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
//        <init-param>
//            <param-name>contextConfigLocation</param-name>
//            <param-value>/WEB-INF/spring-servlet.xml</param-value>
//        </init-param>
//        <load-on-startup>1</load-on-startup>
//    </servlet>
//
//    <servlet-mapping>
//        <servlet-name>spring</servlet-name>
//        <url-pattern>/</url-pattern>
//    </servlet-mapping>
//
//</web-app>