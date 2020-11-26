package com.test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author willmu
 * @date 2020/11/26 14:14
 */
public class MyRequest {
    private String url;
    private String method;

    public MyRequest(InputStream inputStream) throws IOException {
        byte[] httpRequestByte = new byte[1024];
        int length = inputStream.read(httpRequestByte);
        if(length > 0) {
            String httpRequest = new String(httpRequestByte, 0 , length);
            String httpHead = httpRequest.split("\n")[0];
            url = httpHead.split("\\s")[1];
            method = httpHead.split("\\s")[0];
            System.out.println(httpRequest);
        }
    }

    public String getUrl() {
        return url;
    }

    public String getMethod() {
        return method;
    }
}
