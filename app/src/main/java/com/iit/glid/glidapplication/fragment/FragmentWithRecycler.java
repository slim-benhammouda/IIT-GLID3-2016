package com.iit.glid.glidapplication.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.iit.glid.glidapplication.R;
import com.iit.glid.glidapplication.adapter.CustomListAdapter;
import com.iit.glid.glidapplication.adapter.CustomRecyclerAdapter;
import com.iit.glid.glidapplication.core.ListItemWrapper;

import java.util.ArrayList;


public class FragmentWithRecycler extends Fragment {

    private RecyclerView mRecyclerView;
    private ArrayList<ListItemWrapper> mContentList;


    public FragmentWithRecycler() {
    }

    public static FragmentWithRecycler newInstance() {

        return new FragmentWithRecycler();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_recycler, container, false);
        initViews(rootView);
        return rootView;
    }


    private void initViews(View rootView) {
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recycler);
        mContentList = new ArrayList<ListItemWrapper>();
        fillContentList();

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        CustomRecyclerAdapter recyclerAdpater = new CustomRecyclerAdapter(getActivity().getApplicationContext(), mContentList);
        mRecyclerView.setAdapter(recyclerAdpater);
    }


    private void fillContentList() {
        for (int i = 0; i < 10000; i++) {
            mContentList.add(new ListItemWrapper(android.R.drawable.ic_delete, "item " + i, "description " + i));
        }
    }
}