package com.zhanghao.androiddemo.chapter3;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhanghao.androiddemo.R;

import java.util.List;

/**
 * Created by haozhang on 2017/3/5.
 */

public class ChapterAdapter extends ArrayAdapter {

    private int resourceId;

    public ChapterAdapter(@NonNull Context context, @LayoutRes int resource, List<Chapter> objects) {
        super(context, resource, objects);
        this.resourceId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Chapter chapter = (Chapter) getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.imageView = (ImageView) view.findViewById(R.id.imageView);
            viewHolder.textView = (TextView) view.findViewById(R.id.textView);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.imageView.setImageResource(chapter.getImageName());
        viewHolder.textView.setText(chapter.getName());
        return view;
    }

    class ViewHolder {
        ImageView imageView;
        TextView textView;
    }
}