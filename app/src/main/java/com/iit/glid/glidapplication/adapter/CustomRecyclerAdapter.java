package com.iit.glid.glidapplication.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.iit.glid.glidapplication.R;
import com.iit.glid.glidapplication.core.ListItemWrapper;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by slim on 13/10/15.
 */
public class CustomRecyclerAdapter extends
        RecyclerView.Adapter<CustomRecyclerAdapter.ItemViewHolder> {

    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private ArrayList<ListItemWrapper> mObjectsList;

    public CustomRecyclerAdapter(Context context,ArrayList<ListItemWrapper> itemsList) {

        mContext=context;
        mLayoutInflater =  (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mObjectsList = itemsList;
        Log.v("slim", "constructor:mObjectsList.size() = "+mObjectsList.size());

    }

    @Override
    public int getItemCount() {

        return mObjectsList.size();
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.v("slim","onCreateViewHolder called");
        // create a new view
        View view =mLayoutInflater.inflate(
                R.layout.custom_view_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        // ... Nothing to do
        ItemViewHolder viewholder = new ItemViewHolder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        long startTime = Calendar.getInstance().getTimeInMillis();
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.mItemTitle.setText(mObjectsList.get(position).getTitle());
        holder.mItemDescription.setText(mObjectsList.get(position).getDescription());
        holder.mItemIcon.setImageResource(mObjectsList.get(position)
                .getImageRes());
        long endTime = Calendar.getInstance().getTimeInMillis();
        Log.v("slim", "-----spent time to update = " + (endTime - startTime));
    }

    // Provide a reference to the views for each data item
    public static class ItemViewHolder extends RecyclerView.ViewHolder {

        public TextView mItemTitle;
        public TextView mItemDescription;
        public ImageView mItemIcon;

        public ItemViewHolder(View view) {
            super(view);
            mItemTitle = (TextView) view.findViewById(R.id.item_title);
            mItemDescription = (TextView) view.findViewById(R.id.item_description);
            mItemIcon = (ImageView) view.findViewById(R.id.item_image);

        }
    }

}