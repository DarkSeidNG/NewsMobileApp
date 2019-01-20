package com.ifwaxtel.newsapp.util;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;

import com.ifwaxtel.newsapp.R;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


/**
 * The type Divider.
 */
public class Divider extends RecyclerView.ItemDecoration {

    //This saves the Drawable divider the seperate our recyclerView
    private Drawable mDivider;

    private int mOrientation;

    /**
     * Contructor to set up the Divider class
     *
     * @param context     the context
     * @param orientation the orientation
     */
    public Divider(Context context, int orientation) {
        mDivider = ContextCompat.getDrawable(context, R.drawable.divider);

        if (orientation != LinearLayoutManager.VERTICAL) {
            throw new IllegalArgumentException("This item Decoration can be used only with a recycler view that uses a linear layout manager");
        }

        mOrientation = orientation;
    }


    /**
     * this overrides RecyclerView.onItemDecoration draw method to draw the divider below the recycler view
     *
     * @param c
     * @param parent
     * @param state
     */
    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {

        if (mOrientation == LinearLayoutManager.VERTICAL) {
            drawHorizontalDivider(c, parent, state);
        }
    }

    /**
     * This is to calculate where to draw the divider
     *
     * @param c
     * @param parent
     * @param state
     */
    private void drawHorizontalDivider(Canvas c, RecyclerView parent, RecyclerView.State state) {
        int left, right, top, bottom;
        left = parent.getPaddingLeft();
        right = parent.getWidth() - parent.getPaddingRight();
        int count = parent.getChildCount();

        for (int i = 0; i < count; i++) {
            View current = parent.getChildAt(i);
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) current.getLayoutParams();
            top = current.getBottom() + params.bottomMargin;
            bottom = top + mDivider.getIntrinsicHeight();
            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(c);
        }

    }

    /**
     * Draw the divider below the recycler view zrow
     *
     * @param outRect
     * @param view
     * @param parent
     * @param state
     */
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        if (mOrientation == LinearLayoutManager.VERTICAL) {
            outRect.set(0, 0, 0, mDivider.getIntrinsicHeight());
        }
    }
}
