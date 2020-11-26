package com.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * @author willmu
 * @date 2020/11/26 13:31
 */
public class MyTomcat {
    private int port = 8080;

    private Map<String,String> urlServletMapping = new HashMap<>();

    public MyTomcat() {
    }

    public MyTomcat(int port) {
        this.port = port;
    }

    public void start() {
        // 1 初始化 url与对应servlet的关系
        initUrlServletMapping();
        // 2 接收socket accept
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("MyTomcat is starting... Port:"+port);
            while(true) {
                Socket socket = serverSocket.accept();
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();

                MyRequest myRequest = new MyRequest(inputStream);
                MyResponse myResponse = new MyResponse(outputStream);

                // 3 请求分发
                dispatch(myRequest, myResponse);

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        // 4 响应结果
    }

    private void dispatch(MyRequest myRequest, MyResponse myResponse) {
        String clazz = urlServletMapping.get(myRequest.getUrl());
        //反射
        try {
            Class<MyServlet> myServletClass = (Class<MyServlet>) Class.forName(clazz);
            MyServlet myServlet = myServletClass.newInstance();
            myServlet.service(myRequest, myResponse);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void initUrlServletMapping() {
        for(ServletMapping servletMapping: ServletMappingConfig.servletMappingList) {
            urlServletMapping.put(servletMapping.getUrl(), servletMapping.getClazz());
        }
    }

    public static void main(String[] args) {
        new MyTomcat().start();
    }
}
