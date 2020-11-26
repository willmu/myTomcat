package com.test;

/**
 * @author willmu
 * @date 2020/11/26 14:29
 */
public abstract class MyServlet {
    /** 模板方法
     * @param myRequest
     * @param myResponse
     */
    public void service(MyRequest myRequest, MyResponse myResponse) {
        if(myRequest.getMethod().equalsIgnoreCase("POST")){
            doPost(myRequest, myResponse);
        } else if (myRequest.getMethod().equalsIgnoreCase("GET")) {
            doGet(myRequest, myResponse);
        }
    }

    /** 子类实现doGet
     * @param myRequest
     * @param myResponse
     */
    protected abstract void doGet(MyRequest myRequest, MyResponse myResponse);

    /** 子类实现doPost
     * @param myRequest
     * @param myResponse
     */
    protected abstract void doPost(MyRequest myRequest, MyResponse myResponse);
}
