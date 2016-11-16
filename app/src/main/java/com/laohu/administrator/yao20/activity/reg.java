package com.laohu.administrator.yao20.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.laohu.administrator.yao20.R;
import com.laohu.administrator.yao20.model.User;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by Administrator on 2016/9/26.
 */

public class reg extends Activity implements View.OnClickListener{
    private EditText et_name,et_password;
    private Button bn_login,bn_reg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.reg);
        initView();

    }
    private void initView(){
        et_name= (EditText) findViewById(R.id.et_name);
        et_password= (EditText) findViewById(R.id.et_password);
        bn_login= (Button) findViewById(R.id.denlv);
        bn_reg= (Button) findViewById(R.id.zhuche);
        bn_login.setOnClickListener(this);
        bn_reg.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.denlv:
                Intent intent=new Intent(reg.this,Login.class);
                startActivity(intent);

                break;
            case R.id.zhuche:
                User user=new User();
                user.setUsername(et_name.getText().toString().trim());
                user.setPassword(et_password.getText().toString().trim());
                user.setInfo("drug");
                user.signUp(new SaveListener<Object>() {
                    @Override
                    public void done(Object o, BmobException e) {
                        if(e==null){
                            Toast.makeText(reg.this,"注册成功",Toast.LENGTH_SHORT).show();


                        }else {
                            Toast.makeText(reg.this,"注册失败"+e.getMessage(),Toast.LENGTH_SHORT).show();


                        }

                    }
                });

                break;
            default:
                break;


        }

    }
}
