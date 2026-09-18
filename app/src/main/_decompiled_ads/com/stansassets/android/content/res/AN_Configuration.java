package com.stansassets.android.content.res;

import android.content.res.Configuration;
import com.stansassets.core.utility.AN_HashStorage;

/* JADX INFO: loaded from: classes4.dex */
public class AN_Configuration {
    public static int GetUIMode(int i) {
        return ((Configuration) AN_HashStorage.get(i)).uiMode;
    }
}
