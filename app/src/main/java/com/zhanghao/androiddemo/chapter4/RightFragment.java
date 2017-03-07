package com.zhanghao.androiddemo.chapter4;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zhanghao.androiddemo.R;

/**
 * Created by wonderworld on 2017/3/7.
 */

public class RightFragment extends Fragment {

    public static final String TAG = "RightFragment";

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(TAG, "=================================");
        Log.d(TAG, new Exception().getStackTrace()[0].getMethodName());
        Log.d(TAG, "=================================");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "=================================");
        Log.d(TAG, new Exception().getStackTrace()[0].getMethodName());
        Log.d(TAG, "=================================");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.right_fragment, container, false);
        Log.d(TAG, "=================================");
        Log.d(TAG, new Exception().getStackTrace()[0].getMethodName());
        Log.d(TAG, "=================================");
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, "=================================");
        Log.d(TAG, new Exception().getStackTrace()[0].getMethodName());
        Log.d(TAG, "=================================");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "=================================");
        Log.d(TAG, new Exception().getStackTrace()[0].getMethodName());
        Log.d(TAG, "=================================");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "=================================");
        Log.d(TAG, new Exception().getStackTrace()[0].getMethodName());
        Log.d(TAG, "=================================");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "=================================");
        Log.d(TAG, new Exception().getStackTrace()[0].getMethodName());
        Log.d(TAG, "=================================");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "=================================");
        Log.d(TAG, new Exception().getStackTrace()[0].getMethodName());
        Log.d(TAG, "=================================");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "=================================");
        Log.d(TAG, new Exception().getStackTrace()[0].getMethodName());
        Log.d(TAG, "=================================");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "=================================");
        Log.d(TAG, new Exception().getStackTrace()[0].getMethodName());
        Log.d(TAG, "=================================");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "=================================");
        Log.d(TAG, new Exception().getStackTrace()[0].getMethodName());
        Log.d(TAG, "=================================");
    }

}
