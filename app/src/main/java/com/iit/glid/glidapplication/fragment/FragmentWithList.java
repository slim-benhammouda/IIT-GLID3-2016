package com.iit.glid.glidapplication.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.iit.glid.glidapplication.R;
import com.iit.glid.glidapplication.adapter.CustomListAdapter;
import com.iit.glid.glidapplication.core.ListItemWrapper;
import com.iit.glid.glidapplication.views.CustomView;

import java.util.ArrayList;


public class FragmentWithList extends Fragment {

    private ListView mListView;
    private ArrayList<ListItemWrapper> mContentList;



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
        mContentList = new ArrayList<>();
        fillContentList();
        CustomListAdapter listAdpater = new CustomListAdapter(getActivity().getApplicationContext(),mContentList);
        mListView.setAdapter(listAdpater);
    }


    private void fillContentList(){
        for(int i =0;i < 10000;i++){
            mContentList.add(new ListItemWrapper(android.R.drawable.ic_delete,"item "+i,"description "+i));
        }
    }
}