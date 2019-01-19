package com.tvcnews.app.widget.boommenu;

import android.view.animation.Interpolator;

import com.tvcnews.app.widget.boommenu.Eases.EaseType;


/**
 * Created by Weiping on 2016/3/17.
 */
public class InterpolatorFactory {

    /**
     * Gets interpolator.
     *
     * @param easeType the ease type
     * @return the interpolator
     */
    public static BLVInterpolator getInterpolator(EaseType easeType) {
        return new BLVInterpolator(easeType);
    }

    /**
     * The type Blv interpolator.
     */
    public static class BLVInterpolator implements Interpolator {

        private EaseType easeType;

        /**
         * Instantiates a new Blv interpolator.
         *
         * @param easeType the ease type
         */
        public BLVInterpolator(EaseType easeType) {
            this.easeType = easeType;
        }

        @Override
        public float getInterpolation(float input) {
            return easeType.getOffset(input);
        }
    }

}
