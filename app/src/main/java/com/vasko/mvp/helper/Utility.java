package com.vasko.mvp.helper;

import android.content.Context;
import android.widget.Toast;

public class Utility {

    public static void showToast(Context context, int textResourceId) {
        Toast.makeText(context, textResourceId, Toast.LENGTH_SHORT).show();
    }

}
