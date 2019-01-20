package com.ifwaxtel.newsapp.util;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;

import com.ifwaxtel.newsapp.R;

import androidx.core.graphics.drawable.DrawableCompat;

/**
 * Created by ifeanyi orji on 21/02/2017.
 */
public class ChangeTint {
    private Context context;
    private Drawable mDrawable;
    private Drawable mWrapperDrawable;

    /**
     * Instantiates a new Change tint.
     *
     * @param context the context
     */
    public ChangeTint(Context context) {
        this.context = context;
    }

    /**
     * Tinted icon drawable.
     *
     * @param icon the icon
     * @return the drawable
     */
    public Drawable tintedIcon(int icon) {
        int iconColor = context.getResources().getColor(R.color.colorPrimaryDark);
        mDrawable = context.getResources().getDrawable(icon);
        mWrapperDrawable = mDrawable.mutate();
        mWrapperDrawable = DrawableCompat.wrap(mWrapperDrawable);
        DrawableCompat.setTint(mWrapperDrawable, iconColor);
        DrawableCompat.setTintMode(mWrapperDrawable, PorterDuff.Mode.SRC_IN);

        return mWrapperDrawable;
    }
}
