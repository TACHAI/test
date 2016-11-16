package com.laohu.administrator.yao20.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.laohu.administrator.yao20.R;

/**
 * Created by Administrator on 2016/10/13.
 */

public class main extends Activity implements View.OnClickListener{
    private Button bn1,bn2,bn3,bn4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        initView();
    }

    private void initView() {
        bn1= (Button) findViewById(R.id.button);
        bn2= (Button) findViewById(R.id.button2);
        bn3= (Button) findViewById(R.id.button3);
        bn4= (Button) findViewById(R.id.button4);
        bn1.setOnClickListener(this);
        bn2.setOnClickListener(this);
        bn3.setOnClickListener(this);
        bn4.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
         switch(v.getId()) {
             case R.id.button:
                 Intent intentfirst=new Intent(main.this,first.class);
                 startActivity(intentfirst);
                 break;
             case R.id.button2:
                 Intent intentsecond=new Intent(main.this,second.class);
                 startActivity(intentsecond);
                 //未完成的代码
                 break;
             case R.id.button3:
                 Intent intentthird=new Intent(main.this,third.class);
                 startActivity(intentthird);
                 //未完成的代码
                 break;
             case R.id.button4:
                 Intent intentfourth=new Intent(main.this,fourth.class);
                 startActivity(intentfourth);
                 //未完成的代码
                 break;
             default:
                 break;

         }



    }
}
