package com.stansassets.android.content.pm;

import android.content.pm.PackageInfo;

/* JADX INFO: loaded from: classes4.dex */
public class AN_PackageInfo {
    private String m_packageName;
    private String m_sharedUserId;
    private String m_versionName;

    public AN_PackageInfo(PackageInfo packageInfo) {
        this.m_versionName = packageInfo.versionName;
        this.m_packageName = packageInfo.packageName;
        this.m_sharedUserId = packageInfo.sharedUserId;
    }
}
