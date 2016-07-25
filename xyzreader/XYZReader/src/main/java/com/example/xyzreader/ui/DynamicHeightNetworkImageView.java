package com.example.xyzreader.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.android.volley.toolbox.NetworkImageView;

public class DynamicHeightNetworkImageView extends ImageView {
    private float mAspectRatio = 1.5f;

    public DynamicHeightNetworkImageView(Context context) {
        super(context);
    }

    public DynamicHeightNetworkImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DynamicHeightNetworkImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setAspectRatio(float aspectRatio) {
        mAspectRatio = aspectRatio;
        requestLayout();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int aspectRatioHeight;
        if (mAspectRatio < 0) {
            aspectRatioHeight = (int) (MeasureSpec.getSize(widthMeasureSpec) * mAspectRatio);
        } else {
            aspectRatioHeight = (int) (MeasureSpec.getSize(widthMeasureSpec) * (1/mAspectRatio));
        }
        int aspectRatioHeightSpec = MeasureSpec.makeMeasureSpec(aspectRatioHeight, MeasureSpec.EXACTLY);
        super.onMeasure(widthMeasureSpec, aspectRatioHeightSpec);
    }
}
