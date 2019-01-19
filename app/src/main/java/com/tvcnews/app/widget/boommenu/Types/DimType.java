package com.tvcnews.app.widget.boommenu.Types;

import android.graphics.Color;

/**
 * Created by Weiping on 2016/3/22.
 */
public enum DimType {

    /**
     * Dim 0 dim type.
     */
    DIM_0(Color.parseColor("#00000000")),
    /**
     * Dim 1 dim type.
     */
    DIM_1(Color.parseColor("#11000000")),
    /**
     * Dim 2 dim type.
     */
    DIM_2(Color.parseColor("#22000000")),
    /**
     * Dim 3 dim type.
     */
    DIM_3(Color.parseColor("#33000000")),
    /**
     * Dim 4 dim type.
     */
    DIM_4(Color.parseColor("#44000000")),
    /**
     * Dim 5 dim type.
     */
    DIM_5(Color.parseColor("#55000000")),
    /**
     * Dim 6 dim type.
     */
    DIM_6(Color.parseColor("#66000000")),
    /**
     * Dim 7 dim type.
     */
    DIM_7(Color.parseColor("#77000000")),
    /**
     * Dim 8 dim type.
     */
    DIM_8(Color.parseColor("#88000000")),
    /**
     * Dim 9 dim type.
     */
    DIM_9(Color.parseColor("#99000000"));

    /**
     * The Value.
     */
    public int value;

    DimType(int value) {
        this.value = value;
    }
}
