package com.laohu.administrator.yao20.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.laohu.administrator.yao20.R;
import com.laohu.administrator.yao20.db.dbOpenHelper;
import com.laohu.administrator.yao20.model.Conf;
import com.laohu.administrator.yao20.model.User;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by Administrator on 2016/9/26.
 */

public class Login extends Activity implements View.OnClickListener{
    private dbOpenHelper dbhelper;
    private EditText et_name,et_password;
    //private TextView textView,textView1;
    private Button bn_login,bn_reg ,bn_update;
    static final String TB_NAME="drug_tb";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.lojin);
        Bmob.initialize(this, Conf.APP_ID);
        //dbhelper=new dbOpenHelper(this,"drug_db",null,2);
        initView();
        bn_update= (Button) findViewById(R.id.bn_update);
        bn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent6=new Intent(Login.this,main.class);
                startActivity(intent6);


            }
        });

    }
   private void initView(){
       et_name= (EditText) findViewById(R.id.et_name);
       et_password= (EditText) findViewById(R.id.et_password);
       bn_login= (Button) findViewById(R.id.bn_login);
       bn_reg= (Button) findViewById(R.id.bn_reg);
       bn_login.setOnClickListener(this);
       bn_reg.setOnClickListener(this);
   }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bn_login:
                User user=new User();
                user.setUsername(et_name.getText().toString().trim());
                user.setPassword(et_password.getText().toString().trim());
                user.login(new SaveListener<Object>() {
                    @Override
                    public void done(Object o, BmobException e) {
                        if(e==null){
                            Toast.makeText(Login.this,"登录成功",Toast.LENGTH_SHORT).show();
                           Intent intent1=new Intent(Login.this,update.class);
                           startActivity(intent1);
                            finish();


                        }else {
                            Toast.makeText(Login.this,"登录失败",Toast.LENGTH_SHORT).show();


                        }

                    }
                });
                break;
            case R.id.bn_reg:
                Intent intent=new Intent(Login.this,reg.class);
                startActivity(intent);
                finish();
                break;
            default:
                break;


        }

    }
}
