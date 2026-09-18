package com.stansassets.android.content.pm;

import android.content.pm.ResolveInfo;

/* JADX INFO: loaded from: classes4.dex */
public class AN_ResolveInfo {
    private AN_ActivityInfo m_activityInfo;

    public AN_ResolveInfo(ResolveInfo resolveInfo) {
        this.m_activityInfo = new AN_ActivityInfo(resolveInfo.activityInfo);
    }
}
