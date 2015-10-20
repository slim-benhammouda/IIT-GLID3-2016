package com.iit.glid.glidapplication.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.iit.glid.glidapplication.R;
import com.iit.glid.glidapplication.adapter.CustomListAdapter;
import com.iit.glid.glidapplication.adapter.CustomRecyclerAdapter;
import com.iit.glid.glidapplication.core.ListItemWrapper;
import com.iit.glid.glidapplication.fragment.dialog.AddDialogFragment;

import java.util.ArrayList;


public class FragmentWithRecycler extends Fragment implements AddDialogFragment.OnAddFragmentInteractionListener {

    private RecyclerView mRecyclerView;
    private CustomRecyclerAdapter mRecyclerAdpater;
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
        setHasOptionsMenu(true);
        return rootView;
    }


    private void initViews(View rootView) {
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recycler);
        mContentList = new ArrayList<ListItemWrapper>();
        //fillContentList();

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerAdpater = new CustomRecyclerAdapter(getActivity().getApplicationContext(), mContentList);
        mRecyclerView.setAdapter(mRecyclerAdpater);
    }


    private void fillContentList() {
        for (int i = 0; i < 10000; i++) {
            mContentList.add(new ListItemWrapper(android.R.drawable.ic_delete, "item " + i, "description " + i));
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_list:
                Log.v("IIT", "action_list clicked in fragment");
                break;
            case R.id.action_recycler:
                Log.v("IIT", "action_recycler clicked");
                break;
            case R.id.action_add:
                AddDialogFragment addDialogFragment = AddDialogFragment.newInstance(this);
                addDialogFragment.show(getFragmentManager(), "");
                break;


        }


        return true;
    }

    @Override
    public void onOk(String title, String description) {
        Log.v("IIT", "recycler fragment with title = " + title);
        ListItemWrapper listItemWrapper = new ListItemWrapper(android.R.drawable.ic_delete, title, description);
        mContentList.add(0,listItemWrapper);
        mRecyclerAdpater.notifyItemInserted(0);
    }

    @Override
    public void onCancel() {

    }
}