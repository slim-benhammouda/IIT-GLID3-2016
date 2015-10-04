package com.iit.glid.glidapplication.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iit.glid.glidapplication.R;
import com.iit.glid.glidapplication.views.CustomView;


public class MainFragment extends Fragment {

    private CustomView mCustomView;

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
        mCustomView = (CustomView) rootView.findViewById(R.id.custom_item);
        mCustomView.setTitleText("this is a title");
        mCustomView.setDescriptionText("this is a description");
        mCustomView.setImageRes(android.R.drawable.ic_delete);

    }
}