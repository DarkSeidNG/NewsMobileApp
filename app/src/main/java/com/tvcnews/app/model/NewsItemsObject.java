package com.tvcnews.app.model;

import android.graphics.drawable.Drawable;

/**
 * Created by iFwAxTel on 19/02/2017.
 */
public class NewsItemsObject {

    /**
     * The Checked.
     */
    boolean checked;
    private String title;
    private String body;
    private Drawable image;
    private boolean isAward;


    /**
     * Is checked boolean.
     *
     * @return the boolean
     */
    public boolean isChecked() {
        return checked;
    }

    /**
     * Sets checked.
     *
     * @param checked the checked
     */
    public void setChecked(boolean checked) {
        this.checked = checked;
    }


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
     * Gets body.
     *
     * @return the body
     */
    public String getBody() {
        return body;
    }

    /**
     * Sets body.
     *
     * @param body the body
     */
    public void setBody(String body) {
        this.body = body;
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
     * Is award boolean.
     *
     * @return the boolean
     */
    public boolean isAward() {
        return isAward;
    }

    /**
     * Sets award.
     *
     * @param award the award
     */
    public void setAward(boolean award) {
        isAward = award;
    }
}
