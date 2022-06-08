package com.hollysmart.personmodule.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.hollysmart.personmodule.R;
import com.hollysmart.personmodule.bean.PersonFuncItemBean;

import java.util.List;

public class ItemFuncRecyclerViewAdapter extends RecyclerView.Adapter<ItemFuncRecyclerViewAdapter.ViewHolder>{
    private List<PersonFuncItemBean> mList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        View myView;
        ImageView imageView;
        TextView title;
        public ViewHolder(View itemView) {
            super(itemView);
            myView = itemView;
            imageView = (ImageView) itemView.findViewById(R.id.iv_image);
            title = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }

    public ItemFuncRecyclerViewAdapter(List<PersonFuncItemBean> list){
        this.mList = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.person_module_item_func_list,null);
        final ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    //将数据绑定到控件上
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        PersonFuncItemBean bean = mList.get(position);
        holder.imageView.setBackgroundResource(bean.getIconResource());
        holder.title.setText(bean.getItemName());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    //下面两个方法提供给页面刷新和加载时调用
    public void add(List<PersonFuncItemBean> addMessageList) {
        //增加数据
        int position = mList.size();
        mList.addAll(position, addMessageList);
        notifyItemInserted(position);
    }

    public void refresh(List<PersonFuncItemBean> newList) {
        //刷新数据
        mList.removeAll(mList);
        mList.addAll(newList);
        notifyDataSetChanged();
    }
}