package com.hollysmart.personmodule.adapter;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AlertDialog;

import com.bumptech.glide.Glide;
import com.hollysmart.personmodule.R;
import com.hollysmart.personmodule.activity.BigPicActivity;
import com.hollysmart.personmodule.bean.PicBean;
import com.hollysmart.personmodule.linearlayoutforlistview.LinearLayoutBaseAdapter;
import com.lwkandroid.imagepicker.ImagePicker;
import com.lwkandroid.imagepicker.data.ImagePickType;
import com.lwkandroid.imagepicker.data.ImagePickerCropParams;


import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ItemPicAdater extends LinearLayoutBaseAdapter {
    private Context context;
    private int MAXNUM = 9;
    private int REQUEST_CODE_IMAGE = 99;

    List<PicBean> pics;

    public ItemPicAdater(Context context, List<PicBean> pics) {
        super(context, pics);
        this.context = context;
        this.pics = pics;
    }

    public void setMaxSize(int MAXNUM) {
        this.MAXNUM = MAXNUM;
    }

    @Override
    public int getCount() {
        if (pics.size() == MAXNUM) {
            return pics.size();
        } else {
            return pics.size() + 1;
        }
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public View getView(final int position) {
        View convertView = View.inflate(context, R.layout.person_module_item_pic_list, null);
        ImageView imageView = convertView.findViewById(R.id.photo);
        ImageView iv_del = convertView.findViewById(R.id.iv_del);
        iv_del.setVisibility(View.VISIBLE);

        //判断  最后一个Item是加号
        if (pics.size() != MAXNUM && position == pics.size()) {
            iv_del.setVisibility(View.GONE);
            Glide.with(context)
                    .load(R.mipmap.person_module_add_pic)
                    .centerCrop().into(imageView);

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Activity activity = (Activity) context;
                    new ImagePicker()
                            .pickType(ImagePickType.MULTI)
                            .maxNum(MAXNUM - pics.size())
                            .needCamera(true)
                            .cachePath(context.getCacheDir().getPath())
                            .doCrop(new ImagePickerCropParams())
                            .start(activity, REQUEST_CODE_IMAGE);

                }
            });
        } else {
            final PicBean jdPicInfo = pics.get(position);
            Glide.with(context)
                    .load(new File(jdPicInfo.getFilePath()))
                    .centerCrop().into(imageView);

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                        LogUtils.d("点击了大图");
                    Intent intent = new Intent(context, BigPicActivity.class);
                    intent.putExtra("pics", (Serializable) pics);
                    intent.putExtra("index", position);
                    context.startActivity(intent);
                }
            });


        }
        iv_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setMessage("确定要删除该图片吗？");
                builder.setNegativeButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        pics.remove(position);
                        notifyDataSetChanged();
                    }
                });
                builder.setPositiveButton("取消", null);
                builder.create();
                builder.show();

            }
        });
        return convertView;
    }


}
