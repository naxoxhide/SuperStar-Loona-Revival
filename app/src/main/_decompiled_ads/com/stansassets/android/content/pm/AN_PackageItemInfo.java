package com.stansassets.android.content.pm;

import android.content.pm.PackageItemInfo;

/* JADX INFO: loaded from: classes4.dex */
public class AN_PackageItemInfo {
    private String m_name;
    private String m_packageName;

    public AN_PackageItemInfo(PackageItemInfo packageItemInfo) {
        this.m_name = packageItemInfo.name;
        this.m_packageName = packageItemInfo.packageName;
    }
}
