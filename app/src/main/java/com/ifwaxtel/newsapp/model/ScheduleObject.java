package com.ifwaxtel.newsapp.model;

import android.graphics.drawable.Drawable;

/**
 * Created by iFwAxTel on 25/02/2017.
 */
public class ScheduleObject {
    private String title;
    private String anchor;
    private Drawable image;

    /**
     * Gets title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets title.
     *
     * @param title the title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets image.
     *
     * @return the image
     */
    public Drawable getImage() {
        return image;
    }

    /**
     * Sets image.
     *
     * @param image the image
     */
    public void setImage(Drawable image) {
        this.image = image;
    }

    /**
     * Gets anchor.
     *
     * @return the anchor
     */
    public String getAnchor() {
        return anchor;
    }

    /**
     * Sets anchor.
     *
     * @param anchor the anchor
     */
    public void setAnchor(String anchor) {
        this.anchor = anchor;
    }
}
