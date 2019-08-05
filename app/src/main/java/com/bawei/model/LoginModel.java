package com.bawei.model;

import com.bawei.listener.LoginListener;

public class LoginModel implements IModel {

    public void login(String userName, String pwd, LoginListener loginListener){
        //TODO 请求网络
        if(loginListener==null)return;
        if("admin".equals(userName)&&"123456".equals(pwd)){
            loginListener.onSuccess();
        }else{
            loginListener.onFail();
        }
    }
}
