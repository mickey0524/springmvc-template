package com.my.common;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ListenerTest implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("servlet listener init");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("servlet listener destory");
    }
}
