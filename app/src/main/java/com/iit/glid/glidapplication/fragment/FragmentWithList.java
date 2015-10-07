package com.iit.glid.glidapplication.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.iit.glid.glidapplication.R;
import com.iit.glid.glidapplication.views.CustomView;


public class FragmentWithList extends Fragment {

    private ListView mListView;


    public FragmentWithList() {
    }

    public static FragmentWithList newInstance() {

        return new FragmentWithList();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_list, container, false);
        initViews(rootView);
        return rootView;
    }


    private void initViews(View rootView) {
        mListView = (ListView) rootView.findViewById(R.id.list);
    }
}