package com.zhanghao.androiddemo.chapter4;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zhanghao.androiddemo.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AnotherRightFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AnotherRightFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AnotherRightFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_another_right, container, false);
    }

}
