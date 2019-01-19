package com.tvcnews.app.widget.boommenu.Eases;

/**
 * Created by Weiping on 2016/3/3.
 */
public enum EaseType {

    /**
     * Ease in sine ease type.
     */
    EaseInSine(EaseInSine.class),
    /**
     * Ease out sine ease type.
     */
    EaseOutSine(EaseOutSine.class),
    /**
     * Ease in out sine ease type.
     */
    EaseInOutSine(EaseInOutSine.class),

    /**
     * Ease in quad ease type.
     */
    EaseInQuad(EaseInQuad.class),
    /**
     * Ease out quad ease type.
     */
    EaseOutQuad(EaseOutQuad.class),
    /**
     * Ease in out quad ease type.
     */
    EaseInOutQuad(EaseInOutQuad.class),

    /**
     * Ease in cubic ease type.
     */
    EaseInCubic(EaseInCubic.class),
    /**
     * Ease out cubic ease type.
     */
    EaseOutCubic(EaseOutCubic.class),
    /**
     * Ease in out cubic ease type.
     */
    EaseInOutCubic(EaseInOutCubic.class),

    /**
     * Ease in quart ease type.
     */
    EaseInQuart(EaseInQuart.class),
    /**
     * Ease out quart ease type.
     */
    EaseOutQuart(EaseOutQuart.class),
    /**
     * Ease in out quart ease type.
     */
    EaseInOutQuart(EaseInOutQuart.class),

    /**
     * Ease in quint ease type.
     */
    EaseInQuint(EaseInQuint.class),
    /**
     * Ease out quint ease type.
     */
    EaseOutQuint(EaseOutQuint.class),
    /**
     * Ease in out quint ease type.
     */
    EaseInOutQuint(EaseInOutQuint.class),

    /**
     * Ease in expo ease type.
     */
    EaseInExpo(EaseInExpo.class),
    /**
     * Ease out expo ease type.
     */
    EaseOutExpo(EaseOutExpo.class),
    /**
     * Ease in out expo ease type.
     */
    EaseInOutExpo(EaseInOutExpo.class),

    /**
     * Ease in circ ease type.
     */
    EaseInCirc(EaseInCirc.class),
    /**
     * Ease out circ ease type.
     */
    EaseOutCirc(EaseOutCirc.class),
    /**
     * Ease in out circ ease type.
     */
    EaseInOutCirc(EaseInOutCirc.class),

    /**
     * Ease in back ease type.
     */
    EaseInBack(EaseInBack.class),
    /**
     * Ease out back ease type.
     */
    EaseOutBack(EaseOutBack.class),
    /**
     * Ease in out back ease type.
     */
    EaseInOutBack(EaseInOutBack.class),

    /**
     * Ease in elastic ease type.
     */
    EaseInElastic(EaseInElastic.class),
    /**
     * Ease out elastic ease type.
     */
    EaseOutElastic(EaseOutElastic.class),
    /**
     * Ease in out elastic ease type.
     */
    EaseInOutElastic(EaseInOutElastic.class),

    /**
     * Ease in bounce ease type.
     */
    EaseInBounce(EaseInBounce.class),
    /**
     * Ease out bounce ease type.
     */
    EaseOutBounce(EaseOutBounce.class),
    /**
     * Ease in out bounce ease type.
     */
    EaseInOutBounce(EaseInOutBounce.class),

    /**
     * Linear ease type.
     */
    Linear(Linear.class);

    private Class easingType;

    /**
     * ease animation helps to make the movement more real
     * @param easingType
     */
    EaseType(Class easingType) {
        this.easingType = easingType;
    }

    /**
     * Gets offset.
     *
     * @param offset the offset
     * @return the offset
     */
    public float getOffset(float offset) {
        try {
            return ((CubicBezier) easingType.getConstructor().newInstance()).getOffset(offset);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Error("CubicBezier init error.");
        }
    }

}
