package com.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author willmu
 * @date 2020/11/26 14:07
 */
public class ServletMappingConfig {
    public static List<ServletMapping> servletMappingList = new ArrayList<>();
    static {
        servletMappingList.add(new ServletMapping("helloSpring", "/spring", "com.test.HelloSpringServlet"));
        servletMappingList.add(new ServletMapping("helloBoot", "/boot", "com.test.HelloBootServlet"));
    }
}
