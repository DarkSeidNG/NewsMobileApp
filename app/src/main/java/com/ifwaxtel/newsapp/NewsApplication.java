package com.ifwaxtel.newsapp;

import android.app.Application;

import com.ifwaxtel.newsapp.util.FontBinding.FontCache;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by iFwAxTel on 04/01/2017.
 */
public class NewsApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder().build();
        Realm.setDefaultConfiguration(realmConfiguration);
        FontCache.getInstance(this).addFont("roboto-black", "Roboto-Black.ttf");
        FontCache.getInstance(this).addFont("roboto-bold", "Roboto-Bold.ttf");
        FontCache.getInstance(this).addFont("roboto-medium", "Roboto-Medium.ttf");
        FontCache.getInstance(this).addFont("roboto-regular", "Roboto-Regular.ttf");
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

}
