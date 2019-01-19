package com.tvcnews.app.widget.boommenu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.tvcnews.app.R;
import com.tvcnews.app.widget.boommenu.Types.ClickEffectType;


/**
 * Created by Weiping on 2016/3/19.
 */
public class HamButton extends FrameLayout {

    private Context mContext;

    private ShadowLayout shadowLayout;
    private FrameLayout frameLayout;
    private View ripple;
    private ImageView imageView;
    private TextView textView;

    private ClickEffectType clickEffectType = ClickEffectType.RIPPLE;
    private OnHamButtonClickListener onHamButtonClickListener;
    private int index;

    private int width = 0;
    private int height = (int)Util.getInstance().dp2px(40);

    /**
     * Instantiates a new Ham button.
     *
     * @param context the context
     */
    public HamButton(Context context) {
        this(context, null);
    }

    /**
     * Instantiates a new Ham button.
     *
     * @param context the context
     * @param attrs   the attrs
     */
    public HamButton(Context context, AttributeSet attrs) {
        super(context, attrs);

        mContext = context;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            LayoutInflater.from(mContext).inflate(R.layout.boom_ham_button, this, true);
        } else {
            LayoutInflater.from(mContext).inflate(R.layout.boom_ham_button_below_lollipop, this, true);
        }
        shadowLayout = (ShadowLayout)findViewById(R.id.shadow_layout);
        frameLayout = (FrameLayout)findViewById(R.id.frame_layout);
        ripple = findViewById(R.id.ripple);
        imageView = (ImageView)findViewById(R.id.image);
        textView = (TextView)findViewById(R.id.text);

        width = Util.getInstance().getScreenWidth(getContext()) * 8 / 9;
        height = (int)Util.getInstance().dp2px(40);

        LayoutParams layoutParams = (LayoutParams) frameLayout.getLayoutParams();
        layoutParams.width = width - (int)Util.getInstance().dp2px(8);
        frameLayout.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams1 = shadowLayout.getLayoutParams();
        layoutParams1.width = width;
        layoutParams1.height = height + (int)Util.getInstance().dp2px(4);
        shadowLayout.setLayoutParams(layoutParams1);
    }

    /**
     * Sets on ham button click listener.
     *
     * @param onHamButtonClickListener the on ham button click listener
     * @param index                    the index
     */
    public void setOnHamButtonClickListener(
            final OnHamButtonClickListener onHamButtonClickListener, final int index) {
        this.onHamButtonClickListener = onHamButtonClickListener;
        this.index = index;
        setRipple(clickEffectType);
    }

    /**
     * Sets drawable.
     *
     * @param drawable the drawable
     */
    public void setDrawable(Drawable drawable) {
        if (imageView != null) imageView.setImageDrawable(drawable);
    }

    /**
     * Sets text.
     *
     * @param text the text
     */
    public void setText(String text) {
        if (textView != null) textView.setText(text);
    }

    /**
     * Gets frame layout.
     *
     * @return the frame layout
     */
    public FrameLayout getFrameLayout() {
        return frameLayout;
    }

    /**
     * Gets image view.
     *
     * @return the image view
     */
    public ImageView getImageView() {
        return imageView;
    }

    /**
     * Gets text view.
     *
     * @return the text view
     */
    public TextView getTextView() {
        return textView;
    }

    /**
     * Gets shadow layout.
     *
     * @return the shadow layout
     */
    public ShadowLayout getShadowLayout() {
        return shadowLayout;
    }

    /**
     * Sets ripple.
     *
     * @param clickEffectType the click effect type
     */
    public void setRipple(ClickEffectType clickEffectType) {
        this.clickEffectType = clickEffectType;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP
                && clickEffectType.equals(ClickEffectType.RIPPLE)) {
            ripple.setVisibility(VISIBLE);
            ripple.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    onHamButtonClickListener.onClick(index);
                }
            });
        } else {
            ripple.setVisibility(GONE);
            frameLayout.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    onHamButtonClickListener.onClick(index);
                }
            });
        }
    }

    /**
     * Sets color.
     *
     * @param pressedColor the pressed color
     * @param normalColor  the normal color
     */
    public void setColor(int pressedColor, int normalColor) {
        Util.getInstance().setHamButtonStateListDrawable(
                frameLayout, width, height, pressedColor, normalColor);
    }

    /**
     * Sets shadow color.
     *
     * @param mShadowColor the m shadow color
     */
    public void setShadowColor(int mShadowColor) {
        shadowLayout.setShadowColor(mShadowColor);
    }

    /**
     * Sets shadow dx.
     *
     * @param mDx the m dx
     */
    public void setShadowDx(float mDx) {
        shadowLayout.setmDx(mDx);
    }

    /**
     * Sets shadow dy.
     *
     * @param mDy the m dy
     */
    public void setShadowDy(float mDy) {
        shadowLayout.setmDy(mDy);
    }

    /**
     * The interface On ham button click listener.
     */
    public interface OnHamButtonClickListener {
        /**
         * On click.
         *
         * @param index the index
         */
        void onClick(int index);
    }
}
