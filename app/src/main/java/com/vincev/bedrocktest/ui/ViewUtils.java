package com.vincev.bedrocktest.ui;

import android.content.Context;

import com.vincev.bedrocktest.R;

public class ViewUtils {
    public static boolean isTabletLand(Context context){
        return context.getResources().getBoolean(R.bool.isTabletLand);
    }
}
