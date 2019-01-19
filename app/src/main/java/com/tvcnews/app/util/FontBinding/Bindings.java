package com.tvcnews.app.util.FontBinding;

import android.databinding.BindingAdapter;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Custom bindings for XML attributes using data binding.
 * (http://developer.android.com/tools/data-binding/guide.html)
 */
public class Bindings {

    /**
     * Sets font.
     *
     * @param textView the text view
     * @param fontName the font name
     */
    @BindingAdapter({"bind:font"})
    public static void setFont(TextView textView, String fontName) {
        textView.setTypeface(FontCache.getInstance(textView.getContext()).get(fontName));
    }

    /**
     * Sets font.
     *
     * @param editTextView the edit text view
     * @param fontName     the font name
     */
    @BindingAdapter({"bind:font"})
    public static void setFont(EditText editTextView, String fontName) {
        editTextView.setTypeface(FontCache.getInstance(editTextView.getContext()).get(fontName));
    }
}
