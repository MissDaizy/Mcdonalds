package com.diana_ukrainsky.mcdonalds.util;

import android.content.Context;
import android.widget.Toast;

public class AlertUtil {
    public static void showToast(Context context,String textToShow) {
        Toast.makeText(context,textToShow,Toast.LENGTH_SHORT).show();
    }
}
