package com.stansassets.android.content;

import com.stansassets.android.app.AN_Activity;
import com.stansassets.core.templates.AN_LinkedObject;
import com.stansassets.core.utility.AN_UnityBridge;

/* JADX INFO: loaded from: classes4.dex */
public class AN_Context {
    protected int m_classId = 0;
    protected String m_instanceId;

    public static String GetResources(String str) {
        try {
            return AN_UnityBridge.toJson(new AN_LinkedObject(((AN_Activity) AN_UnityBridge.fromJson(str, AN_Activity.class)).toActivity().getResources()));
        } catch (Exception unused) {
            return AN_UnityBridge.toJson(new AN_LinkedObject(null));
        }
    }
}
