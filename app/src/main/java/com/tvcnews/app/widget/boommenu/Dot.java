package com.tvcnews.app.widget.boommenu;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;

import com.tvcnews.app.R;


/**
 * Created by Weiping on 2016/3/19.
 */
public class Dot extends View {
    /**
     * Instantiates a new Dot.
     *
     * @param context the context
     */
    public Dot(Context context) {
        this(context, null);
    }

    /**
     * Instantiates a new Dot.
     *
     * @param context the context
     * @param attrs   the attrs
     */
    public Dot(Context context, AttributeSet attrs) {
        super(context, attrs);
        setBackgroundResource(R.drawable.dot);
    }

    /**
     * Sets color.
     *
     * @param color the color
     */
    public void setColor(int color) {
        ((GradientDrawable)getBackground()).setColor(color);
    }

}
