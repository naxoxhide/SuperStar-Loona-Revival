package com.stansassets.android.support.v4.content;

import androidx.core.content.ContextCompat;
import com.stansassets.core.utility.AN_UnityBridge;

/* JADX INFO: loaded from: classes4.dex */
public class AN_ContextCompat {
    public static int CheckSelfPermission(String str) {
        return ContextCompat.checkSelfPermission(AN_UnityBridge.currentActivity, str);
    }
}
