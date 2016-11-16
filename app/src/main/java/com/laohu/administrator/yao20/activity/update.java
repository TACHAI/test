package com.laohu.administrator.yao20.activity;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.laohu.administrator.yao20.R;
import com.laohu.administrator.yao20.db.dbOpenHelper;
import com.laohu.administrator.yao20.model.DRUG;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

/**
 * Created by Administrator on 2016/10/12.
 */

public class update extends Activity {
    private dbOpenHelper dbhelper;
    private Button BN;
    private String GITHUB;
    static final String TB_NAME="drug_tb";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.update);
        BN= (Button) findViewById(R.id.bn_update);
        dbhelper=new dbOpenHelper(this,"drug_db",null,2);
        BN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db=dbhelper.getWritableDatabase();
                db.delete(TB_NAME,null,null);
                Toast.makeText(update.this,"加载数据中...",Toast.LENGTH_SHORT).show();
                final BmobQuery<DRUG> query = new BmobQuery<DRUG>();
                //查询AAA字段的值含有11的数据查出来：就是将所有的数据查出来；
                query.addWhereEqualTo("AAA","11");
                //query.addWhereContains("NAME", ET.getText().toString().trim());
                query.setLimit(1000);
                //执行查询方法
                query.findObjects(new FindListener<DRUG>() {
                    @Override
                    public void done(List<DRUG> list, BmobException e) {
                        if (e == null) {
//                    mMsgListView= (ListView) findViewById(R.id.list_view01);
//                    myadapter=new first.Myadapter(first.this,list);
//                    mMsgListView.setAdapter( myadapter);
//                    Toast.makeText(first.this, "查询成功：共" + list.size() + "条数据。", Toast.LENGTH_LONG).show();
//                    //打开或创建数据库

                            SQLiteDatabase db=dbhelper.getWritableDatabase();

                            // db.execSQL(createTable);

                            for (DRUG drug : list) {
                                ContentValues values=new ContentValues(5);
                                values.put("NAME",drug.getNAME());
                                values.put("CLASSES",drug.getCLASSES());
                                values.put("EFFECT",drug.getEFFECT());
                                values.put("FLAVOR_MERIDIAN",drug.getFLAVOR_MERIDIAN());
                                values.put("SUBCLASS",drug.getSUBCLASS());
                                db.insert(TB_NAME,null,values);


                            }

                            Log.d("first","成功插入数据");

                        } else {
                            Log.i("bmob", "失败：" + e.getMessage() + "," + e.getErrorCode());
                        }
                    }


                });


                Intent intent1=new Intent(update.this,main.class);
                startActivity(intent1);
                db.close();
                finish();
            }
        });
    }




}
