package com.my.common;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

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
