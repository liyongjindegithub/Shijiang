package com.bawei.presentor;

import android.text.TextUtils;

import com.bawei.listener.LoginListener;
import com.bawei.model.IModel;
import com.bawei.model.LoginModel;
import com.bawei.view.IView;
import com.bawei.view.IloginView;

import java.lang.ref.WeakReference;

public class LoginPresentor extends BasePresentor {

//    private IloginView mLoginView;
    private LoginModel mModel;
    public LoginPresentor(IloginView loginView){
        this.mModel=new LoginModel();
        this.viewReference=  new WeakReference<IView>(loginView);
    }
    public void login(){
        if(viewReference==null)return;
        if (viewReference.get()==null)return;

        final IloginView mLoginView= (IloginView) viewReference.get();
        String userName=mLoginView.getUserName();
        String userPwd=mLoginView.getUserPwd();

        if(TextUtils.isEmpty(userName)){
            // TODO
            return;
        } else if(TextUtils.isEmpty(userPwd)){
            // TODO
            return;
        }

        if(mModel==null) return;

        this.mModel.login(userName, userPwd, new LoginListener() {
            @Override
            public void onSuccess() {
                mLoginView.onLoginSuccess();
            }

            @Override
            public void onFail() {
                mLoginView.onLoginFail();
            }
        });



    }
}
