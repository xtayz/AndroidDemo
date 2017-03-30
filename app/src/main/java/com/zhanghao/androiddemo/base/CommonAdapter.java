package com.zhanghao.androiddemo.base;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by wonderworld on 2017/3/28.
 */

public abstract class CommonAdapter<T> extends BaseAdapter {

    private List<T> mDataSource;
    private Context mContext;

    public CommonAdapter(Context mContext, List<T> mDataSource) {
        this.mContext = mContext;
        this.mDataSource = mDataSource;
    }

    public abstract int getLayoutId(int i);

    @Override
    public int getCount() {
        return mDataSource.size();
    }

    @Override
    public T getItem(int i) {
        return mDataSource.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup){
        ViewHolder holder = ViewHolder.get(mContext, view, viewGroup, getLayoutId(i), i);
        convert(holder, getItem(i), i);
        return holder.getConvertView();
    }

    public abstract void convert(ViewHolder holder, T data, int position);

    public static class ViewHolder {

        private SparseArray<View> mViews;
        private View mConvertView;

        public ViewHolder(Context context, ViewGroup parent, int layoutId) {
            this.mViews = new SparseArray<>();
            this.mConvertView = LayoutInflater.from(context).inflate(layoutId, parent, false);
            mConvertView.setTag(this);
        }

        public static ViewHolder get(Context context, View convertView, ViewGroup parent, int layoutId, int position) {
            if (convertView == null) {
                return new ViewHolder(context, parent, layoutId);
            } else {
                return (ViewHolder) convertView.getTag();
            }
        }

        public View getConvertView() {
            return mConvertView;
        }

        public <T extends View> T getView(int viewId) {
            View view = mViews.get(viewId);
            if (view == null) {
                view = mConvertView.findViewById(viewId);
                mViews.put(viewId, view);
            }
            return (T) view;
        }

        public ViewHolder setText(int viewId, String text) {
            TextView tv = getView(viewId);
            tv.setText(text);
            return this;
        }
    }
}
