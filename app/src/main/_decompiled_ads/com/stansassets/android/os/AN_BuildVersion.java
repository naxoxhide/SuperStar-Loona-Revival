package com.stansassets.android.os;

import android.os.Build;

/* JADX INFO: loaded from: classes4.dex */
public class AN_BuildVersion {
    private String BASE_OS;
    private String CODENAME;
    private String INCREMENTAL;
    private int PREVIEW_SDK_INT;
    private String RELEASE;
    private int SDK_INT;
    private String SECURITY_PATCH;

    public AN_BuildVersion() {
        this.BASE_OS = "";
        this.CODENAME = "";
        this.INCREMENTAL = "";
        this.PREVIEW_SDK_INT = 0;
        this.RELEASE = "";
        this.SDK_INT = 0;
        this.SECURITY_PATCH = "";
        this.CODENAME = Build.VERSION.CODENAME;
        this.INCREMENTAL = Build.VERSION.INCREMENTAL;
        this.RELEASE = Build.VERSION.RELEASE;
        this.SDK_INT = Build.VERSION.SDK_INT;
        if (Build.VERSION.SDK_INT >= 23) {
            this.BASE_OS = Build.VERSION.BASE_OS;
            this.PREVIEW_SDK_INT = Build.VERSION.PREVIEW_SDK_INT;
            this.SECURITY_PATCH = Build.VERSION.SECURITY_PATCH;
        }
    }
}
