package com.stansassets.android.os;

import com.stansassets.core.utility.AN_UnityBridge;

/* JADX INFO: loaded from: classes4.dex */
public class AN_Build {
    public static String GetBuildVerion() {
        return AN_UnityBridge.toJson(new AN_BuildVersion());
    }
}
