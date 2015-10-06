package com.iit.glid.glidapplication.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iit.glid.glidapplication.R;
import com.iit.glid.glidapplication.views.CustomView;


public class MainFragment extends Fragment {

    private CustomView mCustomView1;
    private CustomView mCustomView2;
    private CustomView mCustomView3;

    public MainFragment() {
    }

    public static MainFragment newInstance() {

        return new MainFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        initViews(rootView);
        return rootView;
    }


    private void initViews(View rootView) {
        mCustomView1 = (CustomView) rootView.findViewById(R.id.custom_item_1);

        mCustomView2 = (CustomView) rootView.findViewById(R.id.custom_item_2);
        mCustomView2.setTitleText("this is a title");
        mCustomView2.setDescriptionText("this is a description");
        mCustomView2.setImageRes(android.R.drawable.ic_btn_speak_now);

        mCustomView3 = (CustomView) rootView.findViewById(R.id.custom_item_3);
        mCustomView3.setTitleText("this is a title");
        mCustomView3.setDescriptionText("this is a description");
        mCustomView3.setImageRes(android.R.drawable.ic_media_next);

    }
}