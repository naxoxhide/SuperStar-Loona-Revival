package com.stansassets.android.app.dialogs;

import android.R;
import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.stansassets.core.utility.AN_Logger;
import com.stansassets.core.utility.AN_UnityBridge;

/* JADX INFO: loaded from: classes4.dex */
public class AN_ProgressDialog {
    private static AlertDialog.Builder s_builder;
    private static AlertDialog s_dialog;
    private static Handler s_handler;

    public static void LockScreen(String str) {
        LinearLayout linearLayout = new LinearLayout(AN_UnityBridge.currentActivity);
        linearLayout.setOrientation(0);
        linearLayout.setPadding(30, 30, 30, 30);
        linearLayout.setGravity(17);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        linearLayout.setLayoutParams(layoutParams);
        ProgressBar progressBar = new ProgressBar(AN_UnityBridge.currentActivity);
        progressBar.setIndeterminate(true);
        progressBar.setPadding(0, 0, 30, 0);
        progressBar.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        TextView textView = new TextView(AN_UnityBridge.currentActivity);
        textView.setText(str);
        textView.setTextColor(Color.parseColor("#000000"));
        textView.setTextSize(20.0f);
        textView.setLayoutParams(layoutParams2);
        linearLayout.addView(progressBar);
        linearLayout.addView(textView);
        AlertDialog.Builder builder = new AlertDialog.Builder(AN_UnityBridge.currentActivity);
        s_builder = builder;
        builder.setCancelable(false);
        s_builder.setView(linearLayout);
        GetHandler().sendEmptyMessage(1);
    }

    public static void UnlockScreen() {
        GetHandler().sendEmptyMessage(0);
    }

    private static Handler GetHandler() {
        if (s_handler == null) {
            s_handler = new Handler(Looper.getMainLooper()) { // from class: com.stansassets.android.app.dialogs.AN_ProgressDialog.1
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    int i = message.what;
                    if (i != 0) {
                        if (i != 1) {
                            return;
                        }
                        AlertDialog unused = AN_ProgressDialog.s_dialog = AN_ProgressDialog.s_builder.show();
                    } else if (AN_ProgressDialog.s_dialog != null) {
                        AN_ProgressDialog.s_dialog.hide();
                        AlertDialog unused2 = AN_ProgressDialog.s_dialog = null;
                    } else {
                        AN_Logger.LogWarning("Progress Dialog wasn't present, call ignored");
                    }
                }
            };
        }
        return s_handler;
    }

    public static int GetPlatformDependentTheme(int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            if (i != 1) {
                if (i != 2) {
                    return i != 3 ? R.style.Theme.DeviceDefault.Dialog : R.style.Theme.Material.Light.Dialog;
                }
                return R.style.Theme.Material.Dialog;
            }
        } else if (i != 1) {
            if (i != 2) {
                return i != 3 ? R.style.Theme.DeviceDefault.Dialog : R.style.Theme.Holo.Light.Dialog;
            }
            return R.style.Theme.Holo.Dialog;
        }
        return R.style.Theme.DeviceDefault.Light.Dialog;
    }
}
