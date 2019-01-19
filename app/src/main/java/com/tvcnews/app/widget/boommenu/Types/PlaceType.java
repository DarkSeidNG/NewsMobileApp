package com.tvcnews.app.widget.boommenu.Types;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Weiping on 2016/3/19.
 */
public enum PlaceType {

    /**
     * Circle 1 1 place type.
     */
    CIRCLE_1_1(0),
    /**
     * Circle 2 1 place type.
     */
    CIRCLE_2_1(1),
    /**
     * Circle 2 2 place type.
     */
    CIRCLE_2_2(2),
    /**
     * Circle 3 1 place type.
     */
    CIRCLE_3_1(3),
    /**
     * Circle 3 2 place type.
     */
    CIRCLE_3_2(4),
    /**
     * Circle 3 3 place type.
     */
    CIRCLE_3_3(5),
    /**
     * Circle 3 4 place type.
     */
    CIRCLE_3_4(6),
    /**
     * Circle 4 1 place type.
     */
    CIRCLE_4_1(7),
    /**
     * Circle 4 2 place type.
     */
    CIRCLE_4_2(8),
    /**
     * Circle 5 1 place type.
     */
    CIRCLE_5_1(9),
    /**
     * Circle 5 2 place type.
     */
    CIRCLE_5_2(10),
    /**
     * Circle 5 3 place type.
     */
    CIRCLE_5_3(11),
    /**
     * Circle 5 4 place type.
     */
    CIRCLE_5_4(12),
    /**
     * Circle 6 1 place type.
     */
    CIRCLE_6_1(13),
    /**
     * Circle 6 2 place type.
     */
    CIRCLE_6_2(14),
    /**
     * Circle 6 3 place type.
     */
    CIRCLE_6_3(15),
    /**
     * Circle 6 4 place type.
     */
    CIRCLE_6_4(16),
    /**
     * Circle 6 5 place type.
     */
    CIRCLE_6_5(17),
    /**
     * Circle 6 6 place type.
     */
    CIRCLE_6_6(18),
    /**
     * Circle 7 1 place type.
     */
    CIRCLE_7_1(19),
    /**
     * Circle 7 2 place type.
     */
    CIRCLE_7_2(20),
    /**
     * Circle 7 3 place type.
     */
    CIRCLE_7_3(21),
    /**
     * Circle 7 4 place type.
     */
    CIRCLE_7_4(22),
    /**
     * Circle 8 1 place type.
     */
    CIRCLE_8_1(23),
    /**
     * Circle 8 2 place type.
     */
    CIRCLE_8_2(24),
    /**
     * Circle 8 3 place type.
     */
    CIRCLE_8_3(25),
    /**
     * Circle 9 1 place type.
     */
    CIRCLE_9_1(26),
    /**
     * Circle 9 2 place type.
     */
    CIRCLE_9_2(27),

    /**
     * Ham 1 1 place type.
     */
    HAM_1_1(28),
    /**
     * Ham 2 1 place type.
     */
    HAM_2_1(29),
    /**
     * Ham 3 1 place type.
     */
    HAM_3_1(30),
    /**
     * Ham 4 1 place type.
     */
    HAM_4_1(31),

    /**
     * Share 3 1 place type.
     */
    SHARE_3_1(32),
    /**
     * Share 3 2 place type.
     */
    SHARE_3_2(33),
    /**
     * Share 3 3 place type.
     */
    SHARE_3_3(34),
    /**
     * Share 3 4 place type.
     */
    SHARE_3_4(35),
    /**
     * Share 4 1 place type.
     */
    SHARE_4_1(36),
    /**
     * Share 4 2 place type.
     */
    SHARE_4_2(37),
    /**
     * Share 5 1 place type.
     */
    SHARE_5_1(38),
    /**
     * Share 5 2 place type.
     */
    SHARE_5_2(39),
    /**
     * Share 5 3 place type.
     */
    SHARE_5_3(40),
    /**
     * Share 5 4 place type.
     */
    SHARE_5_4(41),
    /**
     * Share 6 1 place type.
     */
    SHARE_6_1(42),
    /**
     * Share 6 2 place type.
     */
    SHARE_6_2(43),
    /**
     * Share 6 3 place type.
     */
    SHARE_6_3(44),
    /**
     * Share 6 4 place type.
     */
    SHARE_6_4(45),
    /**
     * Share 6 5 place type.
     */
    SHARE_6_5(46),
    /**
     * Share 6 6 place type.
     */
    SHARE_6_6(47),
    /**
     * Share 7 1 place type.
     */
    SHARE_7_1(48),
    /**
     * Share 7 2 place type.
     */
    SHARE_7_2(49),
    /**
     * Share 7 3 place type.
     */
    SHARE_7_3(50),
    /**
     * Share 7 4 place type.
     */
    SHARE_7_4(51),
    /**
     * Share 8 1 place type.
     */
    SHARE_8_1(52),
    /**
     * Share 8 2 place type.
     */
    SHARE_8_2(53),
    /**
     * Share 8 3 place type.
     */
    SHARE_8_3(54),
    /**
     * Share 9 1 place type.
     */
    SHARE_9_1(55),
    /**
     * Share 9 2 place type.
     */
    SHARE_9_2(56);

    /**
     * The V.
     */
    public int v;

    PlaceType(int v) {
        this.v = v;
    }

    private static Map<Integer, PlaceType> map = new HashMap<Integer, PlaceType>();

    static {
        for (PlaceType placeType : PlaceType.values()) {
            map.put(placeType.v, placeType);
        }
    }

    /**
     * Value of place type.
     *
     * @param v the v
     * @return the place type
     */
    public static PlaceType valueOf(int v) {
        return map.get(v);
    }
}
