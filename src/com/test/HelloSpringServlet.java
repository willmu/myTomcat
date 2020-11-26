package com.test;

import java.io.IOException;

/**
 * @author willmu
 * @date 2020/11/26 14:37
 */
public class HelloSpringServlet extends MyServlet {
    @Override
    protected void doGet(MyRequest myRequest, MyResponse myResponse) {
        try {
            myResponse.write("Get: Hello Spring");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(MyRequest myRequest, MyResponse myResponse) {
        try {
            myResponse.write("Post: Hello Spring");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
