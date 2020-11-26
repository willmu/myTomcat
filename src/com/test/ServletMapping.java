package com.test;

/**
 * @author willmu
 * @date 2020/11/26 14:08
 */
public class ServletMapping {
    private String serviceName;
    private String url;
    private String clazz;

    public ServletMapping(String serviceName, String url, String clazz) {
        this.serviceName = serviceName;
        this.url = url;
        this.clazz = clazz;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }
}
