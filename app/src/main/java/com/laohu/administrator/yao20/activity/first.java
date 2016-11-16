package com.laohu.administrator.yao20.activity;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.laohu.administrator.yao20.R;
import com.laohu.administrator.yao20.db.dbOpenHelper;
import com.laohu.administrator.yao20.model.DRUG;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Administrator on 2016/9/27.
 */

public class first extends Activity {
 private Myadapter myadapter;
  private   ListView mMsgListView;
    private dbOpenHelper dbHelper;
    static final String TB_NAME="drug_tb";
    EditText ET;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.first);
        dbHelper=new dbOpenHelper(this,"drug_db",null,2);
        ET= (EditText) findViewById(R.id.chaxun);
    }
    public void  CHAXUN(View view) {


        if (ET.getText().toString().trim()!=null) {
            //写SQL语句
           // new Thread(){
               // @Override
                //public void run() {
                    SQLiteDatabase db=dbHelper.getReadableDatabase();
                    List<DRUG> list=new ArrayList<DRUG>();
                    Log.d("first","成功插数据");
                    //Cursor cursor=db.
                     Cursor cursor=db.query(TB_NAME,null,"NAME like ?",
                        new String[]{"%"+ET.getText().toString().trim()+"%"},  null, null,null);
                     if(cursor.moveToFirst()){
                        do {
                        DRUG drug=new DRUG();
                        //drug.setObjectId(cursor.getString(cursor.getColumnIndex("id")));
                        drug.setNAME(cursor.getString(cursor.getColumnIndex("NAME")));
                        drug.setCLASSES(cursor.getString(cursor.getColumnIndex("CLASSES")));
                        drug.setEFFECT(cursor.getString(cursor.getColumnIndex("EFFECT")));
                        drug.setFLAVOR_MERIDIAN(cursor.getString(cursor.getColumnIndex("FLAVOR_MERIDIAN")));
                        drug.setSUBCLASS(cursor.getString(cursor.getColumnIndex("SUBCLASS")));

                            list.add(drug);

                        }while (cursor.moveToNext());
                     }
                    if(cursor!=null){
                    cursor.close();
                 }

                //return list;
                mMsgListView= (ListView) findViewById(R.id.list_view01);
                myadapter=new Myadapter(first.this,list);
                mMsgListView.setAdapter( myadapter);
            //item里面的点击事件返回的值
//            mMsgListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                @Override
//                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                    TextView text = (TextView) view.findViewById(R.id.NAME_i);
//                    String AA=text.getText().toString();
//                    Toast.makeText(first.this, AA, Toast.LENGTH_SHORT).show();
//
//                }
//            });
            db.close();
               // }
           /* }.start();*/
        } else {
            Toast.makeText(first.this, "搜索框不能为空，请输入关键字", Toast.LENGTH_SHORT).show();
        }

    }

    private class Myadapter extends BaseAdapter {
        private List<DRUG> list;
        Context context;
        public Myadapter(Context context,List<DRUG> list){
            this.context = context;
            this.list=list;
        }
        @Override
        public View getView(final int position, View convertView,
                            ViewGroup parent) {
            ViewHolder holder = null;
            if (convertView == null) {
                convertView = LayoutInflater.from(context)
                        .inflate(R.layout.item, null);
                holder = new ViewHolder();
                holder.NAME = (TextView) convertView
                        .findViewById(R.id.NAME_i);
                holder.CLASS = (TextView) convertView
                        .findViewById(R.id.CLASS_i);
                holder.EFFECT = (TextView) convertView
                        .findViewById(R.id.EFFECT_i);
                holder.FLAVOR_MERIDIAN = (TextView) convertView
                        .findViewById(R.id.FLAVOR_MERIDIAN_i);
                holder.SUBCLASS = (TextView) convertView
                        .findViewById(R.id.SUBCLASS_i);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            DRUG drug = (DRUG) getItem(position);
            holder.NAME.setText(drug.getNAME());
            holder.CLASS.setText(drug.getCLASSES());
            holder.EFFECT.setText(drug.getEFFECT());
            holder.FLAVOR_MERIDIAN.setText(drug.getFLAVOR_MERIDIAN());
            holder.SUBCLASS.setText(drug.getSUBCLASS());
            return convertView;
        }
        class ViewHolder {
            TextView NAME;
            TextView CLASS;
            TextView EFFECT;
            TextView FLAVOR_MERIDIAN;
            TextView SUBCLASS;
        }

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return position;
        }

    }


}
