package com.example.liuwangshu.moonbutterknife;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/12/10 0010.
 */

public class SwordsmanAdapter extends ArrayAdapter<Swordsman>{
    private int resourceId;
    public SwordsmanAdapter(Context context, int resource, List<Swordsman>list) {
        super(context, resource,list);
        resourceId=resource;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Swordsman swordsman=getItem(position);
        View view;
        ViewHolder viewHolder;
        if(convertView==null){
            view= LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
            viewHolder= new ViewHolder(view);
            view.setTag(viewHolder);
        }else{
            view=convertView;
            viewHolder= (ViewHolder) view.getTag();
        }
        viewHolder.tv_name.setText(swordsman.getName());
        return view;
    }
    class ViewHolder{
        @BindView(R.id.tv_name)
        TextView tv_name;
        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
