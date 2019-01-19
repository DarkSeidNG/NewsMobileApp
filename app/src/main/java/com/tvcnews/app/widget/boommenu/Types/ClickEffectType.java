package com.tvcnews.app.widget.boommenu.Types;

/**
 * Created by Weiping on 2016/3/22.
 */
public enum ClickEffectType {

    /**
     * Ripple click effect type.
     */
    RIPPLE(0),
    /**
     * Normal click effect type.
     */
    NORMAL(1);

    /**
     * The Type.
     */
    int type;

    ClickEffectType(int type) {
        this.type = type;
    }
}
