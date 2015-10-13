package com.iit.glid.glidapplication.adapter;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.iit.glid.glidapplication.R;
import com.iit.glid.glidapplication.core.ListItemWrapper;

import java.util.ArrayList;
import java.util.Calendar;

public class CustomListAdapter extends BaseAdapter {


    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private ArrayList<ListItemWrapper> mListContent;


    public CustomListAdapter(Context context, ArrayList<ListItemWrapper> listContent) {
        mContext = context;
        mListContent = listContent;
        //get the layout inflater
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mListContent.size();
    }

    @Override
    public Object getItem(int position) {
        return mListContent.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Log.v("slim", "position to update = " + position);

        long startTime = Calendar.getInstance().getTimeInMillis();

        // best practice
        ViewHolder viewHolder;

        if (convertView == null) {
            Log.v("slim", "convertView==null");
            convertView = mLayoutInflater.inflate(R.layout.custom_view_layout, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.mImageView = (ImageView) convertView.findViewById(R.id.item_image);
            viewHolder.mTitleTextView = (TextView) convertView.findViewById(R.id.item_title);
            viewHolder.mDescriptionTextView = (TextView) convertView.findViewById(R.id.item_description);
            convertView.setTag(viewHolder);

        } else {
            Log.v("slim", "convertView!=null");
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.mImageView.setImageResource(mListContent.get(position).getImageRes());
        viewHolder.mTitleTextView.setText(mListContent.get(position).getTitle());
        viewHolder.mDescriptionTextView.setText(mListContent.get(position).getDescription());

        //Bad version
//        convertView = mLayoutInflater.inflate(R.layout.custom_view_layout, parent, false);
//
//        ImageView mImageView = (ImageView) convertView.findViewById(R.id.item_image);
//        TextView mTitleTextView = (TextView) convertView.findViewById(R.id.item_title);
//        TextView mDescriptionTextView = (TextView) convertView.findViewById(R.id.item_description);
//
//        mImageView.setImageResource(mListContent.get(position).getImageRes());
//        mTitleTextView.setText(mListContent.get(position).getTitle());
//        mDescriptionTextView.setText(mListContent.get(position).getDescription());

        //

        long endTime = Calendar.getInstance().getTimeInMillis();
        Log.v("slim", "-----spent time to update = " + (endTime - startTime));
        return convertView;
    }


    private static class ViewHolder {

        ImageView mImageView;
        TextView mTitleTextView;
        TextView mDescriptionTextView;

    }
}
