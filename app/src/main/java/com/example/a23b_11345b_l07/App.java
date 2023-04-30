package com.example.a23b_11345b_l07;

import android.app.Application;

import com.example.a23b_11345b_l07.Utilities.ImageLoader;
import com.example.a23b_11345b_l07.Utilities.SignalGenerator;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        ImageLoader.initImageLoader(this);
        SignalGenerator.init(this);
    }
}
