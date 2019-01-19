package com.tvcnews.app.util;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.widget.Toast;

/**
 * Created by iFwAxTel on 02/01/2017.
 */
public class RateApp {
    /**
     * The M context.
     */
    Context mContext;

    /**
     * Instantiates a new Rate app.
     *
     * @param context the context
     */
    public RateApp(Context context){
        this.mContext = context;
    }

    /**
     * Rate app.
     */
    public void rateApp(){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY| Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
        if(Build.VERSION.SDK_INT>=21)
        {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_DOCUMENT);
        }
        else
        {
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
        }

        //Try Google Play
        intent.setData(Uri.parse("market://details?id=com.servotronicstech.TVCNEWS"/*+mContext.getPackageName()*/));
        if(!MyStartActivity(intent)){
            //if Google Play Store is not installed, open a browser and open the play store website
            intent.setData(Uri.parse("http://play.google.com/store/apps/details?id=com.servotronicstech.TVCNEWS"/*+mContext.getPackageName()*/));
            if(!MyStartActivity(intent)){
                //if that doesnt work too, the alert the user
                Toast.makeText(mContext, "Could not open the play store for rating", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private boolean MyStartActivity(Intent aIntent){
        try
        {
            mContext.startActivity(aIntent);
            return true;
        }
        catch (ActivityNotFoundException e)
        {
            return false;
        }
    }
}
