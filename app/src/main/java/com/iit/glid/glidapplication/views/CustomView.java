package com.iit.glid.glidapplication.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.iit.glid.glidapplication.R;


public class CustomView extends RelativeLayout {


    private TextView mTitle;
    private TextView mDescription;
    private ImageView mImage;

    public CustomView(Context context) {
        this(context, null);
    }


    public CustomView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initViews(context);
    }

    private void initViews(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.custom_view_layout, this);


        mTitle = (TextView) view.findViewById(R.id.item_title);
        mDescription = (TextView) view.findViewById(R.id.item_description);
        mImage= (ImageView)view.findViewById(R.id.item_image);
    }

    public void setTitleText(String text) {
        mTitle.setText(text);
    }

    public void setDescriptionText(String text) {
        mDescription.setText(text);
    }

    public String getTitleText() {
        return mTitle.getText().toString();
    }

    public String getDescriptionText() {
        return mDescription.getText().toString();
    }


    public void setImageRes(int drawableResId) {
        mImage.setImageResource(drawableResId);
    }

    public Drawable getImageDrawable() {
        return mImage.getDrawable();
    }

}
