package com.vasko.mvp.helper;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Filip on 5.5.2016..
 */
public class Utility {

    public static void showToast(Context context, int textResourceId) {
        Toast.makeText(context, textResourceId, Toast.LENGTH_SHORT).show();
    }
}
