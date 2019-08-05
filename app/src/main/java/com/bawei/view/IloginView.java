package com.bawei.view;

public interface IloginView extends IView{
    public String getUserName();
    public String getUserPwd();

    public void onLoginSuccess();
    public void onLoginFail();
}
