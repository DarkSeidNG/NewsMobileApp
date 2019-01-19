package com.tvcnews.app.widget.boommenu.Types;

/**
 * Created by Weiping on 2016/3/21.
 */
public enum StateType {

    /**
     * Closed state type.
     */
    CLOSED(0),
    /**
     * Opening state type.
     */
    OPENING(1),
    /**
     * Open state type.
     */
    OPEN(2),
    /**
     * Closing state type.
     */
    CLOSING(3);

    /**
     * The Type.
     */
    int type;

    StateType(int type) {
        this.type = type;
    }
}
