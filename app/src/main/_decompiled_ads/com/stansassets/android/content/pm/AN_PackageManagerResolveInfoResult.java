package com.stansassets.android.content.pm;

import android.content.pm.ResolveInfo;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes4.dex */
public class AN_PackageManagerResolveInfoResult {
    private ArrayList<AN_ResolveInfo> m_list = new ArrayList<>();

    public void Add(ResolveInfo resolveInfo) {
        this.m_list.add(new AN_ResolveInfo(resolveInfo));
    }
}
