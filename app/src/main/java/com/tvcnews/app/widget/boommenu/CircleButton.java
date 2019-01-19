package com.tvcnews.app.widget.boommenu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.tvcnews.app.R;
import com.tvcnews.app.widget.boommenu.Types.ClickEffectType;

/**
 * Created by Weiping on 2016/3/19.
 */
public class CircleButton extends FrameLayout {

    private Context mContext;

    private ShadowLayout shadowLayout;
    private FrameLayout frameLayout;
    private ImageButton imageButton;
    private View ripple;
    private ImageView imageView;
    private TextView textView;

    private ClickEffectType clickEffectType = ClickEffectType.RIPPLE;
    private OnCircleButtonClickListener onCircleButtonClickListener;
    private int index;

    private int radius = (int)Util.getInstance().dp2px(80) / 2;

    /**
     * Instantiates a new Circle button.
     *
     * @param context the context
     */
    public CircleButton(Context context) {
        this(context, null);
    }

    /**
     * Instantiates a new Circle button.
     *
     * @param context the context
     * @param attrs   the attrs
     */
    public CircleButton(Context context, AttributeSet attrs) {
        super(context, attrs);

        mContext = context;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            LayoutInflater.from(mContext).inflate(R.layout.boom_circle_button, this, true);
        } else {
            LayoutInflater.from(mContext).inflate(R.layout.boom_circle_button_below_lollipop, this, true);
        }
        shadowLayout = (ShadowLayout)findViewById(R.id.shadow_layout);
        frameLayout = (FrameLayout)findViewById(R.id.frame_layout);
        imageButton = (ImageButton)findViewById(R.id.image_button);
        ripple = findViewById(R.id.ripple);
        imageView = (ImageView)findViewById(R.id.image_view);
        textView = (TextView)findViewById(R.id.text);
    }

    /**
     * Sets on circle button click listener.
     *
     * @param onCircleButtonClickListener the on circle button click listener
     * @param index                       the index
     */
    public void setOnCircleButtonClickListener(
            OnCircleButtonClickListener onCircleButtonClickListener,
            int index) {
        this.onCircleButtonClickListener = onCircleButtonClickListener;
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
     * Gets image button.
     *
     * @return the image button
     */
    public ImageButton getImageButton() {
        return imageButton;
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
     * Gets shadow layout.
     *
     * @return the shadow layout
     */
    public ShadowLayout getShadowLayout() {
        return shadowLayout;
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
     * Sets color.
     *
     * @param pressedColor the pressed color
     * @param normalColor  the normal color
     */
    public void setColor(int pressedColor, int normalColor) {
        Util.getInstance().setCircleButtonStateListDrawable(
                imageButton, radius, pressedColor, normalColor);
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
                    onCircleButtonClickListener.onClick(index);
                }
            });
        } else {
            ripple.setVisibility(GONE);
            imageButton.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    onCircleButtonClickListener.onClick(index);
                }
            });
        }
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
     * The interface On circle button click listener.
     */
    public interface OnCircleButtonClickListener {
        /**
         * On click.
         *
         * @param index the index
         */
        void onClick(int index);
    }
}
