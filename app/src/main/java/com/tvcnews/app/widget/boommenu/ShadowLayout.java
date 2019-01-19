package com.tvcnews.app.widget.boommenu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import com.tvcnews.app.R;


/**
 * The type Shadow layout.
 */
public class ShadowLayout extends FrameLayout {

    private int ShadowColor;
    private int OriginalShadowColor;
    private float mShadowRadius;
    private float mCornerRadius;
    private float mDx;
    private float mDy;

    private boolean mInvalidateShadowOnSizeChanged = true;
    private boolean mForceInvalidateShadow = false;

    /**
     * Instantiates a new Shadow layout.
     *
     * @param context the context
     */
    public ShadowLayout(Context context) {
        super(context);
        initView(context, null);
    }

    /**
     * Instantiates a new Shadow layout.
     *
     * @param context the context
     * @param attrs   the attrs
     */
    public ShadowLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    /**
     * Instantiates a new Shadow layout.
     *
     * @param context      the context
     * @param attrs        the attrs
     * @param defStyleAttr the def style attr
     */
    public ShadowLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context, attrs);
    }

    @Override
    protected int getSuggestedMinimumWidth() {
        return 0;
    }

    @Override
    protected int getSuggestedMinimumHeight() {
        return 0;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if(w > 0 && h > 0 && (getBackground() == null || mInvalidateShadowOnSizeChanged || mForceInvalidateShadow)) {
            mForceInvalidateShadow = false;
            setBackgroundCompat(w, h);
        }
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (mForceInvalidateShadow) {
            mForceInvalidateShadow = false;
            setBackgroundCompat(right - left, bottom - top);
        }
    }

    /**
     * Sets invalidate shadow on size changed.
     *
     * @param invalidateShadowOnSizeChanged the invalidate shadow on size changed
     */
    public void setInvalidateShadowOnSizeChanged(boolean invalidateShadowOnSizeChanged) {
        mInvalidateShadowOnSizeChanged = invalidateShadowOnSizeChanged;
    }

    /**
     * Invalidate shadow.
     */
    public void invalidateShadow() {
        mForceInvalidateShadow = true;
        requestLayout();
        invalidate();
    }

    private void initView(Context context, AttributeSet attrs) {
        initAttributes(context, attrs);

        int xPadding = (int) (mShadowRadius + Math.abs(mDx));
        int yPadding = (int) (mShadowRadius + Math.abs(mDy));
        setPadding(xPadding, yPadding, xPadding, yPadding);
    }

    @SuppressWarnings("deprecation")
    private void setBackgroundCompat(int w, int h) {
        Bitmap bitmap = createShadowBitmap(w, h, mCornerRadius, mShadowRadius, mDx, mDy, ShadowColor, Color.TRANSPARENT);
        BitmapDrawable drawable = new BitmapDrawable(getResources(), bitmap);
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.JELLY_BEAN) {
            setBackgroundDrawable(drawable);
        } else {
            setBackground(drawable);
        }
    }


    private void initAttributes(Context context, AttributeSet attrs) {
        TypedArray attr = getTypedArray(context, attrs, R.styleable.ShadowLayout);
        if (attr == null) {
            return;
        }

        try {
            mCornerRadius = attr.getDimension(R.styleable.ShadowLayout_sl_cornerRadius, getResources().getDimension(R.dimen.default_corner_radius));
            mShadowRadius = attr.getDimension(R.styleable.ShadowLayout_sl_shadowRadius, getResources().getDimension(R.dimen.default_shadow_radius));
            mDx = attr.getDimension(R.styleable.ShadowLayout_sl_dx, 0);
            mDy = attr.getDimension(R.styleable.ShadowLayout_sl_dy, 0);
            OriginalShadowColor = ShadowColor
                    = attr.getColor(R.styleable.ShadowLayout_sl_shadowColor,
                    ContextCompat.getColor(context, R.color.default_shadow_color));
        } finally {
            attr.recycle();
        }
    }

    private TypedArray getTypedArray(Context context, AttributeSet attributeSet, int[] attr) {
        return context.obtainStyledAttributes(attributeSet, attr, 0, 0);
    }

    private Bitmap createShadowBitmap(int shadowWidth, int shadowHeight, float cornerRadius, float shadowRadius,
                                      float dx, float dy, int shadowColor, int fillColor) {

        Bitmap output = Bitmap.createBitmap(shadowWidth, shadowHeight, Bitmap.Config.ALPHA_8);
        Canvas canvas = new Canvas(output);

        RectF shadowRect = new RectF(
                shadowRadius,
                shadowRadius,
                shadowWidth - shadowRadius,
                shadowHeight - shadowRadius);

        if (dy > 0) {
            shadowRect.top += dy;
            shadowRect.bottom -= dy;
        } else if (dy < 0) {
            shadowRect.top += Math.abs(dy);
            shadowRect.bottom -= Math.abs(dy);
        }

        if (dx > 0) {
            shadowRect.left += dx;
            shadowRect.right -= dx;
        } else if (dx < 0) {
            shadowRect.left += Math.abs(dx);
            shadowRect.right -= Math.abs(dx);
        }

        Paint shadowPaint = new Paint();
        shadowPaint.setAntiAlias(true);
        shadowPaint.setColor(fillColor);
        shadowPaint.setStyle(Paint.Style.FILL);

        if (!isInEditMode()) {
            shadowPaint.setShadowLayer(shadowRadius, dx, dy, shadowColor);
        }

        canvas.drawRoundRect(shadowRect, cornerRadius, cornerRadius, shadowPaint);

        return output;
    }

    /**
     * Sets shadow color.
     *
     * @param shadowColor the shadow color
     */
    public void setShadowColor(int shadowColor) {
        this.ShadowColor = shadowColor;
        invalidate();
    }

    /**
     * Gets original shadow color.
     *
     * @return the original shadow color
     */
    public int getOriginalShadowColor() {
        return OriginalShadowColor;
    }

    /**
     * Gets shadow color.
     *
     * @return the shadow color
     */
    public int getShadowColor() {
        return ShadowColor;
    }

    /**
     * Sets shadow radius.
     *
     * @param mShadowRadius the m shadow radius
     */
    public void setmShadowRadius(float mShadowRadius) {
        this.mShadowRadius = mShadowRadius;
    }

    /**
     * Sets corner radius.
     *
     * @param mCornerRadius the m corner radius
     */
    public void setmCornerRadius(float mCornerRadius) {
        this.mCornerRadius = mCornerRadius;
        invalidate();
    }

    /**
     * Sets dx.
     *
     * @param mDx the m dx
     */
    public void setmDx(float mDx) {
        this.mDx = mDx;
        invalidate();
    }

    /**
     * Sets dy.
     *
     * @param mDy the m dy
     */
    public void setmDy(float mDy) {
        this.mDy = mDy;
        invalidate();
    }
}
