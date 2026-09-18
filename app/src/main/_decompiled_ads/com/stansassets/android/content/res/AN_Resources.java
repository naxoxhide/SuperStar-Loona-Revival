package com.stansassets.android.content.res;

import android.content.res.Resources;
import com.stansassets.core.templates.AN_LinkedObject;
import com.stansassets.core.utility.AN_HashStorage;
import com.stansassets.core.utility.AN_UnityBridge;

/* JADX INFO: loaded from: classes4.dex */
public class AN_Resources {
    public static String GetConfiguration(int i) {
        return AN_UnityBridge.toJson(new AN_LinkedObject(((Resources) AN_HashStorage.get(i)).getConfiguration()));
    }
}
