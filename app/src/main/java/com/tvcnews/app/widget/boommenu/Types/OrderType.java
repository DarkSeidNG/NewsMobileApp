package com.tvcnews.app.widget.boommenu.Types;

/**
 * Created by Weiping on 2016/3/20.
 */
public enum OrderType {

    /**
     * Default order type.
     */
    DEFAULT(0),
    /**
     * Reverse order type.
     */
    REVERSE(1),
    /**
     * Random order type.
     */
    RANDOM(2);

    /**
     * The Type.
     */
    int type;

    OrderType(int type) {
        this.type = type;
    }
}
