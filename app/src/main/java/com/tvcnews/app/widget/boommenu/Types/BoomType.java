package com.tvcnews.app.widget.boommenu.Types;

/**
 * Created by Weiping on 2016/3/19.
 */
public enum BoomType {

    /**
     * Line boom type.
     */
    LINE(0),
    /**
     * Parabola boom type.
     */
    PARABOLA(1),
    /**
     * Horizontal throw boom type.
     */
    HORIZONTAL_THROW(2),
    /**
     * Parabola 2 boom type.
     */
    PARABOLA_2(3),
    /**
     * Horizontal throw 2 boom type.
     */
    HORIZONTAL_THROW_2(4);

    /**
     * The Type.
     */
    int type;

    BoomType(int type) {
        this.type = type;
    }
}
