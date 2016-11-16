package com.laohu.administrator.yao20.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.laohu.administrator.yao20.R;
import com.laohu.administrator.yao20.model.DRUG;

import java.util.List;

/**
 * Created by Administrator on 2016/10/15.
 */

public class mAdapter extends BaseAdapter {
    private List<DRUG> list;
    Context context;
    public mAdapter(Context context, List<DRUG> list){
        this.context = context;
        this.list=list;
    }
    @Override
    public View getView(final int position, View convertView,
                        ViewGroup parent) {
        mAdapter.ViewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context)
                    .inflate(R.layout.item, null);
            holder = new mAdapter.ViewHolder();
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
            holder = (mAdapter.ViewHolder) convertView.getTag();
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
