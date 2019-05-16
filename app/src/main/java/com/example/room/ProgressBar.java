package com.example.room;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.view.Window;


public class ProgressBar {

    public static Dialog dialog;

    public static void show(Context context)
    {
        dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.progress_bar);
        dialog.getWindow().setBackgroundDrawableResource(R.color.color_transparent);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(false);

        dialog.show();
    }

    public static void dismiss() {
        if(dialog != null) {
            dialog.dismiss();
        }
    }

}
