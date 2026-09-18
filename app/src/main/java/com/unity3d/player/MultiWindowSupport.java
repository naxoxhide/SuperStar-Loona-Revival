package com.unity3d.player;

import android.app.Activity;

/* JADX INFO: loaded from: classes4.dex */
public class MultiWindowSupport {
    private static final String RESIZABLE_WINDOW = "unity.allow-resizable-window";

    public static boolean getAllowResizableWindow(Activity activity) {
        try {
            return isInMultiWindowMode(activity) && activity.getApplicationInfo().metaData.getBoolean(RESIZABLE_WINDOW);
        } catch (Exception unused) {
            return false;
        }
    }

    static boolean isInMultiWindowMode(Activity activity) {
        if (PlatformSupport.NOUGAT_SUPPORT) {
            return activity.isInMultiWindowMode();
        }
        return false;
    }
}
