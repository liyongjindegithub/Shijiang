package com.bawei.demo;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bawei.presentor.LoginPresentor;
import com.bawei.view.IloginView;

public class MainActivity extends Activity implements IloginView,View.OnClickListener {

    private LoginPresentor loginPresentor;
    private EditText etUserName;
    private EditText etUserPwd;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        this.initView();
        this.initPresentor();
    }

    public void initView(){
        etUserName=findViewById(R.id.userName);
        etUserPwd=findViewById(R.id.usePwd);
        btnLogin=findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);
    }

    private void initPresentor(){
        loginPresentor=new LoginPresentor(this);
    }

    private LoginPresentor getPresentor(){
        if (loginPresentor==null){
            loginPresentor=new LoginPresentor(this);
        }
        return loginPresentor;
    }


    @Override
    public String getUserName() {
        return etUserName.getText().toString();
    }

    @Override
    public String getUserPwd() {
        return etUserPwd.getText().toString();
    }

    @Override
    public void onLoginSuccess() {
        Toast.makeText(this,"login success",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onLoginFail() {
        Toast.makeText(this,"login fail",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginPresentor=null;
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btnLogin){
            getPresentor().login();
        }
    }
}
