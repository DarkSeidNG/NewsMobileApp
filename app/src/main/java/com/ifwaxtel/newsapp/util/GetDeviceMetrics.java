package com.ifwaxtel.newsapp.util;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

/**
 * Created by iFwAxTel on 06/01/2017.
 */
public class GetDeviceMetrics {
    /**
     * The Context.
     */
    Context context;

    /**
     * Instantiates a new Get device metrics.
     *
     * @param mContext the m context
     */
    public GetDeviceMetrics(Context mContext) {
        this.context = mContext;
    }

    /**
     * Get metrics display metrics.
     *
     * @return the display metrics
     */
    public DisplayMetrics getMetrics() {
        DisplayMetrics metrics = new DisplayMetrics();
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        display.getMetrics(metrics);
        return metrics;
    }
}
