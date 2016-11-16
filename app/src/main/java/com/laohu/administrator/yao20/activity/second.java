package com.laohu.administrator.yao20.activity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.laohu.administrator.yao20.R;
import com.laohu.administrator.yao20.adapter.mAdapter;
import com.laohu.administrator.yao20.db.dbOpenHelper;
import com.laohu.administrator.yao20.model.DRUG;

import java.util.ArrayList;
import java.util.List;

public class second extends AppCompatActivity {
    private dbOpenHelper dbHelper;
    private mAdapter mAdapter;
    private ListView listView;
    static final String TB_NAME = "drug_tb";
    private Spinner spinner;
    private String[] res = {
            "发汗解表",
            "解表散寒",
            "疏散风热",
            "清热燥湿",
            "清热解毒",
            "清热凉血",
            "利水消肿",
            "利尿通淋",
            "利湿退黄",
            "利尿通淋",
            "解毒消肿",
            "行气止痛",
            "健脾消食",
            "杀虫消积",
            "凉血止血",
            "消食健胃",
            "涩精止遗",
            "收敛止血",
            "化瘀利尿",
            "活血止痛",
            "活血调经",
            "清热化痰"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        spinner = (Spinner) findViewById(R.id.spinner);
        dbHelper=new dbOpenHelper(this,"drug_db",null,2);
        spinner.setAdapter(new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, res));
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                 SQLiteDatabase db=dbHelper.getReadableDatabase();
               // SQLiteDatabase db = dbHelper.getReadableDatabase();
                List<DRUG> list = new ArrayList<DRUG>();

                //Cursor cursor=db.
                Cursor cursor = db.query(TB_NAME, null, "EFFECT like ?",
                        new String[]{"%" + res[position] + "%"}, null, null, null);
                if (cursor.moveToFirst()) {
                    do {
                        DRUG drug = new DRUG();
                        //drug.setObjectId(cursor.getString(cursor.getColumnIndex("id")));
                        drug.setNAME(cursor.getString(cursor.getColumnIndex("NAME")));
                        drug.setCLASSES(cursor.getString(cursor.getColumnIndex("CLASSES")));
                        drug.setEFFECT(cursor.getString(cursor.getColumnIndex("EFFECT")));
                        drug.setFLAVOR_MERIDIAN(cursor.getString(cursor.getColumnIndex("FLAVOR_MERIDIAN")));
                        drug.setSUBCLASS(cursor.getString(cursor.getColumnIndex("SUBCLASS")));
                        list.add(drug);

                    } while (cursor.moveToNext());
                }
                if (cursor != null) {
                    cursor.close();

                }
                // mMsgListView= (ListView) findViewById(R.id.list_view01);
                listView = (ListView) findViewById(R.id.list_view02);
                mAdapter = new mAdapter(second.this, list);
                listView.setAdapter(mAdapter);
                db.close();
                Log.d("first", "成功插数据");


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });
    }
}





