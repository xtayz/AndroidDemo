package com.zhanghao.androiddemo.chapter10;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by wonderworld on 2017/4/10.
 */

public abstract class CommonRecycleAdapter extends RecyclerView.Adapter<CommonRecycleAdapter.MyViewHolder> {

    private List<Result.SubjectsBean> mDatas;
    private Context mContext;
    private LayoutInflater inflater;

    public CommonRecycleAdapter(Context context, List<Result.SubjectsBean> datas) {
        this.mContext = context;
        this.mDatas = datas;
        inflater = LayoutInflater.from(context);
    }

    public abstract int getLayoutId(int viewType);

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(getLayoutId(viewType), parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

//    @Override
//    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
//        convert((MyViewHolder) holder, mDatas.get(position), position);
//    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        convert(holder, mDatas.get(position), position);
    }

    public abstract void convert(MyViewHolder holder, Result.SubjectsBean data, int position);

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        public MyViewHolder(View itemView) {
            super(itemView);
        }

        @SuppressWarnings("unchecked")
        public <T extends View> T getView(int viewId) {
            View view = itemView.findViewById(viewId);
            return (T) view;
        }

        public MyViewHolder setText(int viewId, String text) {
            TextView tv = getView(viewId);
            tv.setText(text);
            return this;
        }

        public MyViewHolder setImage(int viewId, String imageUrl) {
            SimpleDraweeView sdv = getView(viewId);
            Uri uri = Uri.parse(imageUrl);
            sdv.setImageURI(uri);
            return this;
        }
    }
}
